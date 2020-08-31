package rhobbs.controller;

import rhobbs.model.Model;
import rhobbs.model.storage.Storage;
import rhobbs.view.ConsoleView;

import java.util.Scanner;

public class Controller {

  ConsoleView view;
  Model model;

  public Controller(Model model) {

    this.model = model;
    String input;

    Scanner scanner = new Scanner(System.in);
    ConsoleView.setShowStartScreen(true);
    ConsoleView.showStartMessage();
    input = scanner.nextLine();

    while (!input.equals("EXIT")) {

      if (ConsoleView.isShowStartScreen()) {
       this.runStart(input);
      }
      input = scanner.nextLine();
    }
  }

  private void runStart(String input) {
    if (input.equals("1")) {
      ConsoleView.listAvailableHeroes(this.model.getAllHeroes());
    } else if (input.equals("2")) {
      System.out.println("You selected 2");
    } else {
      ConsoleView.showInputNotRecognized(input);
    }
  }
}
