package tasks;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Task2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (set.contains(num)) {
                System.out.println(num);
                return;
            }
            set.add(num);
        }
        System.out.println("No");
    }
}
