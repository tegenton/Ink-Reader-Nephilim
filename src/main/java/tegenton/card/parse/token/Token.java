package tegenton.card.parse.token;

import tegenton.card.generic.Filter;
import tegenton.card.generic.StringSplitter;
import tegenton.card.parse.token.lexicon.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public abstract class Token {
    private static Filter<Token> filter;
    protected Word word;

    private static void setupFilter() {
        List<Function<String, Token>> tokenTypes;
        tokenTypes = List.of(ArticleToken::fromString, EnglishNumberToken::fromString, KeywordActionToken::fromString, NumberToken::fromString, PunctuationToken::fromString, SubjectToken::fromString, VerbToken::fromString);
        filter = new Filter<>(tokenTypes);
    }

    public static List<Token> tokenize(String s) {
        StringSplitter sentence = new StringSplitter(s);
        List<Token> tokens = new ArrayList<>();
        while (sentence.hasNext()) {
            Token next = Token.fromString(sentence.getNext());
            if (next != null) {
                tokens.add(next);
            }
        }
        return tokens;
    }

    private static Token fromString(String s) {
        if (filter == null) {
            setupFilter();
        }
        return filter.filter(s);
    }

    public Word getWord() {
        return word;
    }

}
