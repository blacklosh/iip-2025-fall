public class SplitExample {

    public static void main(String[] args) {
        String str = "Hello world from java";

        String[] words = str.split(" ");
        for(int i = words.length-1; i >= 0; i--) {
            System.out.println(words[i]);
        }
    }
}
