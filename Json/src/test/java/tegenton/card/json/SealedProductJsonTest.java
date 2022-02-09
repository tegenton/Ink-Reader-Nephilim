package tegenton.card.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class SealedProductJsonTest {
    public static List<SealedProductJson> sealed;

    @BeforeAll
    static void loadJson() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonLoader loader = new JsonLoader(mapper);
        SetJson set = loader.loadSet("LEA");
        sealed = set.getSealedProduct();
    }

    @Test
    void getIdentifiers() {
        fail("TODO: identifiers");
    }

    @Test
    void getName() {
        List<String> expected = List.of("Alpha Edition Booster Box",
                "Alpha Edition Booster Pack", "Alpha Edition Starter Deck");
        List<String> actual = sealed.stream().map(SealedProductJson::getName)
                .toList();
        assertIterableEquals(expected, actual);
    }

    @Test
    void getPurchaseUrls() {
        fail("TODO: purchase urls");
    }

    @Test
    void getReleaseDate() {
        for (SealedProductJson product : sealed) {
            assertNull(product.getReleaseDate());
        }
    }

    @Test
    void getUuid() {
        List<UUID> expected = List.of(
                UUID.fromString("22bb173e-dfe7-5589-8616-c820fce5ebb4"),
                UUID.fromString("1dbdd2d3-1455-5a0d-b775-f33fc1fcd7e2"),
                UUID.fromString("621c6612-daf6-57a6-b2d7-acc126583b4e"));
        List<UUID> actual = sealed.stream().map(SealedProductJson::getUuid)
                .toList();
        assertIterableEquals(expected, actual);
    }
}
