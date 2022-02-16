package tegenton.card.json.model;

import org.junit.jupiter.api.Test;
import tegenton.card.json.JsonLoader;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TokenCardJsonTest {
    @Test
    void tokens() throws IOException {
        JsonLoader loader = new JsonLoader();
        SetJson lea = loader.loadSet("LEA");
        assertEquals(List.of(), lea.getTokens());
    }
}
