package rhobbs.model.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class dataUtil {

  public static List<String> getAllHeroes() throws Exception {
    List<String> result = new ArrayList<>();
    try {
      File file = new File("heroes.txt");
      Scanner scanner = new Scanner(file);
      result.add(scanner.nextLine().split(",")[0]);
      while (scanner.hasNextLine()) {
        result.add(scanner.nextLine().split(",")[0]);
      }
      scanner.close();
    } catch (IOException e) {
      throw new Exception("Error reading file");
    }
    return result;
  }

  public static String[] getSelectedHero(String heroName) throws Exception {
    String[] result = {""};
    try {
      File file = new File("heroes.txt");
      Scanner scanner = new Scanner(file);
      result = scanner.nextLine().split(",");
      while (scanner.hasNextLine()) {
        if (result[0].equals(heroName)) {
          return result;
        }
        result = scanner.nextLine().split(",");
      }
      scanner.close();
    } catch (IOException e) {
      throw new Exception("Error reading file");
    }
    return result;
  }
}
