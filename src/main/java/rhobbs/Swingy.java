package rhobbs;

import rhobbs.controller.console.Controller;
import rhobbs.model.Model;

import rhobbs.controller.gui.GUIController;
import rhobbs.model.Model;
import rhobbs.view.gui.RootView;

public class Swingy {

   Model model;

   public static void main(String[] args) {
//      new SwingyTests(0);
//      Controller controller = new Controller(new Model());
      RootView rootView = new RootView();
      GUIController guiController = new GUIController(rootView, new Model());
//      guiView.setVisible(true);
   }
}
