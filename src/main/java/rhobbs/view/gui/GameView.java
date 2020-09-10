package rhobbs.view.gui;

import rhobbs.model.Hero;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameView extends JPanel {

  JLabel heroInfo;

  private javax.swing.JButton leaveItemButton;
  private javax.swing.JButton moveNorthButton;
  private javax.swing.JButton moveSouthButton;
  private javax.swing.JButton moveEastButton;
  private javax.swing.JButton moveWestButton;
  private javax.swing.JButton fightButton;
  private javax.swing.JButton runButton;
  private javax.swing.JButton attackButton;
  private javax.swing.JButton pickUpButton;
  private javax.swing.JLabel gameInfoLabel;
  private javax.swing.JLabel heroStatsLabel;
  private javax.swing.JLabel gameViewTitleLabel;
  private javax.swing.JLabel errorLabel;
  private javax.swing.JLabel currentCoordsLabel;

  GameView(Hero hero) {
    initComponents(hero);
  }

  private void initComponents(Hero hero) {

    gameInfoLabel = new JLabel();
    heroStatsLabel = new JLabel();
    moveNorthButton = new JButton();
    moveSouthButton = new JButton();
    moveEastButton = new JButton();
    moveWestButton = new JButton();
    fightButton = new JButton();
    runButton = new JButton();
    attackButton = new JButton();
    gameViewTitleLabel = new JLabel();
    errorLabel = new JLabel();
    currentCoordsLabel = new JLabel();
    pickUpButton = new JButton();
    leaveItemButton = new JButton();

    gameInfoLabel.setBackground(new Color(255, 255, 255));
    gameInfoLabel.setText("<html>You won!\n<br/> And hera are more words \n<br/>There are awalys more words \n<br/>oh your coords()\n</html>");
    gameInfoLabel.setAutoscrolls(true);
    gameInfoLabel.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

    heroStatsLabel.setBackground(new Color(255, 255, 255));
    setHeroStatsLabel(hero);
    heroStatsLabel.setBorder(new SoftBevelBorder(BevelBorder.RAISED));

    moveNorthButton.setText("N");
    moveNorthButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
//        jButton2ActionPerformed(evt);
      }
    });

    moveSouthButton.setText("S");
    moveEastButton.setText("E");
    moveWestButton.setText("W");
    fightButton.setText("Fight");
    runButton.setText("Run");
    attackButton.setText("Attack!");
    gameViewTitleLabel.setText("Title");
    errorLabel.setText("Oh nos, errors!");
    currentCoordsLabel.setText("(23,24)");
    currentCoordsLabel.setBorder(new SoftBevelBorder(BevelBorder.RAISED));
    pickUpButton.setText("Pickup item");
    pickUpButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
//        jButton9ActionPerformed(evt);
      }
    });

    leaveItemButton.setText("Leave item");

    GroupLayout jPanel2Layout = new GroupLayout(this);
    this.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(242, 242, 242)
                            .addComponent(gameViewTitleLabel)
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(heroStatsLabel, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(errorLabel, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(39, 39, 39)
                                            .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                    .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                                    .addGap(50, 50, 50)
                                                                    .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                            .addComponent(moveSouthButton)
                                                                            .addComponent(moveNorthButton)))
                                                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                                    .addComponent(moveWestButton)
                                                                    .addGap(27, 27, 27)
                                                                    .addComponent(moveEastButton)))
                                                    .addComponent(fightButton))
                                            .addGap(27, 27, 27)
                                            .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(runButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(currentCoordsLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(attackButton, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addComponent(pickUpButton)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(leaveItemButton)))
                                    .addComponent(gameInfoLabel, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
                            .addGap(22, 22, 22))
    );
    jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(gameViewTitleLabel)
                            .addGap(54, 54, 54)
                            .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(heroStatsLabel, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
                                            .addGap(35, 35, 35)
                                            .addComponent(moveNorthButton)
                                            .addGap(3, 3, 3)
                                            .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(moveEastButton)
                                                    .addComponent(moveWestButton)
                                                    .addComponent(currentCoordsLabel))
                                            .addGap(4, 4, 4)
                                            .addComponent(moveSouthButton))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(306, 306, 306)
                                            .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(fightButton)
                                                    .addComponent(runButton))
                                            .addGap(18, 18, 18)
                                            .addComponent(errorLabel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(gameInfoLabel, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
                                            .addGap(32, 32, 32)
                                            .addComponent(attackButton)
                                            .addGap(18, 18, 18)
                                            .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(pickUpButton)
                                                    .addComponent(leaveItemButton))))
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
  }

  public void setHeroStatsLabel(Hero hero) {
    String heroStatsString ="<html>" + hero.getName()
            + " lvl " + hero.getLevel()
            + " " + hero.getClassType()
            + "<br/>Axe: " + hero.getWeapon().getSubType() + " (" + hero.getAttack() + " attack)"
            + "<br/>Armor: " + hero.getArmor().getSubType() + " (" + hero.getDefense() + " defense)"
            + "<br/>Helm: " + hero.getHelm().getSubType() + " (" + hero.getHelm().getPoints() + " hp bonus)"
            + "<br/>HP: " + hero.getHitPoints()
            + "<br/>XP: " + hero.getExperience()
            + "<html>";
    heroStatsLabel.setText(heroStatsString);
  }
}
