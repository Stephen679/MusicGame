package JavaFinal;

public class Beat {
    private int time;
    private String noteName;

    public Beat(int time, String noteName) {
        this.time = time;
        this.noteName = noteName;
    }

    public int getTime() {
        return time;
    }

    public String getNoteName() {
        return noteName;
    }
}
