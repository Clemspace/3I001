import java.util.Concurrent.*;

public class Babouin implements Runnable{
    private static int cpt = 0;
    public final int id;
    private Corde laCorde;
    private Position;

    public Babouin(Corde c){
      id = cpt++;

    }
    public void traverser(){

    }
    public String toString(){
      return
    }


    public void run(){
        try{
          laCorde.acceder(position);
          System.out.println(this.toString()+ " a pris la corde");
          traverser();
          System.out.println(this.toString()+ " est arrivé");
          laCorde.lacher(position);
        }catch(InterruptedException e){
          System.out.println("Pb babouin!");
        }
    }
}
