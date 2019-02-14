
public class MonteCarlo1 {
	
	

	public static void main(String[] args) throws InterruptedException {
		long startTime = System.currentTimeMillis();
		// TODO Auto-generated method stub
			int totalpoints = 1000000;
			CirclePoints circle_hit = new CirclePoints();
			Thread thrd = new Thread(new Randomize(totalpoints,circle_hit));
			thrd.start();
			try {
				thrd.join();
				double pi = 4.0 * (double)circle_hit.points / (double) totalpoints;
				System.out.println("pi is " + pi);
			}
			catch (InterruptedException ie){
				System.out.println(ie.getMessage());
			}
			long endTime = System.currentTimeMillis();
			System.out.println("Time to run is " + (endTime - startTime));
	}

}

class CirclePoints {
	public int points;
	
	public CirclePoints(){
		points = 0;
	}
}


class Randomize implements java.lang.Runnable {
	
	int total;
	CirclePoints circle_hit;
	
	public Randomize(int total, CirclePoints circle_hit) {
		this.total = total;
		this.circle_hit = circle_hit;
	}
	
	
	public void run() {
		double x;
		double y;
		for(int i = 0; i < total; i++) {
			x = Math.random() * 2 - 1;
			y = Math.random() * 2 - 1;
			
			if(Math.sqrt(x * x + y * y) < 1.0) {
				circle_hit.points++;
			}
		}
		
	}
	
}
