package rhobbs.controller.gui;

import rhobbs.view.gui.WindowManager;

public class GUIController {

  static WindowManager windowManager;

  public GUIController(WindowManager windowManager) {
    this.windowManager = windowManager;
  }

  public static void handler(String input) {
    switch (input) {
      case ControlCommands.showSelect:
        windowManager.showSelectScreen();
    }
  }
}
