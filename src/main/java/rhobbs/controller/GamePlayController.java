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
  private static Model model;

  static void startGame(Model model, Scanner scanner) {

    GamePlayController.model = model;

    String input = "";

    showMovementScreen = true;
    showFightScreen = false;
    showPickUpScreen = false;
    gameOver = false;

    ConsoleView.showMessage("The hero you chose:");
    ConsoleView.showHeroStats(model.getHero());
    model.generateMap();

    while (!input.equals("EXIT") && !gameOver) {
      if (showMovementScreen) {
        ConsoleView.showMessage("Your coordinates");
        ConsoleView.showCoords(model.getCoords());
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
  }

  private static void runMovementScreen(String input) {
    switch (input) {
      case "N":
      case "n":
        ConsoleView.showMessage("You moved north.");
        model.moveNorth();
        if (model.isAtEndOfMap()) {
          ConsoleView.showMessage("You reached the end.");
          showMovementScreen = false;
          gameOver = true;
        }
        break;
      case "E":
      case "e":
        ConsoleView.showMessage("You moved East.");
        model.moveEast();
        if (model.isAtEndOfMap()) {
          ConsoleView.showMessage("You reached the end.");
          showMovementScreen = false;
          gameOver = true;
        }
        break;
      case "S":
      case "s":
        ConsoleView.showMessage("You moved South.");
        model.moveSouth();
        if (model.isAtEndOfMap()) {
          ConsoleView.showMessage("You reached the end.");
          showMovementScreen = false;
          gameOver = true;
        }
        break;
      case "W":
      case "w":
        ConsoleView.showMessage("You moved west.");
        model.moveWest();
        if (model.isAtEndOfMap()) {
          ConsoleView.showMessage("You reached the end.");
          showMovementScreen = false;
          gameOver = true;
        }
        break;
      default:
        ConsoleView.showInputNotRecognized(input);
        break;
    }

//    if (checkEnemy == 1) {
//      showFightScreen = true;
//      showMovementScreen = false;
//    }
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
