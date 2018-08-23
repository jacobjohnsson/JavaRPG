package action;

import javaRPG.Actor;

public class NoActionBehavior implements IActionBehavior {
  public Action act(Actor target) {return new NoAction(target);}
}
