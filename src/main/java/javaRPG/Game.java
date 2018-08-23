package javaRPG;

import java.util.Scanner;
import weather.*;

public class Game {
  Actor player;
  WeatherSimulation weatherSim;

  public Game(Actor player) {
    this.player = player;
    weatherSim = new WeatherSimulation();
  }

  public void menu() {
    Scanner scanner = new Scanner(System.in);
    Boolean exit = false;

    while (!exit) {

      System.out.println("Welcome to the world, friend. It is a " + getWeather() + " day.");
      System.out.println("[1] Find Monsters\n" +
      "[2] Rest\n" +
      "[3] View yourself\n" +
      "[4] Exit");
      String userInput = scanner.next();
      switch(userInput) {
        case "1":
          findMonsters();
          break;
        case "2":
          player.reset();
          System.out.println("You fell well rested.");
          break;
        case "3":
          System.out.println(player.fullPrint());
          break;
        default:
          exit = true;
          break;
      }
    }
  }

  public void findMonsters() {
    MonsterFactory monsterFactory = new MonsterFactory();
    Actor monster = monsterFactory.random();
    Encounter battle = new Encounter(player, monster);
    battle.run();
  }

  public String getWeather(){
    return weatherSim.nextWeather().toLowerCase();
  }
}
