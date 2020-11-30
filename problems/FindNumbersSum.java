/* Given an array a and a number k, find 2 numbers from a that adds up to k
* For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
*/
package problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindNumbersSum {

    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of entries in array");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Enter " + n + "  numbers");
        for (int i =0; i< n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Enter sum value");
        int k = scanner.nextInt();
        findNumbers(array, k);
    }

    private static void findNumbers(int[] array, int sum ) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int value : array) {
            if (map.containsKey(sum - value)) {
                System.out.println("The numbers are " + value + ", " + map.get(sum - value));
                return;
            } else {
                map.put(value, value);
            }
        }
        System.out.println("No numbers that add up to the sum is found!");
    }
}
