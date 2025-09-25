import java.util.*;

public class MyFirstProgram {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		do {
			System.out.println(i);
			i = i - 1;
		} while(i > 0);
	}
}