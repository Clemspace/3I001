
public class TestServeur{

	public static void main(String[] args){

		public final int NB_CLIENTS = 6;
		public final int NB_REQUETES = 5;

		
		public Thread[] clients = new Thread[NB_CLIENTS];
		public Thread serveur = new Thread(new Serveur(clients));

		for(int i = 0;i<NB_CLIENTS;i++){
			clients[i]  = new Thread(new Client(NB_REQUETES));
			i.start();

		}

		for(int i = 0;i<NB_CLIENTS;i++){
			i.join();

		}
		serveur.interrupt();

	}
}