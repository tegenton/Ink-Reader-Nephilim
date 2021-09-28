package tegenton.card.parse;

import org.junit.jupiter.api.Test;
import tegenton.card.parse.lexicon.Article;

import static org.junit.jupiter.api.Assertions.*;

public class ArticleTokenTest {
    public static ArticleToken articleToken;

    @Test
    void a() {
        articleToken = (ArticleToken) ArticleToken.fromString("a").orElse(null);
        assertNotNull(articleToken);
        assertEquals(Article.a, articleToken.getWord());
    }

    @Test
    void an() {
        articleToken = (ArticleToken) ArticleToken.fromString("an").orElse(null);
        assertNotNull(articleToken);
        assertEquals(Article.an, articleToken.getWord());
    }

    @Test
    void invalid() {
        articleToken = (ArticleToken) ArticleToken.fromString("when").orElse(null);
        assertNull(articleToken);
    }
}
