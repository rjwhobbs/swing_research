package rhobbs.model;

import rhobbs.model.artefacts.armor.ArmorFactory;
import rhobbs.model.artefacts.armor.GuitarArmor;
import rhobbs.model.artefacts.weapons.GuitarWeapons;
import rhobbs.model.artefacts.weapons.WeaponFactory;

public class GuitarHero extends Hero {

  // Creating a new hero
  public GuitarHero(String name) {
    super(
            name,
            "Guitar Hero",
            GuitarWeapons.getAcousticGuitar(),
            GuitarArmor.getMarshallAmp(),
            1,
            0,
            100
    );
  }

  //   Retrieving a hero
  public GuitarHero(
          String name,
          String weapon,
          String armor,
          int level,
          int experience,
          int hitPoints
  ) {
    super(name,
            "Guitar hero",
            WeaponFactory.retrieveWeapon(weapon),
            ArmorFactory.retrieveArmor(armor),
            level,
            experience,
            hitPoints
    );
  }
}
