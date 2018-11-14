

import java.util.Random;

public class Producteur implements Runnable{

	private EnsembleDonnees es;
	private static int cpt = 1;
	@SuppressWarnings("unused")
	private int id;
	private final Object mutex = new Object();
	private Random gen;
	private final int AJOUT_MAX = 4;
	
	public Producteur(EnsembleDonnees es) {
		synchronized(mutex) {
			id = cpt ++;
		}
		this.es = es;
		gen = new Random();
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			for(int i=0; i < 3 ; i++) {
				for(int j = 0; j < AJOUT_MAX; j++) {
					es.ajouterDonnee(gen.nextInt(19) + 1);
					Thread.yield();
				}
				Thread.sleep(1000);
			}
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
