import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();

        if (inputString.length() == 0) {
            throw new IllegalArgumentException("Illegal input: empty string");
        }

        inputString = inputString.toLowerCase();
        String[] words = inputString.split(" ");

        Map<String, Boolean> wordInwords = new HashMap<>();
        long result = 0;

        for (int i = 0; i < words.length; i++) {
            if (!(words[i].equals("a") || words[i].equals("an") || words[i].equals("the"))) {
                if (!wordInwords.containsKey(words[i])) {
                    wordInwords.put(words[i], false);
                }
                for (int j = 0; j < words.length; j++) {
                    if (i != j) {
                        if (words[i].equals(words[j])) {
                            wordInwords.put(words[i], true);
                        } else if (words[j]. length() > words[i].length()) {
                            for (int k = 0; k < words[j]. length() - words[i].length() + 1; k++) {
                                if (words[j].substring(k, k + words[i].length()).equals(words[i])) {
                                    wordInwords.put(words[i], true);
                                }
                            }
                        }
                    }
                }
            }
        }
        result = wordInwords.values().stream().filter(s -> s == true).count();
        System.out.println(result);
    }
}