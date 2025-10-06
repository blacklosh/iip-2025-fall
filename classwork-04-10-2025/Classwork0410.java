import java.util.Arrays;
import java.util.Scanner;

public class Classwork0410 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] array = new int[n];
        for(int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        // Task 1
        //System.out.println(findNumberInArray(array, 6));
        //System.out.println(findNumberInArray(array, 12));

        // Task 2
        // System.out.println(sum(array));

        // Task 3
        //System.out.println(findCountEvenNums(array));
        //System.out.println(secondMax(array));

        // Task 5
        // System.out.println(Arrays.toString(removeNegativNums(array)));

        // Task 6
        System.out.println(Arrays.toString(removeDubl(array)));

    }

    public static int findNumberInArray(int[] array, int s) {
        for(int i = 0; i < array.length; i++) {
            if(array[i] == s) {
                return i;
            }
        }
        return -1;
    }

    public static int sum(int[] array) {
        int summ = 0;
        for(int i = 0; i < array.length; i++) {
            summ+=(array[i]);
        }
        return summ;
    }

    public static int findCountEvenNums(int[] arr) {
        int count = 0;
        for (int e : arr) {
            if (e % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static int secondMax(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 2];
    }

    public static int[] removeNegativNums(int[] arr) {
        int cnt = 0;
        for (int i : arr){
            if (i >= 0) {
                cnt++;
            }
        }
        int[] newArr = new int[cnt];
        int flag = 0;
        for (int a : arr) {
            if (a >= 0) {
                newArr[flag] = a;
                flag++;
            }
        }
        return newArr;
    }

    public static int[] removeDubl(int[] arr) {
        int[] arrays = new int[101];
        for (int i = 0; i < 101; i++) {
                arrays[i] = 0;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arrays[arr[i]] == 0) {
                arrays[arr[i]] = 1;
            } else {
                arr[i] = 0;
            }
        }
        return arr;
    }
}

