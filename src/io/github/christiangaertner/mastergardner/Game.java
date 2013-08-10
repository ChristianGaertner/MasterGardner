package io.github.christiangaertner.mastergardner;

import io.github.christiangaertner.mastergardner.entity.npc.Player;
import io.github.christiangaertner.mastergardner.graphics.Screen;
import io.github.christiangaertner.mastergardner.input.Keyboard;
import io.github.christiangaertner.mastergardner.input.Mouse;
import io.github.christiangaertner.mastergardner.level.Level;
import io.github.christiangaertner.mastergardner.level.TileCoordinate;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;

/**
 *
 * @author Christian
 */
public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;
    /**
     *
     */
    public static int width = 400;
    /**
     *
     */
    public static int height = width / 16 * 9;
    /**
     *
     */
    public static int scale = 3;
    /**
     *
     */
    public static String title = "MasterGardner";
    private Thread thread;
    private JFrame frame;
    private Keyboard key;
    private Mouse mouse;
    private Level level;
    private Player player;
    private boolean running = false;
    private Screen screen;
    private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

    /**
     *
     */
    public Game() {
        Dimension size;
        size = new Dimension(width * scale, height * scale);
        setPreferredSize(size);

        screen = new Screen(width, height);
        frame = new JFrame();
        key = new Keyboard();
        mouse = new Mouse();
        level = Level.spawn;
        TileCoordinate playerSpawn = new TileCoordinate(20, 65);
        player = new Player(playerSpawn.x(), playerSpawn.y(), key);
        player.init(level);

        addKeyListener(key);
        addMouseListener(mouse);
        addMouseMotionListener(mouse);

    }

    /**
     *
     * @return
     */
    public static int getWindowWidth() {
        return width * scale;
    }

    /**
     *
     * @return
     */
    public static int getWindowHeight() {
        return height * scale;
    }

    /**
     *
     */
    public synchronized void start() {
        running = true;
        thread = new Thread(this, "Display");
        thread.start();
    }

    /**
     *
     */
    public synchronized void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
        }

    }

    /**
     *
     */
    @Override
    public void run() {

        //timer
        long lastTime;
        lastTime = System.nanoTime();

        long timer;
        timer = System.currentTimeMillis();

        final double ns;
        ns = 1000000000.0 / 60.0;

        double delta;
        delta = 0;

        //ups & fps counter
        int frames;
        frames = 0;

        int updates;
        updates = 0;

        requestFocus(); //focus the canvas
        while (running) {
            long now;
            now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            //update 60 times per second   
            while (delta >= 1) {
                update();
                updates++;
                delta--;
            }
            render();
            frames++;

            if (System.currentTimeMillis() - timer >= 1000) {
                timer += 1000;
                // System.out.println(updates + " ups, " + frames + " fps");
                frame.setTitle(title + "  |  " + updates + " ups, " + frames + " fps");
                updates = 0;
                frames = 0;
            }

        }
        stop();

    }

    /**
     *
     */
    public void update() {
        player.update();
        level.update();
    }

    /**
     *
     */
    public void render() {
        BufferStrategy bs;
        bs = getBufferStrategy();

        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        screen.clear();

        //setting offsets...
        int xScroll;
        xScroll = player.x - screen.width / 2;
        int yScroll;
        yScroll = player.y - screen.height / 2;

        //rendering...
        level.render(xScroll, yScroll, screen);
        player.render(screen);
        
//        screen.renderSprite(300, 11, new Sprite(80, 200, 0xff00ff), true);

        //copy pixels from Screen class to BufferedImage array
        System.arraycopy(screen.pixels, 0, pixels, 0, pixels.length);

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        
        g.setColor(Color.WHITE);
        g.setFont(new Font("Verdana", 0, 50));
        
        g.dispose();
        bs.show();
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Game game = new Game();

        //JFrame stuff
        game.frame.setResizable(false);
        game.frame.setTitle(Game.title);
        game.frame.add(game);
        game.frame.pack();
        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.frame.setLocationRelativeTo(null);
        game.frame.setVisible(true);


        game.start();

    }
}
