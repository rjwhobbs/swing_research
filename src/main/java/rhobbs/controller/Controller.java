package rhobbs.controller;

import rhobbs.model.Model;
import rhobbs.view.ConsoleView;

import java.util.Scanner;

public class Controller {

  ConsoleView view;
  Model model;

//  private List<List<String>> storedHeroes;
  private boolean showStartScreen;
  private boolean showSelectHeroScreen;
  private boolean showSelectedHeroScreen;

  public Controller(Model model) {

    this.model = model;
//    storedHeroes = this.model.getStoredHeroes();
    String input = "";

    Scanner scanner = new Scanner(System.in);

    showStartScreen = true;
    showSelectHeroScreen = false;
    showSelectedHeroScreen = false;

    ConsoleView.showStartScreen();

    while (!input.equals("EXIT")) {
      if (showStartScreen) {
        ConsoleView.showStartSelectScreen();
        input = scanner.nextLine();
        if (input.equals("EXIT")) {
          break;
        }
        this.runStart(input);
      }
      else if (showSelectHeroScreen) {
        ConsoleView.listAvailableHeroes(this.model.getStoredHeroes());
        input = scanner.nextLine();
        if (input.equals("EXIT")) {
          break;
        }
        this.runSelectHero(input);
      }
      else if (showSelectedHeroScreen) {
        ConsoleView.showHeroStats(this.model.getHero());
        input = scanner.nextLine();
        if (input.equals("EXIT")) {
          break;
        }
      }
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
    if (this.validateSelectedHeroIndex(input)) {
      this.model.selectHero(input);
//      ConsoleView.showHeroStats(this.model.getHero());
      showSelectHeroScreen = false;
      showSelectedHeroScreen = true;
    } else {
      ConsoleView.showInputNotRecognized(input);
    }
  }

  private boolean validateSelectedHeroIndex(String index) {
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
