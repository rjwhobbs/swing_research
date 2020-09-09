package rhobbs.view.gui;

import rhobbs.controller.gui.ControlCommands;
import rhobbs.controller.gui.GUIController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SelectScreenCombo extends JPanel implements ActionListener {
  JLabel heroStats;
  JButton selectHero;
  int heroId;
  private List<List<String>> heroList;

  public SelectScreenCombo(List<List<String>> heroList) {
    super(new BorderLayout());

    this.heroList = heroList;
    String[] heroTitle = new String[this.heroList.size()];
    StringBuilder heroString = new StringBuilder();

    for (int i = 0; i < this.heroList.size(); i++) {
      heroString.append(this.heroList.get(i).get(1));
      heroString.append(" " + this.heroList.get(i).get(2));
      heroTitle[i] = heroString.toString();
      heroString.delete(0, heroString.length());
    }

    JComboBox selectHeroList = new JComboBox(heroTitle);
    selectHeroList.setSelectedIndex(0);
    heroId = selectHeroList.getSelectedIndex() + 1;
    selectHeroList.addActionListener(this);


    selectHero = new JButton();
    selectHero.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        GUIController.handler(ControlCommands.selectHeroById, heroId + "");
      }
    });
    heroStats = new JLabel();
//    heroStats.setFont(heroStats.getFont().deriveFont(Font.ITALIC));
    selectHero.setText("Select hero");


    heroStats.setHorizontalAlignment(JLabel.CENTER);
    updateLabel("" + selectHeroList.getSelectedIndex());
    heroStats.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

    heroStats.setPreferredSize(new Dimension(177, 122 + 10));

    add(selectHeroList, BorderLayout.PAGE_START);
    add(heroStats, BorderLayout.CENTER);
    add(selectHero, BorderLayout.PAGE_END);
    setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
  }

  public void actionPerformed(ActionEvent e) {
    JComboBox cb = (JComboBox) e.getSource();
    heroId = cb.getSelectedIndex() + 1;
    updateLabel("" + cb.getSelectedIndex());
  }

  protected void updateLabel(String name) {
      heroStats.setText(name);
  }
}
