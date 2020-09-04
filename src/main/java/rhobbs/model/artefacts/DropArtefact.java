package rhobbs.model.artefacts;

import rhobbs.model.Enemy;
import rhobbs.model.Hero;
import rhobbs.model.artefacts.armor.ArmorFactory;
import rhobbs.model.artefacts.helms.HelmFactory;
import rhobbs.model.artefacts.weapons.WeaponFactory;

import java.util.Random;

public class DropArtefact {

  private static Random random = new Random();

  public static Artefact generateArtefact(Hero hero, Enemy enemy) {

    Artefact artefact = new Artefact();
    String[] artefactsArr = {"Helm", "Weapon", "Armor"};
    String randArtefact = artefactsArr[random.nextInt(3)];
    int levelGap = enemy.getLevel() - hero.getLevel();

    if (levelGap < 0) {
      artefact = HelmFactory.retrieveHelm(ArtefactTypes.getHelmTypes()[0]);
    }
    else if (levelGap == 0) {
      if (randArtefact.equals("Helm")) {
        artefact = HelmFactory.retrieveHelm(
                ArtefactTypes.getHelmTypes()[random.nextInt(2)]
        );
      }
      else if (randArtefact.equals("Weapon")) {
        if (hero.getClassType().equals("Bass Guitar Hero")) {
          artefact = WeaponFactory.retrieveWeapon(
                  ArtefactTypes.getBassGuitarWeapons()[1]
          );
        }
        else if (hero.getClassType().equals("Guitar Hero")) {
          artefact = WeaponFactory.retrieveWeapon(
                  ArtefactTypes.getGuitarWeapons()[1]
          );
        }
        else if (hero.getClassType().equals("Drum Hero")) {
          artefact = WeaponFactory.retrieveWeapon(
                  ArtefactTypes.getDrumWeapons()[1]
          );
        }
      }
      else if (randArtefact.equals("Armor")) {
        if (hero.getClassType().equals("Bass Guitar Hero")) {
          artefact = ArmorFactory.retrieveArmor(
                  ArtefactTypes.getBassGuitarArmor()[1]
          );
        }
        else if (hero.getClassType().equals("Guitar Hero")) {
          artefact = ArmorFactory.retrieveArmor(
                  ArtefactTypes.getGuitarArmor()[1]
          );
        }
        else if (hero.getClassType().equals("Drum Hero")) {
          artefact = ArmorFactory.retrieveArmor(
                  ArtefactTypes.getDrumArmor()[1]
          );
        }
      }
    }
    else if (levelGap == 1) {
      if (randArtefact.equals("Helm")) {
        artefact = HelmFactory.retrieveHelm(
                ArtefactTypes.getHelmTypes()[1]
        );
      }
      else if (randArtefact.equals("Weapon")) {
        if (hero.getClassType().equals("Bass Guitar Hero")) {
          artefact = WeaponFactory.retrieveWeapon(
                  ArtefactTypes.getBassGuitarWeapons()[random.nextInt(2) + 1]
          );
        }
        else if (hero.getClassType().equals("Guitar Hero")) {
          artefact = WeaponFactory.retrieveWeapon(
                  ArtefactTypes.getGuitarWeapons()[random.nextInt(2) + 1]
          );
        }
        else if (hero.getClassType().equals("Drum Hero")) {
          artefact = WeaponFactory.retrieveWeapon(
                  ArtefactTypes.getDrumWeapons()[random.nextInt(2) + 1]
          );
        }
      }
      else if (randArtefact.equals("Armor")) {
        if (hero.getClassType().equals("Bass Guitar Hero")) {
          artefact = ArmorFactory.retrieveArmor(
                  ArtefactTypes.getBassGuitarArmor()[random.nextInt(2) + 1]
          );
        }
        else if (hero.getClassType().equals("Guitar Hero")) {
          artefact = ArmorFactory.retrieveArmor(
                  ArtefactTypes.getGuitarArmor()[random.nextInt(2) + 1]
          );
        }
        else if (hero.getClassType().equals("Drum Hero")) {
          artefact = ArmorFactory.retrieveArmor(
                  ArtefactTypes.getDrumArmor()[random.nextInt(2) + 1]
          );
        }
      }
    }
    else if (levelGap >= 2) {
      if (randArtefact.equals("Helm")) {
        artefact = HelmFactory.retrieveHelm(
                ArtefactTypes.getHelmTypes()[2]
        );
      }
    }


    return artefact;

  }

}
