package com.sundae.particle.factory;

import java.util.Random;

public class ParticleFactory {

    private static Random random = new Random();
    private static float PARTICLE_RUNNING_MAX_SPEED = 1.f;

    public static ParticlePoint getRandomParticle(int parentWidth, int parentHeight, int radius, int color, boolean randomRadius){
        int x = random.nextInt(parentWidth);
        int y = random.nextInt(parentHeight);
        int angle = random.nextInt(360);
        float speed = (random.nextFloat() + 0.1f) * PARTICLE_RUNNING_MAX_SPEED;

        if(randomRadius){
            radius = random.nextInt(radius - 1) + 2;
        }

        if(x - radius < 0) {
            x = radius;
        }else if(x + radius > parentWidth){
            x = parentWidth - radius;
        }

        if(y - radius < 0){
            y = radius;
        }else if(y + radius > parentHeight){
            y =parentHeight - radius;
        }

        return new ParticlePoint(x, y, radius, color, angle, speed);
    }

    public static void doParticleRun(int parentWidth, int parentHeight, ParticlePoint particlePoint){
        double nextX = Math.cos(toRadian(particlePoint.runningAngle)) * particlePoint.runningSpeed;
        double nextY = Math.sin(toRadian(particlePoint.runningAngle)) * particlePoint.runningSpeed;
        particlePoint.x += nextX;
        particlePoint.y -= nextY;

        //TODO 反射角度计算
        if(particlePoint.x <= 0){
            particlePoint.runningAngle = 180 - particlePoint.runningAngle;
        } else if(particlePoint.x >= parentWidth){
            particlePoint.runningAngle = 180 - particlePoint.runningAngle;
        }else if(particlePoint.y <= 0){
            particlePoint.runningAngle = 360 - particlePoint.runningAngle;
        }else if(particlePoint.y >= parentHeight){
            particlePoint.runningAngle = 360 - particlePoint.runningAngle;
        }
    }

    private static double toRadian(double angle){
        return angle / 180 * Math.PI;
    }

}
