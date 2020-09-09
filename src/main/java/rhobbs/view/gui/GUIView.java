package rhobbs.view.gui;

public class GUIView extends javax.swing.JFrame {

  private javax.swing.JButton startSelectScreen;

  public GUIView() {
    initComponents();
  }

  private void initComponents() {

    startSelectScreen = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    startSelectScreen.setText("Lets Go!");

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
  }

}

