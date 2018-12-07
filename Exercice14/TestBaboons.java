
public static void main(Str[] args){

  final int NB_BABOUINS = 15;
  Corde c = new Corde();

  for(int i = 0; i< NB_BABOUINS; i++){
    Thread t = newThread(new Babouin(c)).start();
  }
  for(int i = 0; i< NB_BABOUINS; i++){
    t.join();
  }
  System.out.println("Fin de l'éxécution, bisous!");

}
