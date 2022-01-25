package tegenton.card.lexicon;

public enum Pronoun implements Word {
    SO;

    @Override
    public String getWord() {
        return this.name();
    }
}
