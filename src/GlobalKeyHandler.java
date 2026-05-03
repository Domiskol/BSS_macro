import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;
import javax.swing.JFrame;

public class GlobalKeyHandler implements NativeKeyListener{

    private JFrame frame;

    public GlobalKeyHandler(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        if (e.getKeyCode() == NativeKeyEvent.VC_F4) {
            if (frame.isVisible()) {
                frame.setVisible(false);
            }
        }
        if (e.getKeyCode() == NativeKeyEvent.VC_F5){
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


