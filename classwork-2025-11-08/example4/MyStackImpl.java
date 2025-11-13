package example4;

import example2.MyArrayList;
import example2.MyList;

public class MyStackImpl<T> implements MyStack<T> {

    private MyList<T> list;

    public MyStackImpl() {
        list = new MyArrayList<>();
    }

    @Override
    public void put(T element) {
        list.add(element);
    }

    @Override
    public T pop() {
        if(list.isEmpty()) {
            System.out.println("MyStackImpl: стек пуст, нечего брать!");
            return null;
        }
        T result = list.findByIndex(list.size()-1);
        list.removeByIndex(list.size()-1);
        return result;
    }

    @Override
    public T peek() {
        if(list.isEmpty()) {
            System.out.println("MyStackImpl: стек пуст, нечего смотреть!");
            return null;
        }
        return list.findByIndex(list.size()-1);
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
