package tegenton.card.lexer;

import java.util.stream.Stream;

public class StringStreamBuilder {
    private final Stream.Builder<String> builder = Stream.builder();

    /**
     * Creates a stream of strings from a single string, splitting on spaces
     * (inclusive).
     *
     * @param text String to split.
     */
    public StringStreamBuilder(final String text) {
        if (text.length() == 0) {
            return;
        }
        int i = 0;
        for (int next = nextDelim(text);
             next != -1; next = nextDelim(text, next)) {
            next++;
            builder.add(text.substring(i, next));
            i = next;
        }
        builder.add(text.substring(i));
    }

    private int nextDelim(final String text) {
        return nextDelim(text, 0);
    }

    private int nextDelim(final String text, final int next) {
        final int space = text.indexOf(' ', next);
        final int newline = text.indexOf('\n', next);
        if (newline == -1) {
            return space;
        } else if (space == -1) {
            return newline;
        }
        return Math.min(space, newline);
    }

    /**
     * Finalize stream builder.
     *
     * @return Stream of substrings.
     */
    public Stream<String> build() {
        return builder.build();
    }
}
