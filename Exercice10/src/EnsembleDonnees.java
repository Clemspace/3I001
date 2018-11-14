

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class EnsembleDonnees {

	private List<Integer> liste;
	private ReentrantReadWriteLock l = new ReentrantReadWriteLock();
	
	public EnsembleDonnees() {
		liste = new ArrayList<Integer>();
	}
	
	public List<Integer> getListe(){
		return liste;
	}
	
	public void ajouterDonnee(int donnee) {
		l.writeLock().lock();
		try {
			System.out.println("L'ecrivain ajoute " + donnee +" a la case " + liste.size());
			liste.add(donnee);
		}
		finally
		{
			l.writeLock().unlock();
		}
		
	}
	
	public void lireDonnee() {
		l.readLock().lock();
		try {
			System.out.println("le lecteur va parcourir le tableau");
			for(int i=0; i< liste.size(); i++) {
				System.out.println("la case " + i + "vaut : " + liste.get(i));
			}
			System.out.println("--------------------------------------------------------------------");
		}
		finally
		{
			l.readLock().unlock();
		}
		
	}
	
	public void effacerDonnee(int donnee) throws NonPresentException{
		l.writeLock().lock();
		try
		{
			int cpt =-1;
			for(int i = 0; i< liste.size(); i++) {
				if(liste.get(i) == donnee) {
					cpt = i;
				}
			}
			
			if(cpt == -1) {
				throw new NonPresentException(donnee);
			}
			
			System.out.println("la derniere occurence de " + donnee + " est " + cpt);
			System.out.println("On va donc supprimer la case " + cpt);
			liste.remove(cpt);
		}
		finally
		{
			l.writeLock().unlock();
		}
		
	}
}
