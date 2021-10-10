package tegenton.card.generic;

import java.util.List;
import java.util.function.Function;

/**
 * Filter uses a list of functions that convert from String to a given type.
 *
 * @param <T> the type you would like to filter strings to
 */
public final class Filter<T> {
    private final List<Function<String, T>> filter;

    /**
     * Create a new filter with the given list of methods. These methods should
     * return null if given an invalid string.
     *
     * @param methods functions that convert from String to T
     */
    public Filter(final List<Function<String, T>> methods) {
        filter = methods;
    }

    /**
     * Calls each of the given methods with s as a parameter.
     *
     * @param s The string to filter
     * @return The first non-null object returned by one of the given methods,
     * or null if all methods return null.
     */
    public T filter(final String s) {
        T result;
        for (final Function<String, T> test : filter) {
            result = test.apply(s);
            if (result != null) {
                return result;
            }
        }
        return null;
    }
}
