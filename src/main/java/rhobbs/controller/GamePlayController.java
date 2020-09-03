package rhobbs.controller;

import rhobbs.model.Model;
import rhobbs.view.ConsoleView;

import java.util.Random;
import java.util.Scanner;

public class GamePlayController {

  private static Random random = new Random();
  private static int checkEnemy = 0;
  private static boolean showMovementScreen;
  private static boolean showFightScreen;
  private static boolean showPickUpScreen;
  private static boolean gameOver;

  static void startGame(Model model, Scanner scanner) {

    String input = "";

    showMovementScreen = true;
    showFightScreen = false;
    showPickUpScreen = false;
    gameOver = false;

    ConsoleView.showMessage("You made it here");
    ConsoleView.showMessage("The hero you chose:");
    ConsoleView.showHeroStats(model.getHero());


    while (!input.equals("EXIT") && !gameOver) {
      if (showMovementScreen) {
        ConsoleView.showMessage("Type to move: N, E, S, W");
        input = scanner.nextLine();
        if (input.equals("EXIT")) {
          break;
        }
        runMovementScreen(input);
      }
      else if (showFightScreen) {
        ConsoleView.showMessage("You encountered an enemy.");
        ConsoleView.showMessage("F to fight or R to run");
        input = scanner.nextLine();
        if (input.equals("EXIT")) {
          break;
        }
        runFightScreen(input);
      }
      else if (showPickUpScreen) {
        ConsoleView.showMessage("The enemy dropped an item, pick it up? (Y/N)");
        input = scanner.nextLine();
        if (input.equals("EXIT")) {
          break;
        }
        runPickScreen(input);
      }
    }
//    model.generateMap();
  }

  private static void runMovementScreen(String input) {

    switch (input) {
      case "N":
      case "n":
        ConsoleView.showMessage("You moved north.");
        checkEnemy = random.nextInt(2);
        break;
      case "E":
      case "e":
        ConsoleView.showMessage("You moved East.");
        checkEnemy = random.nextInt(2);
        break;
      case "S":
      case "s":
        ConsoleView.showMessage("You moved South.");
        checkEnemy = random.nextInt(2);
        break;
      case "W":
      case "w":
        ConsoleView.showMessage("You moved west.");
        checkEnemy = random.nextInt(2);
        break;
      default:
        ConsoleView.showInputNotRecognized(input);
        break;
    }

    if (checkEnemy == 1) {
      showFightScreen = true;
      showMovementScreen = false;
    }
  }

  private static void runFightScreen(String input) {
    switch (input) {
      case "F":
      case "f":
        ConsoleView.showMessage("You fight the enemy");
        if (random.nextInt(2) == 1) {
          ConsoleView.showMessage("You fought the enemy and won!");
          if (random.nextInt(2) == 1) {
            showFightScreen = false;
            showPickUpScreen = true;
          }
          else {
            showFightScreen = false;
            showMovementScreen = true;
          }
        }
        else {
          ConsoleView.showMessage("You fought the enemy and lost");
          showFightScreen = false;
          gameOver = true;
        }
        break;
      case "R":
      case "r":
        if (random.nextInt(2) == 1) {
          ConsoleView.showMessage("You where unable to run from the enemy");
          runFightScreen("F");
        }
        else {
          ConsoleView.showMessage("You successfully ran from the enemy");
          showFightScreen = false;
          showMovementScreen = true;
        }
        break;
      default:
        ConsoleView.showInputNotRecognized(input);
    }
  }

  private static void runPickScreen(String input) {
    switch (input) {
      case "Y":
      case "y":
        ConsoleView.showMessage("You picked up the item.");
        showPickUpScreen = false;
        showMovementScreen = true;
        break;
      case "N":
      case "n":
        ConsoleView.showMessage("You left the itme.");
        showPickUpScreen = false;
        showMovementScreen = true;
        break;
      default:
        ConsoleView.showInputNotRecognized(input);
        break;
    }
  }
}
