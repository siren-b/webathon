package web.core.view;

import web.core.model.GameState;
import web.core.model.Player;

public interface ViewableModel {
    GameState getGameState();
    void pressPlay();
    Player getPlayer();
}
