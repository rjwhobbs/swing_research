package rhobbs.model.artefacts.armor;

public class BassGuitarArmor {

  private static Armor hartkeAmp = new Armor("Hartke Amp", 50);
  private static Armor fenderAmp = new Armor("Fender Amp", 100);
  private static Armor ampegAllTubeAmp = new Armor("Ampeg All Tube Amp", 200);

  public static Armor getHartkeAmp() {
    return hartkeAmp;
  }

  public static Armor getFenderAmp() {
    return fenderAmp;
  }

  public static Armor getAmpegAllTubeAmp() {
    return ampegAllTubeAmp;
  }
}
