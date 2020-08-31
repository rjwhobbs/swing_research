package rhobbs.model.artefacts.weapons;

public abstract class WeaponFactory {
  public static Weapon retrieveWeapon(String weaponType) {
    switch (weaponType) {
      case "Acoustic Guitar":
        return GuitarWeapons.getAcousticGuitar();
      case "Flying V":
        return GuitarWeapons.getFlyingV();
      case "Fender Strat":
        return GuitarWeapons.getFenderStrat();
      case "Squier JBass":
        return BassGuitarWeapons.getSquierJBass();
      case "Mexican PBass":
        return BassGuitarWeapons.getMexiPBass();
      case "Double Bass":
        return BassGuitarWeapons.getDoubleBass();
      case "Pearl Drum Kit":
        return DrumWeapons.getPearlDrumKit();
      case "Yamaha Drum Kit":
        return DrumWeapons.getYamahaDrumKit();
      case "Spawn Drum Kit":
        return DrumWeapons.getSpawnDrumKit();
      default:
        return new Weapon("none", 0);
    }
  }
}
