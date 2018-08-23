package javaRPG;

public class Race {
  public static enum RaceType {HUMAN, ELF, DWARF, HALFLING, ANIMAL}

  RaceType race;
  String name;

  public Race(RaceType type) {
    this.race = type;
    switch (type) {
      case HUMAN: name = "Human";
        break;
      case ELF: name = "Elf";
        break;
      case DWARF: name = "Dwarf";
        break;
      case HALFLING: name = "Hafling";
        break;
      case ANIMAL: name = "Animal";
        break;
      default: throw new IllegalArgumentException();
    }
  }

  public String toString(){
    return name;
  }

  public RaceType getRaceType(){
    return race;
  }
}
