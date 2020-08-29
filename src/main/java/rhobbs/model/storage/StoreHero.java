package rhobbs.model.storage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StoreHero {

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
      Connection conn = Connect.getConnection();
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

}
