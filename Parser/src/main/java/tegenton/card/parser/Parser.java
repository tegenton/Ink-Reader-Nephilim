package tegenton.card.parser;

import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.parser.ability.KeywordNode;

import java.util.List;

public class Parser {
    public static ParseTree parse(List<Word> tokens) {
        if (tokens.size() == 0) {
            return new ParseTree();
        }
        return new ParseTree(new CardNode(
                new PermanentNode(new KeywordNode(Keyword.BANDING))));
    }
}
