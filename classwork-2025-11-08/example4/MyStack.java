package example4;

public interface MyStack<T> {

    void put(T element);

    // Достать элемент с верха
    T pop();

    // Посмотреть на верхний элемент, не убирая его из структуры
    T peek();

    int size();

    boolean isEmpty();

}
