

public class Serveur implements Runnable{

	
	private Lock lock= new ReentrantLock();
	
	private Condition nouvelleRequete = new Condition();
	private Condition clientAttente = new Condition();

	private boolean oisif;

	public Serveur(){
	
		oisif = true;

	}

	public void soumettre(int id, int i, int type){
		lock.lock();
		try{
			while(!oisif){
				clientAttente.await();
			}
				nouvelleRequete.signal();
			
		}finally{
			lock.unlock();
		}
	}


	public void attendreRequete()throws InterruptedException{
		
		lock.lock();
		try{
			while(oisif){
				nouvelleRequete.await();
			}
			oisif = false;

		}finally{
			lock.unlock();
		}

	}

	public void traiterRequete(){
		
		lock.lock();
		
		try{
			if(id % 3 != 0){
				;
			}else{
				type = 2;
			}
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
			catch(InterruptedException e){
				System.out.println("Serveur interrompu!");
			}

		}

	}


}

