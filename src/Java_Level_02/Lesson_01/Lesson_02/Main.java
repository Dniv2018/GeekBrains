package Java_Level_02.Lesson_01.Lesson_02;

public class Main {
    public static void main(String[] args) {

        Solid notright1 = new Solid("Массив №1 с нарушенной размерностью", new String[][] {{"1","1","1"}, {"1","1"}});
        Solid notright2 = new Solid("Массив №2 с нарушенной размерностью", new String[][] {{"1","1","1","1","1"}, {"1","1"}, {"1","1"},{"1","1"}});
        Solid notright3 = new Solid("Массив №3 с нарушенной размерностью", new String[][] {{"1","1","1","1"}, {"1","1"}, {"1","1"}, {"1","1"}});
        Solid error = new Solid("Массив с ошибками", new String[][] {{"1","1","1","1"},{"1","З", null,"1"},{"1","I","1","1"},{"1","1","1","1"}});
        Solid right = new Solid("Правильный массив", new String[][] {{"1","1","1","1"},{"1","1","1","1"},{"1","1","1","1"},{"1","1","1","1"}});

        MyArrays arrays = new MyArrays(right, error, notright3, notright2, notright1);


        int count;

        for (Solid a: arrays.getArray()) {
            System.out.println(a.getName());
            String[][] massif = a.getMass();

            int len = massif.length;
            if (len != 4) throw new MyArraySizeException
                    ("Ощибка размера массива. Число строк: надо - 4, найдено - " + len);
            for (int i=0; i<len;i++){
                int innerLen = massif[i].length;
                if (innerLen !=4) throw new MyArraySizeException
                        ("Ощибка размера массива. Число столбцов в строке с индексом " + i + ": надо - 4, найдено - " + innerLen);
            }

            count = 0;
            for (int i=0; i<4;i++){
                for (int j=0; j<4;j++){
                    try {
                        count += Integer.parseInt(massif[i][j]);
                    }catch (MyArrayDataException e){
                        System.out.println("В ячейке с координатами: [" + i + "][" + j + "] лежат неверные данные");
                    }
                }
            }
//            System.out.println(massif.length);
//            System.out.println(massif[0].length);
//            System.out.println(massif[1].length);
            System.out.println(a.getName() + " имеет сумму " + count);
            System.out.println(" ");
        }

    }
}
