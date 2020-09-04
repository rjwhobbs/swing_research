package rhobbs.model;

import rhobbs.model.storage.Storage;
//import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model {

  private Hero hero = null;
  private Hero tempHero = null;
  private Enemy enemy;
  private List<List<String>> storedHeroes;
  private Random random = new Random();
  private int[] coords = {0,0};
  int[][] map;
  private boolean heroDefeated = false;

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

  public Enemy getEnemy() {
    return this.enemy;
  }

  public void generateMap() {
    int mapSize = (this.hero.getLevel() - 1) * 5 + 10 - (this.getHero().getLevel() % 2);
    int centerX = mapSize / 2;
    int heroLevel = this.hero.getLevel();
    int ib = 1;
    int placeEnemyChance = this.hero.getLevel() == 0 ? 100 : 3;
    map = new int[mapSize][mapSize];
    int maxEnemyLevel = this.hero.getLevel() + 2;
    int minEnemyLevel = this.hero.getLevel() - 1 > 0 ? this.hero.getLevel() - 1 : 0;
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
          if (random.nextInt(placeEnemyChance) != 0) {
            map[i][j] = enemyArray[random.nextInt(maxEnemyLevel)];
            if (map[i][j] < heroLevel && map[i][j] != 0 ) {
              map[i][j] = random.nextInt(maxEnemyLevel + 1 - minEnemyLevel) + minEnemyLevel;
            }
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
      }
      System.out.println();
    }

  }

  public int[] getCurrentCoords() {
    return this.coords;
  }

  public void setCoords(int x, int y) {
    this.coords[0] = x;
    this.coords[1] = y;
  }

  public void moveNorth() {
    this.coords[0] -= 1;
  }

  public void moveEast() {
    this.coords[1] += 1;
  }

  public void moveWest() {
    this.coords[1] -= 1;
  }

  public void moveSouth() {
    this.coords[0] += 1;
  }

  public boolean coordHasEnemy() {
    if (this.map[this.coords[0]][this.coords[1]] > 0) {
      return true;
    }
    return false;
  }

  public boolean isAtEndOfMap() {
    if (this.map[this.coords[0]][this.coords[1]] == -1) {
      return true;
    }
    return false;
  }

  public void generateEnemy() {
    String[] enemyTypes = {
            "Clueless audience member",
            "Venue DJ",
            "Drunk fan",
            "Venue owner",
            "Grumpy sound engineer"
    };
    String enemyType = enemyTypes[random.nextInt(enemyTypes.length)];
    int enemyLevel = this.map[this.coords[0]][this.coords[1]];

    this.enemy = EnemyFactory.createEnemy(enemyType, enemyLevel);
  }

  public boolean stillFighting() {
    int heroLevel = this.hero.getLevel() * 1000;
    int heroXP = this.hero.getExperience() / 10;
    int heroDef = this.hero.getDefense() * 10;
    int heroAtt = this.hero.getAttack() * 10;

    int enemyLevel = this.enemy.getLevel() * 1000;
    int enemyDef = this.enemy.getDefense() * 10;
    int enemyAtt = this.enemy.getAttack() * 10;

    int heroWeight = (heroLevel + heroXP + heroDef + heroAtt) / 100;
    int enemyWeight = (enemyLevel + enemyDef + enemyAtt) / 100;

    int heroHP = this.hero.getHitPoints();
    int enemyHP = this.enemy.getHitPoints();
    int heroHPRecovery = 0;
    // 2 = 1 out of 2 chance, 3 == 1 out of 3 chance etc
    int chanceOfLuck = this.makeChanceOfLuck(this.hero.getLevel());

    System.out.println("H " + heroWeight + " E " + enemyWeight);

    int heroScore = random.nextInt(heroWeight);
    int enemyScore = random.nextInt(enemyWeight);

    // Element of luck
    if (random.nextInt(chanceOfLuck) == chanceOfLuck - 1) {
      System.out.println("Doubled");
      heroScore *= 2;
      enemyScore /= 2;
    }

    System.out.println("HS " + heroScore + " ES " + enemyScore);

    if (heroScore >= enemyScore) {
      enemyHP -= heroScore;
      if (enemyHP <= 0) {
        // The hero won
        heroHPRecovery += this.hero.getHitPoints() + heroScore;
        if (heroHPRecovery >= this.hero.getMaxHitPoints()) {
          heroHPRecovery = this.hero.getMaxHitPoints();
        }
        this.hero.setHitPoints(heroHPRecovery);
        this.enemy.setHitPoints(0);
        this.updateHeroStats();
        this.map[this.coords[0]][this.coords[1]] = 0;
        return false;
      }
      else {
        this.enemy.setHitPoints(enemyHP);
      }
    }
    else {
      heroHP -= enemyScore;
      if (heroHP <= 0) {
        this.hero.setHitPoints(0);
        this.heroDefeated = true;
        return false;
      }
      else {
        this.hero.setHitPoints(heroHP);
      }
    }
    return true;
  }

  public boolean isHeroDefeated() {
    return heroDefeated;
  }

  private void updateHeroStats() {
    int updatedXP = 0;
    int levelCheck;
    int nextLevel = this.hero.getLevel() + 1;
    if (this.hero.getLevel() > this.enemy.getLevel()) {
      updatedXP = (100 / ((this.hero.getLevel() - this.enemy.getLevel() + 1))) * 10;
    }
    else if (this.hero.getLevel() == this.enemy.getLevel()) {
      updatedXP = 600;
    }
    else if (this.hero.getLevel() < this.enemy.getLevel()) {
      updatedXP = 500 + (300 * (this.enemy.getLevel() - this.hero.getLevel()));
    }
    this.hero.setExperience(updatedXP + this.hero.getExperience());

    levelCheck = (nextLevel * 1000) + (((nextLevel - 1) * (nextLevel - 1) * 450));
    if (this.hero.getExperience() >= levelCheck ) {
      this.hero.setLevel(nextLevel);
    }
  }

  private int makeChanceOfLuck(int level) {
    switch (level) {
      case 0:
        return 1;
      case 1:
        return 2;
      case 2:
        return 3;
      default:
        return 4;
    }
  }
}
