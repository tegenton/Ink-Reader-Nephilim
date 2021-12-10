package tegenton.card.parse.lexicon;

public enum TriggerWord implements Word {
    WHEN,
    WHENEVER,
    AT;

    @Override
    public String getWord() {
        return this.name();
    }
}
