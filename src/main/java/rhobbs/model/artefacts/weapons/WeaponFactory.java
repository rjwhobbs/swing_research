package rhobbs.model.artefacts.weapons;

public abstract class WeaponFactory {
  public static Weapon retrieveWeapon(String weaponType) {
    switch (weaponType) {
      case "acousticGuitar":
        return GuitarWeapons.getAcousticGuitar();
      case "flyingV":
        return GuitarWeapons.getFlyingV();
      case "fenderStrat":
        return GuitarWeapons.getFenderStrat();
      case "squierJBass":
        return BassGuitarWeapons.getSquierJBass();
      case "mexiPBass":
        return BassGuitarWeapons.getMexiPBass();
      case "doubleBass":
        return BassGuitarWeapons.getDoubleBass();
      default:
        return new Weapon("none", 0);
    }
  }
}
