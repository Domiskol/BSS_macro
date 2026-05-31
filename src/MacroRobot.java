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
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            robot.keyRelease(KeyEvent.VK_W);
        }

    }
    public void walkD(int duration) {
        try {
            robot.keyPress(KeyEvent.VK_D);
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            robot.keyRelease(KeyEvent.VK_D);
        }
    }
    public void walkA(int duration) {
        try {
            robot.keyPress(KeyEvent.VK_A);
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            robot.keyRelease(KeyEvent.VK_A);
        }
    }
    public void walkBackwards(int duration) {
        try {
            robot.keyPress(KeyEvent.VK_S);
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            robot.keyRelease(KeyEvent.VK_S);
        }
    }
    // simulates any keypress
    public void pressKey(int keyCode, int duration) {
        try {
            robot.keyPress(keyCode);
            Thread.sleep(duration);
            robot.keyRelease(keyCode);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    // simulates left click
    public void click() {
        robot.mousePress(java.awt.event.InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(java.awt.event.InputEvent.BUTTON1_DOWN_MASK);
        try{
            Thread.sleep(200);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
            return;
        }
    }


    public void moveMouseTo(int x, int y) {
        robot.mouseMove(x, y);
    }

}
