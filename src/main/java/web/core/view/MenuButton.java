package web.core.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import web.core.model.Position;

public class MenuButton {
    private ViewableModel model;
    private ButtonType type;
    private ImageButton imgButton;

    private int buttonWidth;
    private int buttonHeight;
    private Position buttonPos;
    
    /**
     * @param model Viewable model
     * @param path button image path
     * @param type decides what the button does
     * @param buttonPos position of lower left corner of button
     */
    public MenuButton(ViewableModel model, String path, ButtonType type, Position buttonPos){
        this.model = model;
        this.type = type;

        this.buttonWidth = 172;
        this.buttonHeight = 59;
        this.buttonPos = buttonPos;

        this.imgButton = new ImageButton(makeStyle(path));
        this.imgButton.setSize(buttonWidth, buttonHeight);
        this.imgButton.setPosition(buttonPos.x(), buttonPos.y());
        this.imgButton.addListener(new ButtonClickListener(type, model));
    }

    private ImageButton.ImageButtonStyle makeStyle(String path){
        Texture texture = new Texture(path);
        TextureRegion texReg = new TextureRegion(texture);
        TextureRegionDrawable drawable = new TextureRegionDrawable(texReg);

        ImageButton.ImageButtonStyle style = new ImageButton.ImageButtonStyle();
        style.up = drawable;
        return style;
    }
    
}
