package rhobbs.model;

public abstract class HeroFactory {
  public static Hero buildHero(String name,String classType) {
    switch (classType) {
      case "Guitar Hero":
        return new GuitarHero(name);
      case "Bass Guitar Hero":
        return new BassGuitarHero(name);
      default:
        return null;
    }
  }

  public static Hero buildHero(
          String name,
          String classType,
          String weapon,
          String armor,
          String helm,
          int level,
          int experience
  ) {
    switch (classType) {
      case "Guitar Hero":
        return new GuitarHero(name, weapon, armor, helm, level, experience, 100);
      case "Bass Guitar Hero":
        return new BassGuitarHero(name, weapon, armor, helm, level, experience, 100);
      default:
        return null;
    }
  }
}
