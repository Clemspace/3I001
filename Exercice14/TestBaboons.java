import java.util.concurrent.*;
public class TestBaboons {

	public static void main(String[] args) {

		final int NB_BABOUINS = 15;
		final int NB_KONGS = 1;
		Corde c = new Corde(5);

		// TODO gérer accès aux threads pour le join des classes

		for (int i = 0; i < NB_BABOUINS; i++) {
			Thread t = new Thread(new Babouin(c));
			t.start();
		}
		for (int i = 0; i < NB_KONGS; i++) {
			Thread t = new Thread(new Kong(c));
			t.start();
		}
		/*for (int i = 0; i < NB_BABOUINS; i++) {
			t.join();
		}
		for (int i = 0; i < NB_KONGS; i++) {
			t.join();
		}*/
		
		System.out.println("Fin de l'éxécution, bisous!");

	}
}
