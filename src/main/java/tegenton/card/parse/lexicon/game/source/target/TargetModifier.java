package tegenton.card.parse.lexicon.game.source.target;

import tegenton.card.parse.lexicon.Word;

public enum TargetModifier implements Word {
    POSSESSIVE("'s");

    private final String name;

    TargetModifier(String name) {
        this.name = name;
    }

    @Override
    public String getWord() {
        return this.name;
    }
}
