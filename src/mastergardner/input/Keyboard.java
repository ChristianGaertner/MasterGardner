/*
 * Keyboard Input Getter
 * 
 */
package mastergardner.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Christian
 */
public class Keyboard implements KeyListener{
    
    private boolean[] keys = new boolean[65536];
    /**
     * W || UP_Arrow
     */
    public boolean up,
    /**
     * S || DOWN_Arrow
     */
    down,
    /**
     * A || LEFT_Arrow
     */
    left,
    /**
     * D || RIGHT_Arrow
     */
    right,
    /**
     * Shift
     */
    shift;
    
    
    /**
     *
     */
    public void update() {
        up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
        shift = keys[KeyEvent.VK_SHIFT];                             
    }

    /**
     *
     * @param ke
     */
    @Override
    public void keyTyped(KeyEvent ke) {  
    }

    /**
     *
     * @param ke
     */
    @Override
    public void keyPressed(KeyEvent ke) {
        keys[ke.getKeyCode()] = true;
    }

    /**
     *
     * @param ke
     */
    @Override
    public void keyReleased(KeyEvent ke) {
        keys[ke.getKeyCode()] = false;
    }
    
}
