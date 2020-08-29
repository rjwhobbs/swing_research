package rhobbs.model.artefacts.armor;

public class ArmorFactory {
  public static Armor retrieveArmor(String armorType) {
    switch (armorType) {
      case "marshallAmp":
        return GuitarArmor.getMarshallAmp();
      case "mesaBoogieAmp":
        return GuitarArmor.getMesaBoogieAmp();
      case "voxAmp":
        return GuitarArmor.getVoxAmp();
      case "hartkeAmp":
        return BassGuitarArmor.getHartkeAmp();
      case "fenderAmp":
        return BassGuitarArmor.getFenderAmp();
      case "ampegAllTubeAmp":
        return BassGuitarArmor.getAmpegAllTubeAmp();
      default:
        return null;
    }
  }
}
