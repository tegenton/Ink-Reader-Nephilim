package tegenton.card.lexicon.game.source.target.object;

import tegenton.card.lexicon.Word;

public enum ObjectAttribute implements Word {
    FACE, LOYALTY, NAME, POWER, TOUGHNESS, VALUE;

    @Override
    public String getWord() {
        return this.name();
    }
}
