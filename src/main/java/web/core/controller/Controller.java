package web.core.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import web.core.model.Direction;
import web.core.model.GameState;

public class Controller {
    ControllableModel model;
    GameState gameState;

    public Controller(ControllableModel model){
        this.model = model;
        this.gameState = model.getGameState();
    }

    public void handleInput(float deltaTime) {
        gameState = model.getGameState();

        if (gameState == GameState.MENU){
            if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
                Gdx.app.exit();
            }
            if (Gdx.input.isKeyPressed(Input.Keys.ENTER)){
                model.pressPlay();
            }
        }


        if (gameState == GameState.GAME_ACTIVE) {
            if (Gdx.input.isKeyPressed(Input.Keys.M)){
                model.goToMenu();
            }

            playerInput();
        }
    }

    private void playerInput(){
        if (Gdx.input.isKeyPressed(Input.Keys.UP) || Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            model.movePlayer(Direction.UP);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN) || Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            model.movePlayer(Direction.DOWN);
        }
    }
    
}
