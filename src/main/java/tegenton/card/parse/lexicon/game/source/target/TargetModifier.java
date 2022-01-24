package tegenton.card.parse.lexicon.game.source.target;

import tegenton.card.parse.lexicon.Word;

public enum TargetModifier implements Word {
    POSSESSIVE("'s");

    private final String name;

    TargetModifier(final String s) {
        this.name = s;
    }

    @Override
    public String getWord() {
        return this.name;
    }
}
