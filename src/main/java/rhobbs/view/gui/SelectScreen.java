package rhobbs.view.gui;

import javax.swing.*;

public class SelectScreen extends javax.swing.JPanel {

  private WindowManager windowManager;
  private javax.swing.JLabel jLabel1;

  SelectScreen(WindowManager windowManager) {
    this.windowManager = windowManager;
    initComponents();
  }

  private void initComponents() {

    jLabel1 = new JLabel();

//    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jLabel1.setText("Select Screen");

    GroupLayout jPanel1Layout = new GroupLayout(this);
    this.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(165, 165, 165)
                            .addComponent(jLabel1)
                            .addContainerGap(149, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(123, 123, 123)
                            .addComponent(jLabel1)
                            .addContainerGap(139, Short.MAX_VALUE))
    );
  }
}
