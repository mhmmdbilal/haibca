import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HexTest {

    @Test
    void encode() {
        var out = Hex.encode("Hello from HAI MP23");
        Assertions.assertEquals("48656c6c6f2066726f6d20484149204d503233", out);
    }
}
