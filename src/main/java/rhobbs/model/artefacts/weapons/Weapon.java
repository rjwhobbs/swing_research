package rhobbs.model.artefacts.weapons;

import rhobbs.model.artefacts.Artefact;

public class Weapon extends Artefact {

  Weapon(String type, int attack) {
    this.type = "Weapon";
    this.subType = type;
    this.points = attack;
  }
}
