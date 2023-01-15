import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class sol {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String s = sc.nextLine();
        HashMap<Character, Integer> mp = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ')
                c = '-';
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }
        mp.forEach((k, v) -> System.out.printf("%s: %d\n", k, v));
    }
}