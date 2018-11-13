import java.util.ArrayList;

import java.util.concurrent.locks.*;

public class Chariot{ 
	
	private int poidsMax;
	private int nbMax;
	
	private Lock lock;
	private Condition Dechargeable;
	private Condition Chargeable;
	
	public boolean remplir = false;
	public boolean vider = false;
	
	private int poids;
	private int nb;

	private ArrayList <AleaObjet> chariot;
	
	public Chariot(int nbMax, int poidsMax) {
		
		poidsMax = poidsMax;
		nbMax = nbMax;
		
		this.lock = new ReentrantLock();
		this.Dechargeable = lock.newCondition();
		this.Chargeable = lock.newCondition();
		
		poids = 0;
		nb = 0;
		chariot = new ArrayList<AleaObjet>(nb);
	}
	
	public synchronized boolean pasPlein(){
		
		return (poidsMax <= poids||nbMax <= nb);
	}
	public synchronized boolean plein(){
		
		return (poidsMax >= poids||nbMax >= nb);
	}
	
	public void charge(AleaObjet o) {
		
		try{
			nb++;
			poids += o.getPoids();
			chariot.add(o);
			
			if(plein()){
				
				Dechargeable.signalAll();
			}
			
		} 
		finally {
			
		}
	}
	
	
		public void attendreDeChargeur() throws InterruptedException{
		
		try {
			lock.lock();
			
			while(remplir){
				Chargeable.wait();
			}
		}
		finally{
			lock.unlock();
		}
		
		
		
	}

	public void attendreChargeur() throws InterruptedException{
			
			try {
				lock.lock();
				while(vider) {
					Chargeable.await();
				}
			}finally{
					
				lock.unlock();
			}
			
			
			
		}
	public void decharge(AleaObjet o) {
		
		try{
			lock.lock();
		
			nb--;
			poids+= o.getPoids();
			chariot.remove(o);
			if(nb == 0) {
				
				Chargeable.signal();
			}
		} 
		finally {
			lock.unlock();
		}
		
	}
	
	

}
