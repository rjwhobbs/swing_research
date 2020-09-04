package rhobbs.model.artefacts.helms;

public abstract class HelmFactory {
  public static Helm retrieveHelm(String helmType) {
    if (helmType == null) {
      return null;
    }
    switch (helmType) {
      case "Hard Rock Cafe Cap":
        return new Helm("Hard Rock Cafe Cap", 20);
      case "Toy Machine Beanie":
        return new Helm("Toy Machine Beanie", 40);
      case "Black Vans Hoodie":
        return new Helm("Black Vans Hoodie", 70);
      case "none":
        return new Helm("none", 0);
      default:
        return null;
    }
  }
}
