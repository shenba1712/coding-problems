// Given an array of integers, return a new array such that each element at index i of the new array
// is the product of all the numbers in the original array except the one at i.
// without using division

package problems;

import java.util.Arrays;
import java.util.Scanner;

public class ProductOfArrayNonDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of entries in array");
        int n = scanner.nextInt();
        int[] array = new int[n];
        long[] productArray = new long[n];
        // temp is used to hold the temporary product of each index, so that it can be used to calculate the next one
        int temp = 1;

        System.out.println("Enter " + n + "  numbers");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        // initialize product array values with 1
        for (int i = 0; i < n; i++) {
            productArray[i] = 1;
        }

        // first iteration (each index has the product of the numbers before it)
        for (int i =0; i< n; i++) {
            productArray[i] = temp;
            temp *= array[i];
        }

        temp = 1;
        // second iteration (each index has the value multiplied with value after the number)
        for (int i = n-1; i >= 0; i--) {
            productArray[i] *= temp;
            temp *= array[i];
        }

        // print array
        System.out.println(Arrays.toString(productArray));

    }
}
