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
  private boolean showStartGameScreen;
  private boolean heroCreated;

  public Controller(Model model) {

    this.model = model;
    List<String> userCreateHeroInput = new ArrayList<>();
    String input = "";

    Scanner scanner = new Scanner(System.in);

    showStartScreen = false;
    showSelectHeroScreen = false;
    showSelectedHeroScreen = false;
    showChooseHeroNameScreen = false;
    showChooseHeroClassTypeScreen = false;
    heroCreated = false;

    try {
      this.model.modelInit();
      showStartScreen = true;
      ConsoleView.showStartScreen();
    }
    catch (Exception e) {
      ConsoleView.showMessage("There was an error setting up the hero data base.");
      ConsoleView.showMessage("The game cannot function correctly without this.");
      ConsoleView.showException(e.getMessage());
      ConsoleView.showMessage("Exiting game.");
      input = "EXIT";
    }

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
      else if (showStartGameScreen) {
        ConsoleView.showMessage("And so your quest begins! Hit ENTER to start.");
        input = scanner.nextLine();
        if (input.equals("EXIT")) {
          break;
        }
        GamePlayController.startGame(this.model, scanner);
        input = "EXIT";
      }
    }
    ConsoleView.showMessage("Exiting repl...");
    scanner.close();
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
    if (this.checkSelectedHeroIndex(input)) {
      try {
        this.model.selectHero(input);
        if (this.model.getHero() != null) {
          showSelectHeroScreen = false;
          showStartGameScreen = true;
        }
        else {
          ConsoleView.showMessage("There was an error selecting your hero, please try again");
        }
      }
      catch (Exception e) {
        ConsoleView.showMessage("There was an error selecting your hero from the database.");
        ConsoleView.showException(e.getMessage());
      }
    } else {
      ConsoleView.showInputNotRecognized(input);
    }
  }

  private void runChooseHeroNameScreen(String input, List<String> userInput) {
    userInput.add(input);
    int returnSize;
    try {
      returnSize = this.model.getStoredHeroByName(userInput.get(0)).size();
      if (returnSize == 0) {
        showChooseHeroNameScreen = false;
        showChooseHeroClassTypeScreen = true;
      }
      else {
        userInput.clear();
        ConsoleView.showMessage("Sorry, this hero name is already taken.");
      }
    } catch (Exception e) {
      userInput.clear();
      ConsoleView.showMessage("There was an error creating your hero.");
      ConsoleView.showException(e.getMessage());
    }
  }

  private void runChooseHeroClass(String input, List<String> userInput) {
    int selectedHeroClass;
    if (checkSelectedHeroClassIndex(input)) {
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

      try {
        this.model.createNewHero(userInput.get(0), userInput.get(1));
        if (this.model.getHero() != null) {
          this.model.storeNewHero();
          showChooseHeroClassTypeScreen = false;
          showStartGameScreen = true;
        }
        else {
          ConsoleView.showMessage("There was a error creating your new hero.");
          showChooseHeroNameScreen = true;
          showChooseHeroClassTypeScreen = false;
        }
        userInput.clear();
      }
      catch (Exception e) {
        ConsoleView.showMessage("There was an error creating your hero");
        ConsoleView.showException(e.getMessage());
        userInput.clear();
        showChooseHeroNameScreen = true;
        showChooseHeroClassTypeScreen = false;
      }
    }
    else {
      ConsoleView.showInputNotRecognized(input);
    }
  }

  private boolean checkSelectedHeroIndex(String index) {
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

  private boolean checkSelectedHeroClassIndex(String index) {
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
