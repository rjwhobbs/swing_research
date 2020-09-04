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
            HelmFactory.retrieveHelm("none"),
            0,
            0,
            HeroConstants.BassGuitarHeroHP
    );
  }

  //   Retrieving a hero
  public BassGuitarHero(
          String name,
          String weapon,
          String armor,
          String helm,
          int level,
          int experience
  ) {
    super(name,
            "Bass Guitar Hero",
            WeaponFactory.retrieveWeapon(weapon),
            ArmorFactory.retrieveArmor(armor),
            HelmFactory.retrieveHelm(helm),
            level,
            experience,
            HeroConstants.BassGuitarHeroHP
    );
  }

  @Override
  public void equipHelm() {
    this.hitPoints += this.helm.getPoints();
    this.maxHitPoints = HeroConstants.BassGuitarHeroHP + this.helm.getPoints();
  }
}
