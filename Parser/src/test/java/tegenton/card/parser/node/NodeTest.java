package tegenton.card.parser.node;

import tegenton.card.parser.Parser;
import tegenton.card.parser.item.InputItem;

import java.text.ParseException;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class NodeTest {
    protected void testNode(Node expected, Deque<InputItem> input) {
        Parser parser = new Parser(input);
        try {
            assertEquals(expected, parser.parse(expected));
        } catch (ParseException e) {
            e.printStackTrace();
            fail();
        }
    }
}
