package JavaFinal;

public class Track {
    private String titleImage;
    private String selectImage;
    private String gameImage;
    private String startMusic;
    private String title;
    public void setSelectImage(String selectImage) {
        this.selectImage = selectImage;
    }

    private String gameMusic;

    public String getSelectImage() {
        return selectImage;
    }

    public Track(String titleImage, String selectImage, String gameImage, String startMusic, String gameMusic,String title) {
        this.titleImage = titleImage;
        this.selectImage = selectImage;
        this.gameImage = gameImage;
        this.startMusic = startMusic;
        this.gameMusic = gameMusic;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitleImage(String titleImage) {
        this.titleImage = titleImage;
    }

    public void setGameImage(String gameImage) {
        this.gameImage = gameImage;
    }

    public void setStartMusic(String startMusic) {
        this.startMusic = startMusic;
    }

    public void setGameMusic(String gameMusic) {
        this.gameMusic = gameMusic;
    }

    public String getTitleImage() {
        return titleImage;
    }

    public String getGameImage() {
        return gameImage;
    }

    public String getStartMusic() {
        return startMusic;
    }

    public String getGameMusic() {
        return gameMusic;
    }
}
