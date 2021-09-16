package game.concepts.symbols.chapter;

import game.concepts.symbols.Symbol;

import java.util.Optional;

class SingleChapterSymbol extends ChapterSymbol {
    private final int chapter;

    private SingleChapterSymbol(int chapter) {
        this.chapter = chapter;
    }

    public static Optional<Symbol> fromString(String s) {
        int chapter;
        switch (s.toUpperCase()) {
            case "I":
                chapter = 1;
                break;
            case "II":
                chapter = 2;
                break;
            case "III":
                chapter = 3;
                break;
            case "IV":
                chapter = 4;
                break;
            case "V":
                chapter = 5;
                break;
            default:
                return Optional.empty();
        }
        return Optional.of(new SingleChapterSymbol(chapter));
    }

    public int getChapter() {
        return chapter;
    }
}
