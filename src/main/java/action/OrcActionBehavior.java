package action;

import javaRPG.Actor;
import javaRPG.Dice;

public class OrcActionBehavior implements IActionBehavior {
  Actor self;

  public OrcActionBehavior(Actor self) {
    this.self = self;
  }

  public Action act(Actor target) {
    // Orcs only attack
    return new AttackAction(target, self.getNormalAttackDamage(), self.attackRoll());
  }
}
