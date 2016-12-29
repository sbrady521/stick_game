import javax.swing.JFrame;

public class Game {
    public static void main(String[] args){
        JFrame f = new JFrame();
        MoveStick s = new MoveStick();
        f.add(s);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1280,720);
    }
}
