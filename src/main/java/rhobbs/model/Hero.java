package rhobbs.model;

import rhobbs.model.artefacts.armor.Armor;
import rhobbs.model.artefacts.helms.Helm;
import rhobbs.model.artefacts.weapons.Weapon;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public abstract class Hero {

  @NotNull(message = "Hero name can't be null.")
  @Size(min = 1, max = 20, message = "Hero name can't be less than 1 or more than 20 characters.")
  private String name;

  @NotNull(message = "Hero class type can't be null.")
  @Size(min = 1, max = 50, message = "Hero class type can't be less than 1 or more than 50 characters.")
  private String classType;

  @NotNull(message = "Hero weapon can't be null.")
  private Weapon weapon;

  @NotNull(message = "Hero armor can't be null.")
  private Armor armor;

  @NotNull(message = "Hero helm can't be null.")
  private Helm helm;

  @Min(value = 1, message = "Hero level can't be less than 1.")
  @Max(value = 2147483647, message =  "Hero level can't exceed max signed integer value.")
  private int level;

  @Min(value = 0, message = "Hero experience can't be less than 0.")
  @Max(value = 2147483647, message =  "Hero experience can't exceed max signed integer value.")
  private int experience;

  @Min(value = 0, message = "Hero hit points can't be less than 0.")
  @Max(value = 2147483647, message =  "Hero hit points can't exceed max signed integer value.")
  private int hitPoints;

  @Min(value = 0, message = "Hero attack can't be less than 0.")
  @Max(value = 2147483647, message =  "Hero attack can't exceed max signed integer value.")
  private int attack;

  @Min(value = 0, message = "Hero defense can't be less than 0.")
  @Max(value = 2147483647, message =  "Hero defense can't exceed max signed integer value.")
  private int defense;

  public Hero(
          String name,
          String classType,
          Weapon weapon,
          Armor armor,
          Helm helm,
          int level,
          int experience,
          int hitPoints
  ) {
    this.name = name;
    this.classType = classType;
    this.weapon = weapon;
    this.armor = armor;
    this.helm = helm;
    this.level = level;
    this.experience = experience;
    this.hitPoints = hitPoints + helm.getHitPoints();
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

  public Helm getHelm() {
    return helm;
  }

  public void setHelm(Helm helm) {
    this.helm = helm;
    this.hitPoints += helm.getHitPoints();
  }
}
