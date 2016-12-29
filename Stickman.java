import javax.swing.ImageIcon;
import java.awt.*;
import java.io.*;

import java.util.*;

import java.lang.*;

public class Stickman{
    private int x;
    private int y;
    private int speed;
    private int animationIndex;
    private boolean movingLeft;
    private boolean movingRight;
    private java.util.List<Image> animationFramesRight;
    private java.util.List<Image> animationFramesLeft;
    private java.util.List<Image> startRight;
    private java.util.List<Image> startLeft;
    private boolean startAnimation;
    private int startAnimationCounter;


    Stickman(String animationDir, int newX, int newY, int newSpeed){
        startAnimationCounter = 0;
        startAnimation = false;
        animationFramesRight = new ArrayList<Image>();
        animationFramesLeft = new ArrayList<Image>();
        startRight = new ArrayList<Image>();
        startLeft = new ArrayList<Image>();
        movingLeft = false;
        movingRight = false;
        x = newX;
        y = newY;
        speed = newSpeed;
        animationIndex = 0;

        File folder = new File(animationDir + "/runningRight");
        File[] listOfFiles = folder.listFiles();
        String[] dirs = new String[listOfFiles.length];
        for(int i = 0 ; i < listOfFiles.length ; i++){
                dirs[i] = animationDir + "/runningRight/" + listOfFiles[i].getName();
        }
        Arrays.sort(dirs);
        for(String dir: dirs){
            System.out.println(dir);
            animationFramesRight.add(new ImageIcon(dir).getImage());

        }


        folder= new File(animationDir + "/runningLeft");
        listOfFiles = folder.listFiles();
        dirs = new String[listOfFiles.length];
        for(int i = 0 ; i < listOfFiles.length ; i++){
            dirs[i] = animationDir + "/runningLeft/" + listOfFiles[i].getName();
        }
        Arrays.sort(dirs);
        for(String dir: dirs){
            System.out.println(dir);
            animationFramesLeft.add(new ImageIcon(dir).getImage());

        }

        folder = new File(animationDir + "/startLeft");
        listOfFiles = folder.listFiles();
        dirs = new String[listOfFiles.length];
        for(int i = 0 ; i < listOfFiles.length ; i++){
                dirs[i] = animationDir + "/startLeft/" + listOfFiles[i].getName();
        }
        Arrays.sort(dirs);
        for(String dir: dirs){
            System.out.println(dir);
            startLeft.add(new ImageIcon(dir).getImage());

        }

        folder = new File(animationDir + "/startRight");
        listOfFiles = folder.listFiles();
        dirs = new String[listOfFiles.length];
        for(int i = 0 ; i < listOfFiles.length ; i++){
                dirs[i] = animationDir + "/startRight/" + listOfFiles[i].getName();
        }
        Arrays.sort(dirs);
        for(String dir: dirs){
            System.out.println(dir);
            startRight.add(new ImageIcon(dir).getImage());

        }

    }
    public void setX(int newX){
        x = newX;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }


    public Image getCurrentFrame(){
        if(isMoving() == false){
            return startRight.get(0);
        }
        Image toReturn;
        if(movingRight == true){
            if(startAnimation == true){
                toReturn = startRight.get(startAnimationCounter);
                startAnimationCounter++;
                if(startAnimationCounter >= startRight.size()){
                    startAnimation = false;
                    startAnimationCounter = 0;
                }
            }else{
                toReturn = animationFramesRight.get(animationIndex);
                animationIndex++;
                animationIndex = animationIndex % animationFramesRight.size();
            }
        }else{
            if(startAnimation == true){
                toReturn = startLeft.get(startAnimationCounter);
                startAnimationCounter++;
                if(startAnimationCounter >= startLeft.size()){
                    startAnimation = false;
                    startAnimationCounter = 0;
                }
            }else{
                toReturn = animationFramesLeft.get(animationIndex);
                animationIndex++;
                animationIndex = animationIndex % animationFramesLeft.size();
            }
        }
        return toReturn;
    }

    public void moveRight(){
        x += speed;
    }

    public void moveLeft(){
        x -=  speed;
    }

    public boolean isMoving(){
        return movingLeft || movingRight;
    }

    public void stopStick(){
        startAnimationCounter = 0;
        startAnimation = false;
        movingLeft = false;
        movingRight = false;
    }

    public void move(){
        if(movingLeft){
            this.moveLeft();
        }else if(movingRight){
            this.moveRight();
        }
    }

    public void startMoveLeft(){
        if(movingLeft == false){
            startAnimation = true;
        }
        movingLeft = true;
        movingRight = false;
    }

    public void startMoveRight(){
        if(movingRight == false){
            startAnimation = true;
        }
        movingRight = true;
        movingLeft = false;
    }

}
