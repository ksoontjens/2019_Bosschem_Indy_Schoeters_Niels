/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hellotvxlet;

import java.awt.Component;
import org.havi.ui.HScene;

/**
 *
 * @author student
 */
public class CollisionDetector implements Leefbaar {

    HScene scene;
    Auto auto;
    
    public CollisionDetector(HScene scene, Auto auto) {
        this.scene = scene;
        this.auto = auto;
    }

    public void leef() {
        Component[] comp = scene.getComponents();
        for (int i = 0; i < comp.length; i++) {
            if (comp[i].getClass() == Auto.class) {
                if (comp[i] != auto) {
                    if (comp[i].getBounds().intersects(auto.getBounds())) {
                        System.out.println("collision " + comp[i].getBounds());
                        scene.remove(comp[i]);
                        
                        scene.remove(HelloTVXlet.hearts[HelloTVXlet.lives-1]);
                        HelloTVXlet.lives--;
                        if (HelloTVXlet.lives==0) HelloTVXlet.mtt.running=false;
                    }
                }
            }
        }
    }
}
