package rhobbs.model;

import rhobbs.model.artefacts.GuitarWeapons;
import rhobbs.model.artefacts.WeaponFactory;

public class GuitarHero extends Hero {

  // Creating a new hero
  public GuitarHero(String name) {
    super(
            name,
            "Guitar Hero",
            GuitarWeapons.getAcousticGuitar(),
            1,
            100,
            100,
            0
    );
  }

  //   Retrieving a hero
  public GuitarHero(
          String name,
          String weapon,
          int level,
          int experience,
          int hitPoints,
          int defense
  ) {
    super(name,
            "Guitar hero",
            WeaponFactory.retrieveWeapon(weapon),
            level,
            experience,
            hitPoints,
            defense
    );
  }
}
