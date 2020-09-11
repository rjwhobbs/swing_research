package rhobbs.view.gui;

import rhobbs.controller.gui.ControlCommands;
import rhobbs.controller.gui.GUIController;
import rhobbs.model.Hero;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class RootView extends javax.swing.JFrame implements WindowManager {

  private javax.swing.JButton startSelectScreen;
  private JLabel errorOnStart;
  JPanel mainPanel;
  private static StartScreen startScreen;
  private static SelectScreen selectScreen;
  private static SelectScreenCombo selectScreenCombo;
  private static CreateScreen createScreen;
  private static GameView gameView;

  public RootView() {
    initComponents();
  }

  private void initComponents() {

    mainPanel = new JPanel();
    errorOnStart = new JLabel();
    startSelectScreen = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    this.setSize(600, 400);

    startSelectScreen.setText("Lets Go!");

    startSelectScreen.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        GUIController.handler(ControlCommands.showStartScreen);
      }
    });

    mainPanel.add(startSelectScreen);
    mainPanel.add(errorOnStart);
    this.add(mainPanel);
//    setLocation(200, 200);
    setResizable(false);
    setLocationRelativeTo(null);
    setVisible(true);
  }

  public void showStartScreen() {
    startScreen = new StartScreen();
    setContentPane(startScreen);
    pack();
  }

  public void showSelectScreen(List<List<String>> heroList) {
    selectScreenCombo = new SelectScreenCombo(heroList);
    setContentPane(selectScreenCombo);
    pack();
  }

  public void showCreateScreen(){
    createScreen = new CreateScreen();
    setContentPane(createScreen);
    pack();
  }

  public void showCreateScreenError(String error) {
    String errorReason = "There was an error creating your hero.\n"
            + error
            + "Please try again";
    createScreen.setCreateScreenError("<html>" + errorReason.replaceAll("<","&lt;")
            .replaceAll(">", "&gt;")
            .replaceAll("\n", "<br/>")
            + "</html>");
  }

  public void showSelectScreenError(String error) {
    String errorReason = "There was an error selecting your hero\n"
                        + error
                        + "\nPlease try again";
    selectScreenCombo.setSelectHeroError(
            "<html>" + errorReason.replaceAll("<","&lt;")
            .replaceAll(">", "&gt;")
            .replaceAll("\n", "<br/>")
            + "</html>"
    );
  }

  public void showSelectScreenStats(String stats) {
    selectScreen.setSelectStats(stats);
  }

  public void showGameView(Hero hero) {
    gameView = new GameView(hero);
    setContentPane(gameView);
    pack();
  }

  public void upDateGameViewHeroStats(Hero hero) {
    gameView.setHeroStatsLabel(hero);
  };

  public void showGameInfo(String info) {
    gameView.setGameInfoLabel("<html>" + info.replaceAll("<","&lt;")
            .replaceAll(">", "&gt;")
            .replaceAll("\n", "<br/>")
            + "</html>");
  };

  public void showGameViewError(String error) {
    gameView.setGameViewErrorLabel( "<html>" + error.replaceAll("<","&lt;")
            .replaceAll(">", "&gt;")
            .replaceAll("\n", "<br/>")
            + "</html>");
  };

  public void showErrorOnStart(String error) {
    errorOnStart.setText(
            "<html>" + error.replaceAll("<","&lt;")
                    .replaceAll(">", "&gt;")
                    .replaceAll("\n", "<br/>")
                    + "</html>"
    );
  }

  public void disableStartSelectScreen() {
    startSelectScreen.setEnabled(false);
  }

  public void showCurrentCoords(int[] currentCoords){
    String coords = "(" + (currentCoords[0] + 1)
            + "," + (currentCoords[1] + 1) + ")";
    gameView.setCurrentCoordsLabel(coords);
  };

  public void setMovementEnabled(boolean b) {
    gameView.setMovementButtonsEnabled(b);
  };

  public void setFightRunEnabled(boolean b) {
    gameView.setFightRunButtonsEnabled(b);
  };

  public void setAttackEnabled(boolean b) {
    gameView.setAttackButtonEnabled(b);
  };

  public void setPickUpLeaveEnabled(boolean b) {
    gameView.setPickUpLeaveButtonsEnabled(b);
  };
}

