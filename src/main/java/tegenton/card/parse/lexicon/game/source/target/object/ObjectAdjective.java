package tegenton.card.parse.lexicon.game.source.target.object;

import tegenton.card.parse.lexicon.Word;

public enum ObjectAdjective implements Word {
    TOP;

    @Override
    public String getWord() {
        return this.name();
    }
}
