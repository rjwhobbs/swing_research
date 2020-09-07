package rhobbs.model.artefacts.weapons;

import rhobbs.model.artefacts.ArtefactConstants;

public class DrumWeapons {

  private static Weapon pearlDrumKit = new Weapon("Pearl Drum Kit", ArtefactConstants.getDrumWeaponsAttack()[0]);
  private static Weapon yamahaDrumKit = new Weapon("Yamaha Drum Kit", ArtefactConstants.getDrumWeaponsAttack()[1]);
  private static Weapon spawnDrumKit = new Weapon("Spawn Drum Kit", ArtefactConstants.getDrumWeaponsAttack()[2]);

  public static Weapon getPearlDrumKit() {
    return pearlDrumKit;
  }

  public static Weapon getYamahaDrumKit() {
    return yamahaDrumKit;
  }

  public static Weapon getSpawnDrumKit() {
    return spawnDrumKit;
  }
}
