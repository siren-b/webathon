package web.core.controller;

import web.core.model.Direction;
import web.core.model.GameState;

public interface ControllableModel {

    void movePlayer(Direction d);

    GameState getGameState();

    void pressPlay();

    void pressPause();

    void goToMenu();
    
}
