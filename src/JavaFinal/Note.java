package JavaFinal;

import javax.swing.*;
import java.awt.*;

public class Note extends Thread{
    private Image note;
    private int x , y = 580-1000/ Main.SLEEP_TIME* Main.NOTE_SPEED ;
    private String noteType;
    public Note(String noteType){
        if(DynamicBeat.game.musicName.equals("Gurenge.mp3")){
            note = new ImageIcon("images\\note.jpg").getImage();
        }else{
            note = new ImageIcon("images\\note1.jpg").getImage();
        }
        if(noteType.equals("S")){
            x = 220;
        }else if(noteType.equals("D")){
            x = 332;
        }else if(noteType.equals("F")){
            x = 436;
        }else if(noteType.equals("Space")){
            x = 540;
        }else if(noteType.equals("J")){
            x = 744;
        }else if(noteType.equals("K")){
            x = 848;
        }else if(noteType.equals("L")){
            x = 952;
        }
        this.noteType = noteType;
    }
    public void screenDraw(Graphics g){
        if(noteType.equals("Space")){
            g.drawImage(note,x,y,null);
            g.drawImage(note,x+100,y,null);
        }else{
            g.drawImage(note,x,y,null);
        }
    }
    public void Drop(){
        y += Main.NOTE_SPEED;
    }

    @Override
    public void run(){
        try{
            while(true){
                Drop();
                Thread.sleep(Main.SLEEP_TIME);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
