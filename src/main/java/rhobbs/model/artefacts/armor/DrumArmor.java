package rhobbs.model.artefacts.armor;

import rhobbs.model.artefacts.ArtefactConstants;
import rhobbs.model.artefacts.weapons.Weapon;

public class DrumArmor {

  private static Armor wuhanCrashCymbal = new Armor(
          "Wuhan Crash Cymbal",
          ArtefactConstants.getDrumArmorDefense()[0]
  );
  private static Armor meinlCrashCymbal = new Armor(
          "Meinl Crash Cymbal",
          ArtefactConstants.getDrumArmorDefense()[1]
  );
  private static Armor zildjianCrashCymbal = new Armor(
          "Zildjian Crash Cymbal",
          ArtefactConstants.getDrumArmorDefense()[2]
  );

  public static Armor getWuhanCrashCymbal() {
    return wuhanCrashCymbal;
  }

  public static Armor getMeinlCrashCymbal() {
    return meinlCrashCymbal;
  }

  public static Armor getZildjianCrashCymbal() {
    return zildjianCrashCymbal;
  }
}
