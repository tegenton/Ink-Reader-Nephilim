package tegenton.card.parse.lexicon.game.source;

import tegenton.card.parse.lexicon.Word;

public enum SourceNoun implements Word {
    SOURCE;

    @Override
    public String getWord() {
        return this.name();
    }
}
