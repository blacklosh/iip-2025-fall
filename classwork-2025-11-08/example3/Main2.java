package example3;

import java.util.ArrayList;
import java.util.List;

public class Main2 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("123");
        list.add("abc");
        list.add("ahahhaa");

        list.remove("abc");

        System.out.println(list);
    }

}
