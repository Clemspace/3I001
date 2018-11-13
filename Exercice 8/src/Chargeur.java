
import java.util.concurrent.locks.*;

public class Chargeur implements Runnable{
	
	private final int id;
	private static int cpt = 0;
	
	private AleaStock stock;
	private Chariot chariot;
	
	private AleaObjet objetCourant;
	
	public Chargeur( AleaStock stock, Chariot chariot){
	
		cpt++;
		this.id = cpt; 
		
		

		this.stock = stock;
		this.chariot = chariot;
		
		this.objetCourant = null;
		
		
	}
	
	
	public void empile(){
		
		try {
			
			chariot.remplir = true;
			while(chariot.pasPlein()){// "porte" l'objet du stock vers le chariot		
				
			
				
				objetCourant = stock.extraire(stock.getNbElem());//on extrait l'elem du stock et le chargeur le porte
				chariot.charge(objetCourant);
			}
			
		}
		finally{
			
		}
		
		
	}
	
	
	public void run(){
		
		try {
			
			while(!stock.stockEstVide()){
				
				empile();
				chariot.attendreChargeur();
				System.out.println("Fin Run Chargeur");
			}
			
			
			
			
		}catch(InterruptedException e) {
			System.out.println("Thread Interrompu");
		}
		
	}
	
	

}
