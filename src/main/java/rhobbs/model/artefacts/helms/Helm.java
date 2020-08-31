package rhobbs.model.artefacts.helms;

public class Helm {

  private final String helmType;
  private final int hitPoints;

  Helm(String helmType, int hitPoints) {
    this.helmType = helmType;
    this.hitPoints = hitPoints;
  }

  public String getHelmType() {
    return helmType;
  }

  public int getHitPoints() {
    return hitPoints;
  }

}
