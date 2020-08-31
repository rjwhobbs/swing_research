package rhobbs.model;

import rhobbs.model.storage.Storage;
import java.sql.Connection;
import java.util.List;

public class Model {

  private Connection conn;
  private List<String> heroes;
  private Hero hero;
  private List<List<String>> storedHeroes;

  public Model() {
    this.storedHeroes = Storage.selectAllHeroes();
  }

  public void buildHero(String name) {
    this.hero = new GuitarHero(name);
    try {
//      conn = Storage.getConnection();
      System.out.println("Connected");
      Storage.insertHero(
              this.hero.getName(),
              this.hero.getClassType(),
              this.hero.getWeapon().getType(),
              this.hero.getArmor().getType(),
              this.hero.getLevel(),
              this.hero.getExperience()
      );
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public List<List<String>> getStoredHeroes() {
    return this.storedHeroes;
  }

  public void selectHero(String index) {
    try {
      List<String> hero = Storage.selecHeroById(index);
//      System.out.println("Bru"+ hero.size());
      if (hero.size() == 6) {
        for(String str: hero) {
          System.out.println(str);
        }
      } else {
        System.out.println("problem in selectHero" + hero.size());
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public Hero getHero() {
    return this.hero;
  }


//  public void initHero() {
//    try {
//      heroes = dataUtil.getAllHeroes();
//      for(String hero: heroes) {
//        System.out.println(hero);
//      }
//    } catch (Exception e) {
//      System.out.println(e.getMessage());
//    }
//  }
}
