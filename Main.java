import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Minesweeper minesweeper=new Minesweeper(3, 3);
        System.out.println("Welcome to Minesweeper!");
        while (minesweeper.getRunState()!=0){
            System.out.println("Enter 's' for search, 'f for flag.");
            String input1 = scanner.nextLine();
            System.out.println("Please enter the coordinates as a double-digit number, with the left being row index and right being column index");
                String input2 = scanner.nextLine();
                int row=Integer.parseInt(input2.substring(0, 1));
                int col=Integer.parseInt(input2.substring(1, 2));
                if (input1.charAt(0)=='s'){
                    minesweeper.search(row,col);
                }
                else if (input1.charAt(0)=='f'){
                    minesweeper.flag(row,col);
                }
                else{
                    minesweeper.setRunState(1);
            }

        }

    }
}