package javaRPG;

import action.*;

public class Monster extends Actor {
  public Monster(String name,
                  Race.RaceType race,
                  ActorSheet stats) {
    this.name = name;
    this.race = new Race(race);
    this.stats = stats;
    actionBehavior = new NoActionBehavior();
    effectManager = new EffectManager(stats);
  }
}
