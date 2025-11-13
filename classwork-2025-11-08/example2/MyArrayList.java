package example2;

public class MyArrayList<T> implements MyList<T> {

    private T[] elements;
    private int capacity;
    private int fullness;

    public MyArrayList() {
        capacity = 8;
        fullness = 0;
        elements = (T[]) new Object[capacity];
    }

    @Override
    public void add(T element) {
        if(fullness == capacity) {
            // Нужно пересоздать массив
            resize();
        }
        elements[fullness++] = element;
    }

    @Override
    public void insert(T element, int index) {
        if(fullness == capacity) {
            // Нужно пересоздать массив
            resize();
        }
        if(index < 0 || index > fullness) {
            System.out.println("MyArrayList: нельзя вставить элемент на индекс " + index);
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

    @Override
    public boolean remove(T element) {
        boolean flag = false;
        for(int i = 0; i < fullness; i++) {
            if(elements[i].equals(element)) {
                flag |= removeByIndex(i);
            }
        }
        return flag;
    }

    @Override
    public boolean removeByIndex(int index) {
        if(index < 0 || index >= fullness) {
            System.out.println("MyArrayList: невозможно удалить элемент по индексу " + index);
            return false;
        }
        for(int i = index; i < fullness - 1; i++) {
            elements[i] = elements[i + 1];
        }
        fullness--;
        return true;
    }

    public T findByIndex(int index) {
        if(index < 0 || index >= fullness) {
            System.out.println("MyArrayList: элемент по индексу " + index + " не найден!");
            return null;
        }
        return elements[index];
    }

    public void printList() {
        if(isEmpty()) {
            System.out.println("MyArrayList[]");
            return;
        }
        System.out.print("MyArrayList[");
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
        T[] newElements = (T[]) new Object[capacity * 2];
        for(int i = 0; i < capacity; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        capacity *= 2;
    }
}
