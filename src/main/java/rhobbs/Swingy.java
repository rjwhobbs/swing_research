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

class Car {
   @NotNull(message = "Potato")
   public String manufacturer;

   Car(String manufacturer) {
      this.manufacturer = manufacturer;
   }

}

class TestCar {
   private static Validator validator;

   TestCar() {
      ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
      validator = factory.getValidator();

      Car car = new Car(null);

      Set<ConstraintViolation<Car>> cvs = validator.validate(car);

      for (ConstraintViolation<Car> cv : cvs) {
         System.out.println(cv.getPropertyPath() + ": " + cv.getMessage());
      }
   }
}

class Connect {
   /**
    * Connect to a sample database
    */
   public static void connect() {
      Connection conn = null;
      // SQLite connection string
      String url = "jdbc:sqlite:swingyDB.db";

      // SQL statement for creating a new table
      String sql = "CREATE TABLE IF NOT EXISTS employees ("
              + " id integer PRIMARY KEY,"
              + " name text NOT NULL,"
              + " capacity real"
              + ");";

      try{
         conn = DriverManager.getConnection(url);
         Statement stmt = conn.createStatement();
         stmt.execute(sql);
         System.out.println("here");
      } catch (SQLException e) {
         System.out.println(e.getMessage());
      }
      sql = "INSERT INTO employees(name, capacity) VALUES(?,?)";

      try{
//         Connection conn = this.connect();
         PreparedStatement pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, "Joe");
         pstmt.setDouble(2, 42.42);
         pstmt.executeUpdate();
         System.out.println("and here");
      } catch (SQLException e) {
         System.out.println(e.getMessage());
      }
   }
}

public class Swingy {

   Model model;

   public static void main( String[] args ) {
        Controller controller = new Controller(new Model());
//      TestCar tc = new TestCar();
//      Connect.connect();
   }
}
