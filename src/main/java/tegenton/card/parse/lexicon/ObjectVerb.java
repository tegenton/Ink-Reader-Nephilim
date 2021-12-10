package tegenton.card.parse.lexicon;

public enum ObjectVerb implements Word {
    ATTACK,
    BLOCK,
    DIE,
    ENTER,
    LEAVE,
    TAP;

    @Override
    public String getWord() {
        return this.name();
    }
}
