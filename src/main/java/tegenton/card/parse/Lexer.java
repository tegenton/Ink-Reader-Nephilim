package tegenton.card.parse;

import tegenton.card.parse.token.lexicon.EnglishNumber;
import tegenton.card.parse.token.lexicon.Subject;
import tegenton.card.parse.token.lexicon.Verb;
import tegenton.card.parse.token.lexicon.Word;
import java.util.ArrayDeque;
import java.util.Queue;

public class Lexer {
    Queue<Word> words = new ArrayDeque<>();

    public void consume(String s) {
        int index = 0;
        FiniteStateAutomata state;
        while (index != s.length()) {
            state = new FiniteStateAutomata();
            while (!state.isAccepting()) {
                if (index > s.length()) {
                    throw new ArrayIndexOutOfBoundsException();
                }
                state.transition(s.charAt(index++));
            }
            words.add(state.getWord());
        }
    }

    public Word next() {
        return words.poll();
    }

    private static class FiniteStateAutomata {
        private int state = 0;

        public boolean isAccepting() {
            return state == 'w' || state == 'o' || state == 'd';
        }

        public void transition(char c) {
            if (state < 2) {
                state++;
            } else {
                state = c;
            }
        }

        public Word getWord() {
            switch (state) {
                case 'w':
                    return Verb.draw;
                case 'o':
                    return EnglishNumber.two;
                case 'd':
                    return Subject.card;
                default:
                    throw new IllegalArgumentException();
            }
        }
    }
}
