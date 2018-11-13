import java.util.Arrays;

public class Salle {
	private int nbRangs;
	private int nbPlacesParRang;
	private int nbPlacesLibres;
	private boolean[][] placesLibres;
	
	public Salle(int nbRangs, int nbPlacesParRang) {
		
		this.nbRangs = nbRangs;
		this.nbPlacesParRang = nbPlacesParRang;
		this.nbPlacesLibres = nbRangs* nbPlacesParRang;
		this.placesLibres = new boolean[nbRangs][nbPlacesParRang];
		
		for (int i = 0; i < nbRangs ; i++ ) {
			for(int j = 0; j < nbPlacesParRang; j++ ) {
				placesLibres[i][j] = true;
			}
		}
	}
	
	private boolean capaciteOK(int n) {	// renvoie vrai s’il y a encore au moins n places libres dans la salle;

		return (n <= nbPlacesLibres);
		
	}
	
	 private int nContiguesAuRangI(int n, int i) { //: renvoie -1 s’il n’y pas n places libres cote a cote au rang i. Sinon,
		 										  //renvoie la position j qui est la premiere du bloc de n places libres au rang i;

		int cpt = 0;
		for(int j = 0; j < nbPlacesParRang; j++) {
			
			if ( n > cpt+(nbPlacesParRang-j)) {// on sait alors qu'on aura pas assez de place dans la rangée, même sans aller au bout
				return -1;
			}
			if(placesLibres[i][j]==true) {
				cpt++;
				if(cpt == n) {
					return j-n;
				}
			}
			else{
				cpt = 0;
			}	
		}
		return -1;
	}
	
	 private boolean reserverContigues(int n) { //: lorsque c’est possible, execute pour le groupe appelant la r ´ eservation de ´ n
		 									   //places contigues et renvoie vrai. Renvoie faux sinon.
		 
		 int deb = -1, i;
		 
		 	
		 
			for(i = 0; i < nbRangs && deb != -1; i++)
			{
				deb = nContiguesAuRangI(n, i); //deb = premiere place dispo au rang i valide
			}
			

			if (deb != -1) 
				return false;
			else {
				
				for(int j = 0; j < (deb+n) ; j++) {
					
				placesLibres[i][j] = false;
				nbPlacesLibres--;
				}
				return true;

			}
	 }
	 
	 public synchronized boolean reserver(int n)
		{
			if (!capaciteOK(n))
			{
				return false;
			}
			
			for (int k = 0; k < nbRangs; k++) {
				
			
				if (!reserverContigues(n)) // alors on reserve comme on peut
				{
					for(int i = 0; i < nbRangs; i++)
					{
						for(int j = 0; j < nbPlacesParRang; j++)
						{
							if(n==0) {
								return true;
							}
							else if (placesLibres[i][j])
							{
								nbPlacesLibres--;
								placesLibres[i][j] = false;
								n--;
							}
						}
					}
				}
			}
			return true;
		}
	 
	 public synchronized void cancel(int rang, int place){
			
		 placesLibres[rang][place] = true;
		
	 }

	 

	@Override
	public String toString() {
		String s ="";
		for (int i = 0; i < nbRangs;i++) {
			s+= Arrays.toString(placesLibres[i])+ "\n";
		}
		return "Salle [nbRangs=" + nbRangs + ",\n nbPlacesParRang=" + nbPlacesParRang + ",\n placesLibres=\n"
				+ s + "]";
	}
	 
}
