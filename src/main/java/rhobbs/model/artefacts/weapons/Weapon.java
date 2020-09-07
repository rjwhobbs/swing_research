package rhobbs.model.artefacts.weapons;

import rhobbs.model.artefacts.Artefact;

public class Weapon extends Artefact {

  Weapon(String subType, int attack) {
    this.type = "Weapon";
    this.subType = subType;
    this.points = attack;
  }
}
