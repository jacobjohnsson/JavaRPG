package javaRPG;

import java.util.ArrayList;
import effectSystem.IEffect;

public class EffectManager {
  ActorSheet stats;
  ArrayList<IEffect> effects;

  public EffectManager(ActorSheet stats){
    this.stats = stats;
    effects = new ArrayList<IEffect>();
  }

  public void addEffect(IEffect effect) {
    effects.add(effect);
    effect.activate(stats);
  }

  public void removeEffect(IEffect effect) {
    if (effects.contains(effect)) {
      effects.remove(effect);
      effect.deactivate();
    }
  }

  public void reCalculate() {

  }

  public void clear(){
    effects.clear();
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (IEffect effect : effects) {
      sb.append(effect.getName() + ", ");
    }
    return sb.toString();
  }
}
