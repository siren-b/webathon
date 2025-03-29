package web.core.view;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

import web.core.model.Bird;
import web.core.model.Player;

public class GameRenderer implements IRenderer{
    Texture gameScreen;
    ViewableModel model;
    SpriteBatch batch;
    Stage stage;
    ArrayList<Bird> birds;
    Player player;
    Texture playerTexture;

    public GameRenderer(ViewableModel model, SpriteBatch batch, Stage stage){
        this.model = model;
        this.batch = batch;
        this.stage = stage;

        this.player = model.getPlayer();
        this.playerTexture = new Texture("images/plane.png");


        this.gameScreen = new Texture("images/game-screen.jpg");
    }

    @Override
    public void render() {
        batch.draw(gameScreen, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        this.player = model.getPlayer();
        batch.draw(playerTexture, player.getPos().x(), player.getPos().y(), player.getBounds().getWidth(), player.getBounds().getHeight());

    }

    @Override
    public void dispose() {
        gameScreen.dispose();
    }
    
}
