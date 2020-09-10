package rhobbs.view.gui;
import rhobbs.model.Hero;

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
}
