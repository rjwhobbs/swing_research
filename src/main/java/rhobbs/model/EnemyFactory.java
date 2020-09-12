package rhobbs.model;

public abstract class EnemyFactory {
  public static Enemy createEnemy(String enemyType, int level) {
    switch (enemyType) {
      case "Clueless audience member":
        return new Enemy(enemyType, level, 120,80, 80);
      case "Venue DJ":
        return new Enemy(enemyType, level, 100, 100, 50);
      case "Drunk fan":
        return new Enemy(enemyType, level, 50, 150, 150);
      case "Venue owner":
        return new Enemy(enemyType, level, 150, 110, 50);
      case "Grumpy sound engineer":
        return new Enemy(enemyType, level, 200, 150, 150);
      default:
        return null;
    }
  }
}
