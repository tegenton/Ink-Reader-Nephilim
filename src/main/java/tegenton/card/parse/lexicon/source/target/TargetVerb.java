package tegenton.card.parse.lexicon.source.target;

import tegenton.card.parse.lexicon.Word;

public enum TargetVerb implements Word {
    GAIN;

    @Override
    public String getWord() {
        return this.name();
    }
}