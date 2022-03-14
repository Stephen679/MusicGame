package JavaFinal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class DynamicBeat extends JFrame {
    private Image screenImage;
    private Graphics screenGraphic;
    private Image Background = new ImageIcon("images\\elf(title).jpg").getImage();
    private JButton exitButton = new JButton(new ImageIcon("images\\exitbutton.jpg"));
    private JButton startButton = new JButton(new ImageIcon("images\\startbutton.jpg"));
    private JButton quitButton = new JButton(new ImageIcon("images\\quitbutton.png"));
    private JButton leftButton = new JButton(new ImageIcon("images\\left.jpg"));
    private JButton rightButton = new JButton(new ImageIcon("images\\right.jpg"));
    private JButton easyButton = new JButton(new ImageIcon("images\\easy.jpg"));
    private JButton hardButton = new JButton(new ImageIcon("images\\hard.jpg"));
    private JButton returnButton = new JButton(new ImageIcon("images\\return.jpg"));

    ArrayList<Track> playList = new ArrayList<>();

    private Music selectedMusic;
    private Image SelectedImage = new ImageIcon("images\\tiger.jpg").getImage();
    private Image TitleImage = new ImageIcon("images\\unravel.png").getImage();
    private int nowSelected = 0 ;
    private boolean isMainScreen = false;
    private boolean isGameScreen = false;

    public static Game game;

    public DynamicBeat(){
        setUndecorated(true);
        setTitle("Dynamic Beat");
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        setResizable(false);
        setFocusable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        setBackground(new Color(0,0,0,0));
        setLayout(null);
        Music introMusic = new Music("wolf.mp3",true);
        introMusic.start();
        addKeyListener(new KeyListener());

        //------------------把歌曲添進歌單裡面--------------------
        playList.add(new Track("OceanTitle.png","OceanImage.jpg",
                "OceanGameImage.jpg","Ocean Selected.mp3","Ocean.mp3","Call Summer-EMA"));
        playList.add(new Track("PushTitle.png","PushImage.jpg",
                "PushGameImage.jpg","Push Selected.mp3","Push.mp3","Push-Avril Lavigne"));
        playList.add(new Track("GurengeTitle.png","GurengeImage.jpg",
                "GurengeGameImage.jpg","Gurenge Selected.mp3","Gurenge.mp3","Gurenge-Lisa"));
        playList.add(new Track("MouseTitle.png","MouseImage.jpg",
                "MouseGameImage.jpg","Mouse Selected.mp3","Mouse.mp3","Mice Love Rice"));
        playList.add(new Track("LemonTitle.png","LemonImage.jpg",
                "LemonGameImage.jpg","Lemon Selected.mp3","Lemon.mp3","Lemon-Yonezu Kenshi"));

        //------------------把歌曲添進歌單裡面--------------------

        exitButton.setBounds(1245,0,30,30);
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
        exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(exitButton);

        leftButton.setBounds(140,310,60,60);
        leftButton.setVisible(false);
        leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        leftButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                selecLeft();
            }
        });

        rightButton.setBounds(1080,310,60,60);
        rightButton.setVisible(false);
        rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rightButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                selectRight();
            }
        });

        easyButton.setVisible(false);
        easyButton.setBounds(375,580,60,60);
        easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        easyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                gameStart(nowSelected,"Easy");
            }
        });
        hardButton.setVisible(false);
        hardButton.setBounds(830,580,60,60);
        hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        hardButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                gameStart(nowSelected,"Hard");
            }
        });

        returnButton.setVisible(false);
        returnButton.setBounds(20,50,60,60);
        returnButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        returnButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                BackMain();
            }
        });
        add(leftButton);
        add(rightButton);
        add(easyButton);
        add(hardButton);
        add(returnButton);

        startButton.setBounds(90,340,180,65);
        startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                introMusic.close();
                selectTrack(0);
                startButton.setVisible(false);
                quitButton.setVisible(false);
                leftButton.setVisible(true);
                rightButton.setVisible(true);
                easyButton.setVisible(true);
                hardButton.setVisible(true);
                Background = new ImageIcon("images\\music.jpg").getImage();
                isMainScreen = true;
            }
        });
        add(startButton);

        quitButton.setBounds(90,450,160,65);
        quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        quitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
        add(quitButton);
    }

    public void paint(Graphics g){
        screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);//雙緩衝 生成合適的緩衝區
        screenGraphic = screenImage.getGraphics();//獲得在緩衝區的繪圖環境Graphic
        screenDraw(screenGraphic);
        g.drawImage(screenImage,0,0,null);//最後將緩衝區的內容一次性地寫入Canvas並在視窗中直接顯示出來
    }
    public void screenDraw(Graphics g){
        g.drawImage(Background,0,0,null);
        if(isMainScreen){//若在主選單的話會繪製歌曲示意圖加標題
            g.drawImage(SelectedImage,340,100,null);
            g.drawImage(TitleImage,340,70,null);
        }
        if(isGameScreen){
            game.screenDraw(g);
        }
        paintComponents(g);
        this.repaint();//把IntroBackground的圖片先畫進screenGraphic，也就是screenImage的環境
    }

    public void selectTrack(int nowSelected){//切換歌曲
        if (selectedMusic != null) {
            selectedMusic.close();//關掉一前一首歌
        }
        //TitleImage是歌名 //SelectedImage是歌曲示意圖
        TitleImage = new ImageIcon("images\\"+playList.get(nowSelected).getTitleImage()).getImage();
        SelectedImage = new ImageIcon("images\\"+playList.get(nowSelected).getSelectImage()).getImage();
        selectedMusic = new Music(playList.get(nowSelected).getStartMusic(),true);
        selectedMusic.start();
    }


    public void selecLeft(){
        if(nowSelected==0){
            nowSelected = playList.size()-1;
        }else{
            nowSelected--;
        }
        selectTrack(nowSelected);
    }
    public void selectRight(){
        if(nowSelected==playList.size()-1){
            nowSelected = 0 ;
        }else{
            nowSelected++;
        }
        selectTrack(nowSelected);
    }

    public void gameStart(int nowSelected , String difficulty){
        if(selectedMusic!= null){
            selectedMusic.close();
        }

        isMainScreen = false;
        leftButton.setVisible(false);
        rightButton.setVisible(false);
        easyButton.setVisible(false);
        hardButton.setVisible(false);
        Background = new ImageIcon("images\\"+playList.get(nowSelected).getGameImage()).getImage();
        returnButton.setVisible(true);
        isGameScreen = true;
        game = new Game(playList.get(nowSelected).getTitle(),difficulty,playList.get(nowSelected).getGameMusic());
        game.start();
        setFocusable(true);
    }

    public void BackMain(){
        isMainScreen = true;
        leftButton.setVisible(true);
        rightButton.setVisible(true);
        easyButton.setVisible(true);
        hardButton.setVisible(true);
        Background = new ImageIcon("images\\music.jpg").getImage();
        returnButton.setVisible(false);
        selectTrack(nowSelected);//播放當前歌(片段)
        isGameScreen = false;
        game.close();

    }


}
