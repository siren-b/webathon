package web.core.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class View {
    private ViewableModel model;
    private Renderer renderer;
    private final Stage stage;

    public View (ViewableModel model){
        this.model = model;
        this.renderer = new Renderer(this.model);
        this.stage = renderer.getStage();

        Gdx.input.setInputProcessor(stage);
    }

    public void render(ViewableModel model) {
        this.model = model;
        this.renderer.render(model);

        stage.act();
        stage.draw();
    }

    public void dispose() {
        renderer.dispose();
        stage.dispose();
    }
}
