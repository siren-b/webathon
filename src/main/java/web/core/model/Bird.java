package web.core.model;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class Bird {
    private boolean isAlive;
    private Position pos;
    private Rectangle bounds;
    private int moveSpeed;

    public Bird(){
        this.isAlive = true;
        this.pos = randomStartPos();
        this.bounds = new Rectangle(pos.x(), pos.y(), 60, 60);
    }

    public Rectangle getBounds(){
        return this.bounds;
    }

    public boolean isAlive(){
        return isAlive;
    }

    public void isHit(){
        isAlive = false;
    }
    
    private Position randomStartPos(){
        int startX = (int) (Gdx.graphics.getWidth() - bounds.getWidth());
        int startY = new Random().nextInt(Gdx.graphics.getHeight());
        return new Position(startX, startY);
    }

    public void move(){
        changePos(-moveSpeed, 0);
    }

    private void changePos(int deltaX, int deltaY){ //same as Player.changePos()
        int oldX = pos.x();
        int oldY = pos.y();

        if ((oldX + deltaX) < 0) {
            oldX = -deltaX;
            isAlive = false;
        }
        if ((oldX + deltaX + bounds.getWidth()) > Gdx.graphics.getWidth()) oldX = (int) (Gdx.graphics.getWidth() - deltaX - bounds.getWidth());
        if ((oldY + deltaY) < 0) oldY = -deltaY;
        if ((oldY + deltaY + bounds.getHeight()) > Gdx.graphics.getHeight()) oldY = (int) (Gdx.graphics.getHeight() - deltaY - bounds.getHeight());

        this.pos = new Position(oldX + deltaX, oldY + deltaY);
        this.bounds = new Rectangle(pos.x(), pos.y(), bounds.getWidth(), bounds.getHeight());
    }
}
