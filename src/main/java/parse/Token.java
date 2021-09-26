package parse;

import parse.lexicon.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public abstract class Token {
    private static List<Function<String, Optional<Token>>> tokenTypes;

    static {
        tokenTypes = List.of(EnglishNumberToken::fromString, PunctuationToken::fromString, SubjectToken::fromString, VerbToken::fromString);
    }

    protected Word word;

    public static List<Token> tokenize(String s) {
        StringSplitter sentence = new StringSplitter(s);
        List<Token> tokens = new ArrayList<>();
        while (sentence.hasNext()) {
            Token.fromString(sentence.getNext()).ifPresent(tokens::add);
        }
        return tokens;
    }

    private static Optional<Token> fromString(String s) {
        Token result;
        for (Function<String, Optional<Token>> test : tokenTypes) {
            result = test.apply(s).orElse(null);
            if (result != null) {
                return Optional.of(result);
            }
        }
        return Optional.empty();
    }

    public Word getWord() {
        return word;
    }

}
