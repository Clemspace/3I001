//import java.util.*;
//import java.util.concurrent.Condition;

public class TestServeur{

	public static void main(String[] args){

		final int NB_CLIENTS = 6;
		final int NB_REQUETES = 5;

		Serveur serveur = new Serveur();
		Thread clients[] = new Thread[NB_CLIENTS];
        //Serveur serv = (Serveur)serveur;

		for(int i = 0;i < NB_CLIENTS ; i++){
			clients[i]  = new Thread(new Client(NB_REQUETES, serveur));
			

		}
		Thread serv = new Thread(serveur);
		serv.start();
		for(int i = 0;i < NB_CLIENTS ; i++){
			
			clients[i].start();

		}
        try{
            for(int i = 0;i < NB_CLIENTS ; i++){
                clients[i].join();

            }
        }catch(InterruptedException e){
                System.out.println("Oopsie ! "+e);
        }
		serv.interrupt();

	}
}
