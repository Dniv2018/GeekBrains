package Java_Level_02.Lesson_03;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        1. Создать массив с набором слов(10 - 20слов, должны встречаться повторяющиеся).Найти и вывести
//        список уникальных слов, из которых состоит массив(дубликаты не считаем).Посчитать сколько раз встречается каждое
//        слово.
        String[] str = {"main", "public", "class", "static", "String", "java", "class", "massif", "array", "Class", "java", "java"};
        HashMap<String, Integer> hm_collection = new HashMap<>();

        for (String arr: str) {
            hm_collection.put(arr, 0);
        }
        for (Map.Entry<String, Integer> hm: hm_collection.entrySet()) {
            for (String innerArr: str) {
                if (innerArr.equals(hm.getKey())){
                    hm_collection.put(hm.getKey(), hm.getValue()+1);
                }
            }
        }
        System.out.println(hm_collection);
    }
}
