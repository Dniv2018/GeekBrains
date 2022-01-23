package Java_Level_01;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TickTackToe {
final int SIZE = 3;
final char DOT_EMPTY = '.';
final char DOT_X = 'X';
final char DOT_O = 'O';
final char DOT_DANGER = 'd';

Scanner sc = new Scanner(System.in);
Random rand = new Random();
    public static void main(String[] args) {
        int[] map = new int [3];
        int l=3;
        // Сколько горизонтальных линий может пройти через точку
        for (int i =0; i< map.length;i++){
            if (i+l<= map.length){
                for (int j=0;j<l;j++) map[i+j] ++;
            }
        }
        System.out.println(Arrays.toString(map));

    }
}
