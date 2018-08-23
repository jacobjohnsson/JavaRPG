package action;

import javaRPG.Actor;

public class MageActionBehavior implements IActionBehavior {
  Actor self;

  public MageActionBehavior(Actor actor) {
    self = actor;
  }

  public Action act(Actor target) {
    Action result;
    if (self.getCurrentHP() < 6) {
      result = new HealAction(self, self.intelligenceRoll());
    } else {
      result = new AttackAction(target, self.getNormalAttackDamage(), self.attackRoll());
    }
    return result;
  }
}
