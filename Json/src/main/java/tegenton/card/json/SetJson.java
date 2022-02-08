package tegenton.card.json;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;

public class SetJson {
    private final JSONObject object;

    public SetJson(String setCode) {
        InputStream resourceStream = JSONObject.class.getClassLoader()
                .getResourceAsStream(setCode + ".json");
        if (resourceStream == null) {
            throw new RuntimeException("Could not find set: " + setCode);
        }
        object = new JSONObject(new JSONTokener(resourceStream));
    }

    public int cardCount() {
        return object.getJSONObject("data").getJSONArray("cards").length();
    }
}
