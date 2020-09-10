package rhobbs.view.gui;

import rhobbs.controller.gui.ControlCommands;
import rhobbs.controller.gui.GUIController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SelectScreenCombo extends JPanel implements ActionListener {
  JLabel screenTitle;
  JLabel heroStats;
  JLabel selectHeroError;
  JButton selectHero;
  int heroId;
  private List<List<String>> heroList;

  public SelectScreenCombo(List<List<String>> heroList) {
    super(new BorderLayout());

    this.heroList = heroList;
    String[] heroTitles = new String[this.heroList.size()];
    final String[] heroIds = new String[this.heroList.size()];
    StringBuilder heroString = new StringBuilder();

    for (int i = 0; i < this.heroList.size(); i++) {
      heroString.append(this.heroList.get(i).get(1));
      heroString.append(" " + this.heroList.get(i).get(2));
      heroIds[i] = this.heroList.get(i).get(0);
      heroTitles[i] = heroString.toString();
      heroString.delete(0, heroString.length());
    }

    JComboBox selectHeroList = new JComboBox(heroTitles);
    selectHeroList.setSelectedIndex(0);
    heroId = selectHeroList.getSelectedIndex();
//    selectHeroList.
    selectHeroList.addActionListener(this);

    screenTitle = new JLabel();
    selectHeroError = new JLabel();
    selectHero = new JButton();
    heroStats = new JLabel();
    selectHero.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        GUIController.handler(ControlCommands.selectHeroById, heroIds[heroId]);
      }
    });

    screenTitle.setText("Choose your hero!");
    selectHero.setText("Select hero");

    heroStats.setHorizontalAlignment(JLabel.CENTER);
    screenTitle.setHorizontalAlignment(JLabel.CENTER);
    displayHeroStats(heroId);
    heroStats.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

    heroStats.setPreferredSize(new Dimension(330, 150));
    selectHeroError.setPreferredSize(new Dimension(180, 150));

    add(screenTitle, BorderLayout.PAGE_START);
    add(selectHeroList, BorderLayout.LINE_START);
    add(heroStats, BorderLayout.CENTER);
    add(selectHeroError, BorderLayout.LINE_END);
    add(selectHero, BorderLayout.PAGE_END);
    setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
  }

  public void actionPerformed(ActionEvent e) {
    selectHeroError.setText("");
    JComboBox cb = (JComboBox) e.getSource();
    heroId = cb.getSelectedIndex();
    displayHeroStats(heroId);
  }

  public void setSelectHeroError(String error) {
    selectHeroError.setText(error);
  }

  protected void displayHeroStats(int index) {
    int totalHP = Integer.parseInt(heroList.get(index).get(10))
            + Integer.parseInt(heroList.get(index).get(11));

    String heroStatsString =  heroList.get(index).get(1)
            + " Lvl " + heroList.get(index).get(6)
            + " " + heroList.get(index).get(2)
            + "\nAxe: " + heroList.get(index).get(3) + " (" + heroList.get(index).get(8) + " attack)"
            + "\nDefense: " + heroList.get(index).get(4) + " (" + heroList.get(index).get(9) + " defense)"
            + "\nHelm: " + heroList.get(index).get(5) + " (" + heroList.get(index).get(10) + " hp bonus)"
            + "\nXP: " + heroList.get(index).get(7)
            + "\nTotal HP: " + totalHP;

    heroStats.setText("<html>" + heroStatsString.replaceAll("<","&lt;")
              .replaceAll(">", "&gt;")
              .replaceAll("\n", "<br/>")
              + "</html>");
  }
}
