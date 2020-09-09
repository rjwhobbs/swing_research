package rhobbs.controller.gui;

import rhobbs.model.Model;
import rhobbs.view.gui.WindowManager;

public class GUIController {

  static Model model;
  static WindowManager windowManager;

  public GUIController(WindowManager windowManager, Model model) {
    this.windowManager = windowManager;
    this.model = model;
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
      case ControlCommands.showSelect:
        windowManager.showSelectScreen(model.getStoredHeroes());
        break;
      case ControlCommands.showStats:
        windowManager.showSelectScreenStats("these are stats");
        break;
      case ControlCommands.showGameView:
        windowManager.showGameView(model.getHero());
        break;
    }
  }

  public static void handler(String input, String index) {
    switch (input) {
      case ControlCommands.selectHeroById:
        try {
          model.selectHero(index);
          handler(ControlCommands.showGameView);
        }
        catch (Exception e) {
         System.out.println(e.getMessage());
        }
        break;
    }
  }
}
