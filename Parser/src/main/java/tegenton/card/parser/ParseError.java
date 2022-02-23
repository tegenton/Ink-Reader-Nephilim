package tegenton.card.parser;

import tegenton.card.lexicon.Word;

import java.util.List;

public class ParseError extends Throwable {
    private final List<Word> tokens;

    public ParseError(String s, List<Word> remaining) {
        super(s);
        tokens = remaining;
    }

    public List<Word> getTokens() {
        return tokens;
    }
}
