package web.core.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import web.core.controller.Command;
import web.core.controller.CommandEnum;

public class ButtonClickListener extends ClickListener{
    private ButtonType type;
    private ViewableModel model;
    private GameView view;
    
    public ButtonClickListener(ButtonType type, ViewableModel model, GameView view){
        this.type = type;
        this.model = model;
        // this.commandListener = commandListener;
        this.view = view;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        switch (type) {
            case PLAY:
                view.getCommandListener().sendCommand(new Command(CommandEnum.PLAY, "play"));
                break;
            case QUIT:
                view.getCommandListener().sendCommand(new Command(CommandEnum.QUIT, "play"));
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
