package com.sundae.particle.views;

import com.sundae.particle.factory.ParticleFactory;
import com.sundae.particle.factory.ParticlePoint;
import com.sundae.particle.utils.LogUtil;
import com.sundae.particle.utils.PointUtil;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ParticlePanel extends JPanel {

    private static int RADIUS_VALUE = 4;

    private static int PARTICLE_COUNT = 150;
    private static int LINE_MAX_LENGTH = 100;

    private static int ALPHA_OFFSET = 0;
    private static float LINE_WIDTH = 0.2f;

    private static BasicStroke basicStroke = new BasicStroke(LINE_WIDTH);

    private ArrayList<ParticlePoint> particlePoints = null;
    private boolean isFrist = true;

    public ParticlePanel() {
    }

    private void init(){
        particlePoints = new ArrayList<>();
        this.setVisible(true);
        this.setBackground(new Color(0x1a222c));
        for(int i = 0 ; i < PARTICLE_COUNT; i++){
            particlePoints.add(ParticleFactory.getRandomParticle(getSize().width, getSize().height, RADIUS_VALUE, 0xcccccc, true));
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

            g.fillOval((int)particlePoint.x, (int)particlePoint.y, particlePoint.radius *2, particlePoint.radius *2);
            ParticleFactory.doParticleRun(getWidth(), getHeight(), particlePoint);

            for (ParticlePoint p : particlePoints){
                if(particlePoint == p)
                    continue;

                double distance = PointUtil.getDistance(p.x, p.y, particlePoint.x, particlePoint.y);
                if(distance <= LINE_MAX_LENGTH){
                    int alpha = (int) ((1 - (distance / LINE_MAX_LENGTH)) * 500);
                    alpha += ALPHA_OFFSET;
                    alpha = alpha >= 255 ? 255 : alpha;
                    g.setColor(new Color(255,255,255, alpha));
                    ((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    ((Graphics2D)g).setStroke(basicStroke);
                    g.drawLine((int) p.x + p.radius, (int) p.y + p.radius,
                            (int) particlePoint.x + particlePoint.radius, (int) particlePoint.y + particlePoint.radius);
                }
            }

        }
//        LogUtil.log("", "paint  " + particlePoint.runningAngle + "   " + particlePoint.x + "   " + particlePoint.y);
    }
}
