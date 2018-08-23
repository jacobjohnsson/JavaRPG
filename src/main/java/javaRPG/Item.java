package javaRPG;

public abstract class Item {
  String name;
  String description;
  int cost;

  public String toString() {
    return name + ", " + cost + "gp.";
  }

  public String getName()       {return name;}
  public String getDescription(){return description;}
  public int    getCost()       {return cost;}


}
