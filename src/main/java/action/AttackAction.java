package action;

import javaRPG.Actor;

public class AttackAction extends Action {
  int damage;
  int attackRoll;

  public AttackAction(Actor target, int damage, int attackRoll) {
    this.damage = damage;
    this.target = target;
    this.attackRoll = attackRoll;
  }

  public void execute() {
    target.hitWithWeapon(damage, attackRoll);
  }
}
