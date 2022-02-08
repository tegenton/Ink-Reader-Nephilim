package tegenton.card.json;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;

public class SetJson {
    private final JSONObject object;

    public SetJson(InputStream resourceAsStream) {
        object = new JSONObject(new JSONTokener(resourceAsStream));
    }

    public int cardCount() {
        return object.getJSONObject("data").getJSONArray("cards").length();
    }
}
