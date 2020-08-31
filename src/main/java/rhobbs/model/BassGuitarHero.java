package rhobbs.model;

import rhobbs.model.artefacts.armor.ArmorFactory;
import rhobbs.model.artefacts.armor.BassGuitarArmor;
import rhobbs.model.artefacts.helms.HelmFactory;
import rhobbs.model.artefacts.weapons.BassGuitarWeapons;
import rhobbs.model.artefacts.weapons.WeaponFactory;

public class BassGuitarHero extends Hero {

  // Creating a new hero
  public BassGuitarHero(String name) {
    super(
            name,
            "Bass Guitar Hero",
            BassGuitarWeapons.getMexiPBass(),
            BassGuitarArmor.getHartkeAmp(),
            HelmFactory.getHelm("none"),
            1,
            0,
            70
    );
  }

  //   Retrieving a hero
  public BassGuitarHero(
          String name,
          String weapon,
          String armor,
          String helm,
          int level,
          int experience,
          int hitPoints
  ) {
    super(name,
            "Bass Guitar hero",
            WeaponFactory.retrieveWeapon(weapon),
            ArmorFactory.retrieveArmor(armor),
            HelmFactory.getHelm("none"),
            level,
            experience,
            hitPoints
    );
  }
}
