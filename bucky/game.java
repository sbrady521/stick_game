import java.awt.*;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class game extends JFrame{

    private Screen s;
    private Image bg;
    private Image currentStick;

    public static void main(String[] args){
        DisplayMode dm = new DisplayMode(800, 600, 16, DisplayMode.REFRESH_RATE_UNKNOWN);
        game g = new game();
        g.run(dm);
    }

    public void run(DisplayMode dm){
        setBackground(Color.PINK);
        setForeground(Color.WHITE);
        //setFont(new Font("Arial", Font.PLAIN, 24));

        s = new Screen();

        try{
            s.setFullScreen(dm, this);
            try{
                Thread.sleep(5000);
            }catch(Exception ex){
                System.out.println("Failed to sleep");
            }
        }finally{
            s.restoreScreen();
        }
    }

    public void paint(Graphics g){
        if(g instanceof Graphics2D){
            Graphics2D g2 = (Graphics2D)g;
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        }
        g.drawString("This is some text", 200, 200);
    }
}
