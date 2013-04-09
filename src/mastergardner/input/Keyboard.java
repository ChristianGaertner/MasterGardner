/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
    public boolean up, down, left, right;
    
    
    public void update() {
        up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
        down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
        right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
        
        for (int i = 0; i < keys.length; i++) {
            if (keys[i]) {
                System.out.println("EVENT: KeyPressed >>> " + i);
            }
        }
                             
    }

    @Override
    public void keyTyped(KeyEvent ke) {  
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        keys[ke.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        keys[ke.getKeyCode()] = false;
    }
    
}
