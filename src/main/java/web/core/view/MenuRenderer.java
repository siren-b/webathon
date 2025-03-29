package web.core.view;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class MenuRenderer {
    Texture menuScreen;
    ViewableModel model;
    SpriteBatch batch;
    Stage stage;
    ArrayList<MenuButton> buttons;

    public MenuRenderer(ViewableModel model, SpriteBatch batch, Stage stage, ArrayList<MenuButton> buttons){
        this.model = model;
        this.batch = batch;
        this.stage = stage;

        this.menuScreen = new Texture("images/menu-screen.jpg");
        this.buttons = buttons;

        for (MenuButton mb : this.buttons){
            stage.addActor(mb.getButton());
        }
    }

    public void render(){
        batch.draw(menuScreen, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

    }

    public void clearButtons(){
        for (MenuButton mb : this.buttons){
            if (mb.getButton().hasParent()) mb.getButton().remove();
        }
    }

    public void dispose(){
        menuScreen.dispose();
    }
    
}
