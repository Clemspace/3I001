
public class Barbier implements Runnable {
	public int cpt; //cptclients
	private Salon s;
	
	public Barbier(Salon salon) {
		this.cpt = 0;
		this.s = salon;
		
	}
	
	public void run(){
		
		
	
		while(true) {
			try {
				
				while(s.salonVide()) { //tant que le salon est vide
					
					s.Attend(this);
					
				}
				s.coiffer(this);
				System.out.println("runBarbier");

			}catch(InterruptedException e){
				System.out.println("runBarbier");
			}
			
		}
	}
}
		
		
			

		
		
	

