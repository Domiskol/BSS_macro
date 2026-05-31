import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import javax.swing.JFrame;

public class GlobalKeyHandler implements NativeKeyListener{

    private JFrame frame;
    private Thread sThread;
    private RobotThread currentTask;
    private java.awt.Robot emergencyRobot;

    public GlobalKeyHandler(JFrame frame) {
        this.frame = frame;
        try {

            this.emergencyRobot = new java.awt.Robot();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        if (e.getKeyCode() == NativeKeyEvent.VC_F4) {
            if (frame.isVisible()) {
                frame.setVisible(false);
            }

            try {
                Thread.sleep(600);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            if (sThread == null || !sThread.isAlive()) {
                currentTask = new RobotThread();
                sThread = new Thread(currentTask);
                sThread.start();
            }
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_F5){

            if (currentTask != null) {
                currentTask.stopMacro();
            }
            if (sThread != null && sThread.isAlive()) {
                sThread.interrupt();
            }

            if (emergencyRobot != null) {
                emergencyRobot.keyRelease(java.awt.event.KeyEvent.VK_W);
                emergencyRobot.keyRelease(java.awt.event.KeyEvent.VK_A);
                emergencyRobot.keyRelease(java.awt.event.KeyEvent.VK_S);
                emergencyRobot.keyRelease(java.awt.event.KeyEvent.VK_D);
            }

            if (!frame.isVisible()){
                frame.setVisible(true);
            }
        }
    }

    public static void start(JFrame frame) {
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            System.err.println("Could not register native hook.");
            return;
        }

        GlobalScreen.addNativeKeyListener(new GlobalKeyHandler(frame));
    }
}


