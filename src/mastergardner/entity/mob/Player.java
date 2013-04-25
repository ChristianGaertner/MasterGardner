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
    private Sprite sprite;
    private int anim;
    private boolean walking;
    
    /**
     * Spawn Player at default point
     * @param input
     */
    public Player(Keyboard input) {
        this.walking = false;
        this.anim = 0;
        this.input = input;
    }
    
    /**
     * Spawn player at certain position
     * @param x
     * @param y
     * @param input
     */
    public Player(int x, int y, Keyboard input) {
        this.walking = false;
        this.anim = 0;
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
        
        if (anim < 7500) { //int cannot hold too high values
            anim++;
        } else {
            anim = 0;
        }
        
        if (input.up) ya--;
        if (input.down) ya++;
        if (input.left) xa--;
        if (input.right) xa++;
        
        if (xa != 0 || ya != 0){
            move(xa, ya);
            walking = true;
        } else {
            walking = false;
        }
        
    }
    
    @Override
    public void render(Screen screen) {
        int flip;
        flip = 0;
        
        //get correct sprite
        if (dir == 0) {
            sprite = Sprite.player_forward;
            if (walking) {
                if (anim % 20 > 10) {
                    sprite = Sprite.player_forward_1;
                } else {
                    sprite = Sprite.player_forward_2;
                }
            }
            
        }
        if(dir == 1) {
            sprite = Sprite.player_side;
            if (walking) {
                if (anim % 20 > 10) {
                    sprite = Sprite.player_side_1;
                } else {
                    sprite = Sprite.player_side_2;
                }
            }
        }
        if(dir == 2) {
            sprite = Sprite.player_back;
            if (walking) {
                if (anim % 20 > 10) {
                    sprite = Sprite.player_back_1;
                } else {
                    sprite = Sprite.player_back_2;
                }
            }
        }
        if(dir == 3) {
            sprite = Sprite.player_side;
            if (walking) {
                if (anim % 20 > 10) {
                    sprite = Sprite.player_side_1;
                } else {
                    sprite = Sprite.player_side_2;
                }
            }
            flip = 1;
        }
        screen.renderPlayer(x - 16, y - 16, sprite, flip); //-16 in order to center player
    }
}
