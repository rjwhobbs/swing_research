package rhobbs.model.artefacts;


import java.util.ArrayList;
import java.util.List;

public class GuitarWeapons {

  private static Weapon acousticGuitar = new Weapon("Acoustic Guitar", 50);
  private static Weapon flyingV = new Weapon("Flying V", 100);
  private static Weapon fenderStrat = new Weapon("Fender Stratocaster", 200);

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
