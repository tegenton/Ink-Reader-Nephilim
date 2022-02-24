package tegenton.card.parser.node.phrase;

import tegenton.card.lexicon.Adjective;
import tegenton.card.lexicon.Conjunction;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Noun;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.parser.Node;
import tegenton.card.parser.ParseError;
import tegenton.card.parser.node.phrase.headword.PlayerNode;

import java.util.List;

public class PlayerPhraseNode extends Node {
    public PlayerPhraseNode(final Node... nodes) {
        super(nodes);
    }

    public PlayerPhraseNode(final List<Word> input) throws ParseError {
        super(input);
        if (nextToken() instanceof Determiner
                || nextToken() == PlayerVerb.PLAY) {
            addChild(new PlayerNode(getTokens()));
            expect(Symbol.SPACE);
        }
        addChild(new PlayerVerbPhraseNode(getTokens()));
        if (nextToken() == Symbol.SPACE && getTokens().get(
                1) instanceof Conjunction) {
            expect(Symbol.SPACE);
            consume(Conjunction.AND);
            expect(Symbol.SPACE);
            addChild(new PlayerVerbPhraseNode(getTokens()));
            expect(Symbol.SPACE);
            consume(Determiner.THE);
            expect(Symbol.SPACE);
            consume(Adjective.SAME);
            expect(Symbol.SPACE);
            consume(Noun.WAY);
        } else if (nextToken() == Symbol.COMMA) {
            consume(Symbol.COMMA);
            expect(Symbol.SPACE);
            consume(Conjunction.THEN);
            expect(Symbol.SPACE);
            addChild(new PlayerVerbPhraseNode(getTokens()));
        }
    }
}
