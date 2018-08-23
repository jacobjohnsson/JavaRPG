package effectSystem;

import javaRPG.ActorSheet;

public class RawEffect extends IEffect {
  ActorSheet.Type type;
  int bonus;

  public RawEffect(
        String name,
        ActorSheet.Type type,
        int bonus) {

    this.name = name;
    this.type = type;
    this.bonus = bonus;
    additionalEffect = NoEffect.getInstance();
  }

  public RawEffect(
      String name,
      ActorSheet.Type type,
      int bonus,
      IEffect extension){

    this.name = name;
    this.type = type;
    this.bonus = bonus;
    additionalEffect = extension;
  }

  public void activate(ActorSheet stats) {
    this.stats = stats;
    this.stats.addRawBonus(type, bonus);
    additionalEffect.activate(stats);
  }

  public Boolean deactivate(){
    if (stats == null) {
      return false;
    } else {
      stats.removeRawBonus(type, bonus);
    }
    return true;
  }

  public void extend(IEffect effect) {
    if (additionalEffect == NoEffect.getInstance()) {
      additionalEffect = effect;
    } else {
      additionalEffect.extend(effect);
    }
  }
}
