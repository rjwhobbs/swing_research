package rhobbs.model;

public class Enemy {

  private String enemyType;
  private int level;
  private int hitPoints;
  private int attack;
  private int defense;

  Enemy(
          String enemyType,
          int level,
          int hitPoints,
          int attack,
          int defense
  ) {
    this.enemyType = enemyType;
    this.level = level;
    this.hitPoints = hitPoints;
    this.attack = attack;
    this.defense = defense;
  }

  public String getEnemyType() {
    return enemyType;
  }

  public void setEnemyType(String enemyType) {
    this.enemyType = enemyType;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public int getHitPoints() {
    return hitPoints;
  }

  public void setHitPoints(int hitPoints) {
    this.hitPoints = hitPoints;
  }

  public int getAttack() {
    return attack;
  }

  public void setAttack(int attack) {
    this.attack = attack;
  }

  public int getDefense() {
    return defense;
  }

  public void setDefense(int defense) {
    this.defense = defense;
  }
}
