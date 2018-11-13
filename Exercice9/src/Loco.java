

public class Loco implements Runnable{
	
	private static int cpt = 0;
	private final int id;
	
	private SegAccueil sAccueil;
	private SegTournant sTournant;
	private PoolHangars pHangars;
	
	public Loco() {
		id =+cpt;
		
		
	}

	public void run() {
		try {
			sAccueil.reserver(); //ok
			sTournant.appeler(0);
			sTournant.attendrePositionOK();
			sTournant.entrer(id);
			sAccueil.liberer();
			sTournant.attendrePositionOK();
			pHangars.getHangar( sTournant.getPosition() ).entrer(id);
			sTournant.sortir(id);
		}
		catch (InterruptedException e) {
			System.out.println("Loco " + id + " interrompue (ne devrait pas arriver)");
		}
		
	}

	
}
