package javaRPG;

import java.util.Scanner;

public class JavaRPG {
  public static void main(String[] args) {
    mainMenu();
  }

  public static void mainMenu() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Epic Title!\n" +
        "[1] New Game\n" +
        "[2] Exit");
    String userInput = scanner.next();

    switch(userInput) {
      case "1": newGame();
                break;
      default:
                break;
    }
  }

  public static void newGame() {
    PlayerCreation playerCreation = new PlayerCreation();
    Actor player = playerCreation.playerCreation();

    Game game = new Game(player);
    game.menu();
  }
}
