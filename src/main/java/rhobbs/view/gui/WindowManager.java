package rhobbs.view.gui;
import rhobbs.model.Enemy;
import rhobbs.model.Hero;
import rhobbs.model.artefacts.Artefact;

import java.util.List;
public interface WindowManager {
  public void showStartScreen();
  public void showSelectScreen(List<List<String>> heroList);
  public void showCreateScreen();
  public void showCreateScreenError(String error);
  public void showSelectScreenStats(String stats);
  public void upDateGameViewHeroStats(Hero hero);
  public void showErrorOnStart(String error);
  public void showSelectScreenError(String error);
  public void disableStartSelectScreen();
  public void showGameView(Hero hero);
  public void showCurrentCoords(int[] currentCoords);
  public void setMovementEnabled(boolean b);
  public void setFightRunEnabled(boolean b);
  public void setAttackEnabled(boolean b);
  public void setPickupLeaveEnabled(boolean b);
  public void showGameInfo(String info);
  public void showGameInfo(String info, Enemy enemy);
  public void showGameInfo(String info, Hero hero, Enemy enemy);
  public void showGameInfo(String info, Hero hero, Artefact artefact);
  public void showGameViewError(String error);
}
