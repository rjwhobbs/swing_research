package rhobbs.model;

import rhobbs.model.storage.Storage;
import java.sql.Connection;
import java.util.List;

public class Model {

  private Connection conn;
  private List<String> heroes;
  private Hero hero;


  public void buildHero(String name) {
    this.hero = new GuitarHero(name);
    try {
      conn = Storage.getConnection();
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

  public void retrieveHero() {
    try {
      List<String> hero = Storage.selectHero("Mike");
      for(String str: hero) {
        System.out.println(str);
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
