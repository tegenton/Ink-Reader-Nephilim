package tegenton.card.parse.lexicon.game;

import tegenton.card.parse.lexicon.Word;

public enum TriggerWord implements Word {
    WHEN, WHENEVER, AT;

    @Override
    public String getWord() {
        return this.name();
    }
}
