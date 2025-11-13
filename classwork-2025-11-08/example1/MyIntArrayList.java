package example1;

public class MyIntArrayList {

    private int[] elements;
    private int capacity;
    private int fullness;

    public MyIntArrayList() {
        capacity = 8;
        fullness = 0;
        elements = new int[capacity];
    }

    public void add(int element) {
        if(fullness == capacity) {
            // Нужно пересоздать массив
            resize();
        }
        elements[fullness++] = element;
    }

    public void insert(int element, int index) {
        if(fullness == capacity) {
            // Нужно пересоздать массив
            resize();
        }
        if(index < 0 || index > fullness) {
            System.out.println("MyIntArrayList: нельзя вставить элемент на индекс " + index);
            return;
        }
        if(index == fullness) {
            add(element);
            return;
        }
        for(int i = fullness; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        fullness++;
    }

    public boolean remove(int element) {
        boolean flag = false;
        for(int i = 0; i < fullness; i++) {
            if(elements[i] == element) {
                flag |= removeByIndex(i);
            }
        }
        return flag;
    }

    public boolean removeByIndex(int index) {
        if(index < 0 || index >= fullness) {
            System.out.println("MyIntArrayList: невозможно удалить элемент по индексу " + index);
            return false;
        }
        for(int i = index; i < fullness - 1; i++) {
            elements[i] = elements[i + 1];
        }
        fullness--;
        return true;
    }

    public int findByIndex(int index) {
        if(index < 0 || index >= fullness) {
            System.out.println("MyIntArrayList: элемент по индексу " + index + " не найден!");
            return 0;
        }
        return elements[index];
    }

    public void printList() {
        if(isEmpty()) {
            System.out.println("MyIntArrayList[]");
            return;
        }
        System.out.print("MyIntArrayList[");
        for(int i = 0; i < fullness - 1; i++) {
            System.out.print(elements[i] + ", ");
        }
        System.out.println(elements[fullness-1] + "]");
    }

    public int size() {
        return fullness;
    }

    public boolean isEmpty() {
        return fullness == 0;
    }

    private void resize() {
        int[] newElements = new int[capacity * 2];
        for(int i = 0; i < capacity; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        capacity *= 2;
    }

}
