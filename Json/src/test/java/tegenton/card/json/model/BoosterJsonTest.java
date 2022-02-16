package tegenton.card.json.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import tegenton.card.json.JsonLoader;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BoosterJsonTest {
    public static BoosterJson booster;

    @BeforeAll
    static void loadJson() throws IOException {
        JsonLoader loader = new JsonLoader();
        SetJson set = loader.loadSet("LEA");
        booster = set.getBooster();
    }

    @Test
    void getDefault() {
        assertNotNull(booster.getDefault());
    }

    @Test
    void getBoosters() {
        List<BoosterConfig> expected = List.of(new BoosterConfig(
                Map.of("common", 11, "rare", 1, "uncommon", 3), 1));
        assertEquals(expected, booster.getDefault().getBoosters());
    }

    @Test
    void getBoostersTotalWeight() {
        assertEquals(1, booster.getDefault().getBoostersTotalWeight());
    }

    @Test
    void getSheets() {
        assertEquals(Set.of("common", "uncommon", "rare"),
                booster.getDefault().getSheets().keySet());
        assertEquals(121, booster.getDefault().getSheets().get("common")
                .getTotalWeight());
        assertEquals(121, booster.getDefault().getSheets().get("uncommon")
                .getTotalWeight());
        assertEquals(121,
                booster.getDefault().getSheets().get("rare").getTotalWeight());
    }
}
