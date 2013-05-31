/*
 * Player
 * controlled by HDI
 */
package mastergardner.entity.npc;

import mastergardner.Game;
import mastergardner.entity.projectile.Projectile;
import mastergardner.graphics.Screen;
import mastergardner.graphics.Sprite;
import mastergardner.input.Keyboard;
import mastergardner.input.Mouse;

/**
 *
 * @author Christian
 */
public class Player extends NPC {

    private Keyboard input;
    private Sprite sprite;
    private int anim;
    private boolean walking;

    /**
     * Spawn Player at default point
     *
     * @param input
     */
    public Player(Keyboard input) {
        this.walking = false;
        this.anim = 0;
        this.input = input;
        this.running_speed = 1;
    }

    /**
     * Spawn player at certain position
     *
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
        this.running_speed = 1;
    }

    /**
     *
     */
    @Override
    public void update() {
        int xa;
        xa = 0;
        int ya;
        ya = 0;

        if (anim < 7500) { //int cannot hold too high values
            anim++;
        } else {
            anim = 0;
        }

        if (input.up) {
            ya--;
            if (input.shift) {
                ya -= running_speed;
            }
        }
        if (input.down) {
            ya++;
            if (input.shift) {
                ya += running_speed;
            }
        }
        if (input.left) {
            xa--;
            if (input.shift) {
                xa -= running_speed;
            }
        }
        if (input.right) {
            xa++;
            if (input.shift) {
                xa += running_speed;
            }
        }

        if (xa != 0 || ya != 0) {
            move(xa, ya);
            walking = true;
        } else {
            walking = false;
        }

        clear();
        updateShooting();

    }

    private void updateShooting() {

        if (Mouse.getButton() == 1) {
            double dx = Mouse.getX() - (Game.getWindowWidth() / 2);
            double dy = Mouse.getY() - (Game.getWindowHeight() / 2);
            double angle = Math.atan2(dy, dx);
            shoot(x, y, angle);
        }
    }

    /**
     *
     * @param screen
     */
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
        if (dir == 1) {
            sprite = Sprite.player_side;
            if (walking) {
                if (anim % 20 > 10) {
                    sprite = Sprite.player_side_1;
                } else {
                    sprite = Sprite.player_side_2;
                }
            }
        }
        if (dir == 2) {
            sprite = Sprite.player_back;
            if (walking) {
                if (anim % 20 > 10) {
                    sprite = Sprite.player_back_1;
                } else {
                    sprite = Sprite.player_back_2;
                }
            }
        }
        if (dir == 3) {
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

    private void clear() {
        for (int i = 0; i < level.getProjectiles().size(); i++) {
            Projectile p = level.getProjectiles().get(i);
            if (p.isRemoved()) {
                level.getProjectiles().remove(i);
            }
        }
    }
}
