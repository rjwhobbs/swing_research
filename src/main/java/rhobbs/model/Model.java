package rhobbs.model;

import rhobbs.model.storage.Storage;
//import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Model {

  private Hero hero = null;
  private Hero tempHero = null;
  private List<List<String>> storedHeroes;

  private String errorException = "";

  public Model() {
    Storage.storageInit();
    this.storedHeroes = Storage.selectAllHeroes();
  }

  public void storeNewHero() {
//    this.hero = new GuitarHero(name);
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
      System.out.println(e.getMessage());
    }
  }

  public void createNewHero(String name, String classType) {
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
        System.out.println(e.getMessage());
      }
    }
  }

  public List<String> getStoredHeroByName(String name) {
    List<String> temp = new ArrayList<>();
    try {
      temp = Storage.selectHeroByName(name);
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return temp;
  }

  public Hero getHero() {
    return this.hero;
  }
}
