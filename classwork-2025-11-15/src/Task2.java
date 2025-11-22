import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task2 {

    private static List<String> list1 = List.of(
            "abc",
            "bcd",
            "123",
            "321"
    );

    private static List<String> list2 = List.of(
            "fgh",
            "bcd",
            "ahg",
            "321",
            "987",
            "000"
    );

    public static void main(String[] args) {
        //System.out.println(intersection());
        //System.out.println(xor());

    }

    public static List<String> xor() {
        List<String> united = union();
        united.removeAll(intersection());
        return united;
    }

    public static List<String> union() {
        Set<String> set = new HashSet<>(list1);
        set.addAll(list2);
        return new ArrayList<>(set);
    }

    public static List<String> intersection() {
        Set<String> set1 = new HashSet<>(list1);
        Set<String> set2 = new HashSet<>(list2);
        List<String> list = new ArrayList<>();

        for (String el1 : set1) {
            if (set2.contains(el1)) {
                list.add(el1);
            }
        }

        return list;
    }
}
