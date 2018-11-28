import graphic.Window;
import java.awt.Point;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VonKochConcu{
	 
	private final static double LG_MIN = 8.0;
	Window f;

	public VonKochConcu(Window f, Point a, Point b, Point c, ExecutorService e ){
			this.f = f;
			e.execute(new Thread(new ConcuLine(f, b, a, e)));
			e.execute(new Thread(new ConcuLine(f, a, c, e)));
			e.execute(new Thread(new ConcuLine(f, c, b, e)));
		}
		
	
}
	


