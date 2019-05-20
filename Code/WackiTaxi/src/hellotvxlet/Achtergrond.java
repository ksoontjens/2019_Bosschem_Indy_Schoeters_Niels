/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hellotvxlet;

/**
 *
 * @author student
 */
public class Achtergrond extends Sprite {

    public Achtergrond(int x, int y, int x2, int y2, String imagePath) {
        super(x, y, x2, y2, imagePath);
    }

    public void leef() {
        y++;
        setXY(x, y);
        this.repaint();
    }
}
