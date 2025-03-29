package web.core.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import web.core.model.GameState;

public class Renderer {
    private final SpriteBatch batch;
    private final Viewport viewport;
    private final Stage stage;

    private ViewableModel model;
    private GameState gameState;

    private Texture menuScreen;
    private Texture background;
    
    public Renderer(ViewableModel model){
        this.model = model;
        this.gameState = model.getGameState();

        this.batch = new SpriteBatch();
        this.viewport = new ScreenViewport();
        this.stage = new Stage(viewport);

        this.menuScreen = new Texture("images/menu-screen.jpg");
        this.background = new Texture("images/screen.jpg");
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
            case GAME_ACTIVE:
                batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
                break;
            case MENU:
                batch.draw(menuScreen, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
            case GAME_OVER:
                batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
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
    }
}
