package example2;

public interface MyList<T> {

    void add(T e);

    void insert(T e, int index);

    boolean remove(T e);

    boolean removeByIndex(int index);

    T findByIndex(int index);

    void printList();

    int size();

    boolean isEmpty();

}
