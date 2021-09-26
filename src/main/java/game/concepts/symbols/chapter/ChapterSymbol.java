package game.concepts.symbols.chapter;

import game.concepts.symbols.Symbol;
import generic.Filter;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public abstract class ChapterSymbol extends Symbol {
    private static Filter<Symbol> filter;

    private static void setupFilter() {
        List<Function<String, Optional<Symbol>>> chapterSymbols;
        chapterSymbols = List.of(SingleChapterSymbol::fromString, MultipleChapterSymbol::fromString);
        filter = new Filter<>(chapterSymbols);
    }

    public static Optional<Symbol> fromString(String s) {
        if (filter == null) {
            setupFilter();
        }
        return filter.filter(s);
    }
}
