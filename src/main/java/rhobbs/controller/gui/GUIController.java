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
      System.out.println(e.getMessage());
    }

  }

  public static void handler(String input) {
    switch (input) {
      case ControlCommands.showSelect:
        windowManager.showSelectScreen(model.getStoredHeroes());
        break;
      case ControlCommands.showStats:
        windowManager.showStats("these are stats");
        break;
    }
  }
}
