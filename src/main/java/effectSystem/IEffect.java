package effectSystem;

import javaRPG.ActorSheet;

public abstract class IEffect {
  String name;
  IEffect additionalEffect;
  ActorSheet stats;

  public abstract void activate(ActorSheet stats);
  public abstract Boolean deactivate();
  public abstract void extend(IEffect effect);
  public String getName(){
    return name;
  }
}
