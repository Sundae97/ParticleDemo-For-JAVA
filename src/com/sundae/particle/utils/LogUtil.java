package com.sundae.particle.utils;


public class LogUtil {

    private static boolean DEBUG = true;

    public static void log(String tag, String msg){
        if(DEBUG)
            System.out.println(System.currentTimeMillis() + "  " + "[" + tag + "]" + "  " + msg);
    }

}
