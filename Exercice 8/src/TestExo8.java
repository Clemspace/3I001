
public class TestExo8 {

	public static void main(String[] args) {
		
		final int nbObjets = 100;
		final int capaciteChariot = 10;
		final int poidsChariot = 200;
		AleaStock s = new AleaStock(nbObjets);
		
		for (int i = 0; i < nbObjets; i++) {
			
			AleaObjet objet = new AleaObjet(1,10);
			s.remplir(objet);
		}
		
		Chariot c = new Chariot(capaciteChariot, poidsChariot);
		
		Thread t1 = new Thread(new Chargeur(s, c));
		//Thread t2 = new Thread (new Dechargeur(c));
		t1.start();
		//t2.start();
		
		

	}

}
