package rhobbs.view.gui;

import rhobbs.model.Hero;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {

  JLabel heroInfo;

  GameView(Hero hero) {
    super(new BorderLayout());

    heroInfo = new JLabel();
    heroInfo.setText(hero.getName());
    heroInfo.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
    heroInfo.setPreferredSize(new Dimension(200, 200));

    add(heroInfo, BorderLayout.PAGE_START);
    setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
  }
}
