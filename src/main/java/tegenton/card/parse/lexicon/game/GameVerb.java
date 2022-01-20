package tegenton.card.parse.lexicon.game;

import tegenton.card.parse.lexicon.Word;

public enum GameVerb implements Word {
    BE, CAUSE, FINISH;

    @Override
    public String getWord() {
        return this.name();
    }
}
