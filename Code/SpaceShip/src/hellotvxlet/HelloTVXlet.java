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


    int autox = 720 / 2 - 118 / 2, autoy = 576 - 224 - 20;
    int tegenliggerx = 300, tegenliggery = 0;
    Auto auto = new Auto(autox, autoy, 118, 224, "taxi.png") {
    };
    Auto tegenligger = new Auto(tegenliggerx, tegenliggery, 98, 214, "police.png") {
    };
    Auto ag = new Auto(0, 0, 720, 576, "sterren.png");

    public void initXlet(XletContext context) {

        HScene scene =
                HSceneFactory.getInstance().getDefaultHScene();
        UserEventRepository rep =
                new UserEventRepository("naam");
        rep.addAllArrowKeys();

        EventManager manager = EventManager.getInstance();
        manager.addUserEventListener(this, rep);
        scene.add(auto);
        scene.add(tegenligger);
        scene.add(ag);
        scene.validate();
        scene.setVisible(true);

        Timer t = new Timer();
        MijnTimerTask mtt = new MijnTimerTask();
        mtt.setMc(auto);
        mtt.registreer(tegenligger);
        t.scheduleAtFixedRate(mtt, 0, 5);
    // start op 0 elke 100 ms
    }

    public void userEventReceived(UserEvent e) {
        if (e.getCode() == HRcEvent.VK_LEFT) {
            autox -= 20;
            auto.setXY(autox, autoy);
        }
        if (e.getCode() == HRcEvent.VK_RIGHT) {
            autox += 20;
            auto.setXY(autox, autoy);
        }
        auto.repaint();
    }

    public void startXlet() {
    }

    public void pauseXlet() {
    }

    public void destroyXlet(boolean unconditional) {
    }
}

