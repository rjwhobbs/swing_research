package rhobbs.model.artefacts.armor;

import rhobbs.model.artefacts.ArtefactConstants;

public class BassGuitarArmor {

  private static Armor hartkeAmp = new Armor(
          "Hartke Amp",
          ArtefactConstants.getBassGuitarArmorDefense()[0]
  );
  private static Armor fenderAmp = new Armor(
          "Fender Amp",
          ArtefactConstants.getBassGuitarArmorDefense()[1]
  );
  private static Armor ampegAllTubeAmp = new Armor(
          "Ampeg All Tube Amp",
          ArtefactConstants.getBassGuitarArmorDefense()[2]
  );

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
