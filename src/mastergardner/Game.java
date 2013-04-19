/*
 *
 *
 */
package mastergardner;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;
import mastergardner.graphics.Screen;
import mastergardner.input.Keyboard;
import mastergardner.level.Level;
import mastergardner.level.RandomLevel;

/**
 *
 * @author Christian
 */
public class Game extends Canvas implements Runnable{
    private static final long serialVersionUID = 1L;
    
    
    
    public static int width = 300;
    public static int height = width / 16 * 9;
    public static int scale = 3;
    public static String title = "MasterGardner";
    
    private Thread thread;
    private JFrame frame;
    private Keyboard key;
    private Level level;
    
    private boolean running = false;
    
    private Screen screen;
    
    private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
    
    
    public Game() {
        Dimension size;
        size = new Dimension(width * scale, height * scale);
        setPreferredSize(size);
        
        screen = new Screen(width, height);
        frame = new JFrame();
        key = new Keyboard();
        level = new RandomLevel(64, 64);
       
        addKeyListener(key);
        
    }
    
    
    public synchronized void start() {
        running = true;
        thread = new Thread(this, "Display");
        thread.start();
    }
    
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
    public void run(){
        
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
    
    int x = 0, y = 0, speed;
    
    public void update() {
        key.update();
        speed = 0;
        if (key.alt) speed = 2;
        
        if (key.up)     y -= 1 + speed;
        if (key.down)   y += 1 + speed;
        if (key.left)   x -= 1 + speed;
        if (key.right)  x += 1 + speed;
    }
    
    
    public void render() {
        BufferStrategy bs;
        bs = getBufferStrategy();
        
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
        
        screen.clear();
        level.render(x, y, screen);
        
        //copy pixels from Screen class to BufferedImage array
        System.arraycopy(screen.pixels, 0, pixels, 0, pixels.length);
        
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        g.dispose();
        bs.show();
    }
    
    
    
    
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
