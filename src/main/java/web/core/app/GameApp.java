package web.core.app;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;

import web.core.controller.Controller;
import web.core.model.GameModel;
import web.core.view.View;

public class GameApp implements ApplicationListener {
  private View view;
  private GameModel model;
  private Controller controller;

  @Override
  public void create() {
    model = new GameModel();
    view = new View(model);
    controller = new Controller(model);
  }

  @Override
  public void resize(int width, int height) {
  }

  @Override
  public void render() {
    // float deltaTime = Gdx.graphics.getDeltaTime();
    // controller.handleInput(deltaTime);
    // model.update();
    // view.render(model);
  }

  @Override
  public void pause() {
  }

  @Override
  public void resume() {
  }

  @Override
  public void dispose() {
    // view.dispose();
    // model.dispose();
    // controller.dispose();
  }
}
