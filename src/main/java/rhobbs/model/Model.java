package rhobbs.model;

import rhobbs.model.storage.Storage;
//import java.sql.Connection;
import java.util.List;

public class Model {

//  private Connection conn;
//  private List<String> heroes;
  private Hero hero;
  private List<List<String>> storedHeroes;

  public Model() {
    Storage.storageInit();
    this.storedHeroes = Storage.selectAllHeroes();
  }

  public void saveNewHeroInDB(String name) {
    this.hero = new GuitarHero(name);
    try {
//      conn = Storage.getConnection();
      System.out.println("Connected");
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
      System.out.println(e.getMessage());
    }
  }

  public List<List<String>> getStoredHeroes() {
    return this.storedHeroes;
  }

  public void selectHero(String index) {
    try {
      List<String> selectedHero = Storage.selectHeroById(index);
      if (selectedHero.size() == 7) {
        this.hero = HeroFactory.buildHero(
                selectedHero.get(0),
                selectedHero.get(1),
                selectedHero.get(2),
                selectedHero.get(3),
                selectedHero.get(4),
                Integer.parseInt(selectedHero.get(5)),
                Integer.parseInt(selectedHero.get(6))
        );
      } else {
        System.out.println("problem in selectHero" + selectedHero.size());
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public Hero getHero() {
    return this.hero;
  }
}
