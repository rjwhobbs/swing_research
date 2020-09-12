package rhobbs.view.gui;

import rhobbs.controller.gui.ControlCommands;
import rhobbs.controller.gui.GUIController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScreen extends JPanel {

  private JButton selectHeroButton;
  private JButton createHeroButton;
  private JLabel startScreenTitle;

  StartScreen() {
    super(new BorderLayout());

    startScreenTitle = new JLabel();
    selectHeroButton = new JButton();
    createHeroButton = new JButton();
    JPanel subPanelOne = new JPanel();
    JPanel subPanelTwo = new JPanel();

    startScreenTitle.setText("Select an old hero or ... create a new one?");
    startScreenTitle.setHorizontalAlignment(JLabel.CENTER);
    startScreenTitle.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
    startScreenTitle.setPreferredSize(new Dimension(600, 50));

//    selectHeroButton.setPreferredSize(new Dimension(200, 20));
//    createHeroButton.setPreferredSize(new Dimension(200, 20));

    selectHeroButton.setText("Select Hero");
    subPanelOne.add(selectHeroButton);
    createHeroButton.setText("Create Hero");
    subPanelTwo.add(createHeroButton);

    add(startScreenTitle, BorderLayout.PAGE_START);
    add(subPanelOne, BorderLayout.CENTER);
    add(subPanelTwo, BorderLayout.PAGE_END);
    setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

    selectHeroButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        GUIController.handler(ControlCommands.showSelect);
      }
    });

    createHeroButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        GUIController.handler(ControlCommands.showCreateScreen);
      }
    });
  }

}
