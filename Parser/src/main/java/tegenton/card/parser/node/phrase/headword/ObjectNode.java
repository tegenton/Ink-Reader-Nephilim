package tegenton.card.parser.node.phrase.headword;

import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.target.TargetNoun;
import tegenton.card.lexicon.game.target.object.ObjectNoun;
import tegenton.card.lexicon.game.target.player.PlayerAdjective;
import tegenton.card.lexicon.game.type.SuperType;
import tegenton.card.lexicon.game.type.TypeWord;
import tegenton.card.parser.Node;
import tegenton.card.parser.ParseError;
import tegenton.card.parser.node.atom.AtomicObjectNode;
import tegenton.card.parser.node.atom.ConjunctionNode;
import tegenton.card.parser.node.modifier.PremodifierNode;

import java.util.List;

public class ObjectNode extends Node {
    public ObjectNode(final Node... nodes) {
        super(nodes);
    }

    public ObjectNode(final List<Word> tokens) throws ParseError {
        super(tokens);
        if (nextToken() == SuperType.BASIC) {
            addChild(new PremodifierNode(getTokens()));
            expect(Symbol.SPACE);
            addChild(new AtomicObjectNode(getTokens()));
            expect(Symbol.SPACE);
            addChild(new ConjunctionNode(getTokens()));
            expect(Symbol.SPACE);
            addChild(new AtomicObjectNode(getTokens()));
        } else if (nextToken() instanceof TypeWord
                || nextToken() instanceof ObjectNoun) {
            addChild(new AtomicObjectNode(getTokens()));
        } else {
            addChild(new PremodifierNode(getTokens()));
            expect(Symbol.SPACE);
            addChild(new AtomicObjectNode(getTokens()));
            if (nextToken() == Symbol.SPACE && (
                    getTokens().get(1) == TargetNoun.THEY || getTokens().get(1)
                            == PlayerAdjective.DEFENDING)) {
                expect(Symbol.SPACE);
                addChild(new PostModifierNode(getTokens()));
            }
        }
    }
}
