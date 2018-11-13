import java.util.concurrent.locks.*;

public class SegTournant implements Runnable{

	private int pos;
	public int dest;
	
	
	private boolean appelable = true;
	private boolean occupe = false;
	private boolean positionOk = false;
	
	private Lock lock= new ReentrantLock();
	private Condition SegTourOqp  = new Condition(); 
	private Condition AttenteAppel = new Condition();
	private Condition PosOK = new Condition();
	private Condition AttenteEntree = new Condition();

	private poolHangars pHangars;
	
	
	
	public void appeler(int num) {
		
		lock.lock();
		
		try {
			while (occupe){
				SegTourOqp.await();
			}
			appelable = true;
			dest = num;
			AttenteAppel.signalAll();
			
		}finally {
			
			lock.unlock();
		}
	}
	
	
	
	public int getPosition() {
		return pos;
	}
	
	public void seDeplacer() {
		
		lock.lock();
		try{
			pos = dest;
			PosOK.signalAll();
			
					
		}finally{
			lock.unlock();
		}
		
		
		
	}
	
	public void entrer(int id) {
		
		lock.lock();
	
		occupe = true;		
		
		lock.unlock();
		
		
	}
	
	public void attendreAppel()throws InterruptedException{
		lock.lock();
		try{
			
			while(!appelable) {
				AttenteAppel.await();
			}
					
		}finally{
			lock.unlock();
		}
		
	}
	
	public void attendreEntree()throws InterruptedException{
		lock.lock();
		try{
			
			while(!occupe) {
				AttenteEntree.await();
			}


			
					
		}finally{
			lock.unlock();
		}
		
	}
	
	public void attendrePositionOK() throws InterruptedException{
		
		try{
			
			while(dest != pos) {
				PosOk.await();
			}
			SignalAll();		
		}finally{
			lock.unlock();
		}
	}
	public void sortir(){
		
		lock.lock();
		
		occupe = false;
		AttendreVide.signalAll();

		lock.unlock();

	}
	
	public void attendreVide() throws InterruptedException{
		lock.lock();
		try{
			while(occupe){
				AttendreVide.await();
			}

		}finally{
			lock.unlock();
		}
	}
	
	public void run() {
		try {
			while (true) {
				attendreAppel();//ok
				seDeplacer(); //ok
				attendreEntree();
				seDeplacer();
				attendreVide();
			}
		}
		catch (InterruptedException e) {
			System.out.println("Terminaison sur interruption du segment tournant");
		}
	}

}
