package rhobbs.controller.gui;

import rhobbs.model.Model;
import rhobbs.view.gui.WindowManager;

import java.util.Random;

public class GUIController {

  static Model model;
  static WindowManager windowManager;
  static Random random = new Random();

  public GUIController(WindowManager windowManager, Model model) {
    this.windowManager = windowManager;
    this.model = model;
    // Seems the UI makes the screen before this can run, might need to handle this.
    try {
      this.model.modelInit();
    }
    catch (Exception e) {
      this.windowManager.disableStartSelectScreen();
      String error = "There was an error setting up the hero data base."
              + "\nThe game cannot function correctly without this."
              + "\n" + e.getMessage();
      this.windowManager.showErrorOnStart(error);
    }

  }

  public static void handler(String input) {
    switch (input) {
      case ControlCommands.showStartScreen:
        windowManager.showStartScreen();
        break;
      case ControlCommands.showSelect:
        windowManager.showSelectScreen(model.getStoredHeroes());
        break;
      case ControlCommands.showCreateScreen:
        windowManager.showCreateScreen();
        break;
      case ControlCommands.showStats:
        windowManager.showSelectScreenStats("these are stats");
        break;
      case ControlCommands.showGameView:
        model.generateMap();
        windowManager.showGameView(model.getHero());
        windowManager.showCurrentCoords(model.getCurrentCoords());
        enableMovementButtons();
        break;
      case ControlCommands.pickupItem:
        model.equipArtefact();
        windowManager.showGameInfo("You equip the item.");
        windowManager.upDateGameViewHeroStats(model.getHero());
        enableMovementButtons();
        break;
      case ControlCommands.leaveItem:
        windowManager.showGameInfo("You left the item");
        enableMovementButtons();
        break;
      case ControlCommands.exitGame:
        windowManager.quitGame();
        break;
    }
  }

  public static void handler(String input, String value) {
    switch (input) {
      case ControlCommands.selectHeroById:
        try {
          model.selectHero(value);
          handler(ControlCommands.showGameView);
        }
        catch (Exception e) {
         windowManager.showSelectScreenError(e.getMessage());
        }
        break;
    }
  }

  public static void handler(String input, String valueOne, String valueTwo) {
    switch (input) {
      case ControlCommands.createNewHero:
        try {
          if (model.getStoredHeroByName(valueOne).size() == 0) {
            model.createNewHero(valueOne, valueTwo);
            if (model.getHero() != null) {
              model.storeNewHero();
              handler(ControlCommands.showGameView);
            }
            else {
              windowManager.showCreateScreenError("Hero was not initialized.\n");
            }
          }
          else {
            windowManager.showCreateScreenError("Hero name already exits.\n");
          }
        }
        catch (Exception e) {
          windowManager.showCreateScreenError(e.getMessage());
        }
        break;
    }
  }

  public static void movementHandler(String input) {
    windowManager.showGameInfo("");
    switch (input) {
      case ControlCommands.moveNorth:
        model.moveNorth();
        windowManager.showCurrentCoords(model.getCurrentCoords());
        break;
      case ControlCommands.moveEast:
        model.moveEast();
        windowManager.showCurrentCoords(model.getCurrentCoords());
        break;
      case ControlCommands.moveSouth:
        model.moveSouth();
        windowManager.showCurrentCoords(model.getCurrentCoords());
        break;
      case ControlCommands.moveWest:
        model.moveWest();
        windowManager.showCurrentCoords(model.getCurrentCoords());
        break;
    }
    runCoordinateChecks();
  }

  public static void fightHandler(String input) {
    switch (input) {
      case ControlCommands.startFight:
        windowManager.showGameInfo("And so your fight begins!\nHit attack!");
        enableAttackButton();
        break;
      case ControlCommands.run:
        if (random.nextInt(100) >= 49) {
          windowManager.showGameInfo(
                  "You where unable to run from your enemy."
                  +"\nYou have no choice but to attack!"
          );
          enableAttackButton();
        }
        else {
          windowManager.showGameInfo("You successfully ran away from your enemy!");
          model.setCoords(model.getPrevCoords()[0], model.getPrevCoords()[1]);
          windowManager.showCurrentCoords(model.getCurrentCoords());
          enableMovementButtons();
        }
        break;
      case ControlCommands.continueFight:
        runFightLoop();
        break;
    }
  }

  private static void runCoordinateChecks() {
    if (model.isAtEndOfMap()) {
//      windowManager.showGameInfo(
//              "Congratulations! You reached the end of the map!\nYour stats will be saved."
//      );
      disableAllButtons();
      windowManager.endGameMessage(
              "Congratulations!",
              "You reached the end of the map!\nYour stats will be saved."
      );
      try {
        model.saveHero();
      }
      catch (Exception e) {
        windowManager.showGameViewError(e.getMessage());
      }
    }
    else if (model.coordHasEnemy()) {
      model.generateEnemy();
      windowManager.showGameInfo("", model.getEnemy());
      enableFightStartButtons();
    }
  }

  private static void runFightLoop() {
    if (model.stillFighting()) {
      windowManager.showGameInfo("Attack!", model.getHero(), model.getEnemy());
    }
    else {
      if (model.isHeroDefeated()) {
//        windowManager.showGameInfo(
//                "Ahh no! You were defeated!"
//                        + "\nSince you didn't reach the end of the map your stats won't be saved.",
//                model.getHero(),
//                model.getEnemy()
//        );
        disableAllButtons();
        windowManager.endGameMessage(
                "Ahh no! You were defeated!",
                "\nSince you didn't reach the end of the map\nyour stats won't be saved."
                );
      }
      else {
        StringBuilder info = new StringBuilder();
        info.append("You defeated your foe!");
        if (model.isLevelGained()) {
          info.append("\nAnd you gained a level!");
        }
        info.append("\nYou take a moment to regain some health");
        if (model.didDropArtefact()) {
          enablePickupButtons();
        }
        else {
          enableMovementButtons();
        }
        windowManager.showGameInfo(
                info.toString(),
                model.getHero(),
                model.getArtefact()
        );
      }
    }
    windowManager.upDateGameViewHeroStats(model.getHero());
  }

  private static void enableMovementButtons() {
    windowManager.setMovementEnabled(true);
    windowManager.setFightRunEnabled(false);
    windowManager.setAttackEnabled(false);
    windowManager.setPickupLeaveEnabled(false);
  }

  private static void enableFightStartButtons() {
    windowManager.setMovementEnabled(false);
    windowManager.setFightRunEnabled(true);
    windowManager.setAttackEnabled(false);
    windowManager.setPickupLeaveEnabled(false);
  }

  private static void enableAttackButton() {
    windowManager.setMovementEnabled(false);
    windowManager.setFightRunEnabled(false);
    windowManager.setAttackEnabled(true);
    windowManager.setPickupLeaveEnabled(false);
  }

  private static void enablePickupButtons() {
    windowManager.setMovementEnabled(false);
    windowManager.setFightRunEnabled(false);
    windowManager.setAttackEnabled(false);
    windowManager.setPickupLeaveEnabled(true);
  }

  private static void disableAllButtons() {
    windowManager.setMovementEnabled(false);
    windowManager.setFightRunEnabled(false);
    windowManager.setAttackEnabled(false);
    windowManager.setPickupLeaveEnabled(false);
  }
}
