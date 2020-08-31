package rhobbs.model.artefacts.weapons;

public class BassGuitarWeapons {

  private static Weapon squierJBass = new Weapon("Squier JBass", 60);
  private static Weapon mexiPBass = new Weapon("Mexican PBass", 120);
  private static Weapon doubleBass = new Weapon("Double Bass", 240);

  public static Weapon getSquierJBass() {
    return squierJBass;
  }

  public static Weapon getMexiPBass() {
    return mexiPBass;
  }

  public static Weapon getDoubleBass() {
    return doubleBass;
  }
}
