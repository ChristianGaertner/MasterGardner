/*
 * Level Generation
 * and Level Updating
 */
package io.github.christiangaertner.mastergardner.level;

import io.github.christiangaertner.mastergardner.entity.Entity;
import io.github.christiangaertner.mastergardner.entity.projectile.Projectile;
import io.github.christiangaertner.mastergardner.graphics.Screen;
import io.github.christiangaertner.mastergardner.level.tile.Tile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian
 */
public class Level {

    /**
     * Width & Height of the Map
     */
    protected int width, height;
    /**
     *
     */
    protected int[] tilesInt;
    /**
     *
     */
    protected int[] tiles;
    private List<Entity> entities = new ArrayList<Entity>();
    private List<Projectile> projectiles = new ArrayList<Projectile>();
    /**
     * The spawn level 40 * 75
     */
    public static Level spawn = new SpawnLevel("/levels/spawn.png");

    /**
     *
     * @param width
     * @param height
     */
    public Level(int width, int height) {
        this.width = width;
        this.height = height;
        tilesInt = new int[width * height];
        generateLevel();
    }

    /**
     *
     * @param path
     */
    public Level(String path) {
        loadLevel(path);
        generateLevel();
    }

    public List<Projectile> getProjectiles() {
        return projectiles;
    }

    /**
     *
     */
    protected void generateLevel() {
    }

    /**
     *
     * @param path
     */
    protected void loadLevel(String path) {
    }

    /**
     * Update all entities and projectiles
     */
    public void update() {
        for (int i = 0; i < entities.size(); i++) {
            entities.get(i).update();
        }
        for (int i = 0; i < projectiles.size(); i++) {
            projectiles.get(i).update();
        }

    }

    private void time() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Renders the level
     *
     * @param xScroll
     * @param yScroll
     * @param screen
     */
    public void render(int xScroll, int yScroll, Screen screen) {
        screen.setOffset(xScroll, yScroll);

        int x0, y0, x1, y1;
        x0 = xScroll >> 4;
        x1 = (xScroll + screen.width + 16) >> 4; //change to Sprite.SIZE in the future
        y0 = yScroll >> 4;
        y1 = (yScroll + screen.height + 16) >> 4; //change to Sprite.SIZE in the future

        for (int y = y0; y < y1; y++) {
            for (int x = x0; x < x1; x++) {
                getTile(x, y).render(x, y, screen); //just for random level gen             
            }

        }
        for (int i = 0; i < entities.size(); i++) {
            entities.get(i).render(screen);
        }
        for (int i = 0; i < projectiles.size(); i++) {
            projectiles.get(i).render(screen);
        }
    }

    /**
     * Add an entity to the level
     *
     * @param entity
     */
    public void add(Entity entity) {
        entities.add(entity);
    }

    /**
     * Add a Projectile to the level
     *
     * @param p
     */
    public void addProjectile(Projectile p) {
        projectiles.add(p);
    }

    /**
     * Returns the tile for the given coordinates
     *
     * @param x
     * @param y
     * @return Tile
     */
    public Tile getTile(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return Tile.voidTile; //out of boundarys preventer
        }
        if (tiles[x + y * width] == Tile.planks.color_code) {
            return Tile.planks;
        }
        if (tiles[x + y * width] == Tile.bricks_mix.color_code) {
            return Tile.bricks_mix;
        }
        if (tiles[x + y * width] == Tile.bricks.color_code) {
            return Tile.bricks;
        }
        if (tiles[x + y * width] == Tile.grass.color_code) {
            return Tile.grass;
        }

        return Tile.voidTile;
    }
}