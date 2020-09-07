package rhobbs.model.storage;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Storage {

  public static void storageInit() throws Exception {
    try {
      if (selectHeroByName("Steve").size() == 0) {
        insertHero(
                "Steve",
                "Guitar Hero",
                "Flying V",
                "none",
                "Hard Rock Cafe Cap",
                2,
                2450
        );
      }
      if (selectHeroByName("Brenda").size() == 0) {
        insertHero(
                "Brenda",
                "Bass Guitar Hero",
                "Mexican PBass",
                "Hartke Amp",
                "Black Vans Hoodie",
                3,
                4800
        );
      }
      if (selectHeroByName("Sarel").size() == 0) {
        insertHero(
                "Sarel",
                "Drum Hero",
                "Yamaha Drum Kit",
                "none",
                "Toy Machine Beanie",
                1,
                1000
        );
      }
    }
    catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  public static Connection getConnection() throws Exception {
    String url = "jdbc:sqlite:swingyDB.db";
    String sql;
    sql = "CREATE TABLE IF NOT EXISTS heroes ("
            + " id integer PRIMARY KEY,"
            + " name TEXT NOT NULL UNIQUE "
            + " CHECK(typeof(\"name\") = \"text\" AND "
            + " length(\"name\") <= 20), "
            + " classType TEXT NOT NULL "
            + " CHECK(typeof(\"classType\") = \"text\" AND "
            + " length(\"classType\") <= 50),"
            + " weapon TEXT NOT NULL "
            + " CHECK(typeof(\"weapon\") = \"text\" AND "
            + " length(\"weapon\") <= 50),"
            + " armor varchar(50) NOT NULL "
            + " CHECK(typeof(\"armor\") = \"text\" AND "
            + " length(\"armor\") <= 50),"
            + " helm varchar(50) NOT NULL "
            + " CHECK(typeof(\"helm\") = \"text\" AND "
            + " length(\"helm\") <= 50),"
            + " level integer NOT NULL,"
            + " xp integer NOT NULL);";

    try {
      Connection conn = DriverManager.getConnection(url);
      Statement stmt = conn.createStatement();
      stmt.execute(sql);
      return conn;
    } catch (SQLException e) {
      throw new Exception(e.getMessage());
    }
  }

  public static List<List<String>> selectAllHeroes() throws Exception {
    List<List<String>> result = new ArrayList<>();
    String sql;
    sql = "SELECT * FROM heroes";

    try {
      Connection conn = Storage.getConnection();
      Statement stmt = conn.createStatement();
      ResultSet res = stmt.executeQuery(sql);

      while (res.next()) {
        List<String> temp = new ArrayList<>();
        temp.add(res.getString(1));
        temp.add(res.getString(2));
        temp.add(res.getString(3));
        temp.add(res.getString(4));
        temp.add(res.getString(5));
        temp.add(res.getString(6));
        temp.add(res.getString(7));
        temp.add(res.getString(8));
        result.add(temp);
      }
      conn.close();
      return result;
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  public static void insertHero(
          String name,
          String classType,
          String weapon,
          String armor,
          String helm,
          int level,
          int xp
  ) throws Exception {
    String sql;
    sql = "INSERT INTO heroes"
            + " (name, classType, weapon, armor, helm, level, xp)"
            + " VALUES(?, ?, ?, ?, ?, ?, ?)";

    try {
      Connection conn = Storage.getConnection();
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, name);
      pstmt.setString(2, classType);
      pstmt.setString(3, weapon);
      pstmt.setString(4, armor);
      pstmt.setString(5, helm);
      pstmt.setInt(6, level);
      pstmt.setInt(7, xp);
      pstmt.executeUpdate();
      conn.close();
    } catch (SQLException e) {
//      System.out.println(e.getMessage());
      throw new Exception(e.getMessage());
    }
  }

  private static void updateHero(String col, String val, String name) throws Exception{
    String sql = "UPDATE heroes SET " + col + " = ? WHERE name = ?";
    try {
      Connection conn = Storage.getConnection();
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, val);
      pstmt.setString(2, name);
      pstmt.executeUpdate();
      conn.close();
    }
    catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  private static void updateHero(String col, int val, String name) throws Exception{
    String sql = "UPDATE heroes SET " + col + " = ? WHERE name = ?";
    try {
      Connection conn = Storage.getConnection();
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, val);
      pstmt.setString(2, name);
      pstmt.executeUpdate();
      conn.close();
    }
    catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  public static void saveArmor(String name, String armor) throws Exception {
    try {
      updateHero("armor", armor, name);
    }
    catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  public static void saveWeapon(String name, String weapon) throws Exception {
    try {
      updateHero("weapon", weapon, name);
    }
    catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  public static void saveHelm(String name, String helm) throws Exception {
    try {
      updateHero("helm", helm, name);
    }
    catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  public static void updateLevel(String name, int level) throws Exception {
    try {
      updateHero("level", level, name);
    }
    catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  public static void updateXP(String name, int xp) throws Exception {
    try {
      updateHero("xp", xp, name);
    }
    catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  public static List<String> selectHeroByName(String name) throws Exception {
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
        selectedHero.add(res.getString("helm"));
        selectedHero.add(res.getString("level"));
        selectedHero.add(res.getString("xp"));
      }
      conn.close();
      return selectedHero;
    } catch (SQLException e) {
      throw new Exception(e.getMessage());
    }
  }

  public static List<String> selectHeroById(String id) throws Exception {
    List<String> selectedHero = new ArrayList<>();
    String sql;
    sql = "SELECT * FROM heroes WHERE id = ?";

    try {
      Connection conn = Storage.getConnection();
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, id);
      ResultSet res = pstmt.executeQuery();
      if (res.next()) {
        selectedHero.add(res.getString("name"));
        selectedHero.add(res.getString("classType"));
        selectedHero.add(res.getString("weapon"));
        selectedHero.add(res.getString("armor"));
        selectedHero.add(res.getString("helm"));
        selectedHero.add(res.getString("level"));
        selectedHero.add(res.getString("xp"));
      }
      conn.close();
      return selectedHero;
    } catch (SQLException e) {
      throw new Exception(e.getMessage());
    }
  }
}
