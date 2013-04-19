/*
 * Player
 * controlled by HDI
 */
package mastergardner.entity.mob;

import mastergardner.graphics.Screen;
import mastergardner.graphics.Sprite;
import mastergardner.input.Keyboard;

/**
 *
 * @author Christian
 */
public class Player extends Mob {
    
    private Keyboard input;
    
    /**
     * Spawn Player at default point
     * @param input
     */
    public Player(Keyboard input) {
        this.input = input;
    }
    
    /**
     * Spawn player at certain position
     * @param x
     * @param y
     * @param input
     */
    public Player(int x, int y, Keyboard input) {
        this.x = x;
        this.y = y;
        this.input = input;
    }
    
    @Override
    public void update(){
        int xa;
        xa = 0;
        int ya;
        ya = 0;
        
        if (input.up) ya--;
        if (input.down) ya++;
        if (input.left) xa--;
        if (input.right) xa++;
        
        if (xa != 0 || ya != 0) move(xa, ya);
        
    }
    
    @Override
    public void render(Screen screen) {
        screen.renderPlayer(x, y, Sprite.player0);
        screen.renderPlayer(x + 16, y, Sprite.player1);
        screen.renderPlayer(x, y + 16, Sprite.player2);
        screen.renderPlayer(x + 16, y + 16, Sprite.player3);
    }
}
