
public class LinkedListOfInts implements ListOfInts {
    private Node head;      //Ссылка на начало списка
    private Node tail;      //Последний элемент списка
    private int size;

    //Пустой список
    public LinkedListOfInts() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    //Узел связного списка
    static class Node {
        private int value;
        private Node next;
        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private boolean isCorrectIndex(int index) {
        return index >= 0 && index < size;
    }

    private Node findElement(int index) {
        if(!isCorrectIndex(index)) {
            throw new IndexOutOfBoundsException("Index out of bounds!");
        }

        int counter = 0;
        Node currentNode = head;
        while(counter < index) {
            ++counter;
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int get(int index) {
        return findElement(index).value;
    }

    @Override
    public void set(int index, int value) {
        findElement(index).value = value;
    }

    @Override
    public void insert(int index, int value) {
        Node currentNode = findElement(index);
        // [currentNode -> currentNode.next -> currentNode.next.next]
        // [currentNode -> newElement -> currentNode.next -> currentNode.next.next]
        Node next = currentNode.next;
        Node newElement = new Node(value);
        currentNode.next = newElement;
        newElement.next = next;

        ++size;
    }

    @Override
    public void remove(int index) {
        if(index == 0) {
            head = head.next;
            return;
        }

        Node node = findElement(index - 1);
        // [currentNode -> currentNode.next -> currentNode.next.next]
        // [currentNode -> currentNode.next.next]
        node.next = node.next.next;

        if(index == size - 1) {
            tail = node;
        }
        size--;
    }

    @Override
    public void add(int value) {
        if(head == null) {
            head = new Node(value);
            tail = head;
        }
        else {
            tail.next = new Node(value);
            tail = tail.next;
        }
        ++size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node cur = head;
        while(cur.next != null) {
            result.append(cur.value);
            result.append(", ");
            cur = cur.next;
        }
        result.append(cur.value);
        result.append("]");
        return result.toString();
    }
}
