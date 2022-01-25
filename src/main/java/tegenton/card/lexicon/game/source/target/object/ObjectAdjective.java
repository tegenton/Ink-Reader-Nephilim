package tegenton.card.lexicon.game.source.target.object;

import tegenton.card.lexicon.Word;

public enum ObjectAdjective implements Word {
    TOP;

    @Override
    public String getWord() {
        return this.name();
    }
}
