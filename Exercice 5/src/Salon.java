
public class Salon {
	
	private int nbPlaces;
	public int nbPlacesLibres;
	private Client[] Chaises;
	protected final Object moniBarbier;
	
	public Salon(int nbPlaces) {
		
		this.nbPlaces = nbPlaces;
		this.nbPlacesLibres = nbPlaces;
		this.Chaises = new Client[nbPlaces];
		for(int i = 0; i < nbPlaces; i++) {
			Chaises[i]= null;
		}
		this.moniBarbier = new Object();
	}
	
	public synchronized boolean salonPlein() {
		return (nbPlacesLibres == 0);
	}
	public synchronized boolean salonVide() {
		return (nbPlacesLibres==nbPlaces);
	}
	

	public void Attend(Barbier b)throws InterruptedException{
		
		synchronized(moniBarbier){
			moniBarbier.wait();
			}
		
	}
	
	public void ReveilleClient(Client c) {
		
		synchronized(c.o) {
		
			c.notifyAll();
		}
	}
	
	public synchronized void ClientInstalle(Client c) {
		
		int i = 0;
		while(this.Chaises[i] != null) {
			i++;
		}
		
		
		
	}
	
	public synchronized void ClientArrive(Client c) {
		
		
		try {
			if (salonPlein()) {
			
				System.out.println("Je m'en vais!");
			}
		
			else if(salonVide()){ //le client s'installe a une place non occupée, et notifie le coiffeur
				
				System.out.println("premier!" + c.id);
				synchronized(this.moniBarbier) {	
				
					this.ClientInstalle(c);
					moniBarbier.notifyAll();
				

			
				}
				System.out.println("fini!" +nbPlacesLibres);

						
		}
		else if(!salonVide() && !salonPlein()) {//le client s'installe a une place non occupée
			
			System.out.println("bonjour" + c.id);
				ClientInstalle(c);
						
			
			
		}
		}catch(InterruptedException e) {
			System.out.println("interrompu");
		}

		
	}
	
	
	
	public synchronized void coiffer(Barbier s) { 
	
		int i = 0;
		while(this.Chaises[i]==null) {
			i++;
		}
			s.cpt++;
			ReveilleClient(Chaises[i]);
			Chaises[i] = null;
		
	}
	
	

}
