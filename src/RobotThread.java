import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotThread implements Runnable {
    private Robot robot;
    private volatile boolean running = true;

    public RobotThread() {
        try {
            this.robot = new Robot();
        } catch (AWTException e) {
            System.err.println("Nepodařilo se inicializovat Robota.");
        }
    }

    public void stopMacro() {
        this.running = false;
    }

    @Override
    public void run() {
        for (int i = 0; i < 16 && running; i++) {
            try {
                robot.keyPress(KeyEvent.VK_WINDOWS);
                Thread.sleep(300);
                robot.keyRelease(KeyEvent.VK_WINDOWS);
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println("Makro bylo přerušeno.");
                break;
            }
        }
    }
}
