public enum Position{

  NORD(0), SUD(1);

  private Position(int index){
      this.index = index;
  }
  private final int index;

  public int index(){return index;}
  
}
