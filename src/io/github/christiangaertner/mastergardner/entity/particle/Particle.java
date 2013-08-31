package io.github.christiangaertner.mastergardner.entity.particle;

import io.github.christiangaertner.mastergardner.entity.Entity;
import io.github.christiangaertner.mastergardner.graphics.Renderer;
import io.github.christiangaertner.mastergardner.graphics.Sprite;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian
 */
public class Particle extends Entity {

    protected List<Particle> particles = new ArrayList<Particle>();
    protected int life;
    protected double xx, yy, xa, ya;

    public Particle(int x, int y, int lifetime) {
        this.x = x;
        this.y = y;
        sprite = Sprite.particle_basic;

        this.xa = random.nextGaussian();
        this.ya = random.nextGaussian();
    }

    public Particle(int x, int y, int lifetime, int amount) {
        this(x, y, lifetime);
        for (int i = 0; i < amount; i++) {
            particles.add(new Particle(x, y, lifetime));
        }
        particles.add(this);
    }

    @Override
    public void update() {
        this.xx += xa;
        this.yy += ya;
    }

    @Override
    public void render(Renderer renderer) {
        renderer.renderSprite((int) xx, (int) yy, sprite, true);
    }
}
