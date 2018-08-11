package com.sundae.particle.factory;

public class ParticlePoint {
    public double x;
    public double y;
    public int radius;
    public int color;
    public int runningAngle;

    public ParticlePoint() {
    }

    public ParticlePoint(double x, double y, int radius, int color, int runningAngle) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
        this.runningAngle = runningAngle;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getRunningAngle() {
        return runningAngle;
    }

    public void setRunningAngle(int runningAngle) {
        this.runningAngle = runningAngle;
    }
}
