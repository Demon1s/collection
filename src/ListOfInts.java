
public interface ListOfInts {
    int size();
    int get(int index);
    void set(int index, int value);
    void insert(int index, int value);  //После элемента с индексом index вставить элемент value.
    void remove(int index);             //Удалить элемент с индексом index
    void add(int value);                //Добавить в конец
}
