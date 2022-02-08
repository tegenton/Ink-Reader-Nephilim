package tegenton.card.json;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;

public class SetJson {
    private final JSONObject object;

    /**
     * Load a set from json resource files.
     *
     * @param setCode Set to load, such as "LEA".
     */
    public SetJson(final String setCode) {
        InputStream resourceStream = JSONObject.class.getClassLoader()
                .getResourceAsStream(setCode + ".json");
        if (resourceStream == null) {
            throw new RuntimeException("Could not find set: " + setCode);
        }
        object = new JSONObject(new JSONTokener(resourceStream));
    }

    /**
     * Get the number of cards in the set.
     *
     * @return Number of cards in selected set.
     */
    public int cardCount() {
        return object.getJSONObject("data").getJSONArray("cards").length();
    }
}
