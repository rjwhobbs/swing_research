package rhobbs.model;

import rhobbs.model.storage.Storage;
//import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model {

  private Hero hero = null;
  private Hero tempHero = null;
  private List<List<String>> storedHeroes;
  private Random random;
  private int[] coords = {0,0};
  int[][] map;

  private String errorException = "";

  public Model() {}

  public void modelInit() throws Exception {
    try {
      Storage.storageInit();
      this.storedHeroes = Storage.selectAllHeroes();
    }
    catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  public void storeNewHero() throws Exception {
    try {
      Storage.insertHero(
              this.hero.getName(),
              this.hero.getClassType(),
              this.hero.getWeapon().getType(),
              this.hero.getArmor().getType(),
              this.hero.getHelm().getHelmType(),
              this.hero.getLevel(),
              this.hero.getExperience()
      );
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  public List<List<String>> getStoredHeroes() {
    return this.storedHeroes;
  }

  public void selectHero(String index) throws Exception {
    try {
      List<String> selectedHero = Storage.selectHeroById(index);
      if (selectedHero.size() == 7) {
        this.tempHero = HeroFactory.buildHero(
                selectedHero.get(0),
                selectedHero.get(1),
                selectedHero.get(2),
                selectedHero.get(3),
                selectedHero.get(4),
                Integer.parseInt(selectedHero.get(5)),
                Integer.parseInt(selectedHero.get(6))
        );
      }
      this.tempHero.validateHero();
      this.tempHero.equipArmor();
      this.tempHero.equipWeapon();
      this.tempHero.equipHelm();
      this.hero = this.tempHero;
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }
  }

  public void createNewHero(String name, String classType) throws Exception {
    this.tempHero = HeroFactory.buildHero(name, classType);
    if (this.tempHero != null) {
      try {
        this.tempHero.validateHero();
        this.tempHero.equipArmor();
        this.tempHero.equipWeapon();
        this.tempHero.equipHelm();
        this.hero = this.tempHero;
      }
      catch (Exception e) {
        throw new Exception(e.getMessage());
      }
    }
  }

  public List<String> getStoredHeroByName(String name) throws Exception {
    List<String> temp = new ArrayList<>();
    try {
      temp = Storage.selectHeroByName(name);
    }
    catch (Exception e) {
      throw new Exception(e.getMessage());
    }
    return temp;
  }

  public Hero getHero() {
    return this.hero;
  }

  public void generateMap() {
    random = new Random();
    int mapSize = (this.hero.getLevel() - 1) * 5 + 10 - (this.getHero().getLevel() % 2);
    int centerX = mapSize / 2;
    int ib = 1;
    map = new int[mapSize][mapSize];
    int maxEnemyLevel = this.hero.getLevel() + 2;
    int[] enemyArray = new int[maxEnemyLevel];
    this.setCoords(centerX, centerX);

    for (int e = 0; e < maxEnemyLevel; e++ ) {
      enemyArray[e] = e + 1;
    }

    for (int i = 0; i < mapSize; i++) {
      for (int j = 0; j < mapSize; j++) {
        if ((i == 0 || j == 0) || (i == mapSize - 1 || j == mapSize - 1)) {
          map[i][j] = -1;
        }
        else if (i != centerX || j != centerX) {
          if (random.nextInt(3) != 0) {
            map[i][j] = enemyArray[random.nextInt(maxEnemyLevel)];
          }
          else {
            map[i][j] = 0;
          }
        }
        else {
          map[i][j] = 0;
        }
      }
    }

    for (int i = 0; i < mapSize; i++) {
      for (int j = 0; j < mapSize; j++) {
        System.out.print(map[i][j] + " ");
//        try {
//          Thread.sleep(500);
//        }
//        catch (Exception e) {
//
//        }

      }
      System.out.println();
    }

  }

  public void clearErrorException() {
    this.errorException = "";
  }

  public int[] getCoords() {
    return this.coords;
  }

  public void setCoords(int x, int y) {
    this.coords[0] = x;
    this.coords[1] = y;
  }

  public void moveNorth() {
    this.coords[0] -= 1;
//    System.out.println("mc " + this.map[this.coords[0]][this.coords[1]]);
  }

  public void moveEast() {
    this.coords[1] += 1;
//    System.out.println("mc " + this.map[this.coords[0]][this.coords[1]]);
  }

  public void moveWest() {
    this.coords[1] -= 1;
//    System.out.println("mc " + this.map[this.coords[0]][this.coords[1]]);
  }

  public void moveSouth() {
    this.coords[0] += 1;
//    System.out.println("mc " + this.map[this.coords[0]][this.coords[1]]);
  }

  public boolean isAtEndOfMap() {
    if (this.map[this.coords[0]][this.coords[1]] == -1) {
      return true;
    }
    return false;
  }
}
