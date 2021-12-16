package tegenton.card.parse;

import tegenton.card.parse.dfa.DFA;
import tegenton.card.parse.lexicon.Word;
import java.util.List;

public final class Lexicon {
    static List<Word> lookup(String s) {
        s = s.toUpperCase();
        DFA dfa = new DFA();
        s.chars().forEach(dfa::consume);
        return dfa.products();
    }
}
