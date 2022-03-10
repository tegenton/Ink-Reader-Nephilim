package tegenton.card.parser.node;

import tegenton.card.lexicon.game.Keyword;

import java.util.Objects;

public class KeywordNode extends Node {
    private final Keyword keyword;

    public KeywordNode(Keyword word) {
        this.keyword = word;
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

    @Override
    public String toString() {
        return "KeywordNode{" + keyword + '}';
    }
}
