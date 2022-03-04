import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Hex {
    private static final char[] HEX_CHARS = "0123456789abcdef".toCharArray();

    public static String encode(String input) {
        var buf = input.getBytes(StandardCharsets.UTF_8);
        System.out.println(Arrays.toString(buf));
        var output = new StringBuilder(buf.length * 2);
        for (var c : buf) {
            output.append(HEX_CHARS[c >> 4]);
            output.append(HEX_CHARS[c & 15]);
        }
        return output.toString();
    }
}
