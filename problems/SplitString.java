// Split the string to lines of k length. The words should not be split in between
// If string cannot be split, then return null
package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SplitString {
    public static void main(String[] args) {
        String string = "the quick brown fox jumps over the lazy dog";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter line length");
        int k = scanner.nextInt();

        String[] words =  string.split("\\s");
        List<String> lines = new ArrayList<>();

        StringBuilder currentLine = new StringBuilder("");

        for (String word: words) {
            if (word.length() > k) { // + 1 for the preceding space
                System.out.println("null");
                return;
            }
            if (currentLine.toString().isBlank()) {
                currentLine.append(word);
            } else {
                if (currentLine.length() + word.length() + 1 <= k ) {
                    currentLine.append(" ").append(word);
                } else {
                    lines.add(currentLine.toString());
                    // start next line
                    currentLine.setLength(0);
                    currentLine.append(word);
                }
            }
        }
        lines.add(currentLine.toString());
        System.out.println(lines);

    }
}
