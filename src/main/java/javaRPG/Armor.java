package javaRPG;

public class Armor extends Item {
  int armorPenalty;
  int defense;

  public Armor(String name, String desc, int def, int ap, int cost){
    this.name = name;
    description = desc;
    this.defense = def;
    armorPenalty = ap;
    this.cost = cost;
  }

  public int getArmorPenalty(){
    return armorPenalty;
  }

  public int getDefense(){
    return defense;
  }

  public int getCost(){
    return cost;
  }
}
