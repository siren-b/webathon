package web.core.model;

import web.core.controller.ControllableModel;
import web.core.view.ViewableModel;

public class GameModel implements ViewableModel, ControllableModel {
    GameState gameState;

    public GameModel(){
        this.gameState = GameState.MENU;
    }

    @Override
    public GameState getGameState(){
        return this.gameState;
    }


}
