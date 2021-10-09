package tegenton.card.parse.token;

import tegenton.card.parse.token.lexicon.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import tegenton.card.generic.Filter;
import tegenton.card.generic.StringSplitter;

/**
 * A token represents one "word", such as "draw". It does not have to represent exactly one
 * word of text, rather it is the smallest portion of text which holds meaning.
 */
public abstract class Token {
    private static Filter<Token> filter;
    protected Word word;

    private static void setupFilter() {
        List<Function<String, Token>> tokenTypes;
        tokenTypes = List.of(ArticleToken::fromString,
                EnglishNumberToken::fromString,
                KeywordAbilityToken::fromString,
                KeywordActionToken::fromString,
                NumberToken::fromString,
                PunctuationToken::fromString,
                SubjectToken::fromString,
                VerbToken::fromString);
        filter = new Filter<>(tokenTypes);
    }

    /**
     * Splits a string of words into individual token objects.
     *
     * @param s string to parameterize
     * @return a list of tokens produced from s
     */
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
