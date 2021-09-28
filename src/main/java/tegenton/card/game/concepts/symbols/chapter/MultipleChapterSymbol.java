package tegenton.card.game.concepts.symbols.chapter;

import tegenton.card.game.concepts.symbols.Symbol;

import java.util.Optional;

class MultipleChapterSymbol extends ChapterSymbol {
    private final int[] chapters;

    private MultipleChapterSymbol(int[] chapters) {
        this.chapters = chapters;
    }

    public static Optional<Symbol> fromString(String s) {
        int[] chapters;
        switch (s.toUpperCase()) {
            case "I,II":
                chapters = new int[]{1, 2};
                break;
            case "II,III":
                chapters = new int[]{2, 3};
                break;
            case "I,II,III":
                chapters = new int[]{1, 2, 3};
                break;
            default:
                return Optional.empty();
        }
        return Optional.of(new MultipleChapterSymbol(chapters));
    }

    public int[] getChapters() {
        return chapters;
    }
}
