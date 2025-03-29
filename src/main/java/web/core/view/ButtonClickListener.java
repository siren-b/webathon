package web.core.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class ButtonClickListener extends ClickListener{
    private ButtonType type;
    private ViewableModel model;
    
    public ButtonClickListener(ButtonType type, ViewableModel model){
        this.type = type;
        this.model = model;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        switch (type) {
            case PLAY:
                model.pressPlay();
                break;
            case QUIT:
                Gdx.app.exit();
        }
    }

    @Override
    public void enter(InputEvent event, float x, float y, int pointer, com.badlogic.gdx.scenes.scene2d.Actor fromActor) {
        Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Hand);
    }

    @Override
    public void exit(InputEvent event, float x, float y, int pointer, com.badlogic.gdx.scenes.scene2d.Actor toActor) {
        Gdx.graphics.setSystemCursor(Cursor.SystemCursor.Arrow);
    }
}
