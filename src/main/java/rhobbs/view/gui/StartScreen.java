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

    startScreenTitle.setText("Select a hero or create a new one?");
    startScreenTitle.setHorizontalAlignment(JLabel.CENTER);
    startScreenTitle.setBorder(BorderFactory.createEmptyBorder(10, 10, 70, 10));
    startScreenTitle.setPreferredSize(new Dimension(600, 100));

    selectHeroButton.setPreferredSize(new Dimension(200, 20));
    createHeroButton.setPreferredSize(new Dimension(200, 20));

    selectHeroButton.setText("Select Hero");
    createHeroButton.setText("Create Hero");

    add(startScreenTitle, BorderLayout.PAGE_START);
    add(selectHeroButton, BorderLayout.LINE_START);
    add(createHeroButton, BorderLayout.LINE_END);
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
