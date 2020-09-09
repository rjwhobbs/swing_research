package rhobbs.view.gui;
import rhobbs.model.Hero;

import java.util.List;
public interface WindowManager {
  public void showSelectScreen(List<List<String>> heroList);
  public void showSelectScreenStats(String stats);
  public void showErrorOnStart(String error);
  public void disableStartSelectScreen();
  public void showGameView(Hero hero);
}
