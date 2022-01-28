package tegenton.card.parser;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.Word;
import tegenton.card.lexicon.game.source.target.object.ObjectNoun;
import tegenton.card.lexicon.game.source.target.player.PlayerVerb;
import tegenton.card.lexicon.value.EnglishNumber;
import tegenton.card.parser.node.AdjectiveNode;
import tegenton.card.parser.node.CardNode;
import tegenton.card.parser.node.ParseNode;
import tegenton.card.parser.node.StaticAbilityNode;
import tegenton.card.parser.node.ValueNode;
import tegenton.card.parser.node.ability.KeywordNode;
import tegenton.card.parser.node.ability.target.TargetedAbilityNode;
import tegenton.card.parser.node.ability.target.object.ObjectNode;
import tegenton.card.parser.node.ability.target.player.PlayerNode;
import tegenton.card.parser.node.ability.target.player.PlayerVerbPhraseNode;
import tegenton.card.parser.node.type.TypeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tegenton.card.lexicon.Adverb.NOT;
import static tegenton.card.lexicon.Morpheme.ED;
import static tegenton.card.lexicon.SubordinateConjunction.AS;
import static tegenton.card.lexicon.SubordinateConjunction.THOUGH;
import static tegenton.card.lexicon.Symbol.*;
import static tegenton.card.lexicon.game.Keyword.DEFENDER;
import static tegenton.card.lexicon.game.Keyword.ENCHANT;
import static tegenton.card.lexicon.game.source.SourceVerb.DO;
import static tegenton.card.lexicon.game.source.target.TargetAuxiliaryVerb.CAN;
import static tegenton.card.lexicon.game.source.target.object.ObjectNoun.IT;
import static tegenton.card.lexicon.game.source.target.object.ObjectVerb.ATTACK;
import static tegenton.card.lexicon.game.source.target.object.ObjectVerb.HAVE;
import static tegenton.card.lexicon.game.type.CreatureType.WALL;

public class ParserTest {
    public static ParseNode expected;
    public static List<Word> input;

    @BeforeEach
    void setup() {
        input = new ArrayList<>();
    }

    @AfterEach
    void compare() {
        Parser parse = new Parser();
        ParseNode actual = parse.parse(input);
        assertEquals(expected, actual);
        assertEquals(0, input.size());
    }

    @Test
    void ancestralRecall() {
        Collections.addAll(input, Determiner.TARGET, Symbol.SPACE, PlayerVerb.PLAY, Morpheme.ER, Symbol.SPACE, PlayerVerb.DRAW, Symbol.SPACE, EnglishNumber.THREE, Symbol.SPACE, ObjectNoun.CARD, Morpheme.S, Symbol.PERIOD);
        expected = new CardNode(new TargetedAbilityNode(new PlayerNode(PlayerVerb.PLAY), new PlayerVerbPhraseNode(PlayerVerb.DRAW, new ObjectNode(ObjectNoun.CARD, new ValueNode(EnglishNumber.THREE)))));
    }

    @Test
    void animateWall() {
        Collections.addAll(input, ENCHANT, SPACE, WALL, NEWLINE,
                ENCHANT, ED, SPACE, WALL, SPACE, CAN, SPACE, ATTACK, SPACE, AS, SPACE, THOUGH, SPACE, IT, SPACE, DO, NOT, SPACE, HAVE, SPACE, DEFENDER, PERIOD);
        expected = new CardNode(new KeywordNode(ENCHANT, new TypeNode(WALL)), new StaticAbilityNode(new ObjectNode(WALL, new AdjectiveNode(ENCHANT))));
    }
}
