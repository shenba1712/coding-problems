// Given an array of integers, return a new array such that each element at index i of the new array
// is the product of all the numbers in the original array except the one at i.
package problems;

import java.util.Arrays;
import java.util.Scanner;

public class ProductOfAllNumbersDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of entries in array");
        int n = scanner.nextInt();
        int[] array = new int[n];
        long[] productArray = new long[n];

        System.out.println("Enter " + n + "  numbers");
        for (int i =0; i< n; i++) {
            array[i] = scanner.nextInt();
        }

        long product = 1L;
        for (int a: array) {
            product *= a;
        }

        for (int i=0; i< array.length; i++) {
            productArray[i] =  product / array[i];
        }
        System.out.println("Product Array: " + Arrays.toString(productArray));
    }
}
