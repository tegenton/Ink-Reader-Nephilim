package tegenton.card.parser.state;

import tegenton.card.parser.InputItem;

import java.util.List;

public abstract class State {
    public abstract int reducible(InputItem peek);

    public abstract InputItem reduce(List<InputItem> reductionItems);

    public abstract State shift(InputItem pop);
}
