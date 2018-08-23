package javaRPG;

import java.util.Random;

public class Dice {
  static Random rand = new Random();

  public static int roll(int sides) {
    return rand.nextInt(sides) + 1;
  }

  public static int rollExploding(int sides) {
    int result = roll(sides);
    if (result == sides) {
      result = result + rollExploding(sides);
    }
    return result;
  }

  public static int d6()      {return roll(6); }
  public static int d6by2()   {return rollExploding(6) / 2;}
  public static int d6Plus2() {return rollExploding(6) + 2;}
  public static int d6Plus3() {return rollExploding(6) + 3;}
  public static int d6Plus4() {return rollExploding(6) + 4;}
  public static int d6Minus1(){return rollExploding(6) - 1;}
  public static int d6Minus2(){return rollExploding(6) - 2;}
  public static int d62()     {return rollExploding(6) + rollExploding(6);}
}
