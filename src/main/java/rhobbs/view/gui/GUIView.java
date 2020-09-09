package rhobbs.view.gui;

import rhobbs.controller.gui.ControlCommands;
import rhobbs.controller.gui.GUIController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GUIView extends javax.swing.JFrame implements WindowManager{

  private javax.swing.JButton startSelectScreen;
  JPanel mainPanel;
  private static SelectScreen selectScreen;
  private static SelectScreenCombo selectScreenCombo;

  public GUIView() {
    initComponents();
  }

  private void initComponents() {

    mainPanel = new JPanel();
    startSelectScreen = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    this.setSize(400, 400);

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
    this.add(mainPanel);
    setLocationRelativeTo(null);
    setVisible(true);
  }

  public void showSelectScreen(List<List<String>> heroList) {
//    String[] petStrings = {"Bird", "Cat", "Dog", "Rabbit", "Pig"};
    selectScreenCombo = new SelectScreenCombo(heroList);
    setContentPane(selectScreenCombo);
    pack();
  }

  public void showStats(String stats) {
    selectScreen.setSelectStats(stats);
  }

}

