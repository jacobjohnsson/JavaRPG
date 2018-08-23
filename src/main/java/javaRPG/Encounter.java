package javaRPG;

import action.*;
import java.util.ArrayList;

public class Encounter {
  Actor player;
  Actor monster;
  Boolean exit = false;

  public Encounter(Actor player, Actor monster) {
  this.player = player;
  this.monster = monster;
  }

  public void run() {
    System.out.println("Battle! You're facing a " + monster.getName());
    printState();

    while(!player.isDead() && !monster.isDead()) {
      ArrayList<Action> actionList = new ArrayList<Action>();

      actionList.add(player.act(monster));
      actionList.add(monster.act(player));

      for (Action action : actionList) {
        action.execute();
      }

      printState();
    }
  }

  private void printState(){
    System.out.println(player.getName() + ", HP: " + player.getCurrentHP() +
        ", Mana: " + player.getCurrentMana() + "\n" + monster.getName() +
        ", HP: " + monster.getCurrentHP() + ", Mana: " + monster.getCurrentMana()
         + "\n");
  }
}
