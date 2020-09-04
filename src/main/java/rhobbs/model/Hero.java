package rhobbs.model;

import rhobbs.model.artefacts.Artefact;
import rhobbs.model.artefacts.armor.Armor;
import rhobbs.model.artefacts.helms.Helm;
import rhobbs.model.artefacts.weapons.Weapon;

import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.*;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

public abstract class Hero {

  @NotNull(message = "Hero name can't be null.")
  @Size(min = 1, max = 20, message = "Hero name can't be less than 1 or more than 20 characters.")
  @Pattern(
          regexp = ("^[^\\s]+(\\s+[^\\s]+)*$"),
          message = "Hero name can't have only, leading, or trailing white space")
  private String name;

  @NotNull(message = "Hero class type can't be null.")
  @Size(min = 1, max = 50, message = "Hero class type can't be less than 1 or more than 50 characters.")
  private String classType;

  @NotNull(message = "Hero weapon can't be null.")
  private Artefact weapon;

  @NotNull(message = "Hero armor can't be null.")
  private Artefact armor;

  @NotNull(message = "Hero helm can't be null.")
  Artefact helm;

  @Min(value = 0, message = "Hero level can't be less than 0.")
  @Max(value = 2147483647, message =  "Hero level can't exceed max signed integer value.")
  private int level;

  @Min(value = 0, message = "Hero experience can't be less than 0.")
  @Max(value = 2147483647, message =  "Hero experience can't exceed max signed integer value.")
  private int experience;

  @Min(value = 0, message = "Hero hit points can't be less than 0.")
  @Max(value = 2147483647, message =  "Hero hit points can't exceed max signed integer value.")
  int hitPoints;

  @Min(value = 0, message = "Hero hit points can't be less than 0.")
  @Max(value = 2147483647, message =  "Hero hit points can't exceed max signed integer value.")
  int maxHitPoints;

  @Min(value = 0, message = "Hero attack can't be less than 0.")
  @Max(value = 2147483647, message =  "Hero attack can't exceed max signed integer value.")
  private int attack;

  @Min(value = 0, message = "Hero defense can't be less than 0.")
  @Max(value = 2147483647, message =  "Hero defense can't exceed max signed integer value.")
  private int defense;

  private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
  private static Validator validator = factory.getValidator();

  Hero() {}

  Hero(
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
    this.hitPoints = hitPoints;
    this.maxHitPoints = hitPoints;
    this.attack = 0;
    this.defense = 0;
  }

  public void validateHero() throws Exception {
    Set<ConstraintViolation<Hero>> cvs = validator.validate(this);
    StringBuilder error = new StringBuilder();

    if (cvs.size() > 0) {
      for (ConstraintViolation<Hero> cv : cvs) {
        error.append(cv.getPropertyPath() + ": " + cv.getMessage() + "\n");
      }
      throw new Exception(error.toString());
    }
  }

  public void equipWeapon() {
    this.attack = this.weapon.getPoints();
  }

  public void equipArmor() {
    this.defense = this.armor.getPoints();
  }

  public abstract void equipHelm();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Artefact getWeapon() {
    return weapon;
  }

  public Artefact getArmor() {
    return armor;
  }

  public void setArmor(Artefact armor) {
    this.defense = armor.getPoints();
    this.armor = armor;
  }

  public void setWeapon(Artefact weapon) {
    this.attack = weapon.getPoints();
    this.weapon = weapon;
  }

  public Artefact getHelm() {
    return helm;
  }

  public void setHelm(Artefact helm) {
    this.helm = helm;
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

  public int getMaxHitPoints() {
    return maxHitPoints;
  }

  public void setMaxHitPoints(int maxHitPoints) {
    this.maxHitPoints = maxHitPoints;
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
