package action;

import javaRPG.Actor;

public class NoAction extends Action {
  public NoAction(Actor target){
    this.target = target;
  }
  public void execute(){}
}
