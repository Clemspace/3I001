import java.util.concurrent.locks.*;

public class SegAccueil {
	
	private final int pos = 0;//position du seg d'accueil est toujours 0;
	private boolean occupe = false;
	
	private ReentrantLock lock = new ReentrantLock();
	private Condition SegAccueilOccupe= new Condition();
	
	
	public SegAccueil(){
		
	}
	
	public  void reserver()throws InterruptedException{//appelée par une locomotive
		
		lock.lock();
		
		try {
			
			while(occupe){
				SegAccueilOccupe.await();
			}
			occupe = true;
			
		}finally{
			
			lock.unlock();
			
		}
	}
	
	public  void liberer(){
		
		lock.lock();
		try{
			occupe = false;
			SegAccueilOccupe.signalAll();
		}finally{
			lock.unlock();
		}
	}
	

}
