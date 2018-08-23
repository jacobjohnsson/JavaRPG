package action;

import javaRPG.Actor;

public class HealAction extends Action {
  int heal;

  public HealAction(Actor target, int heal) {
    this.heal = heal;
    this.target = target;
  }

  public void execute() {
    target.heal(heal);
  }
}
