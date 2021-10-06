package tegenton.card.parse.token;

import tegenton.card.parse.token.lexicon.Article;

public class ArticleToken extends Token {
    private ArticleToken(Article word) {
        this.word = word;
    }

    static ArticleToken fromString(String s) {
        Article article = Article.fromString(s);
        if (article != null) {
            return new ArticleToken(article);
        }
        return null;
    }
}
