package tegenton.card.parse.lexicon.source.something.object;

import tegenton.card.parse.lexicon.Word;

public enum ObjectAttribute implements Word {
    POWER,
    TOUGHNESS,
    VALUE;

    @Override
    public String getWord() {
        return this.name();
    }
}
