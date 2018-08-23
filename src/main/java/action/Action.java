package action;

import javaRPG.Actor;

public abstract class Action {
  Actor target;

  public abstract void execute();
}
