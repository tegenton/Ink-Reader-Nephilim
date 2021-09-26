package game.concepts.permanent;

import game.concepts.card.PermanentCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PermanentTest {
    public static Permanent permanent;

    @BeforeEach
    void setup() {
        permanent = new PermanentCard();
    }

    @Test
    void defaultState() {
        /* Permanents enter the battlefield untapped, unflipped, face up, and phased in unless a spell or
ability says otherwise. */
        assertFalse(permanent.getState(State.tapped));
        assertFalse(permanent.getState(State.flipped));
        assertFalse(permanent.getState(State.faceDown));
        assertFalse(permanent.getState(State.phasedOut));
    }

    @Test
    void toggleState() {
        permanent.toggleState(State.tapped);
        permanent.toggleState(State.flipped);
        permanent.toggleState(State.faceDown);
        permanent.toggleState(State.phasedOut);
        assertTrue(permanent.getState(State.tapped));
        assertTrue(permanent.getState(State.flipped));
        assertTrue(permanent.getState(State.faceDown));
        assertTrue(permanent.getState(State.phasedOut));
    }

    @Test
    void setState() {
        permanent.setState(State.tapped, true);
        permanent.setState(State.flipped, true);
        permanent.setState(State.faceDown, true);
        permanent.setState(State.phasedOut, true);
        assertTrue(permanent.getState(State.tapped));
        assertTrue(permanent.getState(State.flipped));
        assertTrue(permanent.getState(State.faceDown));
        assertTrue(permanent.getState(State.phasedOut));
    }
}
