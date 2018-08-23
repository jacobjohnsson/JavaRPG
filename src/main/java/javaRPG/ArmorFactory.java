package javaRPG;

public class ArmorFactory {
  public static Armor create(String type) {
    Armor result;
    String description = "Made in china.";
    switch(type.toLowerCase()) {
      case "none":        result = new Armor("None", "none", 0, 0, 0);
                          break;
      case "clothes":     result = new Armor("Clothes", description, 0, 0, 3);
                          break;
      case "padded cloth":result = new Armor("Padded cloth", description, 1, 0, 8);
                          break;
      case "leather":     result = new Armor("Leather armor", description, 2, 1, 15);
                          break;
      case "scale":       result = new Armor("Scale armor", description, 3, 2, 23);
                          break;
      case "lamellar":    result = new Armor("Lamellar armor", description, 4, 3, 35);
                          break;
      case "chain":       result = new Armor("Chain mail", description, 5, 4, 70);
                          break;
      case "light plate": result = new Armor("Light plate mail", description, 6, 5, 90);
                          break;
      case "heavy plate": result = new Armor("Heavy plate armor", description, 7, 5, 120);
                          break;
      default: throw new IllegalArgumentException();
    }
    return result;
  }
}
