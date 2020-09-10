package rhobbs.view.gui;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateScreen extends JPanel {

  private JLabel titlelabel;
  private JLabel menuLabel;
  private JLabel userTextLabel;
  private JLabel errorLabel;
  private JComboBox heroClassesMenu;
  private JButton createHeroButton;
  private JTextField userTextInputField;
  private JPanel subPanelCenter;
  private JPanel subPanelOne;
  private JPanel subPanelTwo;
  private String userInput = "";

  CreateScreen() {
    super(new BorderLayout());

    String[] heroClasses = {"Guitar Hero", "Bass Guitar Hero", "Drum Hero"};

    titlelabel = new JLabel("Create a new hero.");
    titlelabel.setPreferredSize(new Dimension(600, 100));
    titlelabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10));
    titlelabel.setHorizontalAlignment(JLabel.CENTER);
    titlelabel.setVerticalAlignment(JLabel.CENTER);

    menuLabel = new JLabel("Choose your hero class:");
//    menuLabel.setPreferredSize(new Dimension(200,20));
    userTextLabel = new JLabel("Enter your hero's name:");
    errorLabel = new JLabel();
    errorLabel.setPreferredSize(new Dimension(500, 50));
    errorLabel.setAutoscrolls(true);

    userTextInputField = new JTextField(14);
    heroClassesMenu = new JComboBox(heroClasses);

    createHeroButton = new JButton("Create Hero");
    createHeroButton.setAlignmentX(Component.CENTER_ALIGNMENT);

    subPanelOne = new JPanel();
    subPanelTwo = new JPanel();

    subPanelOne.add(userTextLabel);
    subPanelOne.add(userTextInputField);
    subPanelTwo.add(menuLabel);
    subPanelTwo.add(heroClassesMenu);

    subPanelCenter = new JPanel();
    subPanelCenter.setLayout(new BoxLayout(subPanelCenter, BoxLayout.Y_AXIS));

    subPanelCenter.add(subPanelOne);
    subPanelCenter.add(subPanelTwo);
    subPanelCenter.add(createHeroButton);

    add(titlelabel, BorderLayout.PAGE_START);
    add(subPanelCenter, BorderLayout.CENTER);
    add(errorLabel, BorderLayout.PAGE_END);
    setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

    createHeroButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        errorLabel.setText(userInput);
      }
    });

    userTextInputField.getDocument().addDocumentListener(new DocumentListener() {
      @Override
      public void insertUpdate(DocumentEvent e) {
        userInput = userTextInputField.getText();
      }

      @Override
      public void removeUpdate(DocumentEvent e) {
        userInput = userTextInputField.getText();
      }

      @Override
      public void changedUpdate(DocumentEvent e) {
        userInput = userTextInputField.getText();
      }
    });
  }
}
