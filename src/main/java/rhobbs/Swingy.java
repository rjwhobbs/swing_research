package rhobbs;

//import rhobbs.controller.Controller;
//import rhobbs.model.Model;

import rhobbs.controller.Controller;
import rhobbs.model.Model;

public class Swingy {

   Model model;

   public static void main( String[] args ) {
//      new SwingyTests(0);
      Controller controller = new Controller(new Model());
   }
}
