package rhobbs.model.artefacts.weapons;

import javax.validation.constraints.NotNull;
import static org.junit.Assert.*;
import org.junit.Test;

public abstract class WeaponFactory {
  public static Weapon retrieveWeapon(String weaponType) {
    if (weaponType == null) {
      return null;
    }
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
      case "none":
        return new Weapon("none", 0);
      default:
        return null;
    }
  }
}
