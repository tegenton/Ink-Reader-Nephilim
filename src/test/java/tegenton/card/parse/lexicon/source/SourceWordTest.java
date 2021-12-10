package tegenton.card.parse.lexicon.source;

import org.junit.jupiter.api.Test;
import tegenton.card.parse.lexicon.WordTest;
import java.util.List;

public class SourceWordTest extends WordTest {
    @Test
    void sourceVerb() {
        words = SourceVerb.values();
        values = List.of("DEAL", "CAN", "DO");
    }
}
