package tegenton.card.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class JsonLoader {
    private final ObjectMapper objectMapper;

    public JsonLoader(ObjectMapper mapper) {
        objectMapper = mapper;
    }

    public SetJson loadSet(final String setCode) throws IOException {
        URL resource = JsonLoader.class.getClassLoader()
                .getResource(setCode + ".json");
        if (resource == null) {
            throw new RuntimeException("Could not find set: " + setCode);
        }
        return objectMapper.readValue(resource, SetJson.class);
    }
}
