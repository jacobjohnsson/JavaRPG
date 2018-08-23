package javaRPG;

import action.*;
import effectSystem.*;

public class Player extends Actor {

  public Player(String name, Race.RaceType race, ActorSheet stats) {
    this.name = name;
    this.race = new Race(race );
    this.stats = stats;
    actionBehavior = new PlayerActionBehavior(this);
    effectManager = new EffectManager(stats);
    addEffect(EffectFactory.create(race));

  }

}
