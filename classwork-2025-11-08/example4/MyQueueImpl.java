package example4;

import example2.MyArrayList;
import example2.MyList;

public class MyQueueImpl<T> implements MyQueue<T> {

    private MyList<T> list;

    public MyQueueImpl() {
        list = new MyArrayList<>();
    }

    @Override
    public void add(T element) {
        list.add(element);
    }

    @Override
    public T get() {
        if(list.isEmpty()) {
            System.out.println("MyQueueImpl: очередь пуста, нечего брать!");
            return null;
        }
        T result = list.findByIndex(0);
        list.removeByIndex(0);
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
