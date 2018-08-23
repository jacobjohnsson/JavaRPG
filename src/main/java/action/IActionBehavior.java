package action;

import javaRPG.Actor;

public interface IActionBehavior {
  public abstract Action act(Actor target);
}
