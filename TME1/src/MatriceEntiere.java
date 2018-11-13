import java.util.Arrays;
import java.io.*;

public class MatriceEntiere {
	
	private int x,y;
	private int[][] matrice;
	
	public MatriceEntiere(int lignes, int colonnes) {
		x = lignes;
		y = colonnes;
		matrice = new int[x][y];

		
	}
	public MatriceEntiere(int lignes, int colonnes, int [][]mat) {
		x = lignes;
		y = colonnes;
		matrice = mat;
	}

	public MatriceEntiere(File fichier)throws IOException {
		
		BufferedReader in = new BufferedReader(new FileReader(fichier));
		x =Integer.parseInt(in.readLine()) ;
		y =Integer.parseInt(in.readLine());
		matrice = new int [x][y];
		
		for (int i = 0; i < x;i++) {
			String []s = in.readLine().split(" ");
			for (int j = 0;j < y; j++){
				matrice[i][j] = Integer.parseInt(s[j]); 
			}
			
		}
	}
	
	void initZero() {
		
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				matrice[i][j] = 0;
			}
		}
		return;
		
	}
	
	MatriceEntiere MatrixTranspose() {
		int [][] tmp = new int[y][x];
		
				
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				tmp[i][j] = matrice[j][i];
			}
		}
		
		MatriceEntiere m = new MatriceEntiere(this.y, this.x, tmp);
		return m;
	}
	
	MatriceEntiere SumMatrix(MatriceEntiere A, MatriceEntiere B) {
		try {
			VerifSumMatrixes(A,B);
			
		}catch(TaillesNonConcordantesException e) {
			System.out.println(e.getMessage());
		}
		
		int [][] sum= new int[A.x][A.y]; 
		
		for(int i = 0; i < x; i++){
			for(int j = 0; j < y; j++) {
				sum[i][j] = A.matrice[i][j]+B.matrice[i][j];
			}
		}
		
		MatriceEntiere somme = new MatriceEntiere(A.x,B.x, sum);
		return somme;
		
		
	}
	
	MatriceEntiere ProductMatrix(MatriceEntiere A, MatriceEntiere B){
		try {
			VerifProductMatrixes(A,B);
			
		}catch(TaillesNonConcordantesException e) {
			System.out.println(e.getMessage());
		}
		
		int [][] prod= new int[A.x][B.y]; 
		
		for(int i = 0; i < x; i++){
			for(int j = 0; j < y; j++) {
				for(int k = 0; k < B.y; j++) {
			
				prod[i][j] = prod[i][j] +A.getElem(i,k)*B.getElem(k,j);
				}
			}
		}
		
		MatriceEntiere produit = new MatriceEntiere(A.x,B.y, prod);
		return produit;

		
	}

	public static int[][] multiplicationMatrices(MatriceEntiere mat1, MatriceEntiere mat2) throws TaillesNonConcordantesException{
		 
		// condition pour verifier la taille des matrices
		if(!(mat1.getNbColonnes() == mat2.getNbLignes())){
			throw new TaillesNonConcordantesException();
		}
		else {
			// init du tableau a deux dimensions qui va stocker les valeurs de la multiplication des matrices
			int[][] matFinale = new int[mat1.getNbLignes()][mat2.getNbColonnes()];
			
			// on applique la formule donnée pour la multiplication de deux matrices
			for(int k=0; k< mat1.getNbColonnes(); k++) {
				
				for(int i=0; i< mat1.getNbLignes(); i++) {
					for(int j=0; j< mat2.getNbColonnes(); j++) {
						
						
						matFinale[i][j] += mat1.getElem(i, k) * mat2.getElem(k, j);
					}
				}
			}
			
			// on retourne matFinale qui est le resultat de la multiplication des deux matrices
			return matFinale;
		}
	}
	

	void VerifSumMatrixes(MatriceEntiere A, MatriceEntiere B) throws TaillesNonConcordantesException {
		if(A.x != B.x || A.y != B.x)
			throw new TaillesNonConcordantesException("Les matrices ne sont pas sommables");
	}
	
	void VerifProductMatrixes(MatriceEntiere A, MatriceEntiere B) throws TaillesNonConcordantesException {
		if(A.y != B.x )
			throw new TaillesNonConcordantesException("Les matrices ne sont pas multipliables");
	}
	
	int getElem(int i, int j) {
		return matrice[i][j];
	}
	void setElem(int i, int j, int val) {
		matrice[i][j] = val;
		return;
		
	}
	 int getNbLignes() {
		 return this.x;
	 }
	 int getNbColonnes() {
		 return this.y;
	 }
	
	

	@Override
	public String toString() {
		return "MatriceEntiere [matrice=" + Arrays.toString(matrice) + "]";
	}
	
	public void displayMatrix() {
		System.out.print(this.toString());
		return;
	}
	
}
