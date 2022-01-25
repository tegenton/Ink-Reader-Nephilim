package tegenton.card.lexicon;

import tegenton.card.lexer.dfa.DFA;

import java.util.List;

public final class Lexicon {
    private Lexicon() {

    }

    public static List<Word> lookup(final String s) {
        final DFA dfa = new DFA();
        s.toUpperCase().chars().mapToObj((x) -> (char) x).forEach(dfa::consume);
        return dfa.products();
    }
}
