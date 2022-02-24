package tegenton.card.parser.ability;

import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.game.Keyword;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KeywordNodeTest {
    @Test
    void simpleKeyword() {
        List<Keyword> keywordList =
                List.of(Keyword.BANDING, Keyword.DEFENDER, Keyword.FEAR,
                        Keyword.FLYING, Keyword.HASTE, Keyword.INDESTRUCTIBLE,
                        Keyword.REACH, Keyword.TRAMPLE, Keyword.VIGILANCE);
        for (Keyword keyword : keywordList) {
            KeywordNode keywordNode = new KeywordNode(keyword);
            assertEquals(keywordNode, new KeywordNode(List.of(keyword)));
        }
    }
}
