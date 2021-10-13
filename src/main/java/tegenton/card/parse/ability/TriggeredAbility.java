package tegenton.card.parse.ability;

import tegenton.card.parse.token.TokenStream;

/**
 * Triggered abilities have a trigger condition and an effect. They are written
 * as “[Trigger condition], [effect],” and include (and usually begin with) the
 * word “when,” “whenever,” or “at.” Whenever the trigger event occurs, the
 * ability is put on the stack the next time a player would receive priority and
 * stays there until it’s countered, it resolves, or it otherwise leaves the
 * stack
 */
public class TriggeredAbility extends Ability {
    /**
     * Consume a triggered ability from the stream.
     *
     * @param tokens Stream of tokens starting with a triggered ability.
     * @return A triggered ability as specified in the stream.
     */
    public static TriggeredAbility fromStream(final TokenStream tokens) {
        return new TriggeredAbility();
    }
}
