import example1.MyIntArrayList;
import example2.MyArrayList;
import example2.MyList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> list = new MyArrayList<>();

        list.printList();

        for(int i = 0; i < 10; i++) {
            list.add(i * 10);
        }

        list.printList();

        list.insert(35, 6);

        list.printList();

        System.out.println(list.removeByIndex(5));
        System.out.println(list.removeByIndex(50));

        list.printList();

        System.out.println(list.remove(60));
        System.out.println(list.remove(60));

        list.printList();

        System.out.println("--------------------------------------------");

        MyList<String> list2 = new MyArrayList<>();

        list2.add("Hello");
        list2.add("world");
        list2.add("from");
        list2.add("java!");

        list2.remove("from");

        list2.printList();

        int a = 5;
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = null;
    }
}