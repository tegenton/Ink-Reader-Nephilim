package tegenton.card.parser;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.json.JsonLoader;
import tegenton.card.json.model.SetJson;
import tegenton.card.lexer.Lexer;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.target.object.ObjectNoun;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.lexicon.value.EnglishNumber;
import tegenton.card.parser.node.CardNode;
import tegenton.card.parser.node.SpellNode;
import tegenton.card.parser.node.ability.SpellAbilityNode;
import tegenton.card.parser.node.atom.AtomicObjectNode;
import tegenton.card.parser.node.atom.AtomicPlayerNode;
import tegenton.card.parser.node.atom.DeterminerNode;
import tegenton.card.parser.node.atom.symbol.PunctuationNode;
import tegenton.card.parser.node.modifier.AmountNode;
import tegenton.card.parser.node.modifier.PremodifierNode;
import tegenton.card.parser.node.phrase.PlayerPhraseNode;
import tegenton.card.parser.node.phrase.PlayerVerbPhraseNode;
import tegenton.card.parser.node.phrase.headword.ObjectNode;
import tegenton.card.parser.node.phrase.headword.PlayerNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ParserTest {
    public static List<Word> tokens;
    public static CardNode expected;

    @BeforeEach
    void setup() {
        tokens = new ArrayList<>();
    }

    @AfterEach
    void compare() throws ParseError {
        assertEquals(expected, Parser.parse(tokens));
        assertEquals(0, tokens.size());
    }

    @Test
    void empty() {
        expected = new CardNode();
    }

    @Test
    void ancestralRecall() {
        tokens.addAll(List.of(Determiner.TARGET, Symbol.SPACE, PlayerVerb.PLAY,
                Morpheme.ER, Symbol.SPACE, PlayerVerb.DRAW, Symbol.SPACE,
                EnglishNumber.THREE, Symbol.SPACE, ObjectNoun.CARD, Morpheme.S,
                Symbol.PERIOD));
        expected = new CardNode(new SpellNode(new SpellAbilityNode(
                new PlayerPhraseNode(new PlayerNode(new PremodifierNode(
                        new DeterminerNode(Determiner.TARGET)),
                        new AtomicPlayerNode(PlayerVerb.PLAY, Morpheme.ER)),
                        new PlayerVerbPhraseNode(PlayerVerb.DRAW,
                                new ObjectNode(new PremodifierNode(
                                        new AmountNode(EnglishNumber.THREE)),
                                        new AtomicObjectNode(ObjectNoun.CARD,
                                                Morpheme.S)))),
                new PunctuationNode(Symbol.PERIOD))));
    }

    @Test
    void alpha() throws IOException {
        JsonLoader jsonLoader = new JsonLoader();
        SetJson setJson = jsonLoader.loadSet("LEA");
        setJson.getCards().forEach(card -> {
            tokens = Lexer.lex(card.getProcessedText());
            try {
                Parser.parse(tokens);
                assertEquals(0, tokens.size());
            } catch (final ParseError e) {
                System.err.println("Message:" + e.getMessage());
                System.err.println("Card: " + card.getName());
                System.err.println("Text: " + card.getProcessedText());
                System.err.println("Remaining tokens: " + e.getTokens());
                fail();
            }
        });
    }
}
