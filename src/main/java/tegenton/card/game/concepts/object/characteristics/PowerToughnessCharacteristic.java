package tegenton.card.game.concepts.object.characteristics;

class PowerToughnessCharacteristic extends Characteristic<Integer[]> {
    private final Integer[] powerToughness;

    private PowerToughnessCharacteristic(int power, int toughness) {
        super();
        powerToughness = new Integer[]{power, toughness};
    }

    public static PowerToughnessCharacteristic fromString(String s) {
        String[] parts = s.split("/");
        if (parts.length == 2) {
            try {
                return new PowerToughnessCharacteristic(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return null;
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
