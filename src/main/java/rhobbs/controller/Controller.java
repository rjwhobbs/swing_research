package rhobbs.controller;

import rhobbs.model.Model;
import rhobbs.view.ConsoleView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {

  ConsoleView view;
  Model model;

//  private List<List<String>> storedHeroes;
  private boolean showStartScreen;
  private boolean showSelectHeroScreen;
  private boolean showSelectedHeroScreen;
  private boolean showChooseHeroNameScreen;
  private boolean showChooseHeroClassTypeScreen;
  private boolean heroCreated;

  public Controller(Model model) {

    this.model = model;
    List<String> userCreateHeroInput = new ArrayList<>();
    String input = "";

    Scanner scanner = new Scanner(System.in);

    showStartScreen = true;
    showSelectHeroScreen = false;
    showSelectedHeroScreen = false;
    showChooseHeroNameScreen = false;
    showChooseHeroClassTypeScreen = false;
    heroCreated = false;

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
      else if (showChooseHeroNameScreen) {
        ConsoleView.chooseHeroName();
        input = scanner.nextLine();
        if (input.equals("EXIT")) {
          break;
        }
//        userCreateHeroInput.add(input);
        this.runChooseHeroNameScreen(input, userCreateHeroInput);
      }
      else if (showChooseHeroClassTypeScreen) {
        ConsoleView.chooseHeroClass();
        input = scanner.nextLine();
        if (input.equals("EXIT")) {
          break;
        }
        this.runChooseHeroClass(input, userCreateHeroInput);
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
      showStartScreen = false;
      showChooseHeroNameScreen = true;
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

  private void runChooseHeroNameScreen(String input, List<String> userInput) {
    userInput.add(input);
    if (this.model.getStoredHeroByName(userInput.get(0)).size() == 0) {
      showChooseHeroNameScreen = false;
      showChooseHeroClassTypeScreen = true;
    }
    else {
      userInput.clear();
      ConsoleView.showMessage("Sorry, this hero name is already taken.");
    }
  }

  private void runChooseHeroClass(String input, List<String> userInput) {
    int selectedHeroClass;
    if (validateSelectedHeroClass(input)) {
      selectedHeroClass = Integer.parseInt(input);
      switch (selectedHeroClass) {
        case 1:
          userInput.add("Guitar Hero");
        case 2:
          userInput.add("Bass Guitar Hero");
        case 3:
          userInput.add("Drum Hero");
        default:
          userInput.add("");
      }

      if (this.model.getHero() != null) {
        this.model.storeNewHero();
        ConsoleView.showMessage("Your new hero!");
        ConsoleView.showHeroStats(this.model.getHero());
      }
      else {
        ConsoleView.showMessage("There was a error creating your new hero.");
      }

      showChooseHeroNameScreen = true;
      showChooseHeroClassTypeScreen = false;
      userInput.clear();
    }
    else {
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

  private boolean validateSelectedHeroClass(String index) {
    try {
      int input = Integer.parseInt(index);
      if (input <= 0 || input > 3 || index.indexOf(0) == '+' ) {
        return false;
      }
      return true;
    }
    catch (NumberFormatException e) {
      return false;
    }
  }
}
