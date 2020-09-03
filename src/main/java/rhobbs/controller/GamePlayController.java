package rhobbs.controller;

import rhobbs.model.Model;
import rhobbs.view.ConsoleView;

import java.util.Scanner;

public class GamePlayController {

  static void startGame(Model model, Scanner scanner) {

    String input = "";

    boolean showMovementScreen = true;
    boolean showFightScreen = false;
    boolean showPickUpScreen = false;

    ConsoleView.showMessage("You made it here");
    ConsoleView.showMessage("The hero you chose:");
    ConsoleView.showHeroStats(model.getHero());


    while (!input.equals("EXIT")) {

    }
//    model.generateMap();
  }

}
