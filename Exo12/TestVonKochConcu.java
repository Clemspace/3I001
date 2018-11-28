import java.awt.Point;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import graphic.Window;

public class TestVonKochConcu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int TAILLEPOOL= 5100000;
		final int XMAX = 400;
		final int YMAX = 400;

		final Window f =new Window(XMAX, YMAX, "von Koch Concu");
	
		Point v = new Point();
		v.setLocation(XMAX/2, YMAX/8);

		Point u = new Point();
		u.setLocation(v.x - (3.0*XMAX/10.0), v.y + (0.5196*XMAX));

		Point w =new Point();
		w.setLocation(v.x + (3.0*XMAX/10.0), u.y);
		
		ExecutorService exec  = Executors.newFixedThreadPool(TAILLEPOOL);
			
		VonKochConcu vk = new VonKochConcu(f, u, v, w, exec);
		
	
	}
	

}


