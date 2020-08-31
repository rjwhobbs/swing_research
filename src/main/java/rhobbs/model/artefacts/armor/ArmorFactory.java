package rhobbs.model.artefacts.armor;

public class ArmorFactory {
  public static Armor retrieveArmor(String armorType) {
    switch (armorType) {
      case "Marshall Amp":
        return GuitarArmor.getMarshallAmp();
      case "MesaBoogie Amp":
        return GuitarArmor.getMesaBoogieAmp();
      case "Vox Amp":
        return GuitarArmor.getVoxAmp();
      case "Hartke Amp":
        return BassGuitarArmor.getHartkeAmp();
      case "Fender Amp":
        return BassGuitarArmor.getFenderAmp();
      case "Ampeg All Tube Amp":
        return BassGuitarArmor.getAmpegAllTubeAmp();
      default:
        return new Armor("none", 0);
    }
  }
}
