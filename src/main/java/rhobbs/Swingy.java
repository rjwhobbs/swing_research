package rhobbs;

//import rhobbs.controller.Controller;
//import rhobbs.model.Model;

import rhobbs.controller.Controller;
import rhobbs.model.Model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.*;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class Swingy {

   Model model;

   public static void main( String[] args ) {
      new SwingyTests(0);
      Controller controller = new Controller(new Model());
//      TestCar tc = new TestCar();
//      Connect.connect();
   }
}
