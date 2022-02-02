package tegenton.card.lexer;

import java.util.stream.Stream;

public class StringStreamBuilder {
    private final Stream.Builder<String> builder = Stream.builder();

    public StringStreamBuilder(String text) {
        if (text.length() == 0) {
            return;
        }
        int i = 0;
        for (int next = text.indexOf(' '); next != -1; ) {
            next++;
            builder.add(text.substring(i, next));
            i = next;
            next = text.indexOf(' ', next);
        }
        builder.add(text.substring(i));
    }

    public Stream<String> build() {
        return builder.build();
    }
}
