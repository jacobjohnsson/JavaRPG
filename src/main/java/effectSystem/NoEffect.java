package effectSystem;

import javaRPG.ActorSheet;

public class NoEffect extends IEffect {
  String name;
  IEffect additionalEffect;
  static NoEffect instance;
  ActorSheet stats;

  private NoEffect() {
    this.name = "No Effect";
    additionalEffect = null;
    instance = this;
  }

  public static NoEffect getInstance() {
    if (instance == null) {
      return new NoEffect();
    } else {
      return instance;
    }
  }

  public void activate(ActorSheet stats){

  }

  public Boolean deactivate() {
    return false;
  }

  public void extend(IEffect effect){

  }
}
