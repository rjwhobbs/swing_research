package rhobbs.model.artefacts.armor;

public class GuitarArmor {

  private static Armor marshallAmp = new Armor("Marshall Amp", 60);
  private static Armor mesaBoogieAmp = new Armor("Mesa Boogie Amp", 120);
  private static Armor voxAmp = new Armor("Vox Amp", 240);

  public static Armor getMarshallAmp() {
    return marshallAmp;
  }

  public static Armor getMesaBoogieAmp() {
    return mesaBoogieAmp;
  }

  public static Armor getVoxAmp() {
    return voxAmp;
  }
}
