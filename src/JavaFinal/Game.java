package JavaFinal;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Game extends Thread{
    private Image GameInfo = new ImageIcon("images\\GameInfo.jpg").getImage();
    private Image JudgeMentLineImage = new ImageIcon("images\\JudgementLine.jpg").getImage();

    private Image noteRouteLine = new ImageIcon("images\\noteRouteLine.jpg").getImage();
    private Image noteSRoute = new ImageIcon("images\\noteRoute.jpg").getImage();
    private Image noteDRoute = new ImageIcon("images\\noteRoute.jpg").getImage();
    private Image noteFRoute = new ImageIcon("images\\noteRoute.jpg").getImage();
    private Image noteSpace1Route = new ImageIcon("images\\noteRoute.jpg").getImage();
    private Image noteSpace2Route = new ImageIcon("images\\noteRoute.jpg").getImage();
    private Image noteJRoute = new ImageIcon("images\\noteRoute.jpg").getImage();
    private Image noteKRoute = new ImageIcon("images\\noteRoute.jpg").getImage();
    private Image noteLRoute = new ImageIcon("images\\noteRoute.jpg").getImage();
    private Music GameMusic;
    private String title;
    private String difficulty;
    public String musicName;
    ArrayList<Note> noteList = new ArrayList<Note>();

    public Game(String title, String difficulty,String musicName){
        this.title = title;
        this.difficulty = difficulty;
        this.musicName = musicName;
        GameMusic = new Music(this.musicName,false);
        GameMusic.start();
    }

    public void screenDraw(Graphics g){
        g.drawImage(noteSRoute , 228,30,null);
        g.drawImage(noteDRoute , 332,30,null);
        g.drawImage(noteFRoute , 436,30,null);
        g.drawImage(noteSpace1Route , 540,30,null);
        g.drawImage(noteSpace2Route , 640,30,null);
        g.drawImage(noteJRoute , 744,30,null);
        g.drawImage(noteKRoute , 848,30,null);
        g.drawImage(noteLRoute , 952,30,null);
        g.drawImage(noteRouteLine , 224,30,null);
        g.drawImage(noteRouteLine , 328,30,null);
        g.drawImage(noteRouteLine , 432,30,null);
        g.drawImage(noteRouteLine , 536,30,null);
        g.drawImage(noteRouteLine , 740,30,null);
        g.drawImage(noteRouteLine , 844,30,null);
        g.drawImage(noteRouteLine , 948,30,null);
        g.drawImage(noteRouteLine , 1052,30,null);

        g.drawImage(JudgeMentLineImage , 0,580,null);
        g.setColor(Color.white);
        g.setFont(new Font("Arial" , Font.BOLD,30));

        g.setColor(Color.darkGray);
        for(int i = 0 ; i < noteList.size();i++){
            Note note = noteList.get(i);
            note.screenDraw(g);//每個note呼叫一次 掉下去的動作讓note這個執行續去run(while(true))
        }
        g.drawString("S",270,609);
        g.drawString("D",374,609);
        g.drawString("F",478,609);
        g.drawString("Space",580,609);
        g.drawString("J",784,609);
        g.drawString("K",889,609);
        g.drawString("L",993,609);

        g.drawImage(GameInfo , 0,660,null);
        g.setColor(Color.lightGray);
        g.drawString(title,20,702);
        g.drawString(difficulty,1190,702);
//        g.drawString("00000",565,702);
    }

    public void pressS(){
        noteSRoute = new ImageIcon("images\\noteRoutePress.jpg").getImage();
        new Music("Drum.mp3",false).start();
    }
    public void pressD(){
        noteDRoute = new ImageIcon("images\\noteRoutePress.jpg").getImage();
        new Music("Drum.mp3",false).start();
    }
    public void pressF(){
        noteFRoute = new ImageIcon("images\\noteRoutePress.jpg").getImage();
        new Music("Drum.mp3",false).start();
    }
    public void pressSpace(){
        noteSpace1Route = new ImageIcon("images\\noteRoutePress.jpg").getImage();
        noteSpace2Route = new ImageIcon("images\\noteRoutePress.jpg").getImage();
        new Music("Drum.mp3",false).start();
    }
    public void pressJ(){
        noteJRoute = new ImageIcon("images\\noteRoutePress.jpg").getImage();
        new Music("Drum.mp3",false).start();
    }
    public void pressK(){
        noteKRoute = new ImageIcon("images\\noteRoutePress.jpg").getImage();
        new Music("Drum.mp3",false).start();
    }
    public void pressL(){
        noteLRoute = new ImageIcon("images\\noteRoutePress.jpg").getImage();
        new Music("Drum.mp3",false).start();
    }


    public void releaseS(){
        noteSRoute = new ImageIcon("images\\noteRoute.jpg").getImage();
    }
    public void releaseD(){
        noteDRoute = new ImageIcon("images\\noteRoute.jpg").getImage();
    }
    public void releaseF(){
        noteFRoute = new ImageIcon("images\\noteRoute.jpg").getImage();
    }
    public void releaseSpace(){
        noteSpace1Route = new ImageIcon("images\\noteRoute.jpg").getImage();
        noteSpace2Route = new ImageIcon("images\\noteRoute.jpg").getImage();
    }
    public void releaseJ(){
        noteJRoute = new ImageIcon("images\\noteRoute.jpg").getImage();
    }
    public void releaseK(){
        noteKRoute = new ImageIcon("images\\noteRoute.jpg").getImage();
    }
    public void releaseL(){
        noteLRoute = new ImageIcon("images\\noteRoute.jpg").getImage();
    }
    @Override
    public void run(){
        DropNotes();
    }
    public void close(){
        GameMusic.close();
        this.interrupt();//notelist清除
    }
    public void DropNotes(){
        if(musicName=="Gurenge.mp3"){
            Main.NOTE_SPEED = 7;
            Beat[] beats = {
                    new  Beat(300,"D"),
                    new  Beat(560,"K"),
                    new  Beat(860,"J"),
                    new  Beat(1960,"L"),
                    new  Beat(2320,"Space"),
                    new  Beat(2680,"S"),
                    new  Beat(3560,"L"),
                    new  Beat(3810,"L"),
                    new  Beat(4110,"D"),
                    new  Beat(4410,"K"),
                    new  Beat(5260,"Space"),//11圈
                    new  Beat(6570,"L"),
                    new  Beat(6970,"D"),
                    new  Beat(7280,"F"),
                    new  Beat(8400,"S"),
                    new  Beat(8760,"S"),
                    new  Beat(9150,"D"),
                    new  Beat(10210,"S"),
                    new  Beat(10640,"D"),
                    new  Beat(10940,"F"),//20圈
                    new  Beat(11240,"S"),
                    new  Beat(11570,"D"),
                    new  Beat(11930,"S"),
                    new  Beat(12260,"Space"),
                    new  Beat(12720,"L"),
                    new  Beat(13030,"K"),
                    new  Beat(13340,"L"),
                    new  Beat(13670,"K"),
                    new  Beat(13970,"S"),
                    new  Beat(14410,"F"),//30
                    new  Beat(14740,"Space"),
                    new  Beat(15090,"L"),
                    new  Beat(15430,"K"),
                    new  Beat(15720,"L"),
                    new  Beat(16190,"K"),
                    new  Beat(16530,"F"),
                    new  Beat(16840,"D"),
                    new  Beat(17160,"F"),
                    new  Beat(17460,"D"),
                    new  Beat(17900,"L"),//40
                    new  Beat(18220,"Space"),
                    new  Beat(18570,"J"),
                    new  Beat(18970,"L"),
                    new  Beat(19230,"K"),
                    new  Beat(19530,"Space"),
                    new  Beat(20560,"F"),
                    new  Beat(20750,"D"),
                    new  Beat(20880,"K"),
                    new  Beat(21020,"J"),
                    new  Beat(21290,"L"),//50
                    new  Beat(21490,"F"),
                    new  Beat(21730,"L"),
                    new  Beat(23390,"F"),
                    new  Beat(23610,"L"),
                    new  Beat(23810,"F"),
                    new  Beat(23950,"Space"),
                    new  Beat(24290,"F"),
                    new  Beat(24510,"K"),
                    new  Beat(24750,"F"),
                    new  Beat(24960,"D"),//60
                    new  Beat(25260,"F"),
                    new  Beat(25570,"D"),
                    new  Beat(25970,"F"),
                    new  Beat(26280,"L"),
                    new  Beat(26530,"F"),
                    new  Beat(27400,"K"),
                    new  Beat(27550,"F"),
                    new  Beat(27840,"J"),
                    new  Beat(28050,"F"),
                    new  Beat(28240,"K"),//70
                    new  Beat(28500,"J"),
                    new  Beat(28790,"K"),
                    new  Beat(30020,"J"),
                    new  Beat(30220,"F"),
                    new  Beat(30510,"J"),
                    new  Beat(30840,"K"),
                    new  Beat(31140,"J"),
                    new  Beat(31730,"Space"),
                    new  Beat(31980,"J"),
                    new  Beat(32280,"L"),//80
                    new  Beat(32620,"J"),
                    new  Beat(32960,"K"),
                    new  Beat(33260,"J"),
                    new  Beat(33580,"D"),
                    new  Beat(35260,"J"),
                    new  Beat(35500,"S"),
                    new  Beat(35780,"J"),
                    new  Beat(36110,"D"),
                    new  Beat(36520,"J"),
                    new  Beat(36810,"F"),//90
                    new  Beat(38770,"J"),
                    new  Beat(39030,"S"),
                    new  Beat(39340,"J"),
                    new  Beat(39620,"D"),
                    new  Beat(40060,"J"),
                    new  Beat(40340,"F"),
                    new  Beat(40600,"J"),
                    new  Beat(41180,"F"),
                    new  Beat(41420,"J"),
                    new  Beat(41630,"F"),//100
                    new  Beat(41870,"J"),
                    new  Beat(42140,"D"),
                    new  Beat(42390,"J"),
                    new  Beat(42600,"S"),
                    new  Beat(42870,"J"),
                    new  Beat(44080,"S"),
                    new  Beat(44300,"J"),
                    new  Beat(44580,"S"),
                    new  Beat(44900,"J"),
                    new  Beat(45190,"F"),//110
                    new  Beat(46020,"J"),
                    new  Beat(46340,"K"),
                    new  Beat(46690,"J"),
                    new  Beat(47790,"L"),
                    new  Beat(48110,"J"),
                    new  Beat(48450,"K"),
                    new  Beat(49330,"J"),
                    new  Beat(49560,"S"),
                    new  Beat(49870,"J"),
                    new  Beat(50200,"F"),//120
                    new  Beat(51050,"J"),
                    new  Beat(52360,"Space"),
                    new  Beat(52790,"J"),
                    new  Beat(53100,"K"),
                    new  Beat(54160,"L"),
                    new  Beat(54520,"S"),
                    new  Beat(54820,"D"),
                    new  Beat(55890,"L"),
                    new  Beat(56260 ,"Space"),
                    new  Beat(56610,"F"),//130
                    new  Beat(58820,"S"),
                    new  Beat(59290,"J"),
                    new  Beat(59740,"Space"),
                    new  Beat(60190,"D"),
                    new  Beat(60380,"J"),
                    new  Beat(60580,"D"),
                    new  Beat(60790,"J"),
                    new  Beat(61030,"F"),
                    new  Beat(61300,"J"),
                    new  Beat(61660,"F"),//140
                    new  Beat(61880,"J"),
                    new  Beat(62110,"K"),
                    new  Beat(62310,"L"),
                    new  Beat(62530,"Space"),
                    new  Beat(62780,"L"),
                    new  Beat(62950,"F"),
                    new  Beat(63050,"D"),
                    new  Beat(63400,"S"),
                    new  Beat(63750,"S"),
                    new  Beat(63990,"D"),//150
                    new  Beat(64120,"S"),
                    new  Beat(64440,"L"),
                    new  Beat(64650,"F"),
                    new  Beat(64870,"S"),
                    new  Beat(65110,"F"),
                    new  Beat(65320,"F"),
                    new  Beat(65500,"S"),
                    new  Beat(65890,"F"),
                    new  Beat(66350,"D"),
                    new  Beat(66670,"S"),//160
                    new  Beat(67030,"D"),
                    new  Beat(67290,"S"),
                    new  Beat(67840,"F"),
                    new  Beat(68300,"S"),
                    new  Beat(68550,"L"),
                    new  Beat(68790,"S"),
                    new  Beat(69340,"K"),
                    new  Beat(69580,"J"),
                    new  Beat(70000,"L"),
                    new  Beat(70260,"K"),//170
                    new  Beat(70540,"Space"),
                    new  Beat(70770,"L"),
                    new  Beat(71060,"Space"),
                    new  Beat(71400,"S"),
                    new  Beat(71750,"L"),
                    new  Beat(72020,"Space"),
                    new  Beat(72460,"F"),
                    new  Beat(72890,"D"),
                    new  Beat(73350,"S"),
                    new  Beat(73780,"l"),//180
                    new  Beat(74230,"Space"),
                    new  Beat(74430,"F"),
                    new  Beat(74650,"S"),
                    new  Beat(74860,"Space"),
                    new  Beat(75110,"S"),
                    new  Beat(75290,"F"),
                    new  Beat(75420,"S"),
                    new  Beat(75750,"D"),
                    new  Beat(75890,"S"),
                    new  Beat(76010,"L"),//190
                    new  Beat(76220,"K"),
                    new  Beat(76400,"L"),
                    new  Beat(76580,"J"),
                    new  Beat(76790,"Space"),
                    new  Beat(77030,"S"),
                    new  Beat(77490,"L"),
                    new  Beat(77730,"Space"),
                    new  Beat(78130,"S"),
                    new  Beat(78340,"D"),
                    new  Beat(78720,"F"),//200
                    new  Beat(78970,"S"),
                    new  Beat(79190,"Space"),
                    new  Beat(79850,"L"),
                    new  Beat(80300,"S"),
                    new  Beat(80620,"K"),
                    new  Beat(80940,"S"),
                    new  Beat(81220,"F"),
                    new  Beat(81840,"D"),
                    new  Beat(82240,"S"),
                    new  Beat(82500,"K"),//210
                    new  Beat(82740,"S"),
                    new  Beat(83560,"Space"),
                    new  Beat(83830,"L"),
                    new  Beat(84290,"K"),
                    new  Beat(10210,"L"),     new Beat(22000,"D"),

            };
            int i = 0;
            while(true){
                if(i < beats.length){
                    if(beats[i].getTime() <= GameMusic.getTime()){
                        Note note = new Note(beats[i].getNoteName());
                        note.start();
                        noteList.add(note);
                        System.out.println(++i);
                    }
                }
            }//return按下去後應該要清除notelist
        }

        if(musicName == "Ocean.mp3"){
            Main.NOTE_SPEED = 10;
            Beat []beats = {
                    new  Beat(150,"L"),//2
                    new  Beat(390,"Space"),
                    new  Beat(2110,"K"),
                    new  Beat(2470,"Space"),
                    new  Beat(2850,"S"),
                    new  Beat(3870,"F"),
                    new  Beat(4190,"D"),
                    new  Beat(4490,"F"),
                    new  Beat(4870,"S"),//10
                    new  Beat(5300,"J"),
                    new  Beat(6850,"Space"),
                    new  Beat(7260,"J"),
                    new  Beat(7680,"Space"),
                    new  Beat(8210,"K"),
                    new  Beat(8750,"Space"),
                    new  Beat(9020,"Space"),
                    new  Beat(9310,"F"),
                    new  Beat(9670,"D"),
                    new  Beat(10130,"F"),//20
                    new  Beat(11700,"K"),
                    new  Beat(12080,"J"),
                    new  Beat(12560,"Space"),
                    new  Beat(13470,"Space"),
                    new  Beat(13790,"F"),
                    new  Beat(14110,"F"),
                    new  Beat(14510,"Space"),
                    new  Beat(14950,"K"),
                    new  Beat(16530,"F"),
                    new  Beat(16960,"Space"),//30
                    new  Beat(17340,"K"),
                    new  Beat(17810,"K"),
                    new  Beat(18360,"L"),
                    new  Beat(18660,"K"),
                    new  Beat(19000,"F"),
                    new  Beat(19360,"K"),
                    new  Beat(19820,"S"),
                    new  Beat(21340,"Space"),
                    new  Beat(21770,"K"),
                    new  Beat(22210,"Space"),//40
                    new  Beat(23100,"K"),
                    new  Beat(23440,"L"),
                    new  Beat(23770,"J"),
                    new  Beat(24150,"K"),
                    new  Beat(24660,"K"),
                    new  Beat(26150,"D"),
                    new  Beat(26580,"F"),
                    new  Beat(27010,"K"),
                    new  Beat(27510,"S"),
                    new  Beat(28020,"F"),//50
                    new  Beat(28310,"K"),
                    new  Beat(28600,"Space"),
                    new  Beat(28990,"K"),
                    new  Beat(29430,"L"),
                    new  Beat(31010,"K"),
                    new  Beat(31430,"F"),
                    new  Beat(31850,"D"),
                    new  Beat(32710,"S"),
                    new  Beat(33080,"K"),
                    new  Beat(33390,"K"),//60
                    new  Beat(33830,"L"),
                    new  Beat(34260,"K"),
                    new  Beat(35790,"L"),
                    new  Beat(36210,"K"),
                    new  Beat(36640,"L"),
                    new  Beat(37130,"K"),
                    new  Beat(37660,"J"),
                    new  Beat(37920,"L"),
                    new  Beat(38230,"K"),
                    new  Beat(38610,"D"),//70
                    new  Beat(39040,"K"),
                    new  Beat(40590,"L"),
                    new  Beat(41000,"D"),
                    new  Beat(41400,"F"),
                    new  Beat(42370,"K"),
                    new  Beat(42700,"S"),
                    new  Beat(43020,"K"),
                    new  Beat(43450,"Space"),
                    new  Beat(43890,"K"),
                    new  Beat(45410,"K"),//80
                    new  Beat(45840,"L"),
                    new  Beat(46320,"K"),
                    new  Beat(47940,"D"),
                    new  Beat(48300,"F"),
                    new  Beat(48740,"Space"),
                    new  Beat(50260,"D"),
                    new  Beat(50680,"K"),
                    new  Beat(51120,"D"),
                    new  Beat(52020,"F"),
                    new  Beat(52360,"S"),//90
                    new  Beat(52690,"D"),
                    new  Beat(53090,"F"),
                    new  Beat(53540,"D"),
                    new  Beat(55100,"S"),
                    new  Beat(55560,"K"),
                    new  Beat(55930,"L"),
                    new  Beat(56370,"K"),
                    new  Beat(56930,"Space"),
                    new  Beat(57210,"K"),
                    new  Beat(57520,"L"),//100
                    new  Beat(57890,"Space"),
                    new  Beat(58320,"K"),
                    new  Beat(59900,"S"),
                    new  Beat(60330,"D"),
                    new  Beat(60730,"F"),
                    new  Beat(61650,"K"),
                    new  Beat(61980,"D"),
                    new  Beat(62280,"K"),
                    new  Beat(62710,"D"),
                    new  Beat(63130,"F"),//110
                    new  Beat(64670,"K"),
                    new  Beat(65140,"F"),
                    new  Beat(65570,"D"),
                    new  Beat(66080,"K"),
                    new  Beat(66540,"S"),
                    new  Beat(66860,"D"),
                    new  Beat(67150,"F"),
                    new  Beat(67520,"K"),
                    new  Beat(67960,"Space"),
                    new  Beat(69510,"K"),//120
                    new  Beat(69950,"S"),
                    new  Beat(70380,"D"),
                    new  Beat(71280,"F"),
                    new  Beat(71600,"K"),
                    new  Beat(71920,"J"),
                    new  Beat(72350,"L"),
                    new  Beat(72800,"K"),
                    new  Beat(74300,"J"),
                    new  Beat(74730,"L"),
                    new  Beat(75180,"A"),//130
                    new  Beat(75640,"S"),
                    new  Beat(76180,"D"),
                    new  Beat(76480,"D"),
                    new  Beat(76760,"S"),
                    new  Beat(77170,"K"),
                    new  Beat(77580,"Space"),
                    new  Beat(79160,"L"),
                    new  Beat(79560,"K"),
                    new  Beat(79980,"L"),
                    new  Beat(80890,"K"),//140
                    new  Beat(81220,"S"),
                    new  Beat(81580,"D"),
                    new  Beat(81950,"K"),
                    new  Beat(82380,"F"),
                    new  Beat(83850,"K"),
                    new  Beat(84320,"Space"),
                    new  Beat(84770,"K"),
                    new  Beat(85230,"L"),
                    new  Beat(85830,"S"),
                    new  Beat(86120,"L"),//150
                    new  Beat(86790,"F"),
            };
            int i = 0;
            while(true){
                if(i < beats.length){
                    if(beats[i].getTime() <= GameMusic.getTime()){
                        Note note = new Note(beats[i].getNoteName());
                        note.start();
                        noteList.add(note);
                        System.out.println(++i);
                    }
                }
            }
        }

    }



}
