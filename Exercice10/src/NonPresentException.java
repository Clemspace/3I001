

public class NonPresentException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NonPresentException(int n) {
		super("la donnee " + n + " n'es pas presente dans la liste ");
	}
	

}
