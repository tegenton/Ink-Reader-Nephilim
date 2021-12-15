package tegenton.card.parse.lexicon.type;

public enum EnchantmentType implements Type {
	AURA;

	@Override
	public String getWord() {
		return this.name();
	}
}
