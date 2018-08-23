package javaRPG;

public class WeaponFactory {
  public static Weapon create(String type) {
    Weapon result;

    switch(type.toLowerCase()) {
      case "none": result = new Weapon("None", "none", 0,  Dice::d6by2);
      break;
      case "axe": result = new Weapon("Axe", "sharp", 5);
      break;
      case "bow": result = new Weapon("Bow", "strung", 4);
      break;
      case "crossBow": result = new Weapon("CrossBow", "looks expensive", 8, Dice::d6Plus3);
      break;
      case "dagger": result = new Weapon("Dagger", "sharp", 2, Dice::d6Minus2);
      break;
      case "dragon pistol": result = new Weapon("Dragon pistol", "sweet", 50, Dice::d6Plus4);
      break;
      case "dragon rifle": result = new Weapon("Dragon rifle", "sweet", 80, Dice::d62);
      break;
      case "halberd": result = new Weapon("Halberd", "long", 10, Dice::d6Plus3);
      break;
      case "longbow": result = new Weapon("Longbow", "strung", 8, Dice::d6Plus2);
      break;
      case "mace": result = new Weapon("Mace", "blunt", 5);
      break;
      case "spear": result = new Weapon("Spear", "long", 3);
      break;
      case "staff": result = new Weapon("Staff", "long", 2);
      break;
      case "sword": result = new Weapon("Sword", "sharp", 5);
      break;
      case "throwing star": result = new Weapon("Throwing start", "light", 2, Dice::d6Minus1);
      break;
      case "warhammer": result = new Weapon("Warhammer", "blunt", 5);
      break;
      default: throw new IllegalArgumentException();
    }

    return result;
  }
}
