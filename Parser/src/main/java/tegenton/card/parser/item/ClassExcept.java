package tegenton.card.parser.item;

import tegenton.card.lexicon.game.Keyword;

public class ClassExcept extends InputClass {
    private final Keyword bad;

    public ClassExcept(Keyword protection) {
        super(protection);
        bad = protection;
    }

    @Override
    public boolean match(InputItem inputItem) {
        return super.match(inputItem) && inputItem.getWord() != bad;
    }
}
