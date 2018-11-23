import java.util.*;
import java.util.concurrent.locks.*;
//import java.util.concurrent.Condition;

public class Client implements Runnable{

	private static int cpt = 0;
	public final int id;
	private Random gen = new Random();
	private final Lock lock = new ReentrantLock();
	private int nbRequetes;
	private Serveur s;
	private final Condition attendReponse= lock.newCondition();


	public Client(int nb, Serveur serveur){// sinon definir type dans une methode de la classe serveur
		
		id = ++cpt;
		nbRequetes = nb;
		s = serveur;

	}

	public void requeteServie(ReponseRequete r){
		
		System.out.println(r.toString());
		attendReponse.signal();
		
	}

	public void run(){

		for(int i = 1; i <= nbRequetes ; i++){
			try{
			s.soumettre(id, i);
			}catch(InterruptedException e){
				System.out.println("Client en famine!");
			}	
		}

	}
}
