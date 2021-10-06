package tegenton.card.game.concepts.object.characteristics;

import java.util.Optional;

class PowerToughnessCharacteristic extends Characteristic<Integer[]> {
    private final Integer[] powerToughness;

    private PowerToughnessCharacteristic(int power, int toughness) {
        super();
        powerToughness = new Integer[]{power, toughness};
    }

    public static Optional<Characteristic<?>> fromString(String s) {
        String[] parts = s.split("/");
        if (parts.length == 2) {
            try {
                return Optional.of(new PowerToughnessCharacteristic(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])));
            } catch (NumberFormatException e) {
                return Optional.empty();
            }
        }
        return Optional.empty();
    }

    @Override
    public Integer[] value() {
        return powerToughness;
    }

    @Override
    public CharacteristicName getName() {
        return CharacteristicName.powerToughness;
    }
}
