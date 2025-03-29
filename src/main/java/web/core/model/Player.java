package web.core.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class Player {
    private int livesRemaining;
    private Position pos;
    private Rectangle bounds;
    private int moveSpeed;

    public Player(){
        this.livesRemaining = 3;
        this.moveSpeed = 5;
        this.pos = new Position(120, (int) Gdx.graphics.getHeight()/2);
        this.bounds = new Rectangle(pos.x(), pos.y(), 200, 80);

    }

    public int getLivesRemaining() {
        return this.livesRemaining;
    }

    public Position getPos() {
        return this.pos;
    }

    private void changePos(int deltaX, int deltaY){
        int oldX = pos.x();
        int oldY = pos.y();

        if ((oldX + deltaX) < 0) oldX = -deltaX;
        if ((oldX + deltaX + bounds.getWidth()) > Gdx.graphics.getWidth()) oldX = (int) (Gdx.graphics.getWidth() - deltaX - bounds.getWidth());
        if ((oldY + deltaY) < 0) oldY = -deltaY;
        if ((oldY + deltaY + bounds.getHeight()) > Gdx.graphics.getHeight()) oldY = (int) (Gdx.graphics.getHeight() - deltaY - bounds.getHeight());

        this.pos = new Position(oldX + deltaX, oldY + deltaY);
        this.bounds = new Rectangle(pos.x(), pos.y(), bounds.getWidth(), bounds.getHeight());
    }

    public Rectangle getBounds(){
        return this.bounds;
    }

    public void move(Direction d){
        switch (d) {
            case UP:
                changePos(0, moveSpeed);
                break;
            case DOWN:
                changePos(0, -moveSpeed);
        }
    }
    


}
