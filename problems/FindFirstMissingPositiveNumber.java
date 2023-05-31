/*
* Given an array of integers, find the first missing positive integer in linear time and constant space.
* In other words, find the lowest positive integer that does not exist in the array.
* The array can contain duplicates and negative numbers as well.
* For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
*/
package problems;

import java.util.Scanner;

public class FindFirstMissingPositiveNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of entries in array");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Enter " + n + "  numbers");
        for (int i =0; i< n; i++) {
            array[i] = scanner.nextInt();
        }

        // move all the negative numbers to the beginning of the array.
        // These numbers will be omitted since we want the smallest missing positive number.
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] <= 0) {
                int temp = -array[i];
                array[i] = array[j];
                array[j] = temp;
                j++;
            }
        }

        // start from the first positive index (j)
        for (int i = j; i < n ; i++) {
            int number = Math.abs(array[i]);

            // mark the array[index] visited by marking it as -number
            // in case of duplicates, the number should still be counted as visited (-ve)
            // Hence we use Math.abs()
            if (number <= n) {
                array[number-1] = -Math.abs(array[number-1]);
            }
        }

        // the index of the first positive number is the missing number
        for (int i = 0; i < n; i++) {
            if (array[i] >= 0) {
                System.out.println("First missing number is " + (i+1));
                break;
            }
        }
    }
}
