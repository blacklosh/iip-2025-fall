public class IndexOfExample {

    public static void main(String[] args) {
        String str = "Hello world from java";
        int position = str.indexOf("world");
        int lastPosition = str.lastIndexOf('o');
        System.out.println(position);
        System.out.println(lastPosition);
    }

}
