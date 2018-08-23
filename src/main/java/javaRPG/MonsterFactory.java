package javaRPG;

import action.*;
import java.util.ArrayList;
import java.util.Random;
import effectSystem.*;

public class MonsterFactory {
  ArrayList<Monster> monsters;

  public MonsterFactory(){
    monsters = new ArrayList<Monster>();
    monsters.add(create("orc"));
    monsters.add(create("spider"));
    monsters.add(create("dog"));
    monsters.add(create("mage"));
  }

  public Monster create(String type) {
    Monster result;

    switch(type.toLowerCase()) {
      case "orc": result = new Monster("Gruzlabob", Race.RaceType.DWARF, new ActorSheet(5, 2, 0));
            result.setActionBehavior(new OrcActionBehavior(result));
            result.setArmor(ArmorFactory.create("leather"));
            result.setWeapon(WeaponFactory.create("axe"));
            result.addEffect(EffectFactory.create(Race.RaceType.DWARF));
            break;
      case "spider": result = new Monster("Spider", Race.RaceType.ANIMAL, new ActorSheet(2, 4, 0));
            result.setActionBehavior(new OrcActionBehavior(result));
            result.setArmor(ArmorFactory.create("none"));
            result.setWeapon(WeaponFactory.create("none"));
            break;
      case "dog": result = new Monster("Rabid dog", Race.RaceType.ANIMAL, new ActorSheet(3, 2, 0));
            result.setActionBehavior(new OrcActionBehavior(result));
            result.setArmor(ArmorFactory.create("none"));
            result.setWeapon(WeaponFactory.create("none"));
            break;
      case "mage": result = new Monster("Mage", Race.RaceType.ELF, new ActorSheet(2,3,5));
            result.setActionBehavior(new MageActionBehavior(result));
            result.setArmor(ArmorFactory.create("leather"));
            result.setWeapon(WeaponFactory.create("staff"));
            result.addEffect(EffectFactory.create(Race.RaceType.ELF));
            break;
      default: throw new IllegalArgumentException();
    }
    result.reset();
    return result;
  }

  public Monster random(){
    Random random = new Random();
    return monsters.get(random.nextInt(monsters.size()));
  }
}
