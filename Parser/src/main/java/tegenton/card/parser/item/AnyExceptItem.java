package tegenton.card.parser.item;

import tegenton.card.lexicon.Symbol;

public class AnyExceptItem extends InputItem {
    public AnyExceptItem(Symbol slash) {
        super(slash);
    }

    @Override
    public boolean match(InputItem inputItem) {
        return !super.match(inputItem);
    }
}
