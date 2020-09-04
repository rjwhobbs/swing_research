package rhobbs.model.artefacts.helms;

import rhobbs.model.artefacts.Artefact;

public class Helm extends Artefact {

  Helm(String helmType, int hitPoints) {
    this.type = helmType;
    this.points = hitPoints;
  }
}
