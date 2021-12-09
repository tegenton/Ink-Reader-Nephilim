package tegenton.card.parse.lexicon;

public enum TriggeredAbility implements Word {
    when,
    whenever,
    at;

    @Override
    public String getWord() {
        return name().substring(0, 1).toUpperCase() + name().substring(1);
    }
}
