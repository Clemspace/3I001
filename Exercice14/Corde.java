import java.util.concurrent.*;

public class Corde {
	// gérer la section critique, soit locks, soit semaphores

	private final Semaphore rope;
	private final Semaphore mutex; // substitut lock
	private final Semaphore attente;// substitut condition attenteBabouin
	private final Semaphore attenteKong; // substitut attenteKong

	private Position position;
	private final int capaciteCorde;

	private int nbCorde = 0;
	private int cptAttente = 0;
	private int cptAttenteKong = 0;

	public Corde(int cpCorde) {

		position = null;
		capaciteCorde = cpCorde;

		rope = new Semaphore(cpCorde, true);
		mutex = new Semaphore(1, true);

		attenteKong = new Semaphore(0, true);
		attente = new Semaphore(0, true);
	}

	public void acceder(Position pos) throws InterruptedException {
		mutex.acquire();

		while (pos != null && pos != position && nbCorde == capaciteCorde) {
			
			
		}
		
		
		position = pos;
		rope.acquire();
		nbCorde++;

		mutex.release();

	}

	public void lacher(Position pos) throws InterruptedException {
		mutex.acquire();
		nbCorde--;
		if (nbCorde == 0) {
			position = null;
		}
		rope.release();

		mutex.release();

	}

	public void accederKong(Position pos) throws InterruptedException {
		mutex.acquire();

	}

	public void lacherKong(Position pos) throws InterruptedException {
		mutex.acquire();
		nbCorde = 0;
		position = null;
		rope.release();
		mutex.release();

	}
}
