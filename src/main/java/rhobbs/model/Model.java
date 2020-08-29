package rhobbs.model;

import rhobbs.model.util.dataUtil;

import java.util.List;

public class Model {

  private List<String> heroes;
  private Hero hero;

  public void buildHero(String name) {
    this.hero = new GuitarHero(name);
  }

  public Hero getHero() {
    return this.hero;
  }


  public void initHero() {
    try {
      heroes = dataUtil.getAllHeroes();
      for(String hero: heroes) {
        System.out.println(hero);
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
