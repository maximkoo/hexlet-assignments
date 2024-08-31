package exercise;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
// BEGIN
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        System.out.println(filepath.toString());
        Files.writeString(filepath, content, StandardOpenOption.TRUNCATE_EXISTING);
    }

    // BEGIN
    @Test
    public void test1() {
        FileKV fkv = new FileKV(filepath.toString(), Map.of("testKey1", "testValue1"));
        String content = Utils.readFile(filepath.toString());
        KeyValueStorage storage = new InMemoryKV(Utils.deserialize(content));
        assertThat(storage.get("testKey1", "default")).isEqualTo("testValue1");
        assertThat(storage.get("testKey2", "default")).isEqualTo("default");
    }
    // END
}
