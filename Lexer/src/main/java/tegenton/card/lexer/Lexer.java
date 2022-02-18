package tegenton.card.lexer;

import tegenton.card.lexer.tokenizer.Tokenizer;
import tegenton.card.lexicon.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Stream;

public class Lexer implements
        Collector<String, Stream.Builder<Word>, Stream<Word>> {
    /**
     * Static method to turn a single string into a list of words.
     *
     * @param text String to lex.
     * @return List of Words found in text.
     */
    public static List<Word> lex(final String text) {
        StringStreamBuilder builder =
                new StringStreamBuilder(text.toUpperCase());
        return new ArrayList<>(
                builder.build().collect(Lexer.toWordStream()).toList());
    }

    /**
     * Create an instance of Lexer for use in Stream.collect().
     *
     * @return An instance of the Lexer class.
     */
    public static Lexer toWordStream() {
        return new Lexer();
    }

    /**
     * This method provides a way to create a new result container, which future
     * stream operations can have their results stored in.
     *
     * @return Supplier that returns a mutable Stream.Builder.
     */
    @Override
    public Supplier<Stream.Builder<Word>> supplier() {
        return Stream::builder;
    }

    /**
     * This method provides a way to insert a new result into a container. It
     * accepts a string and a Stream.Builder instance, and will store any Words
     * produced from that string in that stream.
     *
     * @return BiConsumer that accepts a Stream.Builder and a String.
     */
    @Override
    public BiConsumer<Stream.Builder<Word>, String> accumulator() {
        return (stream, string) -> new Tokenizer().tokenize(string)
                .forEach(stream::add);
    }

    /**
     * This method allows two separate result containers to be combined into
     * one.
     *
     * @return BinaryOperator that combines two Stream.Builder instances.
     */
    @Override
    public BinaryOperator<Stream.Builder<Word>> combiner() {
        return (a, b) -> {
            b.build().forEach(a::add);
            return a;
        };
    }

    /**
     * Once the mutable result container is full, it is marked as complete.
     *
     * @return Function that turns a Stream.Builder into a Stream.
     */
    @Override
    public Function<Stream.Builder<Word>, Stream<Word>> finisher() {
        return Stream.Builder::build;
    }

    /**
     * This collector does not use any of the characteristics, so this returns
     * an immutable empty set.
     *
     * @return An immutable set of this collector's characteristics.
     */
    @Override
    public Set<Characteristics> characteristics() {
        return Set.of();
    }
}
