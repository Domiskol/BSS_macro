import java.awt.*;
import java.awt.event.KeyEvent;

public class MacroRobot {

    private Robot robot;

    public MacroRobot() {
        try {
            this.robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public void walkForward(int duration) {
        try {
            robot.keyPress(KeyEvent.VK_W);
            Thread.sleep(duration);
            robot.keyRelease(KeyEvent.VK_W);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    public void pressKey(int keyCode, int duration) {
        try {
            robot.keyPress(keyCode);
            Thread.sleep(duration);
            robot.keyRelease(keyCode);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    public void click() {
        robot.mousePress(java.awt.event.InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(java.awt.event.InputEvent.BUTTON1_DOWN_MASK);
    }

}
