package javaRPG;

public class Attribute {
  public enum Type {STRENGTH, AGILITY, INTELLIGENCE}
  int value;
  int bonus;

  public Attribute(int value) {
    this.value = value;
    bonus = 0;
  }

  public Attribute(int value, int bonus){
    this.value = value;
    this.bonus = bonus;
  }

  public void addBonus(int bonus) {
    if ((this.bonus + bonus) >= 0) {
      this.bonus = this.bonus + bonus;
    }
    System.out.println("Bonus added!: " + bonus);
  }

  public void removeBonus(int bonus) {
    addBonus(bonus * -1);
  }

  public int getValue() {return value;}
  public int getBonus() {return bonus;}
  public int get()      {return value + bonus;}
}
