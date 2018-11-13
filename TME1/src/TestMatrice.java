import java.io.File;
import java.io.IOException;
public class TestMatrice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("donnees_test_scalaire");
		//File f = new File("/Infos/lmd/2018/licence/ue/3I001-2018oct/TME/TME1/donnees_test_scalaire");
		MatriceEntiere m;
		try {
			m = new MatriceEntiere(f);
			m.displayMatrix();

			
			
		}catch(IOException e) {
			System.out.println("LVDMM CA MARCHE PAS");
		}
	}

}
