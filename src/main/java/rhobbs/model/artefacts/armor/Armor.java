package rhobbs.model.artefacts.armor;

public class Armor {
  private String type;
  private int defense;

  Armor(String type, int defense) {
    this.type = type;
    this.defense = defense;
  }

  public String getType() {
    return type;
  }

  public int getDefense() {
    return defense;
  }
}
