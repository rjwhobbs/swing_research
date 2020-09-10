package rhobbs.view.console;

import rhobbs.model.Enemy;
import rhobbs.model.Hero;
import rhobbs.model.artefacts.Artefact;

import java.util.List;

public class ConsoleView {

  public static void showStartScreen() {
    System.out.println("Welcome to Swingy! (Type EXIT to quit)");
    System.out.println("Your epic quest starts here!\nSelect an old hero or ... create a new one?");
  }

  public static void showStartSelectScreen() {
    System.out.println("(1) Select a hero.");
    System.out.println("(2) Create a new hero.");
  }

  public static void listAvailableHeroes(List<List<String>> allHeroes) {
    int totalHP;
    System.out.println("Choose your hero:");
    for (List<String> hero: allHeroes) {
      totalHP = Integer.parseInt(hero.get(10)) + Integer.parseInt(hero.get(11));
      System.out.print(
              " (" + hero.get(0) + ") "
                      + hero.get(1)
                      + " Lvl " + hero.get(6)
                      + " " + hero.get(2) + "\n"
                      + " Axe: " + hero.get(3) + " (" + hero.get(8) + " attack)"
                      + ", Defense: " + hero.get(4) + " (" + hero.get(9) + " defense)"
                      + "\n Helm: " + hero.get(5) + " (" + hero.get(10) + " hp bonus)"
                      + ", XP: " + hero.get(7)
                      + ", Total HP: " + totalHP
                      + "\n -------\n"
      );
    }

  }

  public static void showHeroStats(Hero hero) {
    System.out.print(hero.getName() + " Lvl " + hero.getLevel() + " " + hero.getClassType());
    System.out.println(" , XP: " + hero.getExperience() + ", HP: " + hero.getHitPoints());
    System.out.print(
            "Axe: " + hero.getWeapon().getSubType()
                    + " (+" + hero.getWeapon().getPoints() + ") | "
    );
    System.out.print(
            "Defense: " + hero.getArmor().getSubType()
                    + " (+" + hero.getArmor().getPoints() + ") | "
    );
    System.out.println(
            "Helm: " + hero.getHelm().getSubType()
                    + " (+" + hero.getHelm().getPoints() + ")"
    );
  }

  public static void showEnemyStats(Enemy enemy) {
    System.out.println(
            "Lvl " + enemy.getLevel()
            + " " + enemy.getEnemyType()
            + " HP: " + enemy.getHitPoints()
    );
  }

  public static void showHeroHP(Hero hero) {
    System.out.println("Your HP: " + hero.getHitPoints());
  }

  public static void showEnemyHP(Enemy enemy) {
    System.out.println("Enemy's HP: " + enemy.getHitPoints());
  }

  public static void chooseHeroName() {
    System.out.print("Choose your hero's name: ");
  }

  public static void showArtefactStats(Artefact artefact) {
    String pointsType = "";

    switch (artefact.getType()) {
      case "Helm":
        pointsType = "HP";
        break;
      case "Weapon":
        pointsType = "attack";
        break;
      case "Armor":
        pointsType = "defense";
        break;
    }
    System.out.println(
            artefact.getSubType()
                    + " " + artefact.getType()
                    + " adds " + artefact.getPoints()
                    + " " + pointsType
    );
  }

  public static void chooseHeroClass() {
    System.out.println("Choose your hero's class:");
    System.out.print(
            "(1) Guitar Hero\n"
                    + "(2) Bass Guitar Hero\n"
                    + "(3) Drum Hero\n");
  }

  public static void showYourCoords(int[] coords) {
    System.out.println("Your coords: (" + (coords[0] + 1) + "," + (coords[1] + 1) + ")");
  }

  public static void showEnemyCoords(int[] coords) {
    System.out.println("You encountered an enemy at: (" + (coords[0] + 1) + "," + (coords[1] + 1) + ")");
  }

  public static void showUsersInput(String input) {
    System.out.println(input);
  }

  public static void showInputNotRecognized(String error) {
    System.out.println("Input not recognized: " + error);
  }

  public static void showException(String exceptionMessage) {
    System.out.print("Swingy error: ");
    System.out.println(exceptionMessage);
  }

  public static void showMessage(String message) {
    System.out.println(message);
  }

}
