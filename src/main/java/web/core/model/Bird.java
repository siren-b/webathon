package web.core.model;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class Bird {
    private boolean isAlive;
    private Position pos;
    private Rectangle bounds;
    private int moveSpeed;
    private int size;

    public Bird(){
        this.isAlive = true;
        this.size = 60;
        this.pos = randomStartPos();
        this.bounds = new Rectangle(pos.x(), pos.y(), size, size);
        this.moveSpeed = 2;
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

    public boolean isOut(){
        boolean outOnTop = this.pos.y() >= Gdx.graphics.getHeight();
        boolean outOnLeft = this.pos.x() <= 0;
        return outOnTop || outOnLeft;
    }
    
    private Position randomStartPos(){
        int startX = (int) (Gdx.graphics.getWidth() - size);
        int startY = new Random().nextInt(Gdx.graphics.getHeight() - size);
        return new Position(startX, startY);
    }

    public void move(){
        if (isAlive) changePos(-moveSpeed, 0);
        if (!isAlive) changePos(0, moveSpeed);
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
        // if ((oldY + deltaY + bounds.getHeight()) > Gdx.graphics.getHeight()) oldY = (int) (Gdx.graphics.getHeight() - deltaY - bounds.getHeight());

        this.pos = new Position(oldX + deltaX, oldY + deltaY);
        this.bounds = new Rectangle(pos.x(), pos.y(), bounds.getWidth(), bounds.getHeight());
    }
}
