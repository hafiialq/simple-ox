
public class Player {
    private String name;
    private int win;
    private int lose;
    private int draw;
    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWin() {
        return win;
    }
    
    public void win() {
        win++;
    }
    
    public void lose() {
        lose++;
    }
    
    public void draw() {
        draw++;
    }
    
    
    public int getLose() {
        return lose;
    }


    public int getDraw() {
        return draw;
    }

    
}
