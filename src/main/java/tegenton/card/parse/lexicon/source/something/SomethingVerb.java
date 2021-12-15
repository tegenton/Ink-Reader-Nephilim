package tegenton.card.parse.lexicon.source.something;

import tegenton.card.parse.lexicon.Word;

public enum SomethingVerb implements Word {
    GAIN;

    @Override
    public String getWord() {
        return this.name();
    }
}
