package rhobbs.model.artefacts;

public class Weapon {
  private String type;
  private int attack;

  Weapon(String type, int attack) {
    this.type = type;
    this.attack = attack;
  }

  public String getType() {
    return type;
  }

  public int getAttack() {
    return attack;
  }
}
