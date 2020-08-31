package rhobbs.controller;

import rhobbs.model.Model;
import rhobbs.view.ConsoleView;

import java.util.List;
import java.util.Scanner;

public class Controller {

  ConsoleView view;
  Model model;

//  private List<List<String>> storedHeroes;
  private boolean showStartScreen;
  private boolean showSelectHeroScreen;

  public Controller(Model model) {

    this.model = model;
//    storedHeroes = this.model.getStoredHeroes();
    String input = "";

    Scanner scanner = new Scanner(System.in);
    showStartScreen = true;
    showSelectHeroScreen = false;

    ConsoleView.showStartMessage();

    input = scanner.nextLine();

    while (!input.equals("EXIT")) {
      if (showStartScreen) {
       this.runStart(input);
      }
      if (showSelectHeroScreen) {
        this.runSelectHero(input);
      }
      input = scanner.nextLine();
    }
  }

  private void runStart(String input) {
    if (input.equals("1")) {
      if (this.model.getStoredHeroes().size() != 0) {
        showStartScreen = false;
        showSelectHeroScreen = true;
      }
      else {
        ConsoleView.showMessage("Mmm, there seem to be no available heroes, please create a new one.");
      }
    }
    else if (input.equals("2")) {
      System.out.println("You selected 2");
    }
    else {
      ConsoleView.showInputNotRecognized(input);
    }
  }

  private void runSelectHero(String input) {
    ConsoleView.listAvailableHeroes(this.model.getStoredHeroes());
    if (this.validateSlectedHeroIndex(input)) {
      this.model.selectHero(input);
    }
  }

  private boolean validateSlectedHeroIndex(String index) {
    try {
      int input = Integer.parseInt(index);
      if (input <= 0 || input > this.model.getStoredHeroes().size() || index.indexOf(0) == '+') {
        return false;
      }
      return true;
    }
    catch (NumberFormatException e) {
      return false;
    }
  }
}
