
public static void main(Str[] args){

  final int NB_BABOUINS = 15;
  final int NB_KONGS = 1;
  Corde c = new Corde();

  //TODO gérer accès aux threads pour le join des classes

  for(int i = 0; i< NB_BABOUINS; i++){
    Thread t = newThread(new Babouin(c)).start();
  }
  for(int i = 0; i< NB_KONGS; i++){
    Thread t = newThread(new Kong(c)).start();
  }
  for(int i = 0; i< NB_BABOUINS; i++){
    t.join();
  }
  for(int i = 0; i< NB_KONGS; i++){
    t.join();
  }
  System.out.println("Fin de l'éxécution, bisous!");

}
