package rhobbs.model.artefacts;

public class BassGuitarWeapons {

  private static Weapon squierJBass = new Weapon("Squier J Bass", 50);
  private static Weapon mexiPBass = new Weapon("Mexi P Bass", 100);
  private static Weapon doubleBass = new Weapon("Double Bass", 200);

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
