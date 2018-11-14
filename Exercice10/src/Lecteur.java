
public class Lecteur implements Runnable{

	@SuppressWarnings("unused")
	private int id;
	private static int cpt = 1;
	private EnsembleDonnees es;
	private final Object mutex = new Object();
	
	public Lecteur(EnsembleDonnees ensemble) {
		synchronized(mutex) {
			id = cpt ++;
		}
		es = ensemble;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 3 ; i++) {
			try {
				es.lireDonnee();
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
