package rhobbs.view.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
public class SelectScreenCombo extends JPanel implements ActionListener {
  JLabel picture;
  private List<List<String>> heroList;

  public SelectScreenCombo(List<List<String>> heroList) {
    super(new BorderLayout());
    this.heroList = heroList;
    String[] heroNames = new String[this.heroList.size()];

    for (int i = 0; i < this.heroList.size(); i++) {
      heroNames[i] = this.heroList.get(i).get(1);
    }

//    String[] petStrings = {"Bird", "Cat", "Dog", "Rabbit", "Pig"};

    JComboBox selectHeroList = new JComboBox(heroNames);
    selectHeroList.setSelectedIndex(0);
    selectHeroList.addActionListener(this);

    picture = new JLabel();
    picture.setFont(picture.getFont().deriveFont(Font.ITALIC));
    picture.setHorizontalAlignment(JLabel.CENTER);
    updateLabel("" + selectHeroList.getSelectedIndex());
    picture.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

    picture.setPreferredSize(new Dimension(177, 122 + 10));

    add(selectHeroList, BorderLayout.PAGE_START);
    add(picture, BorderLayout.PAGE_END);
    setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
  }

  public void actionPerformed(ActionEvent e) {
    JComboBox cb = (JComboBox) e.getSource();
    String petName = (String) cb.getSelectedItem();
    updateLabel("" + cb.getSelectedIndex());
  }

  protected void updateLabel(String name) {
      picture.setText(name);
  }
}
