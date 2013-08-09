/*
 * Tile Class
 *
 */
package io.github.christiangaertner.mastergardner.level.tile;

import io.github.christiangaertner.mastergardner.graphics.Screen;
import io.github.christiangaertner.mastergardner.graphics.Sprite;

/**
 *
 * @author Christian
 */
public class Tile {
    
    /**
     *
     */
    public int x,
    /**
     *
     */
    y;
    
    /**
     * The Hex-Demcial represantation of the color used in the level-sheets
     */
    public int color_code;
    
    /**
     * The sprite to use for the tile, object declaration in the constructor
     */
    public Sprite sprite;
    
    //-------------------------TILES-----------------
    
    /**
     * Basic Grass - not solid
     */
    public static Tile grass = new GrassTile(Sprite.grass);
    
    /**
     * Light Grass - not solid
     */
    public static Tile grass_light = new LightGrassTile(Sprite.grass_light);
    
    /**
     * Dark Grass - not solid
     */
    public static Tile grass_dark = new DarkGrassTile(Sprite.grass_dark);
    
    /**
     * Flat Grass - not solid
     */
    public static Tile grass_flat = new FlatGrassTile(Sprite.grass_flat);
    
    /**
     * Dark Flat Grass - not solid
     */
    public static Tile grass_flat_dark = new DarkFlatGrassTile(Sprite.grass_flat_dark);    
    
    /**
     * Rock aka CobbleStone - solid
     */
    public static Tile rock = new RockTile(Sprite.rock);
    
    /**
     * Rock aka CobbleStone with vines - solid
     */
    public static Tile rock_nature = new NatureRockTile(Sprite.rock_nature);
    
    /**
     * Wall of Rock aka CobbleStone - solid
     */
    public static Tile rock_wall = new WallRockTile(Sprite.rock_wall);
    
    /**
     * Dark Rock aka CobbleStone - solid
     */
    public static Tile rock_dark = new DarkRockTile(Sprite.rock_dark);
    
    /**
     * Normal bricks - solid
     */
    public static Tile bricks = new BricksTile(Sprite.bricks);
    
    /**
     * Yellow Bricks - solid
     */
    public static Tile bricks_yellow = new YellowBricksTile(Sprite.bricks_yellow);  
    
    /**
     * Blue Bricks - solid
     */
    public static Tile bricks_blue = new BlueBricksTile(Sprite.bricks_blue);
    
    /**
     * Mixed colored Bricks - solid
     */
    public static Tile bricks_mix = new MixBricksTile(Sprite.bricks_mix);
    
    /**
     * Brown Bricks - solid
     */
    public static Tile bricks_brown = new BrownBricksTile(Sprite.bricks_brown);
    
    /**
     * Hedge - solid / breakable
     */
    public static Tile hedge = new HedgeTile(Sprite.hedge);
    
    /**
     * Yellow Hedge - solid / breakable
     */
    public static Tile hedge_yellow = new YellowHedgeTile(Sprite.hedge_yellow);
    
    /**
     * Birch wood - solid
     */
    public static Tile wood_birch = new BirchWoodTile(Sprite.wood_birch);
    
    /**
     * Red wood - solid
     */
    public static Tile wood_red = new RedWoodTile(Sprite.wood_red);
    
    /**
     * Oak Wood - solid
     */
    public static Tile wood_oak = new OakWoodTile(Sprite.wood_oak);
    
    /**
     * Light water - solid
     */
    public static Tile water_light = new LightWaterTile(Sprite.water_light);
    
    /**
     * Light water - solid
     */
    public static Tile water_dark = new DarkWaterTile(Sprite.water_dark);
    
    /**
     * Light water - solid
     */
    public static Tile water_dark_waved = new DarkWavedWaterTile(Sprite.water_dark_waved);
    
    
    /**
     *
     */
    public static Tile planks = new PlanksTile(Sprite.planks);
    
    /**
     * Void Tile - not solid
     */
    public static Tile voidTile = new VoidTile(Sprite.voidTile);
    
    //-------------------------TILES-----------------//END
    
    /**
     *
     * @param sprite
     */
    public Tile(Sprite sprite) {
        this.color_code = 0;
        this.sprite = sprite;
    }
    
    /**
     *
     * @param x
     * @param y
     * @param screen
     */
    public void render(int x, int y, Screen screen) {
    }
    
    /**
     *
     * @return boolean
     */
    public boolean solid() {
        return false;
    }
}
