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
  JLabel heroStatsLabel;
  JButton selectHeroButton;
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

    JComboBox selectHeroMenu = new JComboBox(heroTitles);
    selectHeroMenu.setSelectedIndex(0);
    heroId = selectHeroMenu.getSelectedIndex();
    selectHeroMenu.addActionListener(this);

    screenTitle = new JLabel();
    selectHeroButton = new JButton();
    heroStatsLabel = new JLabel();
    JPanel subPanelCenter = new JPanel();
    JPanel menuPanel = new JPanel();
    subPanelCenter.setLayout(new BoxLayout(subPanelCenter, BoxLayout.Y_AXIS));

    screenTitle.setText("Choose your hero!");
    screenTitle.setPreferredSize(new Dimension(600, 50));
    selectHeroButton.setText("Select hero");
    selectHeroButton.setAlignmentX(Component.CENTER_ALIGNMENT);

    screenTitle.setHorizontalAlignment(JLabel.CENTER);
    displayHeroStats(heroId);
//    heroStatsLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

    heroStatsLabel.setPreferredSize(new Dimension(100, 150));
    heroStatsLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
    menuPanel.add(selectHeroMenu);

    subPanelCenter.add(menuPanel);
    subPanelCenter.add(heroStatsLabel);
    subPanelCenter.add(selectHeroButton);

    add(screenTitle, BorderLayout.PAGE_START);
    add(subPanelCenter, BorderLayout.CENTER);
    setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

    selectHeroButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        GUIController.handler(ControlCommands.selectHeroById, heroIds[heroId]);
      }
    });
  }

  public void actionPerformed(ActionEvent e) {
    JComboBox cb = (JComboBox) e.getSource();
    heroId = cb.getSelectedIndex();
    displayHeroStats(heroId);
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

    heroStatsLabel.setText("<html>" + heroStatsString.replaceAll("<","&lt;")
              .replaceAll(">", "&gt;")
              .replaceAll("\n", "<br/>")
              + "</html>");
  }
}
