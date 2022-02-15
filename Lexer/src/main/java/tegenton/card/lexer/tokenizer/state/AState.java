package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexer.tokenizer.transition.TransitionFactory;
import tegenton.card.lexicon.Adjective;
import tegenton.card.lexicon.Conjunction;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Noun;
import tegenton.card.lexicon.Preposition;
import tegenton.card.lexicon.SubordinateConjunction;
import tegenton.card.lexicon.game.GameNoun;
import tegenton.card.lexicon.game.TriggerWord;
import tegenton.card.lexicon.game.Zone;
import tegenton.card.lexicon.game.target.TargetAdjective;
import tegenton.card.lexicon.game.target.TargetVerb;
import tegenton.card.lexicon.game.target.object.ObjectVerb;
import tegenton.card.lexicon.game.target.player.PlayerAdjective;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.lexicon.game.turn.Chronology;
import tegenton.card.lexicon.game.type.CardType;
import tegenton.card.lexicon.game.type.EnchantmentType;

import java.util.HashMap;
import java.util.Map;

public class AState extends State {
    private static final Map<String, Map<Character, Transition>> MAP =
            new HashMap<>();

    AState(final String name) {
        super(name);
    }

    /**
     * Lazily load singleton map of A states.
     *
     * @return Map of A state transitions.
     */
    @Override
    protected Map<String, Map<Character, Transition>> transitions() {
        if (MAP.isEmpty()) {
            MAP.put("AB", TransitionFactory.mapOf('I', 'L', 'O'));
            TransitionFactory.sequence(MAP, "ABI", "LIT");
            MAP.put("ABILIT", TransitionFactory.mapOf('I', 'Y'));
            MAP.put("ABILITI", TransitionFactory.mapOf('E'));
            MAP.put("ABILITIE", TransitionFactory.mapOf(GameNoun.ABILITY));
            MAP.put("ABILITY", TransitionFactory.toWord(GameNoun.ABILITY));
            MAP.put("ABL", TransitionFactory.mapOf('E'));
            MAP.put("ABLE", TransitionFactory.toWord(TargetAdjective.ABLE));
            TransitionFactory.sequence(MAP, "ABO", "VE");
            MAP.put("ABOVE", TransitionFactory.toWord(Preposition.ABOVE));
            TransitionFactory.sequence(MAP, "AC", "TIV");
            MAP.put("ACTIV", TransitionFactory.mapOf('A', 'E'));
            TransitionFactory.sequence(MAP, "ACTIVA", "TE");
            MAP.put("ACTIVATE", TransitionFactory.mapOf(PlayerVerb.ACTIVATE));
            MAP.get("ACTIVATE")
                    .put('D', new Transition('D', PlayerVerb.ACTIVATE, "ED"));
            MAP.put("ACTIVE", TransitionFactory.mapOf(PlayerAdjective.ACTIVE));
            MAP.put("AD", TransitionFactory.mapOf('D'));
            MAP.put("ADD", TransitionFactory.mapOf(PlayerVerb.ADD, 'I'));
            TransitionFactory.sequence(MAP, "ADDI", "TION");
            MAP.put("ADDITION",
                    TransitionFactory.mapOf(Preposition.ADDITION, 'A'));
            MAP.put("ADDITIONA", TransitionFactory.mapOf('L'));
            MAP.put("ADDITIONAL",
                    TransitionFactory.toWord(Adjective.ADDITIONAL));
            TransitionFactory.sequence(MAP, "AF", "TER");
            MAP.put("AFTER", TransitionFactory.toWord(Chronology.AFTER));
            MAP.put("AL", TransitionFactory.mapOf('L'));
            MAP.put("ALL", TransitionFactory.toWord(Determiner.ALL));
            MAP.put("AM", TransitionFactory.mapOf('O'));
            MAP.put("AMO", TransitionFactory.mapOf('N', 'U'));
            MAP.put("AMON", TransitionFactory.mapOf('G'));
            MAP.put("AMONG", TransitionFactory.toWord(Preposition.AMONG));
            TransitionFactory.sequence(MAP, "AMOU", "NT");
            MAP.put("AMOUNT", TransitionFactory.toWord(Noun.AMOUNT));
            MAP.put("AN",
                    TransitionFactory.mapOf(Determiner.AN, 'D', 'O', 'T', 'Y'));
            MAP.put("AND", TransitionFactory.toWord(Conjunction.AND));
            MAP.get("AND").put('/', new Transition('/', Conjunction.AND, "/"));
            TransitionFactory.sequence(MAP, "ANO", "THER");
            MAP.put("ANOTHER", TransitionFactory.toWord(Determiner.ANOTHER));
            MAP.put("ANT", TransitionFactory.mapOf('E'));
            MAP.put("ANTE", TransitionFactory.toWord(Zone.ANTE));
            MAP.get("ANTE").put('S', TransitionFactory.getTransition());
            MAP.put("ANY", TransitionFactory.toWord(Determiner.ANY));
            MAP.put("AR", TransitionFactory.mapOf('E', 'T'));
            MAP.put("ARE", TransitionFactory.toWord(ObjectVerb.IS));
            TransitionFactory.sequence(MAP, "ART", "IFACT");
            MAP.put("ARTIFACT", TransitionFactory.toWord(CardType.ARTIFACT));
            MAP.put("AS",
                    TransitionFactory.mapOf(SubordinateConjunction.AS, 'S'));
            TransitionFactory.sequence(MAP, "ASS", "IGN");
            MAP.put("ASSIGN", TransitionFactory.toWord(TargetVerb.ASSIGN));
            MAP.put("AT", TransitionFactory.mapOf(TriggerWord.AT, 'T'));
            TransitionFactory.sequence(MAP, "ATT", "AC");
            MAP.put("ATTAC", TransitionFactory.mapOf('H', 'K'));
            MAP.put("ATTACH", TransitionFactory.toWord(PlayerVerb.ATTACH));
            MAP.put("ATTACK", TransitionFactory.mapOf(ObjectVerb.ATTACK));
            TransitionFactory.sequence(MAP, "AU", "RA");
            MAP.put("AURA", TransitionFactory.mapOf(EnchantmentType.AURA));
        }
        return MAP;
    }
}
