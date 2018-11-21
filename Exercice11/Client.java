import java.util.Random;


public class Client implements Runnable{

	private static int cpt = 0;
	public final int id;
	private Random gen = new Random();
	private int type
	private int nbRequetes;
	private Serveur serv;
	private Object mutex = new Object();


	public Client(int nb, Serveur serveur){
		
		id = ++cpt;
		nbRequetes = nb;
		serv = serveur;
		if(id % 3 != 0){
			type = 1;
		}else{
			type = 2;
		}

	}

	public void requeteServie(ReponseRequete r){
		
		mutex.notify();
	}

	public void run(){

		for(int i = 1; i <= nbRequetes ; i++){
			try{
			s.soumettre(id, i, type);
			mutex.wait();
			}catch(InterruptedException e){
				System.out.println("Client en famine!");
			}	
		}

	}
}
