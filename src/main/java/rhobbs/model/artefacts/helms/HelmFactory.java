package rhobbs.model.artefacts.helms;

import rhobbs.model.artefacts.ArtefactConstants;

public abstract class HelmFactory {
  public static Helm retrieveHelm(String helmType) {
    if (helmType == null) {
      return null;
    }
    switch (helmType) {
      case "Hard Rock Cafe Cap":
        return new Helm("Hard Rock Cafe Cap", ArtefactConstants.getHelmPoints()[0]);
      case "Toy Machine Beanie":
        return new Helm("Toy Machine Beanie", ArtefactConstants.getHelmPoints()[1]);
      case "Black Vans Hoodie":
        return new Helm("Black Vans Hoodie", ArtefactConstants.getHelmPoints()[2]);
      case "none":
        return new Helm("none", 0);
      default:
        return null;
    }
  }
}
