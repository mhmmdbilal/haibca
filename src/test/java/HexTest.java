import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HexTest {

    @Test
    void encode() {
        var out = Hex.encode("Hello from HAI MP23");
        Assertions.assertEquals(out,"48656c6c6f2066726f6d20484149204d503233");
    }
}