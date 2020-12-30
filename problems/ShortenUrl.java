// shortenUrl Functionality
package problems;

import java.util.*;
import java.util.stream.Collectors;

public class ShortenUrl {
    static Map<String, String> urls = new HashMap<>();

    public static void main(String[] args) {
        int option; // to choose between shortening url (Option 1) or retrieving the original url (Option 2)
        String answer; // to continue or not
        String url; // entered URL

        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Choose the operation to be performed: \n" +
                    "1. Shorten URL \n" +
                    "2: Retrieve URL");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Enter URL");
                    url = scanner.next();
                    System.out.println("Shortened Key: " + shortenUrl(url));
                    break;
                case 2:
                    System.out.println("Enter Key");
                    url = scanner.next();
                    System.out.println("Original URL: " + restore(url));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid Option selected");
            }
            System.out.println("Do you want to continue (y/n)");
            answer = scanner.next();
        } while (answer.equalsIgnoreCase("y"));

    }

    private static String shortenUrl(String url) {
        List<String> found = urls.entrySet().stream().filter(entry -> entry.getValue().equals(url)).map(Map.Entry::getKey).collect(Collectors.toUnmodifiableList());
        if (found.isEmpty()) {
            String key;
            do {
             key = generateKey();
            } while (urls.containsKey(key)); // keep generating key until unque key is obtained
            urls.put(key, url);
            return key;
        } else {
            return found.get(0);
        }
    }

    private static String generateKey() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    private static String restore(String shortenedUrl) {
        return urls.getOrDefault(shortenedUrl, "Not found");
    }

}
