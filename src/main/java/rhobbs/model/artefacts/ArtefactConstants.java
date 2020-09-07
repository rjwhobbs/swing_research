package rhobbs.model.artefacts;

public class ArtefactConstants {

  private final static String[] guitarWeapons = {"Acoustic Guitar", "Flying V", "Fender Strat"};
  private final static int[] guitarWeaponsAttack = {50, 100, 200};

  private final static String[] bassGuitarWeapons = {"Squier JBass", "Mexican PBass", "Double Bass"};
  private final static int[] bassGuitarWeaponsAttack = {60, 120, 240};

  private final static String[] drumWeapons = {"Pearl Drum Kit", "Yamaha Drum Kit", "Spawn Drum Kit"};
  private final static int[] drumWeaponsAttack = {80, 180, 250};

  private final static String[] guitarArmor = {"Marshall Amp", "MesaBoogie Amp", "Vox Amp"};
  private final static int[] guitarArmorDefense = {60, 120, 240};

  private final static String[] bassGuitarArmor = {"Hartke Amp", "Fender Amp", "Ampeg All Tube Amp"};
  private final static int[] bassGuitarArmorDefense = {50, 100, 200};

  private final static String[] drumArmor = {"Wuhan Crash Cymbal", "Meinl Crash Cymbal", "Zildjian Crash Cymbal"};
  private final static int[] drumArmorDefense = {50, 100, 200};

  private final static String[] helmTypes = {"Hard Rock Cafe Cap", "Toy Machine Beanie", "Black Vans Hoodie"};
  private final static int[] helmPoints = {20, 40, 80};

  public static String[] getGuitarWeapons() {
    return guitarWeapons;
  }

  public static String[] getBassGuitarWeapons() {
    return bassGuitarWeapons;
  }

  public static String[] getDrumWeapons() {
    return drumWeapons;
  }

  public static String[] getGuitarArmor() {
    return guitarArmor;
  }

  public static String[] getBassGuitarArmor() {
    return bassGuitarArmor;
  }

  public static String[] getDrumArmor() {
    return drumArmor;
  }

  public static String[] getHelmTypes() {
    return helmTypes;
  }

  public static int[] getGuitarWeaponsAttack() {
    return guitarWeaponsAttack;
  }

  public static int[] getBassGuitarWeaponsAttack() {
    return bassGuitarWeaponsAttack;
  }

  public static int[] getDrumWeaponsAttack() {
    return drumWeaponsAttack;
  }

  public static int[] getGuitarArmorDefense() {
    return guitarArmorDefense;
  }

  public static int[] getBassGuitarArmorDefense() {
    return bassGuitarArmorDefense;
  }

  public static int[] getDrumArmorDefense() {
    return drumArmorDefense;
  }

  public static int[] getHelmPoints() {
    return helmPoints;
  }
}
