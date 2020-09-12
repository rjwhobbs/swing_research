package rhobbs.model;

import rhobbs.model.artefacts.armor.ArmorFactory;
import rhobbs.model.artefacts.armor.GuitarArmor;
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
            HelmFactory.retrieveHelm("none"),
            0,
            0,
            HeroConstants.GuitarHeroHP
    );
  }

  //   Retrieving a hero
  public GuitarHero(
          String name,
          String weapon,
          String armor,
          String helm,
          int level,
          int experience
  ) {
    super(name,
            "Guitar Hero",
            WeaponFactory.retrieveWeapon(weapon),
            ArmorFactory.retrieveArmor(armor),
            HelmFactory.retrieveHelm(helm),
            level,
            experience,
            HeroConstants.GuitarHeroHP
    );
  }

  @Override
  public void equipHelm() {
    this.maxHitPoints = HeroConstants.GuitarHeroHP + this.helm.getPoints();
    if (this.hitPoints + this.helm.getPoints() <= this.maxHitPoints) {
      this.hitPoints += this.helm.getPoints();
    }
    else {
      this.hitPoints = this.maxHitPoints;
    }
  }
}
