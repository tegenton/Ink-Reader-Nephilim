package tegenton.card.parser.ability;

import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Keyword;

import java.util.List;
import java.util.Objects;

public class KeywordNode {
    private final Keyword keyword;

    public KeywordNode(List<Word> wordList) {
        keyword = (Keyword) wordList.get(0);
    }

    public KeywordNode(Keyword value) {
        keyword = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        KeywordNode that = (KeywordNode) o;
        return keyword == that.keyword;
    }

    @Override
    public int hashCode() {
        return Objects.hash(keyword);
    }
}
