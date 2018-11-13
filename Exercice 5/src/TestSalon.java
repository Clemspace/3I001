
public class TestSalon {

	public static void main(String[] args) {

		int nbClients =10;
		Salon s = new Salon(8);
		Thread b = new Thread(new Barbier(s));
		Thread[] th = new Thread[nbClients];
		
		b.start();
		
		for (int i = 0; i< nbClients ; i++) {
			 th[i] = new Thread(new Client(s));
		}
		try {
			for (int i = 0; i< nbClients ; i++) {
				th[i].start();
			}
			for (int i = 0; i< nbClients ; i++) {
				th[i].join();
			}
			b.interrupt();
			

		}catch (InterruptedException e)
		{
			System.err.println("ALED");
		}
		finally {
			System.out.println("tadaa");
		}
		
		
		
		
	}

}
