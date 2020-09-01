package rhobbs.model;

public abstract class HeroBuilder {

  public abstract void addName(String name);
  public abstract void addClassType();
  public abstract void addWeapon(String weapon);
  public abstract void addArmor(String armor);
  public abstract void addHelm(String helm);
  public abstract void addLevel(int level);
  public abstract void addExperience(int experience);
  public abstract void addHitPoints(int hitPoints);

}
