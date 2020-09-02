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

  public void storeNewHero() {
    try {
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
      errorException = e.getMessage();
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
        this.errorException = e.getMessage();
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

  public void clearErrorException() {
    this.errorException = "";
  }
}
