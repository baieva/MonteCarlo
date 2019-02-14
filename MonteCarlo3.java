

public class MonteCarlo3 {

	public static void main(String[] args) throws InterruptedException {
		long startTime = System.currentTimeMillis();
		// TODO Auto-generated method stub
		int totalpoints = 1000000;
		int totalthreads = 2;
		CirclePoints circle_hit = new CirclePoints();
		Thread[] thrd = new Thread[totalthreads];
		for(int i = 0; i < totalthreads; i++) {
			thrd[i]= new Thread(new Randomize(totalpoints,circle_hit));
			thrd[i].start();
		}
		try {
			
			for(int i = 0; i< totalthreads; i++) {
				thrd[i].join();
			}
			double pi = 4.0 * (double)circle_hit.points / ((double) totalpoints* (double) totalthreads);
			System.out.println("pi is " + pi);
		}catch(InterruptedException ie) {
			
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Time to run is " + (endTime - startTime));
	}

}
