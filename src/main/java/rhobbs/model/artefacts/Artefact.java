package rhobbs.model.artefacts;

import java.awt.geom.Area;

public class Artefact {
  public String type;
  public int points;

  Artefact() {};

  public String getType() {
    return this.type;
  }

  public int getPoints() {
    return this.points;
  }

  public void setPoints(int points) {
    this.points = points;
  }
}
