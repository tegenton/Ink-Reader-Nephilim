package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexer.tokenizer.transition.TransitionFactory;
import tegenton.card.lexicon.Adjective;
import tegenton.card.lexicon.Adverb;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Pronoun;
import tegenton.card.lexicon.game.GameNoun;
import tegenton.card.lexicon.game.Keyword;
import tegenton.card.lexicon.game.target.object.ObjectNoun;
import tegenton.card.lexicon.game.target.object.source.SourceNoun;
import tegenton.card.lexicon.game.target.player.PlayerAttribute;
import tegenton.card.lexicon.game.target.player.PlayerVerb;
import tegenton.card.lexicon.game.turn.Duration;
import tegenton.card.lexicon.game.type.CardType;
import tegenton.card.lexicon.game.type.LandType;
import tegenton.card.lexicon.value.EnglishNumber;

import java.util.HashMap;
import java.util.Map;

public class SState extends State {
    private static final Map<String, Map<Character, Transition>> MAP =
            new HashMap<>();

    SState(final String name) {
        super(name);
    }

    /**
     * Lazily load singleton map of S states.
     *
     * @return Map of S state transitions.
     */
    protected Map<String, Map<Character, Transition>> transitions() {
        if (MAP.isEmpty()) {
            MAP.put("SA", TransitionFactory.mapOf('C', 'M'));
            MAP.put("SAC", TransitionFactory.mapOf('R'));
            MAP.put("SACR", TransitionFactory.mapOf('I'));
            MAP.put("SACRI", TransitionFactory.mapOf('F'));
            MAP.put("SACRIF", TransitionFactory.mapOf('I'));
            MAP.put("SACRIFI", TransitionFactory.mapOf('C'));
            MAP.put("SACRIFIC", TransitionFactory.mapOf('E'));
            MAP.put("SACRIFICE", TransitionFactory.mapOf(PlayerVerb.SACRIFICE));
            MAP.put("SAM", TransitionFactory.mapOf('E'));
            MAP.put("SAME", TransitionFactory.mapOf(Adjective.SAME));
            MAP.put("SE", TransitionFactory.mapOf('A', 'V'));
            MAP.put("SEA", TransitionFactory.mapOf('R'));
            MAP.put("SEAR", TransitionFactory.mapOf('C'));
            MAP.put("SEARC", TransitionFactory.mapOf('H'));
            MAP.put("SEARCH", TransitionFactory.mapOf(PlayerVerb.SEARCH));
            MAP.put("SEV", TransitionFactory.mapOf('E'));
            MAP.put("SEVE", TransitionFactory.mapOf('N'));
            MAP.put("SEVEN", TransitionFactory.mapOf(EnglishNumber.SEVEN, 'T'));
            MAP.put("SEVENT", TransitionFactory.mapOf('E'));
            MAP.put("SEVENTE", TransitionFactory.mapOf('E'));
            MAP.put("SEVENTEE", TransitionFactory.mapOf('N'));
            MAP.put("SEVENTEEN",
                    TransitionFactory.mapOf(EnglishNumber.SEVENTEEN));
            MAP.put("SH", TransitionFactory.mapOf('U'));
            MAP.put("SHU", TransitionFactory.mapOf('F'));
            MAP.put("SHUF", TransitionFactory.mapOf('F'));
            MAP.put("SHUFF", TransitionFactory.mapOf('L'));
            MAP.put("SHUFFL", TransitionFactory.mapOf('E'));
            MAP.put("SHUFFLE", TransitionFactory.mapOf(PlayerVerb.SHUFFLE));
            MAP.put("SI", TransitionFactory.mapOf('N', 'X', 'Z'));
            MAP.put("SIN", TransitionFactory.mapOf('C'));
            MAP.put("SINC", TransitionFactory.mapOf('E'));
            MAP.put("SINCE", TransitionFactory.mapOf(Duration.SINCE));
            MAP.put("SIX", TransitionFactory.mapOf(EnglishNumber.SIX, 'T'));
            MAP.put("SIXT", TransitionFactory.mapOf('E'));
            MAP.put("SIXTE", TransitionFactory.mapOf('E'));
            MAP.put("SIXTEE", TransitionFactory.mapOf('N'));
            MAP.put("SIXTEEN", TransitionFactory.mapOf(EnglishNumber.SIXTEEN));
            MAP.put("SIZ", TransitionFactory.mapOf('E'));
            MAP.put("SIZE", TransitionFactory.mapOf(PlayerAttribute.SIZE));
            MAP.put("SK", TransitionFactory.mapOf('I'));
            MAP.put("SKI", TransitionFactory.mapOf('P'));
            MAP.put("SKIP", TransitionFactory.mapOf(PlayerVerb.SKIP));
            MAP.put("SP", TransitionFactory.mapOf('E'));
            MAP.put("SPE", TransitionFactory.mapOf('L', 'N'));
            MAP.put("SPEL", TransitionFactory.mapOf('L'));
            MAP.put("SPELL", TransitionFactory.mapOf(ObjectNoun.SPELL));
            MAP.put("SPEN", TransitionFactory.mapOf('D'));
            MAP.get("SPEN")
                    .put('T', new Transition('T', PlayerVerb.SPEND, "ED"));
            MAP.put("SPEND", TransitionFactory.mapOf(PlayerVerb.SPEND));
            MAP.put("SO", TransitionFactory.mapOf(Pronoun.SO, 'M', 'R', 'U'));
            MAP.put("SOM", TransitionFactory.mapOf('E'));
            MAP.put("SOME", TransitionFactory.mapOf(Determiner.SOME));
            MAP.put("SOR", TransitionFactory.mapOf('C'));
            MAP.put("SORC", TransitionFactory.mapOf('E'));
            MAP.put("SORCE", TransitionFactory.mapOf('R'));
            MAP.put("SORCER", TransitionFactory.mapOf('Y'));
            MAP.put("SORCERY", TransitionFactory.mapOf(CardType.SORCERY));
            MAP.put("SOU", TransitionFactory.mapOf('R'));
            MAP.put("SOUR", TransitionFactory.mapOf('C'));
            MAP.put("SOURC", TransitionFactory.mapOf('E'));
            MAP.put("SOURCE", TransitionFactory.mapOf(SourceNoun.SOURCE));
            MAP.put("ST", TransitionFactory.mapOf('E', 'I', 'R'));
            MAP.put("STE", TransitionFactory.mapOf('P'));
            MAP.put("STEP", TransitionFactory.mapOf(GameNoun.STEP));
            MAP.put("STI", TransitionFactory.mapOf('L'));
            MAP.put("STIL", TransitionFactory.mapOf('L'));
            MAP.put("STILL", TransitionFactory.mapOf(Adverb.STILL));
            MAP.put("STR", TransitionFactory.mapOf('I'));
            MAP.put("STRI", TransitionFactory.mapOf('K'));
            MAP.put("STRIK", TransitionFactory.mapOf('E'));
            MAP.put("STRIKE", TransitionFactory.mapOf(Keyword.STRIKE));
            MAP.put("SW", TransitionFactory.mapOf('A'));
            MAP.put("SWA", TransitionFactory.mapOf('M'));
            MAP.put("SWAM", TransitionFactory.mapOf('P'));
            MAP.put("SWAMP", TransitionFactory.mapOf(LandType.SWAMP));
        }
        return MAP;
    }
}
