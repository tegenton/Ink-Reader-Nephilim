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
        for (int next = text.indexOf(' '); next != -1; next = text.indexOf(' ',
                next)) {
            next++;
            builder.add(text.substring(i, next));
            i = next;
        }
        builder.add(text.substring(i));
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
