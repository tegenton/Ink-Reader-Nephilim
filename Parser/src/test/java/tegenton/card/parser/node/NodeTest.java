package tegenton.card.parser.node;

import tegenton.card.parser.Parser;
import tegenton.card.parser.item.InputItem;

import java.text.ParseException;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class NodeTest {
    protected void testNode(Node expected, Node actual,
                            Deque<InputItem> input) {
        Parser parser = new Parser(input);
        try {
            assertEquals(expected, parser.parse(actual));
        } catch (ParseException e) {
            e.printStackTrace();
            fail();
        }
    }
}
