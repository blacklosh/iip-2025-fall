package example4;

import example2.MyArrayList;
import example2.MyList;

public class MyDequeImpl<T> implements MyDeque<T> {

    private MyList<T> list;

    public MyDequeImpl() {
        list = new MyArrayList<>();
    }

    @Override
    public void addToEnd(T element) {
        list.add(element);
    }

    @Override
    public T getFromStart() {
        if(list.isEmpty()) {
            System.out.println("MyDequeImpl: очередь пуста, нечего брать!");
            return null;
        }
        T result = list.findByIndex(0);
        list.removeByIndex(0);
        return result;
    }

    @Override
    public void addToStart(T element) {
        list.insert(element, 0);
    }

    @Override
    public T getFromEnd() {
        if(list.isEmpty()) {
            System.out.println("MyDequeImpl: очередь пуста, нечего брать!");
            return null;
        }
        T result = list.findByIndex(list.size()-1);
        list.removeByIndex(list.size()-1);
        return result;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
