package tegenton.card.parse;

import tegenton.card.parse.dfa.DFA;
import tegenton.card.parse.lexicon.Word;

import java.util.List;

public final class Lexicon {
    private Lexicon() {

    }

    static List<Word> lookup(final String s) {
        final DFA dfa = new DFA();
        s.toUpperCase().chars().mapToObj((x) -> (char) x).forEach(dfa::consume);
        return dfa.products();
    }
}
