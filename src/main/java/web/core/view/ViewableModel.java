package web.core.view;

import java.util.ArrayList;

import web.core.model.Bird;
import web.core.model.GameState;
import web.core.model.Player;

public interface ViewableModel {
    GameState getGameState();
    void pressPlay();
    Player getPlayer();
    ArrayList<Bird> getBirds();
}
