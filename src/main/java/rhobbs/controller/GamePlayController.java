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
  private static boolean showLoopFightScreen;
  private static boolean showPickUpScreen;
  private static boolean gameOverScreen;
  private static Model model;

  static void startGame(Model model, Scanner scanner) {

    GamePlayController.model = model;

    String input = "";

    showMovementScreen = true;
    showFightScreen = false;
    showLoopFightScreen = false;
    showPickUpScreen = false;
    gameOverScreen = false;

    model.generateMap();

    while (!input.equals("EXIT") && !gameOverScreen) {
      if (showMovementScreen) {
        ConsoleView.showHeroStats(GamePlayController.model.getHero());
        ConsoleView.showYourCoords(model.getCurrentCoords());
        ConsoleView.showMessage("Type to move: N, E, S, W");
        input = scanner.nextLine();
        if (input.equals("EXIT")) {
          break;
        }
        runMovementScreen(input);
      }
      else if (showFightScreen) {
        ConsoleView.showEnemyCoords(GamePlayController.model.getCurrentCoords());
        ConsoleView.showEnemyStats(GamePlayController.model.getEnemy());
        ConsoleView.showMessage("F to fight or R to run");
        input = scanner.nextLine();
        if (input.equals("EXIT")) {
          break;
        }
        runFightScreen(input);
      }
      else if (showLoopFightScreen) {
        ConsoleView.showMessage("Hit ENTER to fight!");
        input = scanner.nextLine();
        if (input.equals("EXIT")) {
          break;
        }
        runLoopFightScreen();
      }
      else if (showPickUpScreen) {
        ConsoleView.showHeroStats(GamePlayController.model.getHero());
        ConsoleView.showMessage("The enemy dropped an item...");
        ConsoleView.showArtefactStats(GamePlayController.model.getArtefact());
        ConsoleView.showMessage("Equip it? (Y/N)");
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
        model.moveNorth();
        runCoordinateChecks();
        break;
      case "E":
      case "e":
        model.moveEast();
        runCoordinateChecks();
        break;
      case "S":
      case "s":
        model.moveSouth();
        runCoordinateChecks();
        break;
      case "W":
      case "w":
        model.moveWest();
        runCoordinateChecks();
        break;
      default:
        ConsoleView.showInputNotRecognized(input);
        break;
    }
  }

  private static void runFightScreen(String input) {
    switch (input) {
      case "F":
      case "f":
        ConsoleView.showMessage("And so your battle begins!");
        showFightScreen = false;
        showLoopFightScreen = true;
        break;
      case "R":
      case "r":
        if (random.nextInt(100) >= 49) {
          ConsoleView.showMessage("You where unable to run from the enemy.");
          runFightScreen("F");
        }
        else {
          ConsoleView.showMessage("You successfully ran away from the enemy.");
          model.setCoords(model.getPrevCoords()[0], model.getPrevCoords()[1]);
          showFightScreen = false;
          showMovementScreen = true;
        }
        break;
      default:
        ConsoleView.showInputNotRecognized(input);
    }
  }

  private static void runLoopFightScreen() {
    if (model.stillFighting()) {
      ConsoleView.showHeroHP(model.getHero());
      ConsoleView.showEnemyHP(model.getEnemy());
    }
    else {
      if (model.isHeroDefeated()) {
        ConsoleView.showHeroHP(model.getHero());
        ConsoleView.showEnemyHP(model.getEnemy());
        ConsoleView.showMessage("You were defeated!");
        gameOverScreen = true;
      }
      else {
        ConsoleView.showMessage("You defeated your foe!");
        ConsoleView.showMessage("You take a moment to regain some health");
        if (model.didDropArtefact()) {
          showPickUpScreen = true;
        }
        else {
          showMovementScreen = true;
        }
      }
      showLoopFightScreen = false;
    }
  }

  private static void runPickScreen(String input) {
    switch (input) {
      case "Y":
      case "y":
        model.equipArtefact();
        ConsoleView.showMessage("You equip the item.");
        break;
      case "N":
      case "n":
        ConsoleView.showMessage("You left the item.");
        break;
      default:
        ConsoleView.showInputNotRecognized(input);
        break;
    }
    showPickUpScreen = false;
    showMovementScreen = true;
  }

  private static void runCoordinateChecks() {
    if (model.isAtEndOfMap()) {
      ConsoleView.showMessage("Congratulations! You reached the end of the map, your stats will be saved.");
      try {
        model.saveHero();
      }
      catch (Exception e) {
        ConsoleView.showException(e.getMessage());
      }
      showMovementScreen = false;
      gameOverScreen = true;
    }
    else if (model.coordHasEnemy()) {
      showFightScreen = true;
      showMovementScreen = false;
      model.generateEnemy();
    }
  }
}
