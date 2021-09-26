package game.concepts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ColorTest {
    @Test
    void lowercase() throws InvalidColorException {
        assertEquals(Color.white, Color.fromString("w"));
        assertEquals(Color.blue, Color.fromString("u"));
        assertEquals(Color.black, Color.fromString("b"));
        assertEquals(Color.red, Color.fromString("r"));
        assertEquals(Color.green, Color.fromString("g"));
        assertNull(Color.fromString("c"));
    }

    @Test
    void uppercase() throws InvalidColorException {
        assertEquals(Color.white, Color.fromString("W"));
        assertEquals(Color.blue, Color.fromString("U"));
        assertEquals(Color.black, Color.fromString("B"));
        assertEquals(Color.red, Color.fromString("R"));
        assertEquals(Color.green, Color.fromString("G"));
        assertNull(Color.fromString("C"));
    }

    @Test
    void lowercaseBrackets() throws InvalidColorException {
        assertEquals(Color.white, Color.fromString("{w}"));
        assertEquals(Color.blue, Color.fromString("{u}"));
        assertEquals(Color.black, Color.fromString("{b}"));
        assertEquals(Color.red, Color.fromString("{r}"));
        assertEquals(Color.green, Color.fromString("{g}"));
        assertNull(Color.fromString("{c}"));
    }

    @Test
    void uppercaseBrackets() throws InvalidColorException {
        assertEquals(Color.white, Color.fromString("{W}"));
        assertEquals(Color.blue, Color.fromString("{U}"));
        assertEquals(Color.black, Color.fromString("{B}"));
        assertEquals(Color.red, Color.fromString("{R}"));
        assertEquals(Color.green, Color.fromString("{G}"));
        assertNull(Color.fromString("{C}"));
    }

    @Test
    void invalidColor() {
        //noinspection ResultOfMethodCallIgnored
        assertThrows(InvalidColorException.class, () -> Color.fromString("W/U"));
    }
}
