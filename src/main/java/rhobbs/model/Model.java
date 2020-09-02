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
    int x = (this.hero.getLevel() - 1) * 5 + 10 - (this.getHero().getLevel() % 2);
//    int y = x;
    int centerX = x / 2;
//    int centerY = centerX;
    int[][] map = new int[x][x];

    for (int i = 0; i < x; i++) {
      for (int j = 0; j < x; j++) {
        if ((i == 0 || j == 0) || (i == x - 1 || j == x - 1)) {
          map[i][j] = 0;
        }
        else if (i != centerX || j != centerX) {
          if (random.nextInt(3) != 0) {
            map[i][j] = random.nextInt(7);
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

    for (int i = 0; i < x; i++) {
      for (int j = 0; j < x; j++) {
        System.out.print(map[i][j] + " ");
      }
      System.out.println();
    }

  }

  public void clearErrorException() {
    this.errorException = "";
  }
}
