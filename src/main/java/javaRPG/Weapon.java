package javaRPG;

public class Weapon extends Item {
  WeaponDamage damage;

  public Weapon(String name, String desc, int cost) {
    this.name = name;
    this.description = desc;
    this.cost = cost;
    this.damage = () -> Dice.d6();      // default damage
  }

  public Weapon(String name, String desc, int cost, WeaponDamage damage) {
    this.name = name;
    this.description = desc;
    this.cost = cost;
    this.damage = damage;
  }

  public int getDamage(){
    return damage.getDamage();
  }

  public void setDamageFunction(WeaponDamage damageFunction) {
    damage = damageFunction;
  }
}
