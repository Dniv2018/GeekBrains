package Java_Level_01;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TickTackToe {
final static int SIZE = 3;
final static int LINE =3;
final static char DOT_EMPTY = '.';
final static char DOT_X = 'X';
final static char DOT_0 = 'O';
final static char DOT_DANGER = 'd';
final static char[][] mapGame = new char[SIZE][SIZE];
final static int[][] map = new int[SIZE][SIZE];
final static int[][] mapDanger = new int[SIZE][SIZE];
final static int[][] mapWin = new int[SIZE][SIZE];
final static int[] turnPoint = new int[2];

final static Scanner sc = new Scanner(System.in);
Random rand = new Random();
    public static void main(String[] args) {
        initMap();
        printMap();
        makeMap();

        turnHuman();
        printMap();
        makeMap();
        //boolean win = chekWin();
        if (chekWin()) {
            System.out.println("Вы победили!");
        }





//        System.out.println(Arrays.toString(map));

    }

    private static void makeMap(){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = 0;
            }
        }
        for (int vertPoint=0; vertPoint<SIZE; vertPoint++){
            for (int horizontPoint =0; horizontPoint< SIZE; horizontPoint++){
                //isMakeLine(int x, int y, char DOT, char flag)
                if (isMakeLine(horizontPoint, vertPoint, '.', '-')){
                //if (horizontPoint + (LINE-1) < SIZE){
                    for (int linePoint = 0; linePoint< LINE; linePoint++) {
                        map[vertPoint][horizontPoint+linePoint] ++;//по горизонтали
                    }
                }
                if (isMakeLine(horizontPoint, vertPoint, '.', '|')){
                //if (vertPoint + (LINE-1) < SIZE){
                    for (int linePoint = 0; linePoint< LINE; linePoint++) {
                        map[vertPoint+linePoint][horizontPoint] ++;//по вертикали
                    }
                }
                if(isMakeLine(horizontPoint, vertPoint, '.', 'b')){
                //if((vertPoint+(LINE-1) < SIZE) & (horizontPoint+(LINE-1) < SIZE)){
                    for (int linePoint = 0; linePoint< LINE; linePoint++){
                        map[vertPoint+linePoint][horizontPoint+linePoint]++;//\обратный слэш
                    }
                }
                if(isMakeLine(horizontPoint, vertPoint, '.', '/')){
                //if((vertPoint+(LINE-1) < SIZE) & (horizontPoint-(LINE-1) >= 0)){
                    for (int linePoint = 0; linePoint< LINE; linePoint++){
                        map[vertPoint-linePoint][horizontPoint+linePoint]++;//прямой слэш
                    }
                }
            }
        }
        for (int i=0; i<SIZE; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }

    private static boolean chekWin(){
        int x = turnPoint[0];
        int y = turnPoint[1];
        char b = mapGame[y][x];
        int countX=0;
        int countY=0;
        int countSL=0;
        int countOS=0;
        for (int i=0; i<SIZE;i++){
            for (int j=0; j<SIZE; j++){
                if (mapGame[i][j]==b){
                    //по х
                    for (int l = 1; l < LINE; l++){
                        if ((j+l<SIZE)&&mapGame[i][j+l]!=b) {
                            countX=0;
                            break;
                        }
                        countX++;
                    }
                    //по у
                    for (int l = 1; l < LINE; l++){
                        if ((i+l<SIZE)&&mapGame[i+l][j]!=b){
                            countY=0;
                            break;
                        }
                        countY++;
                    }
                    //по SL
                    for (int l = 1; l < LINE; l++){
                        if ((i-l>=0)&&(j+l<SIZE)&&mapGame[i-l][j+l]!=b){
                            countSL=0;
                            break;
                        }
                        countSL++;
                    }
                    //по\ OS
                    for (int l = 1; l < LINE; l++){
                        if ((i+l<SIZE)&&(j+l<SIZE)&&mapGame[i+l][j+l]!=b){
                            countOS=0;
                            break;
                        }
                        countOS++;
                    }
                }
            }
//        for(int i=0; i<LINE;i++) {
//            if ((x - i >= 0) && mapGame[y][x - i] == b) countX++;
//            if ((x + i <= SIZE) && mapGame[y][x + i] == b) countX++;
//        }
//            //по х
//            //if (x-i>=0||x+i<=SIZE){
//
//            //по у
//            //if (y-i>=0||x+i<=SIZE){
//            if ((y-i>=0)&&mapGame[y-i][x]==b) countY++;
//            if ((x+i<=SIZE)&&mapGame[y+y][x]==b) countY++;
//            //по SL
//            if ((x+i<=SIZE)&&(y-i>=0)&&mapGame[y-i][x+i]==b) countSL++;
//            if ((x-i>=0)&&(y+i<=SIZE)&&mapGame[y+i][x-i]==b) countSL++;
//            //по\ OS
//            if ((x-i>=0)&&(y-i>=0)&&mapGame[y-i][x-i]==b) countOS++;
//            if ((x+i<=SIZE)&&(y+i<=SIZE)&&mapGame[y-i][x-i]==b) countOS++;
        }
        return (countX>=LINE||countY>=LINE||countSL>=LINE||countOS>=LINE);
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

    private static void turnHuman() {
        int x;
        int y;
        do {
            System.out.println("Пожалуйста, введите координаты Х и У вашего хода");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (isNotValid(x, y));
        turnPoint[0] = x;
        turnPoint[1] = y;
        mapGame[y][x] = DOT_X;
    }

    private static boolean isNotValid(int x, int y) {
        boolean rsl = false;
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) rsl = true;
        if (mapGame[y][x] == DOT_X || mapGame[y][x] == DOT_0) rsl = true;
        return rsl;
    }

    private static boolean isMakeLine(int x, int y, char DOT, char flag){
        boolean rsl = true;
        for (int i=0; i<LINE;i++){
            switch (flag) {
                case '-': {
                    //System.out.println("Jn dfv " +y+" "+" "+x+" "+" "+i);
                    if (x + i >= SIZE || (mapGame[y][x + i] != DOT)) rsl = false;
                    break;
                }
                case '|': {
                    if (y + i >= SIZE || mapGame[y + i][x] != DOT) rsl = false;
                    break;
                }
                case '/': {
                    System.out.println("Jn dfv " +y+" "+" "+x+" "+" "+i);
                    if (y - i < 0 || x + i >= SIZE || mapGame[y - i][x+i] != DOT) rsl = false;
                    break;
                }
                case 'b': {
                    if (y + i >= SIZE || x + i >= SIZE || mapGame[y + i][x + i] != DOT) rsl = false;
                    break;
                }
            }
        }
        System.out.println(rsl);
        return rsl;
//        switch (flag){
//            case '-':{
//                for (int i=0; i<LINE;i++){
//                    if (x+i>SIZE||mapGame[y][x+i]!=DOT) rsl=false;
//                }
//                break;
//            }
//            case '|':{
//                for (int i=0; i<LINE;i++){
//                    if (y+i>SIZE||mapGame[y+i][x]!=DOT) rsl=false;
//                }
//                break;
//            }
//            case '/':{
//                for (int i=0; i<LINE;i++){
//                    if (y-i<0||x+i>=SIZE||mapGame[y-i][x]!=DOT) rsl=false;
//                }
//                break;
//            }
//            case 'b':{
//                for (int i=0; i<LINE;i++){
//                    if (y+i>SIZE||x+i>=SIZE||mapGame[y+i][x+i]!=DOT) rsl=false;
//                }
//                break;
//            }

//        }

    }
}
