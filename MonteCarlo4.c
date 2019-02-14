//
//  MonteCarlo4.c
//  
//
//  Created by Mingjia Shi on 2018/2/14.
//

#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <math.h>
#include <omp.h>

double double_random() {
    return rand() / ((double)RAND_MAX + 1);
}



int main() {
    time_t start, end;
    start = time(NULL);
    int i = 0;
    int hit_points = 0;
    int total = 500;
    srand((unsigned)time(NULL));
    double x, y;
#pragma omp num_thread(100) parallel for
    for(i = 0;i < total; i++){
#pragma omp critical
        {
        x = double_random() * 2 - 1;
        y = double_random() * 2 - 1;
        
        if(sqrt(x * x + y * y) < 1.0){
            hit_points++;
        }
        }
    }
    
    double pi = 4.0 * (double)hit_points / (double)total;
    end = time(NULL);
    printf("Pi is %f\n",pi);
    printf("Time is %d ms",end-start);
    return 0;
}
