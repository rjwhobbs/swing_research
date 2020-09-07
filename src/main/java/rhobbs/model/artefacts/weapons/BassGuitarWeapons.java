package rhobbs.model.artefacts.weapons;

import rhobbs.model.artefacts.ArtefactConstants;

public class BassGuitarWeapons {

  private static Weapon squierJBass = new Weapon("Squier JBass", ArtefactConstants.getBassGuitarWeaponsAttack()[0]);
  private static Weapon mexiPBass = new Weapon("Mexican PBass", ArtefactConstants.getBassGuitarWeaponsAttack()[1]);
  private static Weapon doubleBass = new Weapon("Double Bass", ArtefactConstants.getBassGuitarWeaponsAttack()[2]);

  public static Weapon getSquierJBass() {
    return squierJBass;
  }

  public static Weapon getMexiPBass() {
    return mexiPBass;
  }

  public static Weapon getDoubleBass() {
    return doubleBass;
  }
}
