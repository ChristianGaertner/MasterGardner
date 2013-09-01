package io.github.christiangaertner.mastergardner.entity.particle;

import io.github.christiangaertner.mastergardner.entity.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Christian
 */
public class ParticleEmitter {

    protected static final Random RANDOM = new Random();

    public enum ParticleType {
        BASIC
    }
    protected List<Entity> particles = new ArrayList<Entity>();

    public ParticleEmitter(ParticleType type, int x, int y, int lifetime, int amount) {
        for (int i = 0; i < amount; i++) {
            switch (type) {
                default:
                /**
                 * Falls through *
                 */
                case BASIC:
                    particles.add(new Particle(x, y, RANDOM.nextInt(lifetime) + lifetime / 2));
            }
        }
    }

    public List<Entity> getParticles() {
        return particles;
    }
}
