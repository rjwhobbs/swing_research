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
}
