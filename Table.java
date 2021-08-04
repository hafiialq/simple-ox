
public class Table {

    private String[][] table = {{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}};
    private int lastrow, lastcol;
    private Player playX, playO, curplayer;
    private Player winner = null;
    private boolean fn = false;

    public Table(Player x, Player o) {
        playX = x;
        playO = o;
        curplayer = x;
    }

    public void ShowTable() {
        System.out.println(" 1 2 3");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < 3; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }
    public String getRowcol(int row, int col) {
        return table[row][col];
    }

    public boolean setRowCol(int row, int col) {
        if(isFinish()) return false;
        if (table[row][col].equals("-")) {
            table[row][col] = curplayer.getName();
            this.lastrow = row;
            this.lastcol = col;
            checkWin();
            return true;
        }
        return false;

    }

    public Player getCurplayer() {
        return curplayer;
    }

    public void switchPlayer() {
        if (curplayer == playX) {
            curplayer = playO;
        } else {
            curplayer = playX;
        }
    }

    public void checkRow() {
        for (int col = 0; col < 3; col++) {
            if (!table[lastrow][col].equals(curplayer.getName())) {
                return;
            }
        }
        fn = true;
        winner = curplayer;
        setWin();
    }

    private void setWin() {
        if (curplayer == playO) {
            playO.win();
            playX.lose();
        } else if (curplayer == playX){
            playX.win();
            playO.lose();
        } 
    }

    private void checkCol() {
        for (int row = 0; row < 3; row++) {
            if (!table[row][lastcol].equals(curplayer.getName())) {
                return;
            }
        }
        fn = true;
        winner = curplayer;
        setWin();
    }
    int count = 0;

    public void checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (table[i][j].equals("X") || table[i][j].equals("O")) {
                    count++;
                }
            }
        }
        if (count == 9 && fn!=true) {
            fn = true;
            winner = null;
            playX.draw();
            playO.draw();
        }
        count = 0;
        

    }

    public void checkX1() {
        for (int col = 0; col < 3; col++) {
            if (!table[col][col].equals(curplayer.getName())) {
                return;
            }
        }
        fn = true;
        winner = curplayer;
        setWin();
    }

    public void checkX2() {
        for (int col = 0, v = 2; col < 3; col++, v--) {
            if (!table[col][v].equals(curplayer.getName())) {
                return;
            }
        }
        fn = true;
        winner = curplayer;
        setWin();
        
    }

    public void checkWin() {
        checkRow();
        checkCol();
        checkX1();
        checkX2();
        checkDraw();

    }

    public boolean isFinish() {
        return fn;
    }

    public Player winner() {
        return winner;
    }

}
