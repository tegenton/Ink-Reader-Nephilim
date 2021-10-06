package tegenton.card.parse.token;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tegenton.card.parse.token.lexicon.Article;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ArticleTokenTest {
    public static ArticleToken articleToken;

    @Test
    void a() {
        articleToken = ArticleToken.fromString("a");
        assertNotNull(articleToken);
        Assertions.assertEquals(Article.a, articleToken.getWord());
    }

    @Test
    void an() {
        articleToken = ArticleToken.fromString("an");
        assertNotNull(articleToken);
        Assertions.assertEquals(Article.an, articleToken.getWord());
    }

    @Test
    void invalid() {
        articleToken = ArticleToken.fromString("when");
        assertNull(articleToken);
    }
}
