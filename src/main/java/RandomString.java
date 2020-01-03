import java.util.Random;

public class RandomString {
    /**
     * Generate a random string given string length and a random instance.
     * @param r random instance
     * @param n string length
     * @return generated string
     */
    public static String generateString(Random r, int n) {
        char[] arr = new char[n];
        for (int i = 0; i < n; i++) {
            int a = r.nextInt(26) + 97;
            arr[i] = (char) a;
        }
        String s = new String(arr);
        return s;
    }
}
