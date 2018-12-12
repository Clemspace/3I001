import java.util.concurrent.*;

public class Kong implements Runnable {

	private static int cpt = 0;
	public final int id;
	private Corde laCorde;

	private Position pos;

	public Kong(Corde c) {
		id = cpt++;
		pos = Position.getRandom();
		laCorde = c;


	}

	@Override
	public String toString() {
		return "Kong [id=" + id + ", pos=" + pos + "]";
	}

	public void traverser() {

	}

	public void run() {
		try {
			laCorde.accederKong(pos);
			System.out.println(this.toString() + " a pris la corde");
			traverser();
			System.out.println(this.toString() + " est arrivé");
			laCorde.lacherKong(pos);
		} catch (InterruptedException e) {
			System.out.println("Pb babouin!");
		}
	}

}
