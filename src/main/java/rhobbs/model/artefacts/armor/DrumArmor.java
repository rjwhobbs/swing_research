package rhobbs.model.artefacts.armor;

import rhobbs.model.artefacts.weapons.Weapon;

public class DrumArmor {

  private static Armor wuhanCrashCymbal = new Armor("Wuhan Crash Cymbal", 70);
  private static Armor meinlCrashCymbal = new Armor("Meinl Crash Cymbal", 90);
  private static Armor zildjianCrashCymbal = new Armor("Zildjian Crash Cymbal", 250);

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
