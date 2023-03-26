

public class Main {
    public static void main(String[] args) {

        ArrayListOfInts arrays = new ArrayListOfInts();
        arrays.add(1);
        arrays.add(2);
        arrays.insert(0,111);
        arrays.insert(2,222);


        System.out.println(arrays.toStrings());
        System.out.println("Размер массива: " +arrays.size());



    }
}
