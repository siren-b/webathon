package web.core.model;

import java.util.ArrayList;

import web.core.controller.ControllableModel;
import web.core.view.ViewableModel;

import com.badlogic.gdx.utils.Timer;

public class GameModel implements ViewableModel, ControllableModel {
    GameState gameState;
    Player player;
    ArrayList<Bird> birds;
    int killCount;
    int escapeCount;
    Timer.Task timerTask;

    public GameModel(){
        this.gameState = GameState.MENU;
        this.player = new Player();
        birds = new ArrayList<>();
        birds.add(new Bird());
        this.killCount = 0;


        
    }

    private void addBird(){
        this.birds.add(new Bird());
    }

    /**
     * moves birds, removes from list of birds if they are out of the screen
     */
    public void update(){
        if (escapeCount >= 10) gameState = GameState.GAME_OVER;
        birds.removeIf(Bird::isOut);

        for (Bird b : birds){
            b.move();
            if (b.isAlive() && playerHitsBird(b)){
                b.isHit();
                this.killCount += 1;
            }
            if (b.isOut() && b.isAlive()){
                this.escapeCount += 1;
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
    public int getEscapeCount(){
        return escapeCount;
    }

    @Override
    public void pressPlay() {
        this.gameState = GameState.GAME_ACTIVE;
        this.timerTask = Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                addBird();
            }
        }, 1, 1);
    }

    @Override
    public void pressPause() {
        this.gameState = GameState.GAME_PAUSED;
        this.timerTask.cancel();
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
