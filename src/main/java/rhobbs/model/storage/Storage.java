package rhobbs.model.storage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Storage {

  public static Connection getConnection() throws Exception {
    String url = "jdbc:sqlite:swingyDB.db";
    String sql;
    sql = "CREATE TABLE IF NOT EXISTS heroes ("
            + " id integer PRIMARY KEY,"
            + " name varchar(20) NOT NULL UNIQUE,"
            + " classType varchar(50) NOT NULL,"
            + " weapon varchar(50) NOT NULL,"
            + " armor varchar(50) NOT NULL,"
            + " level integer NOT NULL,"
            + " xp integer NOT NULL);";

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

  public static void insertHero(
          String name,
          String classType,
          String weapon,
          String armor,
          int level,
          int xp
  ) throws Exception {
    String sql;
    sql = "INSERT INTO heroes ("
            + " name, classType, weapon, armor, level, xp)"
            + " VALUES(?, ?, ?, ?, ?, ?)";

    try {
      Connection conn = Storage.getConnection();
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, name);
      pstmt.setString(2, classType);
      pstmt.setString(3, weapon);
      pstmt.setString(4, armor);
      pstmt.setInt(5, level);
      pstmt.setInt(6, xp);
      pstmt.executeUpdate();
    } catch (SQLException e) {
      throw new Exception(e.getMessage());
    }
  }

  public static List<String> selectHero(String name) throws Exception{
    List<String> selectedHero = new ArrayList<>();
    String sql;
    sql = "SELECT * FROM heroes WHERE name = ?";

    try {
      Connection conn = Storage.getConnection();
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, name);
      ResultSet res = pstmt.executeQuery();
      if (res.next()) {
        selectedHero.add(res.getString("name"));
        selectedHero.add(res.getString("classType"));
        selectedHero.add(res.getString("weapon"));
        selectedHero.add(res.getString("armor"));
        selectedHero.add(res.getString("level"));
        selectedHero.add(res.getString("xp"));
      }
      return selectedHero;
    } catch (SQLException e) {
      throw new Exception(e.getMessage());
    }
  }

}
