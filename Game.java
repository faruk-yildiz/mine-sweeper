import java.lang.reflect.Array;
import java.util.*;

public class Game {
    private int rowCount;
    private int columnCount;
    private Random rnd;
    private Scanner scanner;
    private int[][] mineCoordinates;
    private char[][] mineChars;

    Game(int rowCount, int columnCount) {
        this.rowCount = rowCount;
        this.columnCount = columnCount;
        rnd = new Random();
        scanner = new Scanner(System.in);
        mineCoordinates = new int[rowCount][columnCount];
        mineChars = new char[rowCount][columnCount];
    }

    private void printGame() {
        System.out.println("\n\n\n*******Mayın Tarlası Oyununa Hoşgeldiniz!!!*******\n\n");
        for (int i = 0; i < rowCount; i++) {
            System.out.print("\t\t\t\t");
            for (int j = 0; j < columnCount; j++) {
                System.out.print(" " + mineChars[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void addMine() {
        int counter = (rowCount * columnCount) / 3;
        for (int i = 0; i < counter; i++) {
            int randRow = rnd.nextInt(rowCount);
            int randColumn = rnd.nextInt(columnCount);
            mineCoordinates[randRow][randColumn] = 1;
        }
    }

    public void run() {
        addMine();
        while (true) {
            printGame();
            System.out.println("\nSatır ve sütun giriniz (0 'dan başlar)");
            int satir = scanner.nextInt();
            int sutun = scanner.nextInt();
            if (isGameOver(satir, sutun)) {
                System.out.println("Kaybettiniz");
                printGame();
                break;
            } else {
                mineChars[satir][sutun] = '0';
            }
        }
    }

    private boolean isGameOver(int row, int column) {
        if (mineCoordinates[row][column] == 1) {
            for (int i = 0; i < mineCoordinates.length; i++) {
                for (int j = 0; j < mineCoordinates[0].length; j++) {
                    if (mineCoordinates[i][j] == 1) {
                        mineChars[i][j] = '*';
                    }
                }
            }
            return true;
        }
        return false;
    }

}
