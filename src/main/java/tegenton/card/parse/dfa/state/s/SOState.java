package tegenton.card.parse.dfa.state.s;

import tegenton.card.parse.dfa.state.SState;
import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Determiner;
import tegenton.card.parse.lexicon.Pronoun;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.type.CardType;

import java.util.Optional;

public class SOState extends SState {
    private static final SOState INSTANCE = new SOState();

    public static SOState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'M' -> new SuffixSubstring("ME", Determiner.SOME);
            case 'R' -> new SuffixSubstring("RCERY", CardType.SORCERY);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.ofNullable(switch (c) {
            case '\0', ' ' -> Pronoun.SO;
            default -> null;
        });
    }
}
