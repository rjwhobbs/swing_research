package rhobbs.model;

//import rhobbs.model.util.dataUtil;

import rhobbs.model.storage.Connect;
import rhobbs.model.storage.StoreHero;

import java.sql.Connection;
import java.util.List;

public class Model {

  private Connection conn;
  private List<String> heroes;
  private Hero hero;


  public void buildHero(String name) {
    this.hero = new GuitarHero(name);
    try {
      conn = Connect.getConnection();
      System.out.println("Connected");
      StoreHero.insertHero(
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
