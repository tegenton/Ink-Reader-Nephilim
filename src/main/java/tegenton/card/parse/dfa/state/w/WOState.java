package tegenton.card.parse.dfa.state.w;

import tegenton.card.parse.dfa.state.State;
import tegenton.card.parse.dfa.state.WState;
import tegenton.card.parse.dfa.substring.SuffixSubstring;
import tegenton.card.parse.lexicon.Noun;
import tegenton.card.parse.lexicon.Word;
import tegenton.card.parse.lexicon.game.source.target.TargetAuxiliaryVerb;

import java.util.Optional;

public class WOState extends WState {
    private static final WOState INSTANCE = new WOState();

    public static WOState state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'R' -> new SuffixSubstring("RD", Noun.WORD);
            case 'U' -> new SuffixSubstring("ULD", TargetAuxiliaryVerb.WOULD);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<? extends Word> produce(char c) {
        return Optional.empty();
    }
}