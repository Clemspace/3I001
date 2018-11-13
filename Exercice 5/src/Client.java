
public class Client implements Runnable {
	
	private static int cpt = 0;
	public final int id;
	private Salon s;
	public Object o;
	
	public Client (Salon salon) {
		cpt++;
		this.id = cpt;
		this.s = salon;
		this.o = new Object();
		
	}
	
	
		
		
		
	public void run() {
		
		s.ClientArrive(this);
		
		
		
	}
	
	

}
