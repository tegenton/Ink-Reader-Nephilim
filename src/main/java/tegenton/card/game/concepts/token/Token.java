package tegenton.card.game.concepts.token;

import tegenton.card.game.concepts.object.Object;
import tegenton.card.game.concepts.permanent.Permanent;
import tegenton.card.game.concepts.permanent.State;
import tegenton.card.game.type.subtype.Subtype;
import java.util.EnumMap;
import java.util.List;
import java.util.Optional;

/**
 * A token is a marker used to represent any permanent
 * that isn’t represented by a card.
 */
public class Token extends Object implements Permanent {
    private final EnumMap<State, Boolean> state = new EnumMap<>(State.class);

    protected Token() {
        super();
        for (final State category : State.values()) {
            state.put(category, false);
        }
    }

    /**
     * Create a token with a given string. A "1/1 white soldier creature"
     * returns a Token with that power, toughness, color, type, and subtype.
     *
     * @param s a description of the token to be made
     * @return a token with those characteristics
     */
    public static Token create(final String s) {
        final Token token = new Token();
        final String[] items = s.split(" ");
        for (int i = 0; i < items.length; i++) {
            if (items[i].equalsIgnoreCase("named")) {
                token.setCharacteristic("named " + items[++i]);
            } else {
                token.setCharacteristic(items[i]);
            }
        }
        if (token.getName().isEmpty()) {
            token.setDefaultName();
        }
        return token;
    }

    private void setDefaultName() {
        StringBuilder name = new StringBuilder();
        if (getSubtypes().isPresent()) {
            final Optional<List<Subtype>> result = getSubtypes();
            if (result.isPresent()) {
                final List<Subtype> subtypes = result.get();
                for (final Subtype subtype : subtypes) {
                    String temp = subtype.getName();
                    temp = temp.substring(0, 1).toUpperCase()
                            + temp.substring(1);
                    name.append(temp).append(" ");
                }
                name = new StringBuilder(name.substring(0, name.length() - 1));
            }
            setName(List.of(name.toString()));
        }
    }

    @Override
    public final boolean getState(final State category) {
        return state.get(category);
    }

    @Override
    public final void setState(final State category, final boolean value) {
        state.put(category, value);
    }

    @Override
    public final void toggleState(final State category) {
        state.put(category, !((boolean) state.get(category)));
    }

    @Override
    protected final void setName(final List<String> names) {
        super.setName(names);
    }
}
