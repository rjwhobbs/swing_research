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
      artefact = HelmFactory.retrieveHelm(ArtefactSubTypes.getHelmTypes()[0]);
    }
    else if (levelGap == 0) {
      if (randArtefact.equals("Helm")) {
        artefact = HelmFactory.retrieveHelm(
                ArtefactSubTypes.getHelmTypes()[random.nextInt(2)]
        );
      }
      else if (randArtefact.equals("Weapon")) {
        if (hero.getClassType().equals("Bass Guitar Hero")) {
          artefact = WeaponFactory.retrieveWeapon(
                  ArtefactSubTypes.getBassGuitarWeapons()[1]
          );
        }
        else if (hero.getClassType().equals("Guitar Hero")) {
          artefact = WeaponFactory.retrieveWeapon(
                  ArtefactSubTypes.getGuitarWeapons()[1]
          );
        }
        else if (hero.getClassType().equals("Drum Hero")) {
          artefact = WeaponFactory.retrieveWeapon(
                  ArtefactSubTypes.getDrumWeapons()[1]
          );
        }
      }
      else if (randArtefact.equals("Armor")) {
        if (hero.getClassType().equals("Bass Guitar Hero")) {
          artefact = ArmorFactory.retrieveArmor(
                  ArtefactSubTypes.getBassGuitarArmor()[1]
          );
        }
        else if (hero.getClassType().equals("Guitar Hero")) {
          artefact = ArmorFactory.retrieveArmor(
                  ArtefactSubTypes.getGuitarArmor()[1]
          );
        }
        else if (hero.getClassType().equals("Drum Hero")) {
          artefact = ArmorFactory.retrieveArmor(
                  ArtefactSubTypes.getDrumArmor()[1]
          );
        }
      }
    }
    else if (levelGap == 1) {
      if (randArtefact.equals("Helm")) {
        artefact = HelmFactory.retrieveHelm(
                ArtefactSubTypes.getHelmTypes()[1]
        );
      }
      else if (randArtefact.equals("Weapon")) {
        if (hero.getClassType().equals("Bass Guitar Hero")) {
          artefact = WeaponFactory.retrieveWeapon(
                  ArtefactSubTypes.getBassGuitarWeapons()[random.nextInt(2) + 1]
          );
        }
        else if (hero.getClassType().equals("Guitar Hero")) {
          artefact = WeaponFactory.retrieveWeapon(
                  ArtefactSubTypes.getGuitarWeapons()[random.nextInt(2) + 1]
          );
        }
        else if (hero.getClassType().equals("Drum Hero")) {
          artefact = WeaponFactory.retrieveWeapon(
                  ArtefactSubTypes.getDrumWeapons()[random.nextInt(2) + 1]
          );
        }
      }
      else if (randArtefact.equals("Armor")) {
        if (hero.getClassType().equals("Bass Guitar Hero")) {
          artefact = ArmorFactory.retrieveArmor(
                  ArtefactSubTypes.getBassGuitarArmor()[random.nextInt(2) + 1]
          );
        }
        else if (hero.getClassType().equals("Guitar Hero")) {
          artefact = ArmorFactory.retrieveArmor(
                  ArtefactSubTypes.getGuitarArmor()[random.nextInt(2) + 1]
          );
        }
        else if (hero.getClassType().equals("Drum Hero")) {
          artefact = ArmorFactory.retrieveArmor(
                  ArtefactSubTypes.getDrumArmor()[random.nextInt(2) + 1]
          );
        }
      }
    }
    else if (levelGap >= 2) {
      if (randArtefact.equals("Helm")) {
        artefact = HelmFactory.retrieveHelm(
                ArtefactSubTypes.getHelmTypes()[2]
        );
      }
      else if (randArtefact.equals("Weapon")) {
        if (hero.getClassType().equals("Bass Guitar Hero")) {
          artefact = WeaponFactory.retrieveWeapon(
                  ArtefactSubTypes.getBassGuitarWeapons()[2]
          );
        }
        else if (hero.getClassType().equals("Guitar Hero")) {
          artefact = WeaponFactory.retrieveWeapon(
                  ArtefactSubTypes.getGuitarWeapons()[2]
          );
        }
        else if (hero.getClassType().equals("Drum Hero")) {
          artefact = WeaponFactory.retrieveWeapon(
                  ArtefactSubTypes.getDrumWeapons()[2]
          );
        }
      }
    }

    // if this happens I will need to save it in the DB.
    if (enemy.getEnemyType().equals("Grumpy sound engineer")) {
      artefact.setPoints(artefact.getPoints() + 30);
    }

    return artefact;

  }

}
