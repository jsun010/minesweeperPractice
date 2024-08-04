public class Minesweeper {
    private int length=0;
    private int [][] field;
    private String [][] userField;
    private int k=0;
    private int runState=1;

    public Minesweeper(int length, int k) {
        this.length = length;
        this.k=k;
        field=new int[length][length];
        userField=new String[length][length];
        for(int i=0;i<length;i++){
            for(int j=0;j<length;j++){
                field[i][j]=0;
                userField[i][j]="x";
            }
        }
        while (k>0){
            int row=(int) (Math.random()*length);
            int col=(int) (Math.random()*length);
            if (field[row][col]!=1){
                field[row][col]=1;
                k--;
            }
        }
        print2dArr();
    }

    public void print2dArr(){
        for (int i=0;i<length;i++){
            for (int j=0;j<length;j++){
                System.out.print(userField[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void search(int row, int col){
        if (row<length && col<length && row>=0 && col>=0){
            if (field[row][col]==1){
                System.out.println("You lose :((");
                runState=0;
            }
            else{
                int adjacentMines=0;
                if (row-1>=0 && field[row-1][col]==1){
                    adjacentMines++;
                }
                if (row+1<length && field[row+1][col]==1){
                    adjacentMines++;
                }
                if (col-1>=0 && field[row][col-1]==1){
                    adjacentMines++;
                }
                if (col+1<length && field[row][col+1]==1){
                    adjacentMines++;
                }
                if (row-1>=0 && col-1>=0 && field[row-1][col-1]==1){
                    adjacentMines++;
                }
                if (row-1>=0 && col+1<length && field[row-1][col+1]==1){
                    adjacentMines++;
                }
                if (row+1<length && col-1>=0 && field[row+1][col-1]==1){
                    adjacentMines++;
                }
                if (row+1<length && col+1<length && field[row+1][col+1]==1){
                    adjacentMines++;
                }
                userField[row][col]= String.valueOf(adjacentMines);
            }
            print2dArr();

        }
        else{
            System.out.println("out of bounds");
        }

    }

    public void flag(int row, int col){
        if (row<length && col<length && row>=0 && col>=0){
            userField[row][col]="f";
            print2dArr();
        }
        else{
            System.out.println("out of bounds");
        }
    }

    public int getRunState(){
        return runState;
    }

    public void setRunState(int runState){
        this.runState=runState;
    }
}
