import java.util.Concurrent.*;

public class Corde {
    // gérer la section critique, soit locks, soit semaphores

    private final Semaphore mutex; // substitut lock
    private final Semaphore attente;// substitut condition attenteBabouin
    private final Semaphore attenteKong; // substitut attenteKong

    private Position pos;
    private int capaciteCorde;
    private int nbCorde = 0;
    private int cptAttente = 0;
    private int cptAttenKong = 0;

    public Corde(int cpCorde) {
	position = null;
	capaciteCorde = cpCorde;
	mutex = new Semaphore(1, true);
	attenteKong = new Semaphore(0, true);
	attente = new Semaphore(0, true);
    }

    public void acceder(Position pos) throws InterruptedException {
	mutex.acquire();
	
	mutex.release();
    }

    public void lacher(Position pos) {
	mutex.release();

    }

    public void accederKong(Position pos) throws InterruptedException {
	mutex.acquire();

    }

    public void lacherKong(Position pos) {
	mutex.release();

    }
}
