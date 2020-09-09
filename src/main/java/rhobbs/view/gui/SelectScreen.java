package rhobbs.view.gui;

import rhobbs.controller.gui.ControlCommands;
import rhobbs.controller.gui.GUIController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectScreen extends javax.swing.JPanel {

  private WindowManager windowManager;
  private javax.swing.JButton jButton1;
  private javax.swing.JLabel jLabel2;

  SelectScreen(WindowManager windowManager) {
    this.windowManager = windowManager;
    initComponents();
  }

  private void initComponents() {

    jButton1 = new JButton();
    jLabel2 = new JLabel();

//    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//    this.setPreferredSize();

    jButton1.setText("Show stats");
//    jLabel2.setText("Words");

    jButton1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        GUIController.handler(ControlCommands.showStats);
      }
    });

    GroupLayout jPanel1Layout = new GroupLayout(this);
    this.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(147, 147, 147)
                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jButton1))
                            .addContainerGap(167, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(125, 125, 125)
                            .addComponent(jButton1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel2)
                            .addContainerGap(131, Short.MAX_VALUE))
    );
  }

  void setSelectStats(String stats) {
    this.jLabel2.setText(stats);
  }
}
