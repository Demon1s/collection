
import java.util.Arrays;

public class ArrayListOfInts implements ListOfInts {
    private int size;
    private int lastIndex;
    private int[] arr;


    //Пустой список
    public ArrayListOfInts() {
        this.lastIndex = 0;
        this.size = 0;
        this.arr = null;
    }

    private boolean isCorrectIndex(int index) {
        return index >= 0 && index < size;
    }

    private void findElement(int index) {
        if (!isCorrectIndex(index)) {
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int get(int index) {
        return arr[index];
    }

    @Override
    public void set(int index, int value) {
        arr[index] = value;
    }

    @Override
    public void insert(int index, int value) {
        findElement(index);
        if (size == lastIndex + 1) {
            int[] arrCopy = Arrays.copyOf(arr, size);
            this.arr = Arrays.copyOf(arrCopy, size * 2);
            size *= 2;
            for (int i = size - 1; i > index; i--) {
                arr[i] = arr[i - 1];
            }
            arr[index] = value;
            lastIndex++;
        } else {
            findElement(index);
            for (int i = size - 1; i > index; i--) {
                arr[i] = arr[i - 1];
            }
            arr[index] = value;
            lastIndex++;
        }

    }

    @Override
    public void remove(int index) {
        for (int i = index; i < lastIndex - 1; i++) {
            arr[i] = arr[i + 1];
        }
        lastIndex--;
    }

    @Override
    public void add(int value) {
        if (size == 0) {
            this.arr = new int[1];
            size = 1;
            arr[0] = value;
        } else if (size == lastIndex + 1) {
            int[] arrCopy = Arrays.copyOf(arr, size);
            this.arr = Arrays.copyOf(arrCopy, size * 2);
            arr[lastIndex + 1] = value;
            size *= 2;
            lastIndex++;
        } else {
            arr[lastIndex + 1] = value;
            lastIndex++;
        }
    }


    public String toStrings() {
        StringBuilder result = new StringBuilder("[");

        for (int i = 0; i < lastIndex + 1; i++) {
            result.append(arr[i]);
            result.append(" ");

        }
        result.append("]");
        return result.toString();
    }
}




