package rhobbs.model.storage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {

  public static Connection getConnection() throws Exception {
    String url = "jdbc:sqlite:swingyDB.db";
    String sql;
    sql = "CREATE TABLE IF NOT EXISTS heroes ("
            + " id integer PRIMARY KEY,"
            + " name varchar(20) NOT NULL,"
            + " classType varchar(50) NOT NULL,"
            + " weapon varchar(50) NOT NULL,"
            + " armor varchar(50) NOT NULL,"
            + " level integer NOT NULL,"
            + " xp integer NOT NULL );";

    try {
      Connection conn = DriverManager.getConnection(url);
      Statement stmt = conn.createStatement();
      stmt.execute(sql);
//      System.out.println("here");
      return conn;
    } catch (SQLException e) {
      throw new Exception(e.getMessage());
    }
  }

}
