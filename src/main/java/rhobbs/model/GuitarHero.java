package rhobbs.model;

import rhobbs.model.artefacts.armor.ArmorFactory;
import rhobbs.model.artefacts.armor.GuitarArmor;
import rhobbs.model.artefacts.helms.Helm;
import rhobbs.model.artefacts.helms.HelmFactory;
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
            HelmFactory.getHelm("none"),
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
          String helm,
          int level,
          int experience,
          int hitPoints
  ) {
    super(name,
            "Guitar Hero",
            WeaponFactory.retrieveWeapon(weapon),
            ArmorFactory.retrieveArmor(armor),
            HelmFactory.getHelm(helm),
            level,
            experience,
            hitPoints
    );
  }
}
