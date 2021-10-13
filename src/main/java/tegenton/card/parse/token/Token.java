package tegenton.card.parse.token;

import tegenton.card.generic.Filter;
import tegenton.card.generic.StringSplitter;
import tegenton.card.parse.token.lexicon.Word;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * A token represents one "word", such as "draw". It does not have to represent
 * exactly one word of text, rather it is the smallest portion of text which
 * holds meaning.
 */
public abstract class Token {
    private static Filter<Token> filter;
    private Word word;

    private static void setupFilter() {
        final List<Function<String, Token>> tokenTypes;
        tokenTypes = List.of(ArticleToken::fromString,
                EnglishNumberToken::fromString,
                KeywordAbilityToken::fromString,
                KeywordActionToken::fromString,
                NumberToken::fromString,
                PunctuationToken::fromString,
                QualifierToken::fromString,
                SubjectToken::fromString,
                TriggeredAbilityToken::fromString,
                VerbToken::fromString);
        filter = new Filter<>(tokenTypes);
    }

    /**
     * Splits a string of words into individual token objects.
     *
     * @param s string to parameterize
     * @return a list of tokens produced from s
     */
    public static List<Token> tokenize(final String s) {
        final StringSplitter sentence = new StringSplitter(s);
        final List<Token> tokens = new ArrayList<>();
        while (sentence.hasNext()) {
            final Token next = Token.fromString(sentence.getNext());
            if (next != null) {
                tokens.add(next);
            }
        }
        return tokens;
    }

    private static Token fromString(final String s) {
        if (filter == null) {
            setupFilter();
        }
        return filter.filter(s);
    }

    /**
     * @return The word that represents this token
     */
    public final Word getWord() {
        return word;
    }

    protected final void setWord(final Word newWord) {
        this.word = newWord;
    }
}
