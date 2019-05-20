/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hellotvxlet;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;

/**
 *
 * @author lorenz.adriaensen
 */
public class SpawnTask extends TimerTask {
    // import + implement all abstract methods
    
    HelloTVXlet ht;
    
    public SpawnTask(HelloTVXlet ht)
    {
        this.ht=ht;
    }
    public void run(){
        if(HelloTVXlet.mtt.running){
        ht.spawnTegenligger();
        }
        }
    

}