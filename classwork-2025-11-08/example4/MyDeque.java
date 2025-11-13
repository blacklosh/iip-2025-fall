package example4;

public interface MyDeque<T> {

    void addToEnd(T element);

    T getFromStart();

    void addToStart(T element);

    T getFromEnd();

    int size();

    boolean isEmpty();

}
