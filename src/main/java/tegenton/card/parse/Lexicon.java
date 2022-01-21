package tegenton.card.parse;

import tegenton.card.parse.dfa.DFA;
import tegenton.card.parse.lexicon.Word;

import java.util.List;

public final class Lexicon {
    static List<Word> lookup(String s) {
        s = s.toUpperCase();
        final DFA dfa = new DFA();
        s.chars().mapToObj((x) -> (char) x).forEach(dfa::consume);
        return dfa.products();
    }
}
