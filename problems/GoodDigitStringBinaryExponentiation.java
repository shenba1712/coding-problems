/**
 * A digit string is good if the digits (0-indexed) at even indices are even,
 * and the ones at odd indices are prime (2, 3, 5, or 7).
 * Given an integer, n, return the total number of good digit strings of length n.
 * Since the answer can be large, please return it as modulo 1e9 + 7.
 * A digit string is a string of digits 0-9 and may contain leading zeros.
 * For example,
 * "4567" is good because the digits (4 and 6) at even positions are even, and the digits (5 and 7) at odd indices are prime.
 * "7245" is not good because 7 is at an even index but is not even.
 * "6923" is not good because 9 is at an odd index but is not a prime number.
 **/

// Explanation: https://medium.com/@shenbagalakshmi/an-interesting-math-question-that-a-senior-developer-loves-asking-in-interviews-39aff813a5aa

package problems;

import java.util.Scanner;

public class GoodDigitStringBinaryExponentiation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter length of string");
        long n = scanner.nextInt();

        if (n == 0) {
            System.out.println("Length cannot be zero");
            return;
        }

        long evenIndexPower = (n % 2 == 0) ? n / 2 : n / 2 + 1;
        long oddIndexPower = n / 2;

        long evenIndex = binaryExpo(5, evenIndexPower);
        long oddIndex = binaryExpo(4, oddIndexPower);

        int count = (int) ((evenIndex * oddIndex) % (1e9 + 7));
        System.out.println("Total number of good digits of length n: " + count);
    }

    // Calculate pow(x,y) in O(log n)
    // Converting a decimal to binary requires dividing the number by 2 and setting the reminder as the digit.
    // And because the number gets halved every time, the time complexity is O(log n)
    private static long binaryExpo(long number, long power) {
        long temp;
        // base case (number^0 = 1)
        if (power == 0) {
            return 1;
        }
        // computing pow(number,power/2) -> calculating via binary representation
        temp = binaryExpo(number, power / 2);

        // result of sub problem when power is even (2^2 = 2^1 * 2^1)
        if (power % 2 == 0) {
            return (temp * temp);
        } else {
            // result of sub problem when power is odd (2^3 = 2 * 2^1 * 2^1)
            return (number * temp * temp);
        }
    }
}
