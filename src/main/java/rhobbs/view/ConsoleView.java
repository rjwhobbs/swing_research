package rhobbs.view;

import rhobbs.model.Hero;

import java.util.List;

public class ConsoleView {

  private static boolean showStartScreen;

  public static void showStartMessage() {
    System.out.println("Welcome to Swingy! (Type EXIT to quit)");
    System.out.println("Type the number of your option");
    System.out.println("1 Select a hero.");
    System.out.println("2 Create a new hero.");
  }

  public static void listAvailableHeroes(List<List<String>> allHeroes) {
    System.out.println("Choose your hero:");
    for (List<String> hero: allHeroes) {
      System.out.print(
              " (" + hero.get(0) + ") "
                      + hero.get(1) + " "
                      + " Lvl " + hero.get(5)
                      + " " + hero.get(2) + "\n"
                      + " Axe: " + hero.get(3)
                      + ", Defense: " + hero.get(4)
                      + ", XP: " + hero.get(6)
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
  }

  public static void showUsersInput(String input) {
    System.out.println(input);
  }

  public static void showInputNotRecognized(String error) {
    System.out.println("Input not recognized: " + error);
  }

  public static boolean isShowStartScreen() {
    return showStartScreen;
  }

  public static void setShowStartScreen(boolean showStartScreen) {
    ConsoleView.showStartScreen = showStartScreen;
  }

  public static void showAvailableHeroes() {
  }
}
