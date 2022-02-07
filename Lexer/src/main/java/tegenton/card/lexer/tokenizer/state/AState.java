package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexer.tokenizer.transition.TransitionFactory;
import tegenton.card.lexicon.*;
import tegenton.card.lexicon.game.GameNoun;
import tegenton.card.lexicon.game.TriggerWord;
import tegenton.card.lexicon.game.Zone;
import tegenton.card.lexicon.game.target.TargetAdjective;
import tegenton.card.lexicon.game.target.TargetVerb;
import tegenton.card.lexicon.game.target.object.ObjectVerb;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.lexicon.game.turn.Chronology;
import tegenton.card.lexicon.game.type.CardType;
import tegenton.card.lexicon.game.type.EnchantmentType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AState extends State {
    private static final Map<String, List<Transition>> MAP = new HashMap<>();

    AState(final String name) {
        super(name);
    }

    /**
     * Lazily load singleton map of A states.
     *
     * @return Map of A state transitions.
     */
    @Override
    protected Map<String, List<Transition>> transitions() {
        if (MAP.isEmpty()) {
            MAP.put("AB", TransitionFactory.listOf('I', 'L', 'O'));
            TransitionFactory.sequence(MAP, "ABI", "LITY");
            MAP.put("ABILITY", TransitionFactory.toWord(GameNoun.ABILITY));
            MAP.put("ABL", TransitionFactory.listOf('E'));
            MAP.put("ABLE", TransitionFactory.toWord(TargetAdjective.ABLE));
            TransitionFactory.sequence(MAP, "ABO", "VE");
            MAP.put("ABOVE", TransitionFactory.toWord(Preposition.ABOVE));
            TransitionFactory.sequence(MAP, "AC", "TIVATE");
            MAP.put("ACTIVATE", TransitionFactory.toWord(PlayerVerb.ACTIVATE));
            MAP.put("AD", TransitionFactory.listOf('D'));
            MAP.put("ADD", TransitionFactory.listOf(PlayerVerb.ADD, 'I'));
            TransitionFactory.sequence(MAP, "ADDI", "TIONAL");
            MAP.put("ADDITIONAL",
                    TransitionFactory.toWord(Adjective.ADDITIONAL));
            TransitionFactory.sequence(MAP, "AF", "TER");
            MAP.put("AFTER", TransitionFactory.toWord(Chronology.AFTER));
            MAP.put("AL", TransitionFactory.listOf('L'));
            MAP.put("ALL", TransitionFactory.toWord(Determiner.ALL));
            MAP.put("AM", TransitionFactory.listOf('O'));
            MAP.put("AMO", TransitionFactory.listOf('N', 'U'));
            MAP.put("AMON", TransitionFactory.listOf('G'));
            MAP.put("AMONG", TransitionFactory.toWord(Preposition.AMONG));
            TransitionFactory.sequence(MAP, "AMOU", "NT");
            MAP.put("AMOUNT", TransitionFactory.toWord(Noun.AMOUNT));
            MAP.put("AN", TransitionFactory.listOf(Determiner.AN, 'D', 'O', 'T',
                    'Y'));
            MAP.put("AND", TransitionFactory.toWord(Conjunction.AND));
            TransitionFactory.sequence(MAP, "ANO", "THER");
            MAP.put("ANOTHER", TransitionFactory.toWord(Determiner.ANOTHER));
            MAP.put("ANT", TransitionFactory.listOf('E'));
            MAP.put("ANTE", TransitionFactory.toWord(Zone.ANTE));
            MAP.put("ANY", TransitionFactory.toWord(Determiner.ANY));
            MAP.put("AR", TransitionFactory.listOf('E', 'T'));
            MAP.put("ARE", TransitionFactory.toWord(ObjectVerb.IS));
            TransitionFactory.sequence(MAP, "ART", "IFACT");
            MAP.put("ARTIFACT", TransitionFactory.toWord(CardType.ARTIFACT));
            MAP.put("AS",
                    TransitionFactory.listOf(SubordinateConjunction.AS, 'S'));
            TransitionFactory.sequence(MAP, "ASS", "IGN");
            MAP.put("ASSIGN", TransitionFactory.toWord(TargetVerb.ASSIGN));
            MAP.put("AT", TransitionFactory.listOf(TriggerWord.AT, 'T'));
            TransitionFactory.sequence(MAP, "ATT", "AC");
            MAP.put("ATTAC", TransitionFactory.listOf('H', 'K'));
            MAP.put("ATTACH", TransitionFactory.toWord(PlayerVerb.ATTACH));
            MAP.put("ATTACK", TransitionFactory.toWord(ObjectVerb.ATTACK));
            TransitionFactory.sequence(MAP, "AU", "RA");
            MAP.put("AURA", TransitionFactory.toWord(EnchantmentType.AURA));
        }
        return MAP;
    }
}
