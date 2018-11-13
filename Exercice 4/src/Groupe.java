import java.util.ArrayList;

public class Groupe implements Runnable {
	private static int cpt = 0;
	private int id;
	private int nb;
	private  Salle salle;
	private ArrayList<Integer[]> listPos;

	
	public Groupe(int nb, Salle s) {
		cpt++;
		this.id = cpt;
		this.nb = nb;
		this.salle = s;
		listPos = new ArrayList<Integer[]>();

	}
	public void addPos(int rang, int place)
	{
		Integer[] tmp = {rang, place};
		listPos.add(tmp);
	}

	public void cancelAll()
	{
		while (!listPos.isEmpty())
		{
			this.cancelOne();
		}
	}

	public void cancelOne()
	{
		if (!listPos.isEmpty())
		{
			Integer[] tmp = listPos.get(0);
			listPos.remove(0);
			salle.cancel(tmp[0], tmp[1]);
		}
	}

	public void run()
	{
		salle.reserver(this.nb);
	}
	

}
