/*
 * Load all sprites
 *
 */
package mastergardner.graphics;

/**
 *
 * @author Christian
 */
public class Sprite {
    
    /**
     * Size of the sprite in pixels
     */
    public final int SIZE;
    private int x, y;
    /**
     *
     */
    public int[] pixels;
    private SpriteSheet sheet;
    
    // Sprites, make sure to leave size at 16 or change it at mastergardner.level.Level, in the x0, etc. setting.
    /**
     *
     */
    public static Sprite voidTile = new Sprite(16, 0x1B87E0); //SIZE, COLOR    
    
    /**
     *
     */
    public static Sprite grass = new Sprite(16, 0, 1, SpriteSheet.tiles);
    /**
     *
     */
    public static Sprite grass_light = new Sprite(16, 0, 2, SpriteSheet.tiles);
    /**
     *
     */
    public static Sprite grass_dark = new Sprite(16, 0, 3, SpriteSheet.tiles);
    /**
     *
     */
    public static Sprite grass_flat = new Sprite(16, 0, 4, SpriteSheet.tiles);
    /**
     *
     */
    public static Sprite grass_flat_dark = new Sprite(16, 0, 5, SpriteSheet.tiles);
    
    
    /**
     *
     */
    public static Sprite rock = new Sprite(16, 1, 0, SpriteSheet.tiles);
    /**
     *
     */
    public static Sprite rock_nature = new Sprite(16, 1, 1, SpriteSheet.tiles);
    /**
     *
     */
    public static Sprite rock_wall = new Sprite(16, 1, 2, SpriteSheet.tiles);
    /**
     *
     */
    public static Sprite rock_dark = new Sprite(16, 1, 3, SpriteSheet.tiles);
    
    
    /**
     *
     */
    public static Sprite bricks = new Sprite(16, 2, 0, SpriteSheet.tiles);
    /**
     *
     */
    public static Sprite bricks_yellow = new Sprite(16, 2, 1, SpriteSheet.tiles);
    /**
     *
     */
    public static Sprite bricks_blue = new Sprite(16, 2, 2, SpriteSheet.tiles);
    /**
     *
     */
    public static Sprite bricks_mix = new Sprite(16, 2, 3, SpriteSheet.tiles);
    /**
     *
     */
    public static Sprite bricks_brown = new Sprite(16, 2, 4, SpriteSheet.tiles);
    
    
    /**
     *
     */
    public static Sprite hedge = new Sprite(16, 3, 0, SpriteSheet.tiles);
    /**
     *
     */
    public static Sprite hedge_yellow = new Sprite(16, 3, 1, SpriteSheet.tiles);
    
    /**
     *
     */
    public static Sprite wood_birch = new Sprite(16, 4, 0, SpriteSheet.tiles);
    /**
     *
     */
    public static Sprite wood_red = new Sprite(16, 4, 1, SpriteSheet.tiles);
    /**
     *
     */
    public static Sprite wood_oak = new Sprite(16, 4, 2, SpriteSheet.tiles);

    
    
    /**
     *
     */
    public static Sprite water_light = new Sprite(16, 5, 0, SpriteSheet.tiles);
    /**
     *
     */
    public static Sprite water_dark = new Sprite(16, 5, 1, SpriteSheet.tiles);
    /**
     *
     */
    public static Sprite water_dark_waved = new Sprite(16, 5, 2, SpriteSheet.tiles);
    
    /**
     *
     */
    public static Sprite planks = new Sprite(16, 6, 0, SpriteSheet.tiles);
    
    
    
    
    //ENTITIES
    /**
     *
     */
    public static Sprite projectiles_king_basic = new Sprite(16, 0, 0, SpriteSheet.projectiles_king);
    
    
        
    //PLAYER
    /**
     *
     */
    public static Sprite player_forward = new Sprite(32, 0, 5, SpriteSheet.tiles);
    /**
     *
     */
    public static Sprite player_back = new Sprite(32, 2, 5, SpriteSheet.tiles);
    /**
     *
     */
    public static Sprite player_side = new Sprite(32, 1, 5, SpriteSheet.tiles);
    
    /**
     *
     */
    public static Sprite player_forward_1 = new Sprite(32, 0, 6, SpriteSheet.tiles);
    /**
     *
     */
    public static Sprite player_forward_2 = new Sprite(32, 0, 7, SpriteSheet.tiles);
    
    
    /**
     *
     */
    public static Sprite player_side_1 = new Sprite(32, 1, 6, SpriteSheet.tiles);
    /**
     *
     */
    public static Sprite player_side_2 = new Sprite(32, 1, 7, SpriteSheet.tiles);
    
    
    /**
     *
     */
    public static Sprite player_back_1 = new Sprite(32, 2, 6, SpriteSheet.tiles);
    /**
     *
     */
    public static Sprite player_back_2 = new Sprite(32, 2, 7, SpriteSheet.tiles);
    
    /**
     * Constructor for accessing tiles from the spritesheet
     * @param size
     * @param x
     * @param y
     * @param sheet
     */
    public Sprite(int size, int x, int y, SpriteSheet sheet) {
        SIZE = size;
        pixels = new int[SIZE * SIZE];
        this.x = x * SIZE;
        this.y = y * SIZE;
        this.sheet = sheet;
        load();
    }
    
    /**
     * Alternative Constructor for generating pure colored tiles
     * @param size
     * @param color
     */
    public Sprite(int size, int color) {
        SIZE = size;
        pixels = new int[SIZE * SIZE];
        setColor(color);
    }
    
    private void load() {
        for (int Ly = 0; Ly < SIZE; Ly++) {
            for (int Lx = 0; Lx < SIZE; Lx++) {
                pixels[Lx + Ly * SIZE] = sheet.pixels[( Lx + this.x) + (Ly + this.y) * sheet.SIZE];
            }
        }
    }

    private void setColor(int color) {
        for (int i = 0; i < SIZE*SIZE; i++) {
            pixels[i] = color;
        }
    }
}
