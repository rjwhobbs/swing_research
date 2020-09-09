package rhobbs;

//import rhobbs.controller.Controller;
//import rhobbs.model.Model;

import rhobbs.controller.console.Controller;
import rhobbs.model.Model;
import rhobbs.view.gui.GUIView;

public class Swingy {

   Model model;

   public static void main(String[] args) {
//      new SwingyTests(0);
//      Controller controller = new Controller(new Model());
      GUIView guiView = new GUIView();
      guiView.setVisible(true);
   }
}
