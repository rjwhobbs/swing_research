package rhobbs.controller;

import rhobbs.model.Model;
import rhobbs.model.storage.Storage;
import rhobbs.view.ConsoleView;

import java.util.List;
import java.util.Scanner;

public class Controller {

  ConsoleView view;
  Model model;

  private List<List<String>> storedHeroes;
  private boolean showStartScreen;
  private boolean showSelectHeroScreen;

  public Controller(Model model) {

    this.model = model;
    storedHeroes = this.model.getAllHeroes();
    String input;

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
      if (this.storedHeroes.size() != 0) {
        showStartScreen = false;
        showSelectHeroScreen = true;
      } else {
        ConsoleView.showMessage("Mmm, there seem to be no available heroes, please create a new one.");
      }
    } else if (input.equals("2")) {
      System.out.println("You selected 2");
    } else {
      ConsoleView.showInputNotRecognized(input);
    }

  }

  private void runSelectHero(String input) {

    ConsoleView.listAvailableHeroes(this.storedHeroes);
  }
}
