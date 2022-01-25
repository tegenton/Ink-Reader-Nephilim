package tegenton.card.lexicon.game.source;

import tegenton.card.lexicon.Word;

public enum SourceNoun implements Word {
    SOURCE;

    @Override
    public String getWord() {
        return this.name();
    }
}
