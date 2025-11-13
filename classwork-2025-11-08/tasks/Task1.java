package tasks;

import java.util.Scanner;
import java.util.Stack;

public class Task1 {
    public static void main(String[] args) {
        //[({})]
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        String strochka = sc.nextLine();
        for(char ch : strochka.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if(stack.isEmpty()) {
                    System.out.println("Не пошло");
                    return;
                }
                char lastSymb = stack.peek();
                if((lastSymb + "" + ch).equals("()") ||
                        (lastSymb + "" + ch).equals("{}") ||
                        (lastSymb + "" + ch).equals("[]")) {
                    stack.pop();
                } else {
                    System.out.println("Не пошло");
                    return;
                }
            }
        }
        System.out.println(stack.isEmpty() ? "Все круто" : "Не пошло");
    }
}
