/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hellotvxlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import org.havi.ui.HComponent;

public abstract class Sprite extends HComponent implements Leefbaar {

    Image autoSprite;
    int ay = 0;
    //   Image achtergrond;
    int x;
    int y;
//C:\Program Files\TechnoTrend\TT-MHP-Browser\fileio\dsmcc\0.0.3
//C:\mhpemu\TT-MHP-Browser\fileio\dsmcc\0.0.3

    public Sprite(int m_X, int m_Y, int m_X2, int m_Y2, String imagePath) {
        this.setBounds(m_X, m_Y, m_X2, m_Y2);
        this.x=m_X;
        this.y=m_Y;
        autoSprite = this.getToolkit().getImage(imagePath);
        //  achtergrond=this.getToolkit().getImage("sterren.png");
        MediaTracker mt = new MediaTracker(this);
        mt.addImage(autoSprite, 1);
        //mt.addImage(achtergrond,2);
        try {
            mt.waitForAll();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void setXY(int x, int y) {
        this.setBounds(x, y, autoSprite.getWidth(this), autoSprite.getHeight(this));
    }

    public void paint(Graphics g) {
        //  g.drawImage(achtergrond, 0, ay, this);
        //    g.drawImage(achtergrond, 0, ay-570, this);
        g.drawImage(autoSprite, 0, 0, this);

    }

    public abstract void leef();
}
    
