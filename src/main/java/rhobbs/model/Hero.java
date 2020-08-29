package rhobbs.model;

import rhobbs.model.artefacts.armor.Armor;
import rhobbs.model.artefacts.weapons.Weapon;

public abstract class Hero {

  private String name;
  private String classType;
  private Weapon weapon;
  private Armor armor;
  private int level;
  private int experience;
  private int hitPoints;
  private int attack;
  private int defense;

  public Hero(
          String name,
          String classType,
          Weapon weapon,
          Armor armor,
          int level,
          int experience,
          int hitPoints
  ) {
    this.name = name;
    this.classType = classType;
    this.weapon = weapon;
    this.armor = armor;
    this.level = level;
    this.experience = experience;
    this.hitPoints = hitPoints;
    this.attack = weapon.getAttack();
    this.defense = armor.getDefense();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Weapon getWeapon() {
    return weapon;
  }

  public Armor getArmor() {
    return armor;
  }

  public void setArmor(Armor armor) {
    this.defense = armor.getDefense();
    this.armor = armor;
  }

  public void setWeapon(Weapon weapon) {
    this.attack = weapon.getAttack();
    this.weapon = weapon;
  }

  public String getClassType() {
    return classType;
  }

  public void setClassType(String classType) {
    this.classType = classType;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public int getExperience() {
    return experience;
  }

  public void setExperience(int experience) {
    this.experience = experience;
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
