
public class AleaStock {
	
	private int taille;
	private AleaObjet[] stock;
	private int nbElem;
	
	public int getNbElem() {
		return nbElem;
	}

	private void setNbElem(int nbElem) {
		this.nbElem = nbElem;
	}

	public AleaStock(int taille) {
		taille =taille;
		stock = new AleaObjet[taille];
		nbElem = 0;
	}
	
	public boolean stockEstVide(){
		return nbElem==0;
	}
	public AleaObjet extraire(int id){
		
		AleaObjet o  = null;
		if(!stockEstVide()){
			 
			for(int i = nbElem;i< 0;i--) {
				
				if (id == stock[i].getId()){
					
					o = stock[i];
					stock[i] = null;
					nbElem--;
					return o;
					
				}
			}
			
		}
		return o;
	}
	
	
	
	public void remplir(AleaObjet objet) {
		
		stock[nbElem] = objet;
		nbElem++;
		
	}
}
