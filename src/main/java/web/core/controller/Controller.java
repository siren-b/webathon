package web.core.controller;

import web.core.model.GameState;

public class Controller {
    ControllableModel model;
    GameState gameState;

    public Controller(ControllableModel model){
        this.model = model;
        this.gameState = model.getGameState();
    }
    
}
