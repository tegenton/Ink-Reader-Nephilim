package tegenton.card.parse.lexicon;

public enum Qualifier implements Word {
    enchanted;

    @Override
    public String getWord() {
        return name().substring(0, 1).toUpperCase() + name().substring(1);
    }
}
