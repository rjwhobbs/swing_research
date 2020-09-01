package rhobbs.model.artefacts.armor;

public class ArmorFactory {
  public static Armor retrieveArmor(String armorType) {
    if (armorType == null) {
      return null;
    }
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
      case "Wuhan Crash Cymbal":
        return DrumArmor.getWuhanCrashCymbal();
      case "Meinl Crash Cymbal":
        return DrumArmor.getMeinlCrashCymbal();
      case "Zildjian Crash Cymbal":
        return DrumArmor.getZildjianCrashCymbal();
      case "none":
        return new Armor("none", 0);
      default:
        return null;
    }
  }
}
