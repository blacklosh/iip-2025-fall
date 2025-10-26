public class FunctionExample {

    public static void main(String[] args) {
        System.out.println("123");
        printLine();
        System.out.println("654");
        printLine();
        System.out.println(sum(100, 200));
        System.out.println(sum(10, 400));
    }

    public static void printLine() {
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=--=-");
    }

    public static int sum(int a, int b) {
        return a + b;
    }
}
