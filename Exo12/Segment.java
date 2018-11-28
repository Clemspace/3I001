import graphic.Window;
import java.awt.Point;

public class Segment {
	private Window f;
	private final Point m, n;

	public Segment (Window f, Point m, Point n) {
		this.f = f;
		this.m = m;
		this.n = n;
	}

	public static double longueur(Point m, Point n) {
	
		return Math.sqrt( Math.pow (m.y - n.y, 2.0) + Math.pow (m.x - n.x, 2.0) );
	}

	public static void tracer (Window f, Point m, Point n) {
		
		f.plotLine(m, n);
	}
}
