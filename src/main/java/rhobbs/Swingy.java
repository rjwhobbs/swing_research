package rhobbs;

import rhobbs.controller.console.Controller;
import rhobbs.model.Model;

import rhobbs.controller.gui.GUIController;
import rhobbs.model.Model;
import rhobbs.view.gui.RootView;

public class Swingy {

   public static void main(String[] args) {

      String validInput = "Unrecognised argument."
              +"\nPlease choose only \"console\" or \"gui\".";

      if (args.length != 1) {
         System.out.println(validInput);
      }
      else if (args[0].equals("console") || args[0].equals("gui")) {
         if (args[0].equals("console")) {
            Controller controller = new Controller(new Model());
         }
         else if (args[0].equals("gui")) {
            RootView rootView = new RootView();
            GUIController guiController = new GUIController(rootView, new Model());
         }
      }
      else {
         System.out.println(validInput);
      }
   }
}
