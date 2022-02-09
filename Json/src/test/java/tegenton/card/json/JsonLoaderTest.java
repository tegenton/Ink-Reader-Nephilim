package tegenton.card.json;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.json.model.SetJson;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JsonLoaderTest {
    public static JsonLoader loader;

    @BeforeEach
    void setup() {
        loader = new JsonLoader();
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
