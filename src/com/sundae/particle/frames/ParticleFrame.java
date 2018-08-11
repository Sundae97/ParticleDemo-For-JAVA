package com.sundae.particle.frames;

import com.sundae.particle.utils.LogUtil;
import com.sundae.particle.views.ParticlePanel;

import javax.swing.*;
import java.awt.*;

public class ParticleFrame extends JFrame {

    private ParticlePanel particlePanel = null;
    private boolean running = false;

    private static int FRAME_SPEED = 20;

    public ParticleFrame(){
        this.setVisible(true);
        this.setSize(700,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        particlePanel = new ParticlePanel();
        this.add(particlePanel);
        start();
    }

    public void start(){
        running = true;
        paintThread.start();
    }

    public void stop(){
        running = false;
    }

    private Thread paintThread = new Thread(new Runnable() {
        @Override
        public void run() {
            while (running){
                if(particlePanel != null){
                    particlePanel.repaint();
                }
                try {
                    Thread.sleep(FRAME_SPEED);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            LogUtil.log("PaintThread", "thread end");
        }
    });

}