package example4;

import example5.MyMap;
import example5.MyMapImpl;

import java.util.*;

public class Main3 {

    public static void main(String[] args) {
        //testStack();
        //testQueue();
        testMap();

        //Queue<Integer> queue = new LinkedList<>();
        //Deque<Integer> deque = new LinkedList<>();
        //Stack<Integer> stack = new Stack<>();
    }

    private static void testStack() {
        MyStack<Integer> stack = new MyStackImpl<>();

        stack.put(1);
        stack.put(10);
        stack.put(100);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    private static void testQueue() {
        MyQueue<Integer> queue = new MyQueueImpl<>();

        queue.add(10);
        queue.add(12);
        queue.add(15);

        System.out.println(queue.get());
        System.out.println(queue.get());
        System.out.println(queue.get());
        System.out.println(queue.get());
    }

    private static void testMap() {
        MyMap<Integer, String> map = new MyMapImpl<>();

        map.put(1, "Fedor");
        map.put(2, "Marsel");
        map.put(2, "Marsel2");

        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.get(3));
    }
}
