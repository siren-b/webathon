package web.core.model;

import java.util.ArrayList;

import web.core.controller.ControllableModel;
import web.core.view.ViewableModel;

public class GameModel implements ViewableModel, ControllableModel {
    GameState gameState;
    Player player;
    ArrayList<Bird> birds;
    int killCount;

    public GameModel(){
        this.gameState = GameState.MENU;
        this.player = new Player();
        birds = new ArrayList<>();
        birds.add(new Bird());
        this.killCount = 0;
    }

    /**
     * moves birds. To be called in GameApp.render()
     */
    public void update(){
        birds.removeIf(Bird::isOut);

        for (Bird b : birds){
            b.move();
            if (b.isAlive() && playerHitsBird(b)){
                b.isHit();
                this.killCount += 1;
                System.out.println("Birds killed: " + killCount);
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
    public int getKillCount(){
        return killCount;
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
