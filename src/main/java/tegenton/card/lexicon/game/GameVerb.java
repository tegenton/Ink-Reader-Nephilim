package tegenton.card.lexicon.game;

import tegenton.card.lexicon.Word;

public enum GameVerb implements Word {
    BE, CAUSE, FINISH, TOUCH;

    @Override
    public String getWord() {
        return this.name();
    }
}
