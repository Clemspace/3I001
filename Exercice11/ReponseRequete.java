

public class ReponseRequete{
	
	private int id;
	//private String message;
	private int valeur;
	private int type;


	public ReponseRequete(int id, int type){
		id = ++cpt;
		valeur = val;
		client = c;
		
	}

	public String toString(){
		return "requete: (" + client +", "+ valeur+", "+type+")"; 
	}


}
