package tegenton.card.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import tegenton.card.json.model.SetJson;

import java.io.IOException;
import java.net.URL;

public class JsonLoader {
    private final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Load (setCode).json as a set.
     *
     * @param setCode Code for set to load.
     * @return SetJson of that set.
     * @throws IOException If set file does not exist.
     */
    public SetJson loadSet(final String setCode) throws IOException {
        URL resource = JsonLoader.class.getClassLoader()
                .getResource(setCode + ".json");
        if (resource == null) {
            throw new RuntimeException("Could not find set: " + setCode);
        }
        return objectMapper.readValue(resource, SetJson.class);
    }
}
