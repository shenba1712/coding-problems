// Given a sorted array of integers that has been rotated unknown number of times,
// Find the index of integer k in less than O(n) time.
// Eg: array = [13, 18, 25, 30, 56, 2, 8, 10], k = 8 Ans: 6

/* LOGIC:
Perform binary search, but compare with the first number to determine which section of the elements should be checked next.
*/

package problems;

import java.util.Scanner;

public class BinarySearchArrayRotation {

    public static void main(String[] args) {
        int[] array = new int[]{2, 8, 10, 13, 18, 25, 30, 56, 70};
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number to found");
        int k = scanner.nextInt();

        int index = findIndex(array, k);
        System.out.println( k + " is in index: " + index);
    }

    private static int findIndex(int[] array, int k ) {
       if (array.length == 0) {
           return -1;
       }
       return binarySearch(array, k, 0, array.length - 1);
    }

    private static int binarySearch(int[] array, int k, int minIndex, int maxIndex) {
        int selectedIndex = (minIndex + maxIndex) / 2;
         if (array[selectedIndex] == k) {
             return selectedIndex;
         }

         if (minIndex == maxIndex) {
             return -1;
         }

         if (array[minIndex] == k) {
             return minIndex;
         }

         if (array[maxIndex] == k) {
             return maxIndex;
         }

         if (array[selectedIndex] > k) {
             if (k < array[minIndex]) {
                 return binarySearch(array, k, selectedIndex + 1 <= array.length ? selectedIndex + 1 : selectedIndex, maxIndex);
             } else {
                 return binarySearch(array, k, minIndex, Math.max(selectedIndex - 1, 0));
             }
         } else {
             return binarySearch(array, k, selectedIndex + 1 <= array.length ? selectedIndex + 1 : selectedIndex, maxIndex);
         }
    }
}
