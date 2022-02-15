package tegenton.card.lexer.tokenizer.state;

import tegenton.card.lexer.tokenizer.transition.Transition;
import tegenton.card.lexer.tokenizer.transition.TransitionFactory;
import tegenton.card.lexicon.Determiner;
import tegenton.card.lexicon.Morpheme;
import tegenton.card.lexicon.Symbol;
import tegenton.card.lexicon.game.ManaSymbol;
import tegenton.card.lexicon.game.Tap;
import tegenton.card.lexicon.value.Variable;

import java.util.HashMap;
import java.util.Map;

public class BaseState extends State {
    private static final Map<String, Map<Character, Transition>> MAP =
            new HashMap<>();

    BaseState(final String s) {
        super(s);
    }


    /**
     * Lazily load singleton map of base states, which begin from an empty
     * string.
     *
     * @return Map of base state transitions.
     */
    protected Map<String, Map<Character, Transition>> transitions() {
        if (MAP.isEmpty()) {
            MAP.put("",
                    TransitionFactory.mapOf('A', 'B', 'C', 'D', 'E', 'F', 'G',
                            'H', 'I', 'L', 'M', 'N', 'O', 'P', 'R', 'S', 'T',
                            'U', 'V', 'W', 'X', 'Y', 'Z', '1', '3', '\u2022',
                            '\u2014', '{', '\0', '+', '"', '~'));
            MAP.put("A",
                    TransitionFactory.mapOf(Determiner.A, 'B', 'C', 'D', 'F',
                            'L', 'M', 'N', 'R', 'S', 'T', 'U'));
            MAP.put("B",
                    TransitionFactory.mapOf(ManaSymbol.B, 'A', 'E', 'L', 'U',
                            'Y'));
            MAP.put("C",
                    TransitionFactory.mapOf(ManaSymbol.C, 'A', 'H', 'O', 'R'));
            MAP.put("D", TransitionFactory.mapOf('A', 'E', 'I', 'O', 'R', 'U'));
            MAP.put("E",
                    TransitionFactory.mapOf('A', 'D', 'F', 'I', 'L', 'N', 'Q',
                            'R', 'V', 'X'));
            MAP.put("F", TransitionFactory.mapOf('A', 'E', 'I', 'L', 'O', 'R'));
            MAP.put("G",
                    TransitionFactory.mapOf(ManaSymbol.G, 'A', 'E', 'O', 'R'));
            MAP.put("H", TransitionFactory.mapOf('A', 'E'));
            MAP.put("I", TransitionFactory.mapOf('F', 'G', 'N', 'S', 'T'));
            MAP.put("L", TransitionFactory.mapOf('A', 'E', 'I', 'O'));
            MAP.put("M", TransitionFactory.mapOf('A', 'E', 'I', 'O'));
            MAP.put("N",
                    TransitionFactory.mapOf('A', 'E', 'I', 'O', 'U', '\''));
            MAP.put("O",
                    TransitionFactory.mapOf('F', 'N', 'P', 'R', 'T', 'U', 'V',
                            'W'));
            MAP.put("P",
                    TransitionFactory.mapOf('A', 'E', 'I', 'O', 'L', 'R', 'U'));
            MAP.put("R",
                    TransitionFactory.mapOf(ManaSymbol.R, 'A', 'E', 'I', 'O'));
            MAP.put("S",
                    TransitionFactory.mapOf(Morpheme.S, 'A', 'E', 'H', 'I', 'K',
                            'P', 'O', 'T', 'W'));
            MAP.put("T",
                    TransitionFactory.mapOf(Tap.T, 'A', 'E', 'H', 'I', 'O', 'R',
                            'W', 'U', 'Y'));
            MAP.put("U", TransitionFactory.mapOf(ManaSymbol.U, 'N', 'P'));
            MAP.put("V", TransitionFactory.mapOf('A', 'I'));
            MAP.put("W",
                    TransitionFactory.mapOf(ManaSymbol.W, 'A', 'H', 'I', 'O'));
            MAP.put("X", TransitionFactory.mapOf(Variable.X));
            MAP.put("Y", TransitionFactory.mapOf(Variable.Y, 'O'));
            MAP.put("Z", TransitionFactory.mapOf('E', 'O'));
            MAP.put("'", TransitionFactory.mapOf('S'));
            MAP.put("\u2022", TransitionFactory.toSymbol(Symbol.BULLET, ' '));
            MAP.put(":", TransitionFactory.toWord(Symbol.COLON));
            MAP.put(",", TransitionFactory.toWord(Symbol.COMMA));
            MAP.put("\u2014", TransitionFactory.toSymbol(Symbol.DASH, '\n'));
            MAP.put("{",
                    TransitionFactory.toSymbol(Symbol.LBRACKET, 'T', 'W', '0',
                            '1'));
            MAP.put("\n",
                    Map.of('\0', new Transition('\0', Symbol.NEWLINE, "")));
            MAP.put(".",
                    TransitionFactory.toSymbol(Symbol.PERIOD, '\n', '"', ' '));
            MAP.put("+",
                    TransitionFactory.toSymbol(Symbol.PLUS, '0', '1', '2'));
            MAP.put("\"", TransitionFactory.toSymbol(Symbol.QUOTE, 'A'));
            MAP.put("}",
                    TransitionFactory.toSymbol(Symbol.RBRACKET, ':', ',', '{',
                            '.', ' '));
            MAP.put(";", TransitionFactory.toSymbol(Symbol.SEMICOLON, ' '));
            MAP.put(" ", TransitionFactory.toSymbol(Symbol.SPACE));
            MAP.put("/", TransitionFactory.toSymbol(Symbol.SLASH, 'O', '+'));
            MAP.put("~",
                    TransitionFactory.toSymbol(Symbol.TILDE, '\'', ' ', '.'));
        }
        return MAP;
    }
}
