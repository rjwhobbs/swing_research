package rhobbs.model;

public abstract class EnemyFactory {
  public static Enemy createEnemy(String enemyType, int level) {
    switch (enemyType) {
      case "Clueless audience member":
        return new Enemy(enemyType, level, 100,40, 50);
      case "Venue DJ":
        return new Enemy(enemyType, level, 100, 100, 50);
      case "Drunk fan":
        return new Enemy(enemyType, level, 50, 50, 20);
      case "Venue owner":
        return new Enemy(enemyType, level, 150, 100, 50);
      case "Grumpy sound engineer":
        return new Enemy(enemyType, level, 200, 200, 200);
      default:
        return null;
    }
  }
}
