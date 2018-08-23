package javaRPG;

import java.io.Console;
import effectSystem.*;

public class PlayerCreation {
  int points;
  ActorSheet sheet;
  Console console = System.console();

  public Player playerCreation() {
    points = 10;
    System.out.println("Welcome to character creation. Here you will be guided through the process of creating a character. ");
    System.out.println("\nSpend your 10 points wisely, my friend.");

    sheet = createSheet();

    Weapon weapon = chooseWeaponLoop();

    Race.RaceType race = chooseRace();

    String name = console.readLine("What is your name? ");

    System.out.print("This is you: \n");
    Player player = new Player(name, race, sheet);
    player.setArmor(ArmorFactory.create("leather"));
    player.setWeapon(weapon);
    System.out.println(player.fullPrint());

    return player;
  }

  private ActorSheet createSheet() {
    int strength = 0;
    int agility = 0;
    int intelligence = 0;

    while (points > 0) {
      System.out.println("Points left: " + points + ".\n" +
        "[1] Strength " + strength + "\n" +
        "[2] Agility " + agility + "\n" +
        "[3] Intelligence " + intelligence + "\n");

      switch(console.readLine()) {
        case "1": strength = addPoint(strength);

                  break;
        case "2": agility = addPoint(agility);

                  break;
        case "3": intelligence = addPoint(intelligence);

                  break;
        default: System.out.println("Invalid input, try again");
      }
    }
    System.out.println("[1] Strength " + strength + "\n" +
    "[2] Agility " + agility + "\n" +
    "[3] Intelligence " + intelligence + "\n");
    return new ActorSheet(strength, agility, intelligence);
  }

  private int addPoint(int p) {
    if (p == 6) {
      return p;
    } else {
      points = points - 1;
      return p + 1;
    }
  }

  private Weapon chooseWeaponLoop(){
    Boolean legitChoice = false;
    Weapon result = WeaponFactory.create("sword");

    System.out.println("Choose your starting weapon: \n" +
    "\t[1] A dagger\n\t[2] An axe\n\t[3] A bow" +
    "\n\t[4] A Spear");

    switch(console.readLine()) {
      case "1":
        result = WeaponFactory.create("dagger");
        break;
      case "2":
        result = WeaponFactory.create("axe");
        break;
      case "3":
        result = WeaponFactory.create("bow");
        break;
      case "4":
        result = WeaponFactory.create("spear");
        break;
      default:
        System.out.println("That's not an option. Try again.");
        chooseWeaponLoop();
        break;
    }
    return result;
  }

  private Race.RaceType chooseRace(){
    Race.RaceType race;
    System.out.println("Choose your race: \n" +
        "[1] Human.\n" +
        "[2] Dwarf.\n" +
        "[3] Elf.\n" +
        "[4] Halfling.");

    switch (console.readLine()) {
      case "1": race = Race.RaceType.HUMAN;
        break;
      case "2": race = Race.RaceType.DWARF;
        break;
      case "3": race = Race.RaceType.ELF;
        break;
      case "4": race = Race.RaceType.HALFLING;
        break;
      default: race = chooseRace();
        break;
    }
    return race;
  }
}
