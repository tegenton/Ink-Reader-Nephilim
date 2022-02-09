package tegenton.card.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
        List<IdentifiersJson> expected = List.of(new IdentifiersJson("27262"),
                new IdentifiersJson("27324"), new IdentifiersJson("139147"));
        List<IdentifiersJson> actual = sealed.stream()
                .map(SealedProductJson::getIdentifiers).toList();
        assertIterableEquals(expected, actual);
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
        List<PurchaseUrlsJson> expected = List.of(new PurchaseUrlsJson(
                        "https://mtgjson.com/links/7bcc9476dbbc3611"),
                new PurchaseUrlsJson(
                        "https://mtgjson.com/links/a5a160aafd3ff5f9"),
                new PurchaseUrlsJson(
                        "https://mtgjson.com/links/487b629730e4d3dc"));
        List<PurchaseUrlsJson> actual = sealed.stream()
                .map(SealedProductJson::getPurchaseUrls).toList();
        assertIterableEquals(expected, actual);
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
