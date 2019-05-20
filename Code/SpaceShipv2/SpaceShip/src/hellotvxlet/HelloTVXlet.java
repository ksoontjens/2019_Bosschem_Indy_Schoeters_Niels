package hellotvxlet;

//import SpaceShip.*;
import java.util.Timer;
import javax.tv.xlet.*;
import org.bluray.ui.event.HRcEvent;
import org.dvb.event.EventManager;
import org.dvb.event.UserEvent;
import org.dvb.event.UserEventListener;
import org.dvb.event.UserEventRepository;
import org.havi.ui.HScene;
import org.havi.ui.HSceneFactory;

public class HelloTVXlet implements Xlet, UserEventListener {    // add import + implement all abstract methods --^

       public static  MijnTimerTask mtt = new MijnTimerTask();
                  HScene scene =
                HSceneFactory.getInstance().getDefaultHScene();
    int autox = 720 / 2 - 118 / 2, autoy = 576 - 130 - 20;
    int tegenliggerx = 300, tegenliggery = 0;
    Auto taxi = new Auto(autox, autoy, 68, 130, "taxi.png") {
    };
    /*Auto tegenligger = new Auto(tegenliggerx, tegenliggery, 60, 130, "police.png") {
    };*/
    Achtergrond ag = new Achtergrond(0, 0, 720, 576, "ROAD.gif");
    int numOfLives = 3;
    int autot=0;
    static public int lives = 3;
    static public Achtergrond[] hearts=new Achtergrond[lives];
    
 
 
    public void initXlet(XletContext context) {

              
      
        UserEventRepository rep =
                new UserEventRepository("naam");
        rep.addAllArrowKeys();        
        EventManager manager = EventManager.getInstance();
        manager.addUserEventListener(this, rep);
        scene.add(taxi); 
        scene.add(ag);
        scene.validate();
        scene.setVisible(true);

        Timer t = new Timer();
        
        
   
        
        mtt.setMc(taxi);
        
        //mtt.registreer(tegenligger);
        
        t.scheduleAtFixedRate(mtt, 0, 10);
        
        
        Timer s = new Timer();
        
        SpawnTask sTask = new SpawnTask(this);
        
     //   sTask.spawnTegenligger();
        
        s.scheduleAtFixedRate(sTask, 0, 2000);
        CollisionDetector cd=new CollisionDetector(scene,taxi);
        mtt.registreer(cd);
    // start op 0 elke 100 ms
       
                    for(int i = 0; i<lives;i++){
             System.out.println(lives);
            hearts[i] = new Achtergrond(65*i, 20, 62, 58, "Heart.png");
            scene.add(hearts[i]);
            scene.popToFront(hearts[i]);
        } 
    }
    
    public void spawnTegenligger() 
    {
        
      

//Sprite mTegenligger, HScene mScene, int randomLane
        String filePath;
        double randomDouble = Math.random();
        randomDouble = randomDouble * 3 + 1;
        int randomInt = (int) randomDouble;
        

        int tegenliggerx = 0;
        
        switch (randomInt) 
        {
            case 1:
                tegenliggerx = 141-30;
                break;

            case 2:
                tegenliggerx = 360-30;
                break;

            case 3:
                tegenliggerx = 578-30;         
                break;
                
            default:

        }
        
        double randomDoublePath = Math.random();
        randomDoublePath = randomDoublePath * 3 + 1;
        int randomIntPath = (int) randomDoublePath;
        
        int spriteLength;
        int spriteHeight;
        
        switch (randomIntPath) 
        {
            case 1:
                filePath = "police.png";
                spriteLength = 60;
                spriteHeight = 130;
                break;

            case 2:
                filePath = "audi.png";
                spriteLength = 60;
                spriteHeight = 130;
                break;

            case 3:
                filePath = "Mini_van.png";
                spriteLength = 65;
                spriteHeight = 137;
                break;
                
            default:
                filePath = "police.png";
                spriteLength = 60;
                spriteHeight = 130;
                break;

        }

        System.out.println(tegenliggerx);
          Auto tegenligger = new Auto(tegenliggerx, tegenliggery, spriteLength, spriteHeight, filePath) ;
          scene.add(tegenligger);
          scene.popToFront(tegenligger);
mtt.registreer(tegenligger);
autot++;
System.out.println("auto's="+autot);


    }
    public void userEventReceived(UserEvent e) {
        
        int step = 20;
        if(mtt.running == true)
        {
            if(autox >= 0 + step)
            {
            if (e.getCode() == HRcEvent.VK_LEFT) {
                autox -= step;
                taxi.setXY(autox, autoy);
            }
            else{
                autox +=step;
            }
            }
            if(autox<=720-step){
            if (e.getCode() == HRcEvent.VK_RIGHT) {
                autox += step;
                taxi.setXY(autox, autoy);
            }
            else
            {
                autox-=step;
            }
            }
        taxi.repaint();
        }
        if(mtt.running == false) {
            if (e.getCode() == HRcEvent.VK_LEFT || e.getCode() == HRcEvent.VK_RIGHT) {
                lives = numOfLives; 
                for(int i = 0; i<lives;i++){
             System.out.println(lives);
            hearts[i] = new Achtergrond(65*i, 20, 62, 58, "Heart.png");
            scene.add(hearts[i]);
            scene.popToFront(hearts[i]);
        } 
                mtt.running = true;
                
            }
        }
    }

    public void startXlet() {
    }

    public void pauseXlet() {
    }

    public void destroyXlet(boolean unconditional) {
    }
}

