/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hellotvxlet;

import java.util.ArrayList;
import java.util.TimerTask;

/**
 *
 * @author lorenz.adriaensen
 */
public class MijnTimerTask extends TimerTask {
    // import + implement all abstract methods

    Sprite mc;
    ArrayList levendedingen = new ArrayList();
    public boolean running=true;
    public void setMc(Sprite mc_p) {
        mc = mc_p;
    }

    public void registreer(Leefbaar l) {
        levendedingen.add(l);
    }

    public void run() {
        // System.out.println(".");
        if (running)
        {
        mc.ay++;
        if (mc.ay > 570) {
            mc.ay = 0;
        }
        mc.repaint();


        for (int i = 0; i < levendedingen.size(); i++) {
            ((Leefbaar) levendedingen.get(i)).leef();
        }
        }
    }

}