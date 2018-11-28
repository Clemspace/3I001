

public class ReponseRequete{
	

	private int id;
	//private String message;
	private int valeur;
	private int type;


	public ReponseRequete(int id, int val){
		id = id;
		valeur = val;

		if(id % 3 != 0){
			type = 1;
		}else{
			type = 2;
		}
		System.out.println(this.toString());
	}

	public String toString(){
		return "requete: (" + id +", "+ valeur+", "+type+")"; 
	}


}
