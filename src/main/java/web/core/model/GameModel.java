package web.core.model;

import java.util.ArrayList;

import web.core.controller.ControllableModel;
import web.core.view.ViewableModel;

public class GameModel implements ViewableModel, ControllableModel {
    GameState gameState;
    Player player;
    ArrayList<Bird> birds;

    public GameModel(){
        this.gameState = GameState.MENU;
        this.player = new Player();
        birds = new ArrayList<>();
        birds.add(new Bird());
    }

    /**
     * moves birds. To be called in GameApp.render()
     */
    public void update(){
        for (Bird b : birds){
            b.move();
            if (playerHitsBird(b)){
                b.isHit();
            }
        }
    }

    private boolean playerHitsBird(Bird bird){
        return player.getBounds().overlaps(bird.getBounds());
    }

    @Override
    public void movePlayer(Direction d){
        player.move(d);
    }

    @Override
    public GameState getGameState(){
        return this.gameState;
    }

    @Override
    public void pressPlay() {
        this.gameState = GameState.GAME_ACTIVE;
    }

    @Override
    public void goToMenu() {
        this.gameState = GameState.MENU;
    }

    @Override
    public Player getPlayer(){
        return this.player;
    }

    @Override
    public ArrayList<Bird> getBirds(){
        return birds;
    }


}
