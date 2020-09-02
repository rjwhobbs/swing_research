package rhobbs.controller;

import rhobbs.model.Model;
import rhobbs.view.ConsoleView;

import java.util.Scanner;

public class GamePlayController {

  static void startGame(Model model, Scanner scanner) {
    ConsoleView.showMessage("You made it here");
    ConsoleView.showMessage("The hero you chose:");
    ConsoleView.showHeroStats(model.getHero());
    model.generateMap();
  }

}
