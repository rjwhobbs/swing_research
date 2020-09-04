package rhobbs.model.artefacts;

public class Artefact {

  public String type;
  public String subType;
  public int points;

  public Artefact() {};

  public String getType() {
    return type;
  }

  public String getSubType() {
    return this.subType;
  }

  public int getPoints() {
    return this.points;
  }

  public void setPoints(int points) {
    this.points = points;
  }
}
