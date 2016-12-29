import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.ImageIcon;
import java.io.*;

public class MoveStick extends JPanel implements ActionListener, KeyListener {

    Timer t = new Timer(100, this);
    Stickman mrStick = new Stickman("running", 640, 250, 8);
    Image background = new ImageIcon("floor.jpg").getImage();

    public MoveStick(){
        t.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        int stickX = mrStick.getX();
        int stickY = mrStick.getY();
        Image currentStick = mrStick.getCurrentFrame();
        g2.drawImage(background, 0, 0, null);
        g2.drawImage(currentStick, stickX, stickY, null);

    }

    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
        if(command != null && command.equals("UP")){
            System.out.println("oi");
        }
        //System.out.println(command);
        repaint();
        //System.out.println("move");
        //mrStick.move();

    }

    public void keyPressed(KeyEvent e){
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_LEFT){
            System.out.println("left pressed");
            mrStick.startMoveLeft();
            mrStick.moveLeft();
        }else if(code == KeyEvent.VK_RIGHT ){
            mrStick.startMoveRight();
            mrStick.moveRight();
            System.out.println("right pressed");
        }
    }

    public void keyTyped(KeyEvent e){}

    public void keyReleased(KeyEvent e){
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_LEFT){
            System.out.println("left released");
            mrStick.stopStick();
        }else if(code == KeyEvent.VK_RIGHT){
            System.out.println("right released");
            mrStick.stopStick();
        }
    }



}
