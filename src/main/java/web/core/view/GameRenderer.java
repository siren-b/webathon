package web.core.view;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import web.core.model.Bird;
import web.core.model.Player;

public class GameRenderer implements IRenderer{
    private ViewableModel model;
    private SpriteBatch batch;
    private ArrayList<Bird> birds;
    private Player player;

    private Texture gameScreen;
    private Texture playerTexture;
    private Texture bAliveTexture;
    private Texture bDeadTexture;

    private BitmapFont font;

    public GameRenderer(ViewableModel model, SpriteBatch batch){
        this.model = model;
        this.batch = batch;

        this.player = model.getPlayer();
        this.playerTexture = new Texture("images/plane.png");

        this.birds = model.getBirds();
        this.bAliveTexture = new Texture("images/alive-bird.png");
        this.bDeadTexture = new Texture("images/dead-bird.png");

        this.gameScreen = new Texture("images/game-screen.jpg");

        this.font = new BitmapFont();
        this.font.setColor(com.badlogic.gdx.graphics.Color.BLACK);
    }

    @Override
    public void render() {        
        batch.draw(gameScreen, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        this.player = model.getPlayer();
        batch.draw(playerTexture, player.getPos().x(), player.getPos().y(), player.getBounds().getWidth(), player.getBounds().getHeight());

        this.birds = model.getBirds();
        for (Bird b : birds){
            if (b.isAlive()){
                batch.draw(bAliveTexture, b.getBounds().getX(), b.getBounds().getY(), b.getBounds().getWidth(), b.getBounds().getHeight());
            } else {
                batch.draw(bDeadTexture, b.getBounds().getX(), b.getBounds().getY(), b.getBounds().getWidth(), b.getBounds().getHeight());
            }
        }

        font.draw(batch, "Birds killed: " + model.getKillCount(), Gdx.graphics.getWidth() - 200, Gdx.graphics.getHeight() - 20);
        font.draw(batch, "Birds escaped: " + model.getEscapeCount(), Gdx.graphics.getWidth() - 200, Gdx.graphics.getHeight() - 40);

    }

    @Override
    public void dispose() {
        gameScreen.dispose();
        font.dispose();
    }
    
}
