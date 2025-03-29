package web.core.app;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

public class Main {
  public static void main(String[] args) {

    Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
    cfg.setTitle("hei");
    cfg.setWindowedMode(960, 640);

    new Lwjgl3Application(new GameApp(), cfg);
  }
}