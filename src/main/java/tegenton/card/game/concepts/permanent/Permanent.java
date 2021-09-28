package tegenton.card.game.concepts.permanent;


public interface Permanent {
    boolean getState(State category);

    void setState(State category, boolean value);

    void toggleState(State category);
}
