package tegenton.card.parse.token.lexicon;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ArticleTest {
    public static Article article;

    @ParameterizedTest
    @ValueSource(strings = {"a", "an"})
    void validPunctuation(String s) {
        article = Article.fromString(s).orElse(null);
        assertNotNull(article);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Whenever", "Lifelink"})
    void invalid(String s) {
        article = Article.fromString(s).orElse(null);
        assertNull(article);
    }
}