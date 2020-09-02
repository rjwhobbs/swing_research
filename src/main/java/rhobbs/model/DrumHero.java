package rhobbs.model;

import rhobbs.model.artefacts.armor.ArmorFactory;
import rhobbs.model.artefacts.armor.BassGuitarArmor;
import rhobbs.model.artefacts.armor.DrumArmor;
import rhobbs.model.artefacts.helms.HelmFactory;
import rhobbs.model.artefacts.weapons.BassGuitarWeapons;
import rhobbs.model.artefacts.weapons.DrumWeapons;
import rhobbs.model.artefacts.weapons.WeaponFactory;

public class DrumHero extends Hero {

  // Creating a new hero
  public DrumHero(String name) {
    super(
            name,
            "Drum Hero",
            DrumWeapons.getPearlDrumKit(),
            DrumArmor.getWuhanCrashCymbal(),
            HelmFactory.retrieveHelm("none"),
            1,
            0,
            70
    );
  }

  //   Retrieving a hero
  public DrumHero(
          String name,
          String weapon,
          String armor,
          String helm,
          int level,
          int experience,
          int hitPoints
  ) {
    super(name,
            "Drum Hero",
            WeaponFactory.retrieveWeapon(weapon),
            ArmorFactory.retrieveArmor(armor),
            HelmFactory.retrieveHelm(helm),
            level,
            experience,
            hitPoints
    );
  }
}
