import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Test Suite")
class TestSuite {
    // strLen String,Number -> Bool
    public static boolean strLen(String s, int len) {
        return s.length() == len;
    }

    @Test
    @DisplayName("test str len")
    void testStrLen() {
        assertEquals(strLen("test", 4), true);
        assertEquals(strLen("test", 2), false);
    }

    @ParameterizedTest()
    @ValueSource(strings = { "Hello", "World", "t" })
    void testShouldPassNonNullMessageAsMethodParameter(String message) {
        assertNotNull(message.indexOf(3));
    }

    @Test
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    @DisplayName("test Performance")
    void testPerformance() {
        long startTime = System.nanoTime();
        testStrLen();
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000;
        assertTrue(duration < 100);
    }

    @Nested
    @DisplayName("when new")
    class NestedTests {

        @Test
        void innerTest1() {
            assertEquals(strLen("test", 4), true);
        }
    }
}