import java.util.Concurrent.*;

public class Kong implements Runnable {

    private static int cpt = 0;
    public final int id;
    private Corde laCorde;

    private Position pos;

  public Babouin(Corde c){
    id = cpt++;

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
