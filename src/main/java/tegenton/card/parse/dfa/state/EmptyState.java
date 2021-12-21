package tegenton.card.parse.dfa.state;

import tegenton.card.parse.dfa.state.y.o.YOUState;
import tegenton.card.parse.dfa.substring.InfixSubstring;
import tegenton.card.parse.lexicon.Word;

import java.util.Optional;

class EmptyState extends State {
    private static final EmptyState INSTANCE = new EmptyState();

    public static State state() {
        return INSTANCE;
    }

    @Override
    public State transition(char c) {
        return switch (c) {
            case 'A' -> AState.state();
            case 'B' -> BState.state();
            case 'C' -> CState.state();
            case 'D' -> DState.state();
            case 'E' -> EState.state();
            case 'F' -> FState.state();
            case 'G' -> GState.state();
            case 'H' -> HState.state();
            case 'I' -> IState.state();
            case 'L' -> LState.state();
            case 'M' -> MState.state();
            case 'N' -> NState.state();
            case 'O' -> OState.state();
            case 'P' -> PState.state();
            case 'R' -> RState.state();
            case 'S' -> SState.state();
            case 'T' -> TState.state();
            case 'U' -> UState.state();
            case 'V' -> VState.state();
            case 'W' -> WState.state();
            case 'Y' -> new InfixSubstring("YO", 'U', YOUState::state);
            case 'Z' -> ZState.state();
            case '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' -> NumberState.state(
                    c);
            case '\u2019', '\u2022', '\u201D', ':', '\u2014', ',', '{', '-',
                    '\u201C', '.', '+', '}', '/', ';', '~', '\n', '\0', ' ' -> SymbolState.state(
                    c);
            default -> invalid(c);
        };
    }

    @Override
    public Optional<Word> produce(char c) {
        return Optional.empty();
    }
}
