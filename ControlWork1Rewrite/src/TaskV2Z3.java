public class TaskV2Z3 {

    public static void main(String[] args) {
        System.out.println(replaceLast("Hello world", 'H', 'a'));
    }

    public static String replaceLast(String source, char target,
                                     char replacement) {
        int index = source.lastIndexOf(target);
        if(index == -1) return source;

        if(index == source.length() - 1) return source.substring(0, index) + replacement;
        return source.substring(0, index) + replacement + source.substring(index + 1);
    }
}
