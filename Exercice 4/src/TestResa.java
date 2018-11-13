
public class TestResa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread[] th = new Thread[10];
		Salle s = new Salle(10, 10);
		
		for (int i = 0; i < th.length; i++)
		{
			th[i] = new Thread(new Groupe(7,s));
		}
		try
		{
		for (int i = 0; i < th.length; i++)
		{
			th[i].start();
		}
		
		
			for (int i = 0; i < th.length; i++)
			{
				th[i].join();
			}
		}
		catch (InterruptedException e)
		{
			System.err.println("ALED");
		}
		finally
		{
			System.out.println(s);
		}

	}
}
