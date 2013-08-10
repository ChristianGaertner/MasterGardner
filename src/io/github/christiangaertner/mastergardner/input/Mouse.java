package io.github.christiangaertner.mastergardner.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author Christian
 */
public class Mouse implements MouseListener, MouseMotionListener {

    private static int mouseX = -1;
    private static int mouseY = -1;
    private static int mouseB = -1;

    /**
     *
     * @return
     */
    public static int getX() {
        return mouseX;
    }

    /**
     *
     * @return
     */
    public static int getY() {
        return mouseY;
    }

    /**
     *
     * @return
     */
    public static int getButton() {
        return mouseB;
    }

    /**
     *
     * @param me
     */
    @Override
    public void mouseClicked(MouseEvent me) {
    }

    /**
     *
     * @param me
     */
    @Override
    public void mousePressed(MouseEvent me) {
        mouseB = me.getButton();
    }

    /**
     *
     * @param me
     */
    @Override
    public void mouseReleased(MouseEvent me) {
        mouseB = -1;
    }

    /**
     *
     * @param me
     */
    @Override
    public void mouseEntered(MouseEvent me) {
    }

    /**
     *
     * @param me
     */
    @Override
    public void mouseExited(MouseEvent me) {
    }

    /**
     *
     * @param me
     */
    @Override
    public void mouseDragged(MouseEvent me) {
        mouseX = me.getX();
        mouseY = me.getY();
    }

    /**
     *
     * @param me
     */
    @Override
    public void mouseMoved(MouseEvent me) {
        mouseX = me.getX();
        mouseY = me.getY();
    }
}
