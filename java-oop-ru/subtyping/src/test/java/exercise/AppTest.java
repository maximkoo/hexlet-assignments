package exercise;

import org.junit.jupiter.api.Test;
<<<<<<< HEAD
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Map;

=======

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
>>>>>>> e8d6b6a8fd155984d6aaec00fe57d534e888e765

class AppTest {
    @Test
    void testSwapKV() {
        KeyValueStorage storage = new InMemoryKV(Map.of("key", "value"));
        storage.set("key2", "value2");
        App.swapKeyValue(storage);

        assertThat(storage.get("key3", "default")).isEqualTo("default");
        assertThat(storage.get("value", "")).isEqualTo("key");
        assertThat(storage.get("value2", "")).isEqualTo("key2");
    }

    @Test
    void testSwapKV2() {
        KeyValueStorage storage = new InMemoryKV(Map.of("foo", "bar", "bar", "zoo"));
        App.swapKeyValue(storage);
        Map<String, String> expected = Map.of("bar", "foo", "zoo", "bar");
        assertThat(storage.toMap()).isEqualTo(expected);
    }
}
