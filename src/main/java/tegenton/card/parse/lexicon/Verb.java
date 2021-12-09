package tegenton.card.parse.lexicon;

public enum Verb implements Word {
    draw,
    create;

    @Override
    public String getWord() {
        return name();
    }
}
