package tegenton.card.lexicon.game.source;

import tegenton.card.lexicon.Word;

public enum SourceVerb implements Word {
    DEAL, DO, PRODUCE, RESOLVE;

    @Override
    public String getWord() {
        return this.name();
    }
}
