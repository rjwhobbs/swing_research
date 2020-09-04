package rhobbs.model.artefacts;

public class ArtefactTypes {

  private static String[] guitarWeapons = {"Acoustic Guitar", "Flying V", "Fender Strat"};
  private static String[] bassGuitarWeapons = {"Squier JBass", "Mexican PBass", "Double Bass"};
  private static String[] drumWeapons = {"Pearl Drum Kit", "Yamaha Drum Kit", "Spawn Drum Kit"};

  private static String[] guitarArmor = {"Marshall Amp", "MesaBoogie Amp", "Vox Amp"};
  private static String[] bassGuitarArmor = {"Hartke Amp", "Fender Amp", "Ampeg All Tube Amp"};
  private static String[] drumArmor = {"Wuhan Crash Cymbal", "Meinl Crash Cymbal", "Zildjian Crash Cymbal"};

  private static String[] helmTypes = {"Hard Rock Cafe Cap", "Toy Machine Beanie", "Black Vans Hoodie"};

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
}
