import java.awt.*;
import javax.swing.JFrame;

public class Screen {
    private GraphicsDevice vc;

    //constructor gets environment graphics variables
    public Screen(){
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        vc = env.getDefaultScreenDevice();

    }

    //changes a windows settings to ensure regular full screen, not resizeable and undercorated
    //Changes the window to full screen according to video card
    //attempts to set the display mode as the new window
    public void setFullScreen(DisplayMode dm, JFrame window){
        window.setUndecorated(true);
        window.setResizable(false);
        vc.setFullScreenWindow(window);

        if(dm != null && vc.isDisplayChangeSupported()){
            try{
                vc.setDisplayMode(dm);
            }catch(Exception ex){
                System.out.println("Full screen creation failed");
            }
        }
    }

    //Returns the current full screen window
    public Window getFullScreenWindow(){
        return vc.getFullScreenWindow();
    }

    //closes the full screen
    public void restoreScreen(){
        Window w = vc.getFullScreenWindow();
        if(w != null){
            w.dispose();
        }
        vc.setFullScreenWindow(null);
    }
}
