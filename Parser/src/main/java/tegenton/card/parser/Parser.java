package tegenton.card.parser;

import tegenton.card.lexicon.Word;
import tegenton.card.parser.node.CardNode;
import tegenton.card.parser.node.KeywordNode;
import tegenton.card.parser.node.PermanentNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Parser {
    private final Deque<InputItem> input = new ArrayDeque<>();

    public Parser(List<Word> tokens) {
        tokens.stream().map(InputItem::new).forEach(input::add);
    }

    public CardNode parse() {
        if (input.isEmpty()) {
            return new CardNode(new PermanentNode());
        }
        return new CardNode(
                new PermanentNode(new KeywordNode(input.remove().getWord())));
    }
}
