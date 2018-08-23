package action;

import javaRPG.Actor;
import javaRPG.Dice;
import java.io.Console;

public class PlayerActionBehavior implements IActionBehavior {
  Actor self;

  public PlayerActionBehavior(Actor player) {
    this.self = player;
  }

  public Action act(Actor target) {
    Console console = System.console();
    Action result = new NoAction(target);
    Boolean isDone = false;

    while (!isDone) {
      String userInput = console.readLine("What do you wish to do?\n" +
                      "[1] Attack " + "\t\t[2] Heal\n" + "[3] View yourself" +
                      "\t[4] View monster\n");
      switch(userInput) {
       case "1": result = new AttackAction(target, self.getNormalAttackDamage(), self.attackRoll());
                  isDone = true;
                  break;
       case "2": result = new HealAction(self, self.getNormalAttackDamage());
                  isDone = true;
                  break;
       case "3": System.out.println(self.fullPrint());
                  break;
       case "4": System.out.println(target.fullPrint());
                  break;
       default: break;
      }
    }
    return result;
  }
}
