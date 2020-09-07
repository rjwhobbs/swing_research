package rhobbs.model.artefacts.armor;

import rhobbs.model.artefacts.Artefact;

public class Armor extends Artefact {

  Armor(String subType, int defense) {
    this.type = "Armor";
    this.subType = subType;
    this.points = defense;
  }
}
