import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import javax.swing.JFrame;

public class GlobalKeyHandler implements NativeKeyListener{
    private JFrame frame;
    private Thread sThread;
    private RobotThread currentTask;
    private java.awt.Robot emergencyRobot; // Pre-initialized Robot to safely release stuck keys anywhere

    public GlobalKeyHandler(JFrame frame) {
        this.frame = frame;
        try {
            // Instantiate once while the application is in focus to prevent OS access blocks
            this.emergencyRobot = new java.awt.Robot();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        // F4 -> START MACRO
        if (e.getKeyCode() == NativeKeyEvent.VC_F4) {
            if (frame.isVisible()) {
                frame.setVisible(false); // Hide GUI so user inputs go directly to Roblox
            }
            // Crucial delay: Gives Windows time to focus the Roblox client before keys are pressed
            try {
                Thread.sleep(600);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            // Start the macro thread if it is not already running
            if (sThread == null || !sThread.isAlive()) {
                currentTask = new RobotThread();
                sThread = new Thread(currentTask);
                sThread.start();
            }
        }
        // F5 -> EMERGENCY STOP MACRO
        if (e.getKeyCode() == NativeKeyEvent.VC_F5) {
            // Signal the loop inside the thread to stop executing further steps
            if (currentTask != null) {
                currentTask.stopMacro();
            }
            // Instantly interrupt any active Thread.sleep() or movement routines
            if (sThread != null && sThread.isAlive()) {
                sThread.interrupt();
            }
            // Release basic movement keys immediately to prevent character running infinitely
            if (emergencyRobot != null) {
                emergencyRobot.keyRelease(java.awt.event.KeyEvent.VK_W);
                emergencyRobot.keyRelease(java.awt.event.KeyEvent.VK_A);
                emergencyRobot.keyRelease(java.awt.event.KeyEvent.VK_S);
                emergencyRobot.keyRelease(java.awt.event.KeyEvent.VK_D);
            }
            // Restore GUI visibility back to the screen
            if (!frame.isVisible()) {
                frame.setVisible(true);
            }
        }
    }
    // Initializes and registers the JNativeHook background keyboard listener.
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


