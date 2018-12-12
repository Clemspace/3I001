import java.util.concurrent.*;

public class Babouin implements Runnable {
	private static int cpt = 0;
	public final int id;
	private Corde laCorde;
	private Position pos;

	public Babouin(Corde c) {
		id = cpt++;
		laCorde = c;
		pos = Position.getRandom();

	}

	public void traverser() {
		// incrémenter la position %2
	}
	
	
	

	@Override
	public String toString() {
		return "Babouin [id=" + id + ", pos=" + pos + "]";
	}

	public void run() {
		try {
			laCorde.acceder(pos);
			System.out.println(this.toString() + " a pris la corde");
			traverser();
			System.out.println(this.toString() + " est arrivé");
			laCorde.lacher(pos);
		} catch (InterruptedException e) {
			System.out.println("Pb babouin!");
		}
	}
}
