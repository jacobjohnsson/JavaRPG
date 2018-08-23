package javaRPG;

import action.*;
import effectSystem.IEffect;

public abstract class Actor {
  String name;
  Race race;
  ActorSheet stats;
  IActionBehavior actionBehavior;
  Weapon equippedWeapon;
  Armor equippedArmor;
  EffectManager effectManager;

  public String getName()          {return name;}
  public String getRace()          {return race.toString();}
  public int    strengthRoll()     {return stats.strengthRoll();}
  public int    agilityRoll()      {return stats.agilityRoll();}
  public int    intelligenceRoll() {return stats.intelligenceRoll();}
  public int    mainRoll()         {return stats.mainRoll();}

  public int defenseRoll(){
    return equippedArmor.getDefense() + stats.getDefense();
  }

  public int attackRoll() {
    return mainRoll();
  }

  public Action act(Actor target){
    return actionBehavior.act(target);
  }

  public void setActionBehavior(IActionBehavior behavior){
    actionBehavior = behavior;
  }

  public int getCurrentHP() {
    return stats.getCurrentHP();
  }

  public int getCurrentMana() {
    return stats.getCurrentMana();
  }

  public Armor getArmor(){
    return equippedArmor;
  }

  public Boolean isDead() {
    return (getCurrentHP() == 0);
  }

  public void setArmor(Armor armor) {
    equippedArmor = armor;
  }

  public void setWeapon(Weapon weapon) {
    equippedWeapon = weapon;
  }

  public void addEffect(IEffect effect){
    effectManager.addEffect(effect);
  }

  public void removeEffect(IEffect effect) {
    effectManager.removeEffect(effect);
  }

  public void heal(int heal) {
    stats.addHP(heal);
  }

  public void hitWithWeapon(int damage, int attackRoll) {
    if (attackRoll > defenseRoll()) {
      System.out.println(name + " was hit: " + damage + "\n");
      stats.addHP(damage * -1);
    } else {
      System.out.println(name + " was missed!\n");
    }
  }

  public int getNormalAttackDamage() {
    return equippedWeapon.getDamage();
  }

  public String fullPrint() {
    return "\n\tCharacter sheet: " +
    "\n\t" + name + ", " + race + "\n\n" + stats.toString() +
    "\n\n\tArmor: " + equippedArmor.getName() +
    "\n\tBase defense: " + stats.getDefense() +
    ", Armor defense: " + equippedArmor.getDefense() + "\n" +
    "\n\tWeapon: " + equippedWeapon.getName() + "\n" +
    "\n\tModifiers: " + effectManager.toString() + "\n";
  }

  public String toString() {
    return name + ", " + race;
  }

  public void reset(){
    stats.reset();
  }
}
