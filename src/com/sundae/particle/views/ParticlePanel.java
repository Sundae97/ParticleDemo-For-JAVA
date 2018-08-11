package com.sundae.particle.views;

import com.sundae.particle.factory.ParticleFactory;
import com.sundae.particle.factory.ParticlePoint;
import com.sundae.particle.utils.LogUtil;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ParticlePanel extends JPanel {

    private static int RADIUS_VALUE = 5;
    private static int DIAMETER_VALUE = RADIUS_VALUE * 2;

    private ArrayList<ParticlePoint> particlePoints = null;
    private boolean isFrist = true;

    public ParticlePanel() {
    }

    private void init(){
        particlePoints = new ArrayList<>();
        this.setVisible(true);
        this.setBackground(Color.GRAY);
        for(int i = 0 ; i < 180; i++){
            particlePoints.add(ParticleFactory.getRandomParticle(getSize().width, getSize().height, DIAMETER_VALUE, 0xcccccc));
        }
        isFrist = false;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        if(isFrist)
            init();

        for(ParticlePoint particlePoint : particlePoints){
            g.setColor(new Color(particlePoint.color));

            g.fillOval((int)particlePoint.x, (int)particlePoint.y, DIAMETER_VALUE, DIAMETER_VALUE);
            ParticleFactory.doParticleRun(getWidth(), getHeight(), particlePoint);

        }
//        LogUtil.log("", "paint  " + particlePoint.runningAngle + "   " + particlePoint.x + "   " + particlePoint.y);
    }
}
