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
      artefact = HelmFactory.retrieveHelm(ArtefactConstants.getHelmTypes()[0]);
    }
    else if (levelGap == 0) {
      if (randArtefact.equals("Helm")) {
        artefact = HelmFactory.retrieveHelm(
                ArtefactConstants.getHelmTypes()[random.nextInt(2)]
        );
      }
      else if (randArtefact.equals("Weapon")) {
        if (hero.getClassType().equals("Bass Guitar Hero")) {
          artefact = WeaponFactory.retrieveWeapon(
                  ArtefactConstants.getBassGuitarWeapons()[1]
          );
        }
        else if (hero.getClassType().equals("Guitar Hero")) {
          artefact = WeaponFactory.retrieveWeapon(
                  ArtefactConstants.getGuitarWeapons()[1]
          );
        }
        else if (hero.getClassType().equals("Drum Hero")) {
          artefact = WeaponFactory.retrieveWeapon(
                  ArtefactConstants.getDrumWeapons()[1]
          );
        }
      }
      else if (randArtefact.equals("Armor")) {
        if (hero.getClassType().equals("Bass Guitar Hero")) {
          artefact = ArmorFactory.retrieveArmor(
                  ArtefactConstants.getBassGuitarArmor()[1]
          );
        }
        else if (hero.getClassType().equals("Guitar Hero")) {
          artefact = ArmorFactory.retrieveArmor(
                  ArtefactConstants.getGuitarArmor()[1]
          );
        }
        else if (hero.getClassType().equals("Drum Hero")) {
          artefact = ArmorFactory.retrieveArmor(
                  ArtefactConstants.getDrumArmor()[1]
          );
        }
      }
    }
    else if (levelGap == 1) {
      if (randArtefact.equals("Helm")) {
        artefact = HelmFactory.retrieveHelm(
                ArtefactConstants.getHelmTypes()[1]
        );
      }
      else if (randArtefact.equals("Weapon")) {
        if (hero.getClassType().equals("Bass Guitar Hero")) {
          artefact = WeaponFactory.retrieveWeapon(
                  ArtefactConstants.getBassGuitarWeapons()[random.nextInt(2) + 1]
          );
        }
        else if (hero.getClassType().equals("Guitar Hero")) {
          artefact = WeaponFactory.retrieveWeapon(
                  ArtefactConstants.getGuitarWeapons()[random.nextInt(2) + 1]
          );
        }
        else if (hero.getClassType().equals("Drum Hero")) {
          artefact = WeaponFactory.retrieveWeapon(
                  ArtefactConstants.getDrumWeapons()[random.nextInt(2) + 1]
          );
        }
      }
      else if (randArtefact.equals("Armor")) {
        if (hero.getClassType().equals("Bass Guitar Hero")) {
          artefact = ArmorFactory.retrieveArmor(
                  ArtefactConstants.getBassGuitarArmor()[random.nextInt(2) + 1]
          );
        }
        else if (hero.getClassType().equals("Guitar Hero")) {
          artefact = ArmorFactory.retrieveArmor(
                  ArtefactConstants.getGuitarArmor()[random.nextInt(2) + 1]
          );
        }
        else if (hero.getClassType().equals("Drum Hero")) {
          artefact = ArmorFactory.retrieveArmor(
                  ArtefactConstants.getDrumArmor()[random.nextInt(2) + 1]
          );
        }
      }
    }
    else if (levelGap >= 2) {
      if (randArtefact.equals("Helm")) {
        artefact = HelmFactory.retrieveHelm(
                ArtefactConstants.getHelmTypes()[2]
        );
      }
      else if (randArtefact.equals("Weapon")) {
        if (hero.getClassType().equals("Bass Guitar Hero")) {
          artefact = WeaponFactory.retrieveWeapon(
                  ArtefactConstants.getBassGuitarWeapons()[2]
          );
        }
        else if (hero.getClassType().equals("Guitar Hero")) {
          artefact = WeaponFactory.retrieveWeapon(
                  ArtefactConstants.getGuitarWeapons()[2]
          );
        }
        else if (hero.getClassType().equals("Drum Hero")) {
          artefact = WeaponFactory.retrieveWeapon(
                  ArtefactConstants.getDrumWeapons()[2]
          );
        }
      }
      else if (randArtefact.equals("Armor")) {
        if (hero.getClassType().equals("Bass Guitar Hero")) {
          artefact = ArmorFactory.retrieveArmor(
                  ArtefactConstants.getBassGuitarArmor()[2]
          );
        }
        else if (hero.getClassType().equals("Guitar Hero")) {
          artefact = ArmorFactory.retrieveArmor(
                  ArtefactConstants.getGuitarArmor()[2]
          );
        }
        else if (hero.getClassType().equals("Drum Hero")) {
          artefact = ArmorFactory.retrieveArmor(
                  ArtefactConstants.getDrumArmor()[2]
          );
        }
      }
    }

    // if this happens I will need to save it in the DB.
//    if (enemy.getEnemyType().equals("Grumpy sound engineer")) {
//      artefact.setPoints(artefact.getPoints() + 30);
//    }

    return artefact;

  }

}
