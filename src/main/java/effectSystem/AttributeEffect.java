package effectSystem;

import javaRPG.ActorSheet;
import javaRPG.Attribute;

public class AttributeEffect extends IEffect {
  Attribute.Type attribute;
  int bonus;

  public AttributeEffect(
        String name,
        Attribute.Type type,
        int bonus){

    this.bonus = bonus;
    this.attribute = type;
    this.name = name;
    additionalEffect = NoEffect.getInstance();
  }

  public AttributeEffect(
        String name,
        Attribute.Type type,
        int bonus,
        IEffect extension){

    this.bonus = bonus;
    this.attribute = type;
    this.name = name;
    this.additionalEffect = extension;
  }

  public void activate(ActorSheet stats) {
    this.stats = stats;
    this.stats.addAttrBonus(attribute, bonus);
    additionalEffect.activate(stats);
  }

  public Boolean deactivate(){
    if (stats == null) {
      return false;
    } else {
      stats.removeAttrBonus(attribute, bonus);
    }
    return true;
  }

  public void extend(IEffect effect){
    if (additionalEffect == NoEffect.getInstance()) {
      additionalEffect = effect;
    } else {
      additionalEffect.extend(effect);
    }
  }
}
