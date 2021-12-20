package tegenton.card.parse.lexicon.game.source;

import tegenton.card.parse.lexicon.Word;

public enum SourceVerb implements Word {
    DEAL, DO, PRODUCE, RESOLVE;

    @Override
    public String getWord() {
        return this.name();
    }
}
