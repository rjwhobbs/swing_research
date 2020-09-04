package rhobbs.view;

import rhobbs.model.Enemy;
import rhobbs.model.Hero;

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
    System.out.println("Choose your hero:");
    for (List<String> hero: allHeroes) {
      System.out.print(
              " (" + hero.get(0) + ") "
                      + hero.get(1)
                      + " Lvl " + hero.get(6)
                      + " " + hero.get(2) + "\n"
                      + " Axe: " + hero.get(3)
                      + ", Defense: " + hero.get(4)
                      + ", Helm: " + hero.get(5)
                      + ", XP: " + hero.get(7)
                      + "\n -------\n"
      );
    }

  }

  public static void showHeroStats(Hero hero) {
    System.out.println(hero.getName() + " Lvl " + hero.getLevel() + " " + hero.getClassType());
    System.out.println("XP: " + hero.getExperience());
    System.out.println("HP: " + hero.getHitPoints());
    System.out.println("Weapon: " + hero.getWeapon().getType());
    System.out.println("Armor: " + hero.getArmor().getType());
    System.out.println("Helm: " + hero.getHelm().getHelmType());
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
    System.out.println("Your foes HP: " + enemy.getHitPoints());
  }

  public static void chooseHeroName() {
    System.out.print("Choose your hero's name: ");
  }

  public static void chooseHeroClass() {
    System.out.println("Choose your hero's class:");
    System.out.print(
            "(1) Guitar Hero\n"
                    + "(2) Bass Guitar Hero\n"
                    + "(3) Drum Hero\n");
  }

  public static void showCoords(int[] coords) {
    System.out.println("Your coords: (" + (coords[0] + 1) + "," + (coords[1] + 1) + ")");
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
