import java.util.concurrent.locks.*;
import java.util.*;
//import java.util.concurrent.Condition;

public class Serveur implements Runnable{

	
	private ReponseRequete r;
	private final Lock lock= new ReentrantLock();
	
	private final Condition nouvelleRequete = lock.newCondition();
	private final Condition clientAttente = lock.newCondition();

	private boolean oisif;

	public Serveur(){
	
		oisif = true;

	}

	public void soumettre(int id, int i) throws InterruptedException{
		lock.lock();
		try{
			while(!oisif){
				clientAttente.await();
				System.out.println("Le Client "+id+ " attend ");
			}
				oisif = false;
				r = new ReponseRequete(id, i);
			
				nouvelleRequete.signalAll();
			
		}finally{
			lock.unlock();
		
        }
    }


	public void attendreRequete() throws InterruptedException{
		
		lock.lock();
		try{
			while(oisif){
				System.out.println("Le Serveur attend ");
				nouvelleRequete.await();
			}
			System.out.println("Le Serveur travaille ");

			oisif = false;
			

		}finally{
			lock.unlock();
		}

	}

	public void traiterRequete(){
		
		lock.lock();
		
		try{
			oisif = true;
			clientAttente.signalAll();
		
		}finally{
			lock.unlock();
		}

	}
	

                              
	public void run(){
		try{
		
			while(true){ //a changer pour terminaison du run serveur propre
				attendreRequete();
				traiterRequete();
			}
			}catch(InterruptedException e){
				System.out.println("Serveur interrompu!");
			}

		

	}


}

