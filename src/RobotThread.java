import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotThread implements Runnable {
    private MacroRobot robot;
    private volatile boolean running = true;
    private BearQuest currentBear;

    public RobotThread() {

        this.robot = new MacroRobot();
        this.currentBear = new PolarBearQuest();

    }

    public void stopMacro() {
        this.running = false;
    }

    @Override
    public void run() {

        while (running) {

            if (!running) break;
            currentBear.walkToBear(robot);
            if (!running) break;
            currentBear.claimQuest(robot);

            if (!running) break;
            currentBear.doQuestLogic(robot);


        }

    }
}
