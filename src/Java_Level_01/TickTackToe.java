package Java_Level_01;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TickTackToe {
final static int SIZE = 3;
final static int LINE =3;
final static char DOT_EMPTY = '.';
final static char DOT_X = 'X';
final static char DOT_O = 'O';
final static char DOT_DANGER = 'd';
final static char[][] mapGame = new char[SIZE][SIZE];

Scanner sc = new Scanner(System.in);
Random rand = new Random();
    public static void main(String[] args) {
        initMap();
        printMap();
        int[][] map = new int[SIZE][SIZE];

        // Сколько горизонтальных, вертикальных и диагональных линий может пройти через точку
        for (int vertPoint=0; vertPoint<SIZE; vertPoint++){
            for (int horizontPoint =0; horizontPoint< SIZE; horizontPoint++){
                if (horizontPoint + (LINE-1) < SIZE){
                    for (int linePoint = 0; linePoint< LINE; linePoint++) {
                        map[vertPoint][horizontPoint+linePoint] ++;//по горизонтали
                    }
                }
                if (vertPoint + (LINE-1) < SIZE){
                    for (int linePoint = 0; linePoint< LINE; linePoint++) {
                        map[vertPoint+linePoint][horizontPoint] ++;//по вертикали
                    }
                }
                if((vertPoint+(LINE-1) < SIZE) & (horizontPoint+(LINE-1) < SIZE)){
                    for (int linePoint = 0; linePoint< LINE; linePoint++){
                        map[vertPoint+linePoint][horizontPoint+linePoint]++;//обратный слэш
                    }
                }
                if((vertPoint+(LINE-1) < SIZE) & (horizontPoint-(LINE-1) >= 0)){
                    for (int linePoint = 0; linePoint< LINE; linePoint++){
                        map[vertPoint+linePoint][horizontPoint-linePoint]++;//прямой слэш
                    }
                }
            }
        }
        for (int i=0; i<SIZE; i++) {
            System.out.println(Arrays.toString(map[i]));
        }

//        System.out.println(Arrays.toString(map));

    }
    private static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                mapGame[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(mapGame[i][j] + " ");
            }
            System.out.println();
        }
    }
}
