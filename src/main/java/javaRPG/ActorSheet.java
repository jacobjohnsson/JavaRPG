package javaRPG;

public class ActorSheet {
  public enum Type {MAX_HP, MAX_MANA, CUR_HP, CUR_MANA}

  Attribute strength;
  Attribute agility;
  Attribute intelligence;
  int max_hp;
  int max_mana;
  int current_hp;
  int current_mana;
  int baseDefense;
  int bonusDefense;

  public ActorSheet(int s, int a, int i) {
    strength = new Attribute(s);
    agility = new Attribute(a);
    intelligence = new Attribute(i);

    max_hp = strength.get() + 6;
    max_mana = intelligence.get() * 2;

    current_hp = max_hp;
    current_mana = max_mana;

    baseDefense = (strength.get() + agility.get()) / 2 + 4;
    bonusDefense = 0;
  }

  public int getCurrentHP() {
    return current_hp;
  }

  public int getCurrentMana() {
    return current_mana;
  }

  public int getDefense(){
    return baseDefense + bonusDefense;
  }

  public int strengthRoll()     {return strength.get() + Dice.rollExploding(6);}
  public int agilityRoll()      {return agility.get() + Dice.rollExploding(6);}
  public int intelligenceRoll() {return intelligence.get() + Dice.rollExploding(6);}
  public int mainRoll() {
    int[] array = {strength.get(), agility.get(), intelligence.get()};
    int max = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] > max) {
        max = array[i];
      }
    }
    return max + Dice.rollExploding(6);
  }

  public void setCurrentMana(int x) {
    if (x < 0) {
      current_mana = 0;
    } else if (x > max_mana) {
      current_mana = max_mana;
    } else {
      current_mana = x;
    }
  }

  public void setCurrentHP(int x) {
    if (x < 0) {
      current_hp = 0;
    } else if (x > max_hp) {
      current_hp = max_hp;
    } else {
      current_hp = x;
    }
  }

  public void addHP(int x) {
    current_hp = current_hp + x;

    if (current_hp > max_hp) {
      current_hp = max_hp;
    } else if (current_hp < 0) {
      current_hp = 0;
    }
  }

  public void addAttrBonus(Attribute.Type type, int bonus){
    switch (type) {
      case STRENGTH:      strength.addBonus(bonus);
        break;
      case AGILITY:       agility.addBonus(bonus);
        break;
      case INTELLIGENCE:  intelligence.addBonus(bonus);
        break;
      default: throw new IllegalArgumentException();
    }
  }

  public void removeAttrBonus(Attribute.Type type, int bonus) {
    switch (type) {
      case STRENGTH:      strength.removeBonus(bonus);
        break;
      case AGILITY:       agility.removeBonus(bonus);
        break;
      case INTELLIGENCE:  intelligence.removeBonus(bonus);
        break;
      default: throw new IllegalArgumentException();
    }
  }

  public void addRawBonus(ActorSheet.Type type, int bonus) {
    if (bonus >= 0) {
      switch (type) {
        case MAX_HP:    max_hp = max_hp + bonus;
          break;
        case MAX_MANA:  max_mana = max_mana + bonus;
          break;
        default: throw new IllegalArgumentException();
      }
    }
  }

  public void removeRawBonus(ActorSheet.Type type, int bonus) {
    if (bonus <= 0) {
      switch (type) {
        case MAX_HP:    max_hp = max_hp - bonus;
          break;
        case MAX_MANA:  max_mana = max_mana - bonus;
          break;
        default: throw new IllegalArgumentException();
      }
    }
  }

  private void reCalculate() {
    max_hp = strength.get() + 6;
    max_mana = intelligence.get() * 2;
    baseDefense = (strength.get() + agility.get()) / 2 + 4;
    bonusDefense = 0;
  }

  public void reset() {
    current_hp = max_hp;
    current_mana = max_mana;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("\tStrength: \t" + strength.get() + " + (" + strength.getBonus() + "), HP:   " + current_hp + "/" + max_hp + "\n" +
              "\tAgility: \t" + agility.get() + " + (" + agility.getBonus() + ")\n" +
              "\tIntelligence: \t" + intelligence.get()  + " + (" + intelligence.getBonus() +
              "), Mana: " + current_mana + "/" + max_mana);
    return sb.toString();
  }
}
