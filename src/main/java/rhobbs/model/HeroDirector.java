package rhobbs.model;

public class HeroDirector {

  public void MakeHero (
          HeroBuilder heroBuilder,
          String name,
          String weapon,
          String armor,
          String helm,
          int level,
          int experience,
          int hitPoints) {
    heroBuilder.addName(name);
    heroBuilder.addClassType();
    heroBuilder.addWeapon(weapon);
    heroBuilder.addArmor(armor);
    heroBuilder.addHelm(helm);
    heroBuilder.addLevel(level);
    heroBuilder.addExperience(experience);
    heroBuilder.addHitPoints(hitPoints);
  }

}
