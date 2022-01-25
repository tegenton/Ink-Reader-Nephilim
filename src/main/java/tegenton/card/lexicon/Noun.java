package tegenton.card.lexicon;

public enum Noun implements Word {
    AMOUNT, CHOICE, FEWEST, FOOT, HEIGHT, INSTANCE, LABEL, NUMBER, ORDER,
    RANDOM, REST, TEXT, TIME, WAY, WORD;

    @Override
    public String getWord() {
        return this.name();
    }
}
