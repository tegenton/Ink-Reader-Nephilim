package tegenton.card.game.concepts.object.characteristics;

import java.util.List;

final class PowerToughnessCharacteristic extends Characteristic {
    private final List<Integer> powerToughness;

    private PowerToughnessCharacteristic(final int power, final int toughness) {
        super();
        powerToughness = List.of(power, toughness);
    }

    public static PowerToughnessCharacteristic fromString(final String s) {
        final String[] parts = s.split("/");
        if (parts.length == 2) {
            try {
                final int power = Integer.parseInt(parts[0]);
                final int toughness = Integer.parseInt(parts[1]);
                return new PowerToughnessCharacteristic(power, toughness);
            } catch (final NumberFormatException e) {
                return null;
            }
        }
        return null;
    }

    @Override
    public List<Integer> value() {
        return powerToughness;
    }

    @Override
    public CharacteristicName getName() {
        return CharacteristicName.powerToughness;
    }
}
