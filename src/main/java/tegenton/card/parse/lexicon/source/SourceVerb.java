package tegenton.card.parse.lexicon.source;

import tegenton.card.parse.lexicon.Word;

public enum SourceVerb implements Word {
    DEAL, CAN, DO;

    @Override
    public String getWord() {
        return this.name();
    }
}
