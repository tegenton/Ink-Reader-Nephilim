package game.concepts.object.characteristics;

import java.util.Optional;

class PowerToughnessCharacteristic extends Characteristic {
    private int[] powerToughness;

    private PowerToughnessCharacteristic(int power, int toughness) {
        super();
        this.powerToughness = new int[]{power, toughness};
    }

    public static Optional<Characteristic> fromString(String s) {
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
    public CharacteristicName getName() {
        return CharacteristicName.powerToughness;
    }

    @Override
    public void add(Characteristic characteristic) {
    }

    @Override
    public Object value() {
        return powerToughness;
    }

    @Override
    public void add(Object value) {
        if (value.getClass() == int[].class) {
            powerToughness = (int[]) value;
        }
    }
}
