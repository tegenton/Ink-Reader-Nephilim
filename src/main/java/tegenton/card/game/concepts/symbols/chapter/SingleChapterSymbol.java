package tegenton.card.game.concepts.symbols.chapter;

enum RomanNumeral {
    zero, // for ordinal offset
    I,
    II,
    III,
    IV,
    V
}

final class SingleChapterSymbol extends ChapterSymbol {
    private final int chapter;

    private SingleChapterSymbol(final int chapterNum) {
        this.chapter = chapterNum;
    }

    public static SingleChapterSymbol fromString(final String s) {
        final RomanNumeral numeral;
        try {
            numeral = RomanNumeral.valueOf(s.toUpperCase());
        } catch (final IllegalArgumentException e) {
            return null;
        }
        return new SingleChapterSymbol(numeral.ordinal());
    }

    public int getChapter() {
        return chapter;
    }
}
