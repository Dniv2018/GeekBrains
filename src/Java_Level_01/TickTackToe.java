package Java_Level_01;
import java.util.Arrays;
//import java.util.Random;
import java.util.Scanner;

public class TickTackToe {
final static int SIZE = 3;
final static int LINE =3;
final static char DOT_EMPTY = '.';
final static char DOT_X = 'X';
final static char DOT_0 = 'O';
//final static char DOT_DANGER = 'd';
final static char[][] mapGame = new char[SIZE][SIZE]; //Карта Игры
final static int[][] map = new int[SIZE][SIZE];//Карта плотности/густоты возможных линий для Компа
final static int[][] mapMan = new int[SIZE][SIZE];//Карта плотности/густоты возможных линий для Игрока
final static int[][] mapDanger = new int[SIZE][SIZE];//Карта количества точек необходимых для построения линии включая текущую точку, для Игрока
final static int[][] mapWin = new int[SIZE][SIZE];//Карта количества точек необходимых для построения линии включая текущую точку, для Игрока
final static int[] turnPoint = new int[2];//Точка хода
final static int[] calcPoint = new int[3];//Точка расчета
final static int[][] mapMult = new int[SIZE][SIZE];

final static Scanner sc = new Scanner(System.in);
//Random rand = new Random();
    public static void main(String[] args) {
        initMap();
        printMap();
        boolean isWin = false;


    while (true){
        turnHuman();
        printMap();

        if (chekWin()) {
            System.out.println("Вы победили!");
            break;
        }
        //printMap();
//        System.out.println("DANGER");
        makeMapDanger();
//        System.out.println("Плотность Man");
        makeMapMan();
//        takeCorrect(DOT_X);
//        System.out.println("Плотности");
        makeMap();
//        System.out.println("Win");
        makeMapWin();
//        takeCorrect(DOT_0);

//        System.out.println("Mult");
        makemapMult();

        //Поиск победной точки
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (mapWin[i][j]==1){
                    calcPoint[0]=j;
                    calcPoint[1]=i;
                    isWin = true;
                }
            }
        }
        //Если победной точки нет - ищем точку хода
        if (!isWin){
            if (isCalcPoint()) {
                takeCalcPoint();
            }
            else{
                if (isMultPoint()){
                    takeMultPoint();
//                }
//                else{
//                    if (isTurnPoint()) takeTurnPoint();
               }
            }
        }


        mapGame[calcPoint[1]][calcPoint[0]]=DOT_0;
        turnPoint[0]=calcPoint[0];
        turnPoint[1]=calcPoint[1];
        System.out.println("Ход Компьютера:");
        System.out.println("X: "+(turnPoint[0]+1)+" Y: "+(turnPoint[1]+1));
        printMap();
        if (chekWin()) {
            System.out.println("Комп победил!");
            break;
        }
        if (checkStandoff()) {
            System.out.println("Ничья");
            break;
        }


    }


    }
    private static void takeMultPoint(){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++){
                if ((mapMult[i][j]>calcPoint[2])){
//                if ((mapWin[i][j]<mapMult[i][j])&&(mapMult[i][j]>calcPoint[2])){
                    calcPoint[0]=j;
                    calcPoint[1]=i;
                    calcPoint[2]=mapMult[i][j];
                }
            }
        }
    }

    private static boolean isMultPoint(){
        boolean rsl = false;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (mapMult[i][j]>=mapWin[i][j]){
                    rsl=true;
                    calcPoint[0]=j;
                    calcPoint[1]=i;
                    calcPoint[2]=mapMult[i][j];
                }
            }
        }
        return rsl;
    }

    private static void makemapMult(){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                mapMult[i][j] = map[i][j]+mapMan[i][j];
            }
        }
//        for (int i=0; i<SIZE; i++) {
//            System.out.println(Arrays.toString(mapMult[i]));
//        }
    }

    private static void takeCorrect(char DOT){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++){
                if (mapDanger[i][j]>0){
                    switch (DOT){
                        case DOT_X:{
                            //Коррекция по горизонтали
                            if (isPointCorrection(j,i,DOT,'-') & mapDanger[i][j]>1) mapDanger[i][j]--;
                            //Коррекция по вертикали
                            if (isPointCorrection(j,i,DOT,'|') & mapDanger[i][j]>1) mapDanger[i][j]--;
                            //Коррекция по слэш
                            if (isPointCorrection(j,i,DOT,'/') & mapDanger[i][j]>1) mapDanger[i][j]--;
                            //Коррекция по обратному слэшу
                            if (isPointCorrection(j,i,DOT,'b') & mapDanger[i][j]>1) mapDanger[i][j]--;
                        }
                        case DOT_0:{
                            if (isPointCorrection(j,i,DOT,'-') & mapWin[i][j]>1) mapWin[i][j]--;
                            //Коррекция по вертикали
                            if (isPointCorrection(j,i,DOT,'|') & mapWin[i][j]>1) mapWin[i][j]--;
                            //Коррекция по слэш
                            if (isPointCorrection(j,i,DOT,'/') & mapWin[i][j]>1) mapWin[i][j]--;
                            //Коррекция по обратному слэшу
                            if (isPointCorrection(j,i,DOT,'b') & mapWin[i][j]>1) mapWin[i][j]--;
                        }
                    }

                }
            }
        }
    }

    private static boolean isPointCorrection(int x, int y, char DOT, char flag){
       boolean rsl = false;
       switch (flag){
           case '-':{
               rsl = ((x+1<SIZE)&&(mapGame[y][x+1]==DOT) & ((x-1>=0)&&mapGame[y][x-1]==DOT));
               break;
           }
           case '|':{
               rsl = ( (y+1<SIZE) && (mapGame[y+1][x]==DOT) & ((y-1>=0) && (mapGame[y-1][x]==DOT)) );
               break;
           }
           case '/':{
               rsl = ((y+1<SIZE) && (x-1>=0) && (mapGame[y+1][x-1]==DOT)) & ((y-1>=0) && (x+1<SIZE) && (mapGame[y-1][x+1]==DOT));
               break;
           }
           case 'b':{
               rsl = ((y+1<SIZE) && (x+1<SIZE) && (mapGame[y+1][x+1]==DOT)) & ((y-1>=0) && (x-1>=0) && (mapGame[y-1][x-1]==DOT));
               break;
           }
       }
       return rsl;
    }

    private static boolean checkStandoff(){
        //boolean rsl=false;
        int count =0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++){
                if (map[i][j]==0) count++;
            }
        }
        return count==SIZE*SIZE;
    }

    private static void takeTurnPoint() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++){
                if (map[i][j]>calcPoint[2]){
                    calcPoint[0]=j;
                    calcPoint[1]=i;
                    calcPoint[2]=map[i][j];
                }
            }
        }
    }

    private static boolean isTurnPoint() {
        boolean rsl =false;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++){
                if (map[i][j]>0){
                    calcPoint[0]=j;
                    calcPoint[1]=i;
                    calcPoint[2]=map[i][j];
                    rsl=true;
                }
            }
        }
        return rsl;
    }
//Может здесь поставить мэпМэн
    private static boolean isCalcPoint() {
        boolean rsl=false;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (mapDanger[i][j]==1){
                    calcPoint[0]=j;
                    calcPoint[1]=i;
                    calcPoint[2]=map[i][j];
                    rsl=true;
                }
            }
        }
        return rsl;
    }

    private static void takeCalcPoint() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (mapDanger[i][j]==1){
                    if (map[i][j]>calcPoint[2]){
                        calcPoint[0]=j;
                        calcPoint[1]=i;
                        calcPoint[2]=map[i][j];
                    }
                }
            }
        }
    }

    private static void makeMapDanger(){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                mapDanger[i][j] = LINE;
            }
        }
//        for (int i=0; i<SIZE; i++) {
//            System.out.println(Arrays.toString(mapDanger[i]));
//        }

        //int a = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++){
                if(mapGame[i][j]==DOT_X){
                    countHorizontLine(j,i, DOT_X);
                    countVertLine(j,i, DOT_X);
                    countSleshLine(j,i, DOT_X);
                    countBackSleshLine(j,i, DOT_X);
                }
            }
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(mapGame[i][j] == DOT_X) mapDanger[i][j]=0;
                if(mapGame[i][j] == DOT_0) mapDanger[i][j]=0;
            }
        }

        takeCorrect(DOT_X);

//        for (int i=0; i<SIZE; i++) {
//            System.out.println(Arrays.toString(mapDanger[i]));
//        }
    }

    private static void makeMapWin(){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                mapWin[i][j] = LINE;
            }
        }

        //int a = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++){
                if(mapGame[i][j]==DOT_0){
                    countHorizontLine(j,i, DOT_0);
                    countVertLine(j,i, DOT_0);
                    countSleshLine(j,i, DOT_0);
                    countBackSleshLine(j,i, DOT_0);
                }
            }
        }
//        System.out.println("Win");
//        for (int i=0; i<SIZE; i++) {
//            System.out.println(Arrays.toString(mapWin[i]));
//        }
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (mapGame[i][j] == DOT_X) mapWin[i][j]=0;
                if (mapGame[i][j] == DOT_0) mapWin[i][j]=0;
                if (map[i][j]==0) mapWin[i][j]=0;
            }
        }
        takeCorrect(DOT_0);
//        for (int i=0; i<SIZE; i++) {
//            System.out.println(Arrays.toString(mapWin[i]));
//        }
    }

    private static void countHorizontLine(int x, int y, char DOT){
        int cl=0;
        //int cl_L=0;
        for (int i =0; i<SIZE; i++){
            if ((x+i<SIZE) && (mapGame[y][x+i]==DOT)) cl++;
            canPointWrite(x+i,y, DOT, cl);
        }
        //return cl;
        cl=0;
        for (int i =0; i<SIZE; i++){
            if ((x-i>=0) && (mapGame[y][x-i]==DOT)) cl++;
            canPointWrite(x-i,y, DOT, cl);
        }
    }

    private static void countVertLine(int x, int y, char DOT){
        int cl=0;
        //int cl_L=0;
        for (int i =0; i<SIZE; i++){
            if ((y+i<SIZE) && (mapGame[y+i][x]==DOT)) cl++;
            canPointWrite(x,y+i, DOT, cl);
        }
        //return cl;
        cl=0;
        for (int i =0; i<SIZE; i++){
            if ((y-i>=0) && (mapGame[y-i][x]==DOT)) cl++;
            canPointWrite(x,y-i, DOT, cl);
        }
    }

    private static void countSleshLine(int x, int y, char DOT){
        int cl=0;
        //int cl_L=0;
        for (int i =0; i<SIZE; i++){
            if ((y-i>=0)&&(x+i<SIZE) && (mapGame[y-i][x+i]==DOT)) cl++;
            canPointWrite(x+i,y-i, DOT, cl);
        }
        //return cl;
        cl=0;
        for (int i =0; i<SIZE; i++){
            if ((y+i<SIZE)&&(x-i>=0) && (mapGame[y+i][x-i]==DOT)) cl++;
            canPointWrite(x-i,y+i, DOT, cl);
        }
    }

    private static void countBackSleshLine(int x, int y, char DOT){
        int cl=0;
        //int cl_L=0;\
        for (int i =0; i<SIZE; i++){
            if ((y+i<SIZE)&&(x+i<SIZE) && (mapGame[y+i][x+i]==DOT)) cl++;
            canPointWrite(x+i,y+i, DOT, cl);
        }
        //return cl;
        cl=0;
        for (int i =0; i<SIZE; i++){
            if ((y-i>=0)&&(x-i>=0) && (mapGame[y-i][x-i]==DOT)) cl++;
            canPointWrite(x-i,y-i, DOT, cl);
        }
    }

    //Проверка и запись количества оставшихся точек до построения линии в крайнюю точку
    private static void canPointWrite(int x, int y, char DOT, int cl){
        //boolean rsl = false;
        switch (DOT){
            case DOT_X:{
                if (((x>=0)&(x<SIZE)&(y>=0)&(y<SIZE))&&((mapGame[y][x]!=DOT_0)&(mapGame[y][x]!=DOT)&(mapDanger[y][x]>LINE-cl))) mapDanger[y][x] = LINE-cl;
                break;
            }
            case DOT_0:{
                if (((x>=0)&(x<SIZE)&(y>=0)&(y<SIZE))&&((mapGame[y][x]!=DOT_X)&(mapGame[y][x]!=DOT)&(mapWin[y][x]>LINE-cl))) mapWin[y][x] = LINE-cl;
                break;
            }
        }
        //return rsl;
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
                if (isMakeLine(horizontPoint, vertPoint, 'X', '-')){
                //if (horizontPoint + (LINE-1) < SIZE){
                    for (int linePoint = 0; linePoint< LINE; linePoint++) {
                        map[vertPoint][horizontPoint+linePoint] ++;//по горизонтали
                    }
                }
                if (isMakeLine(horizontPoint, vertPoint, 'X', '|')){
                //if (vertPoint + (LINE-1) < SIZE){
                    for (int linePoint = 0; linePoint< LINE; linePoint++) {
                        map[vertPoint+linePoint][horizontPoint] ++;//по вертикали
                    }
                }
                if(isMakeLine(horizontPoint, vertPoint, 'X', 'b')){
                //if((vertPoint+(LINE-1) < SIZE) & (horizontPoint+(LINE-1) < SIZE)){
                    for (int linePoint = 0; linePoint< LINE; linePoint++){
                        map[vertPoint+linePoint][horizontPoint+linePoint]++;//\обратный слэш
                    }
                }
                if(isMakeLine(horizontPoint, vertPoint, 'X', '/')){
                //if((vertPoint+(LINE-1) < SIZE) & (horizontPoint-(LINE-1) >= 0)){
                    for (int linePoint = 0; linePoint< LINE; linePoint++){
                        map[vertPoint-linePoint][horizontPoint+linePoint]++;//прямой слэш
                    }
                }
            }
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                //if(mapGame[i][j] == DOT_X) map[i][j]=0;
                if(mapGame[i][j] == DOT_0) map[i][j]=0;
            }
        }
//        for (int i=0; i<SIZE; i++) {
//            System.out.println(Arrays.toString(map[i]));
//        }
    }

    private static void makeMapMan(){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                mapMan[i][j] = 0;
            }
        }
        for (int vertPoint=0; vertPoint<SIZE; vertPoint++){
            for (int horizontPoint =0; horizontPoint< SIZE; horizontPoint++){
                //isMakeLine(int x, int y, char DOT, char flag)
                if (isMakeLine(horizontPoint, vertPoint, DOT_0, '-')){
                    //if (horizontPoint + (LINE-1) < SIZE){
                    for (int linePoint = 0; linePoint< LINE; linePoint++) {
                        mapMan[vertPoint][horizontPoint+linePoint] ++;//по горизонтали
                    }
                }
                if (isMakeLine(horizontPoint, vertPoint, DOT_0, '|')){
                    //if (vertPoint + (LINE-1) < SIZE){
                    for (int linePoint = 0; linePoint< LINE; linePoint++) {
                        mapMan[vertPoint+linePoint][horizontPoint] ++;//по вертикали
                    }
                }
                if(isMakeLine(horizontPoint, vertPoint, DOT_0, 'b')){
                    //if((vertPoint+(LINE-1) < SIZE) & (horizontPoint+(LINE-1) < SIZE)){
                    for (int linePoint = 0; linePoint< LINE; linePoint++){
                        mapMan[vertPoint+linePoint][horizontPoint+linePoint]++;//\обратный слэш
                    }
                }
                if(isMakeLine(horizontPoint, vertPoint, DOT_0, '/')){
                    //if((vertPoint+(LINE-1) < SIZE) & (horizontPoint-(LINE-1) >= 0)){
                    for (int linePoint = 0; linePoint< LINE; linePoint++){
                        mapMan[vertPoint-linePoint][horizontPoint+linePoint]++;//прямой слэш
                    }
                }
            }
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(mapGame[i][j] == DOT_X) mapMan[i][j]=0;
//                if(mapGame[i][j] == DOT_0) mapMan[i][j]=0;
            }
        }
//        for (int i=0; i<SIZE; i++) {
//            System.out.println(Arrays.toString(mapMan[i]));
//        }
    }

    private static boolean chekWin(){
        int x = turnPoint[0];
        int y = turnPoint[1];
        char b = mapGame[y][x];

        boolean rsl = false;
        for (int i=0; i<SIZE;i++){
            for (int j=0; j<SIZE; j++){
                if (mapGame[i][j]==b){
                    int countX=0;
                    int countY=0;
                    int countSL=0;
                    int countOS=0;
                    //по х
                    for (int l = 0; l < LINE; l++){
                        if ((j+l<SIZE)&&mapGame[i][j+l]==b) countX++;
                    }
                    //по у
                    for (int l = 0; l < LINE; l++){
                        if ((i+l<SIZE)&&mapGame[i+l][j]==b) countY++;
                    }
                    //по SL
                    for (int l = 0; l < LINE; l++){
                        if ((i-l>=0)&&(j+l<SIZE)&&mapGame[i-l][j+l]==b) countSL++;
                    }
                    //по\ OS
                    for (int l = 0; l < LINE; l++){
                        if ((i+l<SIZE)&&(j+l<SIZE)&&mapGame[i+l][j+l]==b) countOS++;
                    }
                    if (countX>=LINE||countY>=LINE||countSL>=LINE||countOS>=LINE) rsl= true;
                }
            }
        }
        return rsl;
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
        if ((x < 0 || x >= SIZE || y < 0 || y >= SIZE)||(mapGame[y][x] == DOT_X || mapGame[y][x] == DOT_0)) rsl = true;
        //if (mapGame[y][x] == DOT_X || mapGame[y][x] == DOT_0) rsl = true;
        return rsl;
    }

    private static boolean isMakeLine(int x, int y, char DOT, char flag){
        boolean rsl = true;
        for (int i=0; i<LINE;i++){
            switch (flag) {
                case '-': {
                    //System.out.println("Jn dfv " +y+" "+" "+x+" "+" "+i);
                    if (x + i >= SIZE || (mapGame[y][x + i] == DOT)) rsl = false;
                    break;
                }
                case '|': {
                    if (y + i >= SIZE || mapGame[y + i][x] == DOT) rsl = false;
                    break;
                }
                case '/': {
                    //System.out.println("Jn dfv " +y+" "+" "+x+" "+" "+i);
                    if (y - i < 0 || x + i >= SIZE || mapGame[y - i][x+i] == DOT) rsl = false;
                    break;
                }
                case 'b': {
                    if (y + i >= SIZE || x + i >= SIZE || mapGame[y + i][x + i] == DOT) rsl = false;
                    break;
                }
            }
        }
        //System.out.println(rsl);
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
