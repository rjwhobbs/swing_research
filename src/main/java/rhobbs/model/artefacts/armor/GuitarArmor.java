package rhobbs.model.artefacts.armor;

import rhobbs.model.artefacts.ArtefactConstants;

public class GuitarArmor {

  private static Armor marshallAmp = new Armor(
          "Marshall Amp",
          ArtefactConstants.getGuitarArmorDefense()[0]
  );
  private static Armor mesaBoogieAmp = new Armor(
          "MesaBoogie Amp",
          ArtefactConstants.getGuitarArmorDefense()[1]
  );
  private static Armor voxAmp = new Armor(
          "Vox Amp",
          ArtefactConstants.getGuitarArmorDefense()[2]
  );

  public static Armor getMarshallAmp() {
    return marshallAmp;
  }

  public static Armor getMesaBoogieAmp() {
    return mesaBoogieAmp;
  }

  public static Armor getVoxAmp() {
    return voxAmp;
  }
}
