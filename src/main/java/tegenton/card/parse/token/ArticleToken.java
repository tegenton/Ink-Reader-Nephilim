package tegenton.card.parse.token;

import tegenton.card.parse.token.lexicon.Article;

import java.util.Optional;

public class ArticleToken extends Token {
    private ArticleToken(Article word) {
        this.word = word;
    }

    static Optional<Token> fromString(String s) {
        Article article = Article.fromString(s).orElse(null);
        if (article != null) {
            return Optional.of(new ArticleToken(article));
        }
        return Optional.empty();
    }
}
