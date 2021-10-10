package tegenton.card.parse.token;

import tegenton.card.parse.token.lexicon.Article;

public final class ArticleToken extends Token {
    private ArticleToken(final Article word) {
        setWord(word);
    }

    static ArticleToken fromString(final String s) {
        final Article article = Article.fromString(s);
        if (article != null) {
            return new ArticleToken(article);
        }
        return null;
    }
}
