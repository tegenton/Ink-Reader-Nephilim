package tegenton.card.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JsonLoaderTest {
    public static JsonLoader loader;

    @BeforeEach
    void setup() {
        ObjectMapper mapper = new ObjectMapper();
        loader = new JsonLoader(mapper);
    }

    @Test
    void cardCountByCode() throws IOException {
        SetJson lea = loader.loadSet("LEA");
        assertEquals(295, lea.getBaseSetSize());
    }

    @Test
    void fakeSet() {
        assertThrows(RuntimeException.class, () -> loader.loadSet("fake"));
    }
}
