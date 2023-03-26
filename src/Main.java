

public class Main {
    public static void main(String[] args) {

        ArrayListOfInts arrays = new ArrayListOfInts();
        arrays.add(1);
        arrays.add(2);
        arrays.insert(1,111);


        System.out.println(arrays.toStrings());
        System.out.println("Размер массива: " +arrays.size());



    }
}
