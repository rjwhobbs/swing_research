package rhobbs.controller.gui;

import rhobbs.model.Model;
import rhobbs.view.console.ConsoleView;
import rhobbs.view.gui.WindowManager;

public class GUIController {

  static Model model;
  static WindowManager windowManager;

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
        enableMovement();
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

  private static void enableMovement() {
    windowManager.setMovementEnabled(true);
    windowManager.setFightRunEnabled(false);
    windowManager.setAttackEnabled(false);
    windowManager.setPickUpLeaveEnabled(false);
  }

  private static void enableFightStart() {
    windowManager.setMovementEnabled(false);
    windowManager.setFightRunEnabled(true);
    windowManager.setAttackEnabled(false);
    windowManager.setPickUpLeaveEnabled(false);
  }

  private static void enableAttack() {
    windowManager.setMovementEnabled(false);
    windowManager.setFightRunEnabled(false);
    windowManager.setAttackEnabled(true);
    windowManager.setPickUpLeaveEnabled(false);
  }

  private static void enablePickUp() {
    windowManager.setMovementEnabled(false);
    windowManager.setFightRunEnabled(false);
    windowManager.setAttackEnabled(false);
    windowManager.setPickUpLeaveEnabled(true);
  }

  private static void disableAllButtons() {
    windowManager.setMovementEnabled(false);
    windowManager.setFightRunEnabled(false);
    windowManager.setAttackEnabled(false);
    windowManager.setPickUpLeaveEnabled(false);
  }

  private static void runCoordinateChecks() {
    if (model.isAtEndOfMap()) {
      windowManager.showGameInfo(
              "Congratulations! You reached the end of the map, your stats will be saved."
      );
      windowManager.showGameViewError("OH NOES\nERRRSS sfioifweofihworighworighworighorhg");
      disableAllButtons();
      try {
        model.saveHero();
      }
      catch (Exception e) {
        ConsoleView.showException(e.getMessage());
      }
    }
    else if (model.coordHasEnemy()) {
      model.generateEnemy();
    }
  }
}
