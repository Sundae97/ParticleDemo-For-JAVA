package com.sundae.particle.utils;

public class PointUtil {

    public static double getDistance(double x1, double y1, double x2, double y2){
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

}
