package rhobbs.view.gui;

import rhobbs.controller.gui.ControlCommands;
import rhobbs.controller.gui.GUIController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIView extends javax.swing.JFrame implements WindowManager{

  private javax.swing.JButton startSelectScreen;

  public GUIView() {
    initComponents();
  }

  private void initComponents() {

    startSelectScreen = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    startSelectScreen.setText("Lets Go!");

    startSelectScreen.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        GUIController.handler(ControlCommands.showSelect);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGap(179, 179, 179)
                            .addComponent(startSelectScreen)
                            .addContainerGap(183, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGap(113, 113, 113)
                            .addComponent(startSelectScreen)
                            .addContainerGap(122, Short.MAX_VALUE))
    );

    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }

  public void showSelectScreen() {
    SelectScreen selectScreen = new SelectScreen(this);
    setContentPane(selectScreen);
    pack();
  }

}

