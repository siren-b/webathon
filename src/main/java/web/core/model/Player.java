package web.core.model;

import com.badlogic.gdx.Gdx;

public class Player {
    private int livesRemaining;
    private Position pos;

    public Player(){
        this.livesRemaining = 3;
        this.pos = new Position(120, (int) Gdx.graphics.getHeight()/2);
    }

    public int getLivesRemaining() {
        return livesRemaining;
    }

    public Position getPos() {
        return pos;
    }
    
}
