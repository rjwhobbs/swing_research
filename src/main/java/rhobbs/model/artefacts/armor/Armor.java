package rhobbs.model.artefacts.armor;

import rhobbs.model.artefacts.Artefact;

public class Armor extends Artefact {

  Armor(String type, int defense) {
    this.type = type;
    this.points = defense;
  }

  public String getType() {
    return type;
  }

  public int getDefense() {
    return points;
  }
}
