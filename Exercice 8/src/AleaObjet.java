
public class AleaObjet {

	private int poids;
	private final int id;
	private static int cpt = 0;
	
	
	public AleaObjet( int min, int max) {
		cpt++;
		id = cpt;
		int poids =(int) (Math.random()*(max-min) +min);
		
	}


	public int getPoids() {
		return poids;
	}


	private void setPoids(int poids) {
		this.poids = poids;
	}


	public int getId() {
		return id;
	}


	@Override
	public String toString() {
		return "AleaObjet [poids=" + poids + ", id=" + id + "]";
	}
}
