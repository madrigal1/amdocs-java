import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class sol {
    static Scanner sc = new Scanner(System.in);
    static FastReader fr = new FastReader();

    static class FastReader {
        static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st = new StringTokenizer("");

        String next() {
            try {
                while (!st.hasMoreTokens())
                    st = new StringTokenizer(br.readLine());
            } catch (Exception err) {
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(this.next());
        }
    }

    public static void main(String[] args) throws Exception {
        int n = fr.nextInt();
        int steps = 0;
        while (n != 1) {
            int nval = -1;
            if (n % 2 == 0) {
                nval = n / 2;
                System.out.printf("%d is even so i take half: %d\n", n, nval);
            } else {
                nval = 3 * n + 1;
                System.out.printf("%d is odd so i make 3n+2: %d\n", n, nval);
            }
            n = nval;
            steps++;
        }
        System.out.printf("There are total %d steps to reach 1\n", steps);
    }
}