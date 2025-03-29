package web.core.app;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;

import web.core.controller.Controller;
import web.core.model.GameModel;
import web.core.model.GameState;
import web.core.view.GameView;

public class GameApp implements ApplicationListener {
  private GameView view;
  private GameModel model;
  private Controller controller;

  @Override
  public void create() {
    model = new GameModel();
    view = new GameView(model);
    controller = new Controller(model, view);
  }

  @Override
  public void resize(int width, int height) {
  }

  @Override
  public void render() {
    float deltaTime = Gdx.graphics.getDeltaTime();
    if (model.getGameState() == GameState.GAME_ACTIVE){
      model.update();
    }
    controller.handleInput(deltaTime);
    view.render(model);
  }

  @Override
  public void pause() {
  }

  @Override
  public void resume() {
  }

  @Override
  public void dispose() {
    view.dispose();
  }
}
