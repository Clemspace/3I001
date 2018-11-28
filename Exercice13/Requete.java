import java.util.Random;

public class Requete{

	private Client client;
	private int valeur;
	private int type;
	private Random gen = new Random();



	public Requete(Client c){
		client = c;
		int val = gen.nextInt[];
		if(client.id % 3 != 0){
			type = 1;
		}else{
			type = 2;
		}

	}

}