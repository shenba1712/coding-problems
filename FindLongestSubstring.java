// Given an integer k and a string a, find the longest substring in a that contains k distinct characters
// Eg: if k = 2 and a = 'abcba', then the answer is 'bcb'

/*
* Assumptions: Return the first longest string when there are multiple longest strings
* Return nil when there are no enough distinct characters in the provided string.
* k should always be greater than 0 (obviously)
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindLongestSubstring {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter k value (number of distinct characters)");
        int k = scanner.nextInt();

        if (k <= 0) {
            System.out.println("k should be greater than zero");
            return;
        }

        System.out.println("Enter the string");
        String a = scanner.next();

        System.out.println("Longest String: " + findLongestSubstring(k, a));
    }

    private static String findLongestSubstring(int n, String s) {
        StringBuilder longest = new StringBuilder();
        StringBuilder currentSubString = new StringBuilder();
        // if n = 1, then we need to only check for the same consecutive char. If the char changes, then we check if the current string is the longest.
        // If yes, then update the longest string and change the character sequence and check if there is a longer sequence with this character.
        if (n == 1) {
            char currentChar = ' ';
            for (char c: s.toCharArray()) {
                if (c == currentChar) {
                    currentSubString.append(c);
                } else {
                    currentChar = c;
                    if (longest.length() < currentSubString.length()) {
                        longest = currentSubString;
                    }
                    currentSubString = new StringBuilder();
                    currentSubString.append(c);
                }
            }
        } else {
            // when n is greater than 1, then we maintain a character list to keep track of the distinct characters in the substring.
            // we try to build the substring char by char and when there is a new char apart from n distinct ones, then we remove the first char
            // and build the new substring with the new char added.
            // We also check if the substring is longer than the previous one and update accordingly
            List<Character> characterList = new ArrayList<>();
            char prevChar = ' ';

            for (char c: s.toCharArray()) {
                if (characterList.size() > 0) {
                    // check if the char is already available in the list. If yes, then we just update the substring since it will be part of the existing substring.
                    boolean isAlreadyAvailable = characterList.stream().anyMatch(character -> character == c);
                    if (isAlreadyAvailable) {
                        prevChar = c;
                        currentSubString.append(c);
                    } else {
                        // when there are already n char, then we should remove the oldest char and add the new char to the list.
                        // Update longest string if current substring is longer
                        // Update currentSubstring by only removing the part till the removed char is present.
                        // So that the new substring will no longer have the removed char.
                        if (characterList.size() == n) {
                            char toBeRemoved = ' ';
                            for (char ch: characterList) {
                                if (ch != prevChar) {
                                    toBeRemoved = ch;
                                    break;
                                }
                            }
                            characterList.remove(Character.valueOf(toBeRemoved));

                            if (longest.length() < currentSubString.length()) {
                                longest.replace(0, longest.length(), currentSubString.toString());
                            }
                            int index = currentSubString.lastIndexOf(String.valueOf(toBeRemoved));
                            currentSubString.delete(0, index+1);
                        }
                        prevChar = c;
                        characterList.add(c);
                        currentSubString.append(c);
                    }
                } else {
                    // when the first char is processed, characterList is empty, so we just update the values.
                    characterList.add(c);
                    prevChar = c;
                    currentSubString.append(c);
                }
            }
            // throw error when there are not enough distinct characters in the search string
            if (characterList.size() != n) {
                System.out.println("No match with " + n + " distinct characters");
                return "-";
            }
        }
        if (longest.length() < currentSubString.length()) {
            longest = currentSubString;
        }
        return longest.toString();
    }
}
