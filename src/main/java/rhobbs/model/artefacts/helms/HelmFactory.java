package rhobbs.model.artefacts.helms;

public abstract class HelmFactory {
  public static Helm getHelm(String helmType) {
    switch (helmType) {
      case "Hard Rock Cafe Cap":
        return new Helm("Hard Rock Cafe Cap", 10);
      case "Toy Machine Beanie":
        return new Helm("Toy Machine Beanie", 20);
      case "Black Vans Hoodie":
        return new Helm("Black Vans Hoodie", 50);
      default:
        return new Helm("none", 0);
    }
  }
}
