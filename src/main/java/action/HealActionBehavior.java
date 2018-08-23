package action;

import javaRPG.Actor;
import javaRPG.Dice;

public class HealActionBehavior implements IActionBehavior {
  Actor self;

  public HealActionBehavior(Actor actor) {
    self = actor;
  }

  public Action act(Actor target) {
    return new HealAction(target, Dice.roll(6));
  }
}
