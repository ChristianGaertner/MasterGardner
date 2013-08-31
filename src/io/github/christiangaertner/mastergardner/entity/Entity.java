/*
 * Abstract for entities
 * 
 */
package io.github.christiangaertner.mastergardner.entity;

import io.github.christiangaertner.mastergardner.graphics.Renderer;
import io.github.christiangaertner.mastergardner.graphics.Sprite;
import io.github.christiangaertner.mastergardner.level.Level;
import java.util.Random;

/**
 *
 * @author Christian
 */
public abstract class Entity {

    /**
     * Position of the Entity
     */
    public int x, y;
    protected boolean removed = false;
    /**
     *
     */
    protected Level level;
    /**
     * 
     */
    protected Sprite sprite;
    /**
     *
     */
    protected static final Random random = new Random();

    /**
     *
     */
    public void update() {
    }

    /**
     *
     * @param screen
     */
    public void render(Renderer screen) {
    }

    /**
     *
     */
    public void remove() {
        removed = true;
    }

    /**
     *
     * @return
     */
    public boolean isRemoved() {
        return removed;
    }

    /**
     *
     * @param level
     */
    public void init(Level level) {
        this.level = level;
    }
}
