package example4;

public interface MyQueue<T> {

    void add(T element);

    T get();

    int size();

    boolean isEmpty();

}
