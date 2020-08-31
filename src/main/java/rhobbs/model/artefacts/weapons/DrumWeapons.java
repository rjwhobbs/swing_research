package rhobbs.model.artefacts.weapons;

public class DrumWeapons {

  private static Weapon pearlDrumKit = new Weapon("Pearl Drum Kit", 40);
  private static Weapon yamahaDrumKit = new Weapon("Yamaha Drum Kit", 130);
  private static Weapon spawnDrumKit = new Weapon("Spawn Drum Kit", 220);

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
