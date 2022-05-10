package Java_Level_02.Lesson_02;

public class MyArrays {
    private Solid[] myArr;

    public MyArrays(Solid... mass){
        this.myArr = mass;
    }

    public Solid[] getArray(){
        return this.myArr;
    }
}
