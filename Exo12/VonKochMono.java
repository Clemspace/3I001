import graphic.Window;
import java.awt.Point;
public class VonKochMono {
	private final static double LG_MIN = 8.0;
	Window f;

	public VonKochMono (Window f, Point a, Point b, Point c) {
		this.f = f;
		new Cote(f, b, a).tracer();
		new Cote(f, a, c).tracer();
		new Cote(f, c, b).tracer();
	}
}
