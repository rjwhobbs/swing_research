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
  private static SelectScreen selectScreen;
  private static SelectScreenCombo selectScreenCombo;
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
        GUIController.handler(ControlCommands.showSelect);
      }
    });

//    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//    getContentPane().setLayout(layout);
//    layout.setHorizontalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                    .addGroup(layout.createSequentialGroup()
//                            .addGap(179, 179, 179)
//                            .addComponent(startSelectScreen)
//                            .addContainerGap(183, Short.MAX_VALUE))
//    );
//    layout.setVerticalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                    .addGroup(layout.createSequentialGroup()
//                            .addGap(113, 113, 113)
//                            .addComponent(startSelectScreen)
//                            .addContainerGap(122, Short.MAX_VALUE))
//    );
//
//    pack();
    mainPanel.add(startSelectScreen);
    mainPanel.add(errorOnStart);
    this.add(mainPanel);
    setLocation(200, 200);
    setVisible(true);
  }

  public void showSelectScreen(List<List<String>> heroList) {
    selectScreenCombo = new SelectScreenCombo(heroList);
    setContentPane(selectScreenCombo);
    pack();
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

}

