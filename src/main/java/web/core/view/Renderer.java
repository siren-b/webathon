package web.core.view;

import java.util.ArrayList;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import web.core.model.GameState;
import web.core.model.Position;

public class Renderer {
    private final SpriteBatch batch;
    private final Viewport viewport;
    private final Stage stage;

    private ViewableModel model;
    private GameState gameState;

    private Texture gameOverScreen;
    private Texture pauseScreen;

    private MenuRenderer menuRenderer;
    private GameRenderer gameRenderer;
    private ArrayList<MenuButton> menuButtons;
    
    public Renderer(ViewableModel model){
        this.model = model;
        this.gameState = model.getGameState();

        this.batch = new SpriteBatch();
        this.viewport = new ScreenViewport();
        this.stage = new Stage(viewport);

        makeMenuButtons();
        this.menuRenderer = new MenuRenderer(model, batch, stage, menuButtons);

        this.gameRenderer = new GameRenderer(model, batch);

        this.gameOverScreen = new Texture("images/over-screen.jpg");
        this.pauseScreen = new Texture("images/pause-screen.jpg");
    }

    private void makeMenuButtons(){
        this.menuButtons = new ArrayList<MenuButton>();
        menuButtons.add(new MenuButton(model, "images/play.png", ButtonType.PLAY, new Position(350, 90)));
        menuButtons.add(new MenuButton(model, "images/quit.png", ButtonType.QUIT, new Position(650, 90)));
    }

    public Stage getStage(){
        return this.stage;
    }

    public void render(ViewableModel model) {
        this.model = model;
        this.gameState = model.getGameState();

        ScreenUtils.clear(Color.BLACK);
        batch.begin();

        switch (gameState){
            case MENU:
                this.menuRenderer.render();
                break;
            case GAME_ACTIVE:
                menuRenderer.clearButtons();
                this.gameRenderer.render();
                break;
            case GAME_OVER:
                batch.draw(gameOverScreen, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
                break;
            case GAME_PAUSED:
                batch.draw(pauseScreen, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
                break;
            default:
                System.out.println("Something went wrong with gamestate in renderer");
                break;
        }

        batch.end();

        stage.act();
        stage.draw();
    }

    public void dispose() {
        batch.dispose();
        menuRenderer.dispose();
    }
}
