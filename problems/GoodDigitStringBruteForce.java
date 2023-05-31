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

// This solution is not the optimal solution.
// It's the brute force approach used to explain this article: https://medium.com/@shenbagalakshmi/an-interesting-math-question-that-a-senior-developer-loves-asking-in-interviews-39aff813a5aa

package problems;

import java.util.Scanner;
import java.util.stream.IntStream;

public class GoodDigitStringBruteForce {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter length of string");
        long n = scanner.nextInt();

        if (n == 0) {
            System.out.println("Length cannot be zero");
            return;
        }

        long count = findGoodDigitStrings(n);
        int simplifiedCount = (int) (count % (1e9 + 7));
        System.out.println("Total number of good digits of length n: " + simplifiedCount);
    }

    private static long findGoodDigitStrings(long length) {
        long count = 0;
        long upperLimit = (long) Math.pow(10, length);
        boolean isGoodDigitString;
        for (long i = 0; i < upperLimit; i++) {
            isGoodDigitString = true;
            char[] digitStringCharArray = getDigitString(length, i).toCharArray();
            for (long j = 0; j < length; j++) {
                if (j % 2 == 0) {
                    if (!checkEven(digitStringCharArray[(int) j])) {
                        isGoodDigitString = false;
                        break;
                    }
                } else {
                    if (!checkPrime(digitStringCharArray[(int) j])) {
                        isGoodDigitString = false;
                        break;
                    }
                }
            }
            if (isGoodDigitString) {
                count++;
            }
        }
        return count;
    }

    private static String getDigitString(long length, long number) {
        StringBuilder sb = new StringBuilder();
        long numLength = number == 0 ? 1 : (long) (Math.log10(number) + 1);
        if (numLength == length) {
            return String.valueOf(number);
        } else {
            while (sb.length() < length - numLength) {
                sb.append('0');
            }
            sb.append(number);
            return sb.toString();
        }
    }

    private static boolean checkEven(char digitChar) {
        int digit = Character.getNumericValue(digitChar);
        return (digit % 2) == 0;
    }

    private static boolean checkPrime(char digitChar) {
        int digit = Character.getNumericValue(digitChar);
        return digit > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(digit))
                .noneMatch(n -> (digit % n == 0));
    }
}
