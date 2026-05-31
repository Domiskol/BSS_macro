import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotThread implements Runnable {

    private MacroRobot robot;
    private volatile boolean running = true; // Volatile flag ensuring thread-safe status updates across threads
    private BearQuest currentBear;
    public RobotThread() {
        this.robot = new MacroRobot();
        this.currentBear = new PolarBearQuest(); // Current quest logic targeting Polar Bear
    }
     // Safely flags the running macro loop to terminate.

    public void stopMacro() {
        this.running = false;
    }








    @Override
    public void run() {
        // Main macro execution loop
        while (running) {
            // Always check macro state before executing the next major routine
            if (!running) break;
            currentBear.walkToBear(robot);

            if (!running) break;
            currentBear.claimQuest(robot);

            if (!running) break;
            currentBear.doQuestLogic(robot);

            // Standard rest period between complete execution cycles
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Thread was forcefully interrupted via F5, exit immediately
                Thread.currentThread().interrupt();
                break;
            }
        }

    }
}
