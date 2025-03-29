package web.core.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import web.core.model.Direction;
import web.core.model.GameState;
import web.core.view.GameView;

public class Controller {//implements ICommandListener{
    ControllableModel model;
    GameView view;
    GameState gameState;

    public Controller(ControllableModel model, GameView view){
        this.model = model;
        this.view = view;
        this.gameState = model.getGameState();

        // view.addCommandListener(this);
    }

    public void handleInput(float deltaTime) {
        gameState = model.getGameState();

        switch (gameState) {
            case MENU:
                if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
                    Gdx.app.exit();
                }
                if (Gdx.input.isKeyPressed(Input.Keys.ENTER)){
                    model.pressPlay();
                }
                break;
            case GAME_ACTIVE:
                if (Gdx.input.isKeyPressed(Input.Keys.M)){
                    model.goToMenu();
                }
                if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {
                    model.pressPause();
                }

                playerInput();
                break;
            case GAME_OVER:
                if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
                    Gdx.app.exit();
                }
                break;
            case GAME_PAUSED:
                if (Gdx.input.isKeyPressed(Input.Keys.ENTER)){
                    model.pressPlay();
                }
                break;


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

    @Override
    public void sendCommand(Command command) {
        switch(command.command()){
            case PLAY:
                model.pressPlay();
                break;
            case QUIT:
                Gdx.app.exit();
                break;
        }
    }
    
}
