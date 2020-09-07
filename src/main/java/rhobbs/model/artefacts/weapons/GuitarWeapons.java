package rhobbs.model.artefacts.weapons;


import rhobbs.model.artefacts.ArtefactConstants;
import rhobbs.model.artefacts.weapons.Weapon;

public class GuitarWeapons {

  private static Weapon acousticGuitar = new Weapon("Acoustic Guitar", ArtefactConstants.getBassGuitarWeaponsAttack()[0]);
  private static Weapon flyingV = new Weapon("Flying V",  ArtefactConstants.getBassGuitarWeaponsAttack()[1]);
  private static Weapon fenderStrat = new Weapon("Fender Strat",  ArtefactConstants.getBassGuitarWeaponsAttack()[2]);

  public static Weapon getAcousticGuitar() {
    return acousticGuitar;
  }

  public static Weapon getFlyingV() {
    return flyingV;
  }

  public static Weapon getFenderStrat() {
    return fenderStrat;
  }
}
