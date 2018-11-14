

import java.util.List;
import java.util.Random;

public class Effaceur implements Runnable{

	private EnsembleDonnees es ;
	private static int cpt = 1;
	@SuppressWarnings("unused")
	private int id;
	private final Object mutex = new Object();
	private Random gen;
	
	public Effaceur(EnsembleDonnees es) {
		synchronized(mutex) {
			id = cpt ++;
		}
		this.es = es;
		gen = new Random();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i =0; i < 3; i++) {
			int rand = gen.nextInt(20) +1;
			try {
				System.out.println("L'effaceur va effacer " + rand);
				es.effacerDonnee(rand);
				System.out.println("Apres qu'on ai efface ------------------------------------------ la valeur");
				List<Integer> liste = es.getListe();
				for(int j = 0; j< liste.size(); j++) {
					System.out.println("apres suppression : " + liste.get(j));
				}
				System.out.println("Apres qu'on ai efface ------------------------------------------ la valeur");
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NonPresentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

}
