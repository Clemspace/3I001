

public class Test10 {
	
	public static void main(String[] args) {
		
		EnsembleDonnees ensemble = new EnsembleDonnees();
		
		Thread p1 = new Thread(new Producteur(ensemble));
		Thread p2 = new Thread(new Producteur(ensemble));
		Thread e1 = new Thread(new Effaceur(ensemble));
		Thread e2 = new Thread(new Effaceur(ensemble));
		Thread l1 = new Thread(new Lecteur(ensemble));
		Thread l2 = new Thread(new Lecteur(ensemble));
		
		p1.start();
		p2.start();
		l1.start();
		l2.start();
		e1.start();
		e2.start();
		
		try {
			Thread.sleep(10000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		p1.interrupt();
		p2.interrupt();
		l1.interrupt();
		l2.interrupt();
		e1.interrupt();
		e2.interrupt();
		
		System.out.println("la test est terminé");
		
		
		
	}

}
