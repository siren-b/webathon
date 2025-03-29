package web.core.model;

import web.core.controller.ControllableModel;
import web.core.view.ViewableModel;

public class GameModel implements ViewableModel, ControllableModel {
    GameState gameState;
    Player player;

    public GameModel(){
        this.gameState = GameState.MENU;
        this.player = new Player();
    }

    @Override
    public void movePlayer(Direction d){
        player.move(d);
    }

    @Override
    public GameState getGameState(){
        return this.gameState;
    }

    @Override
    public void pressPlay() {
        this.gameState = GameState.GAME_ACTIVE;
    }

    @Override
    public Player getPlayer(){
        return this.player;
    }


}
