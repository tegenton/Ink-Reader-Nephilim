package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexer.tokenizer.transition.TransitionFactory;
import tegenton.card.lexicon.Adjective;
import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.SubordinateConjunction;
import tegenton.card.lexicon.game.GameNoun;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.Zone;
import tegenton.card.lexicon.game.target.object.ObjectVerb;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.lexicon.game.turn.Step;
import tegenton.card.lexicon.game.type.CardType;
import tegenton.card.lexicon.value.EnglishNumber;

import java.util.HashMap;
import java.util.Map;

public class EState extends State {
    private static final Map<String, Map<Character, Transition>> MAP =
            new HashMap<>();

    EState(final String name) {
        super(name);
    }

    /**
     * Lazily load singleton map of E states.
     *
     * @return Map of E state transitions.
     */
    protected Map<String, Map<Character, Transition>> transitions() {
        if (MAP.isEmpty()) {
            MAP.put("EA", TransitionFactory.mapOf('C'));
            MAP.put("EAC", TransitionFactory.mapOf('H'));
            MAP.put("EACH", TransitionFactory.mapOf(Determiner.EACH));
            MAP.put("ED", TransitionFactory.mapOf(Morpheme.ED));
            MAP.put("EF", TransitionFactory.mapOf('F'));
            MAP.put("EFF", TransitionFactory.mapOf('E'));
            MAP.put("EFFE", TransitionFactory.mapOf('C'));
            MAP.put("EFFEC", TransitionFactory.mapOf('T'));
            MAP.put("EFFECT", TransitionFactory.mapOf(GameNoun.EFFECT));
            MAP.put("EI", TransitionFactory.mapOf('G'));
            MAP.put("EIG", TransitionFactory.mapOf('H'));
            MAP.put("EIGH", TransitionFactory.mapOf('T'));
            MAP.put("EIGHT", TransitionFactory.mapOf(EnglishNumber.EIGHT));
            MAP.put("EL", TransitionFactory.mapOf('E'));
            MAP.put("ELE", TransitionFactory.mapOf('V'));
            MAP.put("ELEV", TransitionFactory.mapOf('E'));
            MAP.put("ELEVE", TransitionFactory.mapOf('N'));
            MAP.put("ELEVEN", TransitionFactory.mapOf(EnglishNumber.ELEVEN));
            MAP.put("EN", TransitionFactory.mapOf('C', 'D', 'T'));
            MAP.put("ENC", TransitionFactory.mapOf('H'));
            MAP.put("ENCH", TransitionFactory.mapOf('A'));
            MAP.put("ENCHA", TransitionFactory.mapOf('N'));
            MAP.put("ENCHAN", TransitionFactory.mapOf('T'));
            MAP.put("ENCHANT", TransitionFactory.mapOf(Keyword.ENCHANT, 'M'));
            MAP.put("ENCHANTM", TransitionFactory.mapOf('E'));
            MAP.put("ENCHANTME", TransitionFactory.mapOf('N'));
            MAP.put("ENCHANTMEN", TransitionFactory.mapOf('T'));
            MAP.put("ENCHANTMENT",
                    TransitionFactory.mapOf(CardType.ENCHANTMENT));
            MAP.put("END", TransitionFactory.mapOf(Step.END));
            MAP.put("ENT", TransitionFactory.mapOf('E'));
            MAP.put("ENTE", TransitionFactory.mapOf('R'));
            MAP.put("ENTER", TransitionFactory.mapOf(ObjectVerb.ENTER));
            MAP.put("EQ", TransitionFactory.mapOf('U'));
            MAP.put("EQU", TransitionFactory.mapOf('A'));
            MAP.put("EQUA", TransitionFactory.mapOf('L'));
            MAP.put("EQUAL", TransitionFactory.mapOf(Adjective.EQUAL));
            MAP.put("ER", TransitionFactory.mapOf(Morpheme.ER));
            MAP.put("EV", TransitionFactory.mapOf('E'));
            MAP.put("EVE", TransitionFactory.mapOf('N'));
            MAP.put("EVEN", TransitionFactory.mapOf('L'));
            MAP.put("EVENL", TransitionFactory.mapOf('Y'));
            MAP.put("EVENLY", TransitionFactory.mapOf(Adverb.EVENLY));
            MAP.put("EX", TransitionFactory.mapOf('C', 'I', 'T'));
            MAP.put("EXC", TransitionFactory.mapOf('E', 'H'));
            MAP.put("EXCE", TransitionFactory.mapOf('P'));
            MAP.put("EXCEP", TransitionFactory.mapOf('T'));
            MAP.put("EXCEPT",
                    TransitionFactory.mapOf(SubordinateConjunction.EXCEPT));
            MAP.put("EXCH", TransitionFactory.mapOf('A'));
            MAP.put("EXCHA", TransitionFactory.mapOf('N'));
            MAP.put("EXCHAN", TransitionFactory.mapOf('G'));
            MAP.put("EXCHANG", TransitionFactory.mapOf('E'));
            MAP.put("EXCHANGE", TransitionFactory.mapOf(PlayerVerb.EXCHANGE));
            MAP.put("EXI", TransitionFactory.mapOf('L'));
            MAP.put("EXIL", TransitionFactory.mapOf('E'));
            MAP.put("EXILE", TransitionFactory.mapOf(Zone.EXILE));
            MAP.put("EXT", TransitionFactory.mapOf('R'));
            MAP.put("EXTR", TransitionFactory.mapOf('A'));
            MAP.put("EXTRA", TransitionFactory.mapOf(Adjective.EXTRA));
        }
        return MAP;
    }
}
