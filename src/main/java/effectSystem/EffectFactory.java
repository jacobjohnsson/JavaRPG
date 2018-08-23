package effectSystem;

import javaRPG.Attribute;
import javaRPG.ActorSheet;
import javaRPG.Race;

public class EffectFactory {
  public enum EffectType {WEAK, STRONG, FIRE, FREEZING, COLD, POISON}

  public static IEffect create(Race.RaceType type){
    IEffect result;
    switch (type){
      case HUMAN: result = NoEffect.getInstance();
        break;
      case ELF:   result = new AttributeEffect(
                            "Elf",
                            Attribute.Type.INTELLIGENCE,
                            1,
                            new RawEffect("Elf", ActorSheet.Type.MAX_MANA, 2));
        break;
      case DWARF: result = new AttributeEffect(
                            "Dwarf",
                            Attribute.Type.STRENGTH,
                            2);
        break;
      case HALFLING: result = new AttributeEffect(
                            "Halfling",
                            Attribute.Type.AGILITY,
                            2,
                            create(EffectType.WEAK));
        break;
      default: throw new IllegalArgumentException();
    }
    return result;
  }

  public static IEffect create(EffectType type){
    IEffect result;
    switch (type){
      case WEAK:    result = new RawEffect(
            "Weak",
            ActorSheet.Type.MAX_HP,
            -2);
        break;
      case STRONG:    result = new RawEffect(
            "String",
            ActorSheet.Type.MAX_HP,
            2);
        break;
      default: throw new IllegalArgumentException();
    }
    return result;
  }
}
