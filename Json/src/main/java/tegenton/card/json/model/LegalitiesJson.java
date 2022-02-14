package tegenton.card.json.model;

import java.util.Objects;

enum Legality {
    Banned,
    Legal,
    Restricted
}

public class LegalitiesJson {
    private Legality alchemy;
    private Legality brawl;
    private Legality commander;
    private Legality duel;
    private Legality future;
    private Legality gladiator;
    private Legality historic;
    private Legality historicbrawl;
    private Legality legacy;
    private Legality modern;
    private Legality oldschool;
    private Legality pauper;
    private Legality paupercommander;
    private Legality penny;
    private Legality pioneer;
    private Legality premodern;
    private Legality standard;
    private Legality vintage;

    /**
     * If the card is legal in the Alchemy play format.
     *
     * @return If the card is legal in the Alchemy play format.
     */
    public Legality getAlchemy() {
        return alchemy;
    }

    /**
     * If the card is legal in the Brawl play format.
     *
     * @return If the card is legal in the Brawl play format.
     */
    public Legality getBrawl() {
        return brawl;
    }

    /**
     * If the card is legal in the Commander play format.
     *
     * @return If the card is legal in the Commander play format.
     */
    public Legality getCommander() {
        return commander;
    }

    /**
     * Set Commander legality.
     *
     * @param legality Commander legality.
     * @return This.
     */
    LegalitiesJson setCommander(final Legality legality) {
        commander = legality;
        return this;
    }

    /**
     * If the card is legal in the Duel Commander play format.
     *
     * @return If the card is legal in the Duel Commander play format.
     */
    public Legality getDuel() {
        return duel;
    }

    /**
     * Set Duel Commander legality.
     *
     * @param legality Duel Commander legality.
     * @return This.
     */
    LegalitiesJson setDuel(final Legality legality) {
        this.duel = legality;
        return this;
    }

    /**
     * If the card is legal in the future for the Standard play format.
     *
     * @return If the card is legal in the future for the Standard play format.
     */
    public Legality getFuture() {
        return future;
    }

    /**
     * If the card is legal in the Gladiator play format.
     *
     * @return If the card is legal in the Gladiator play format.
     */
    public Legality getGladiator() {
        return gladiator;
    }

    /**
     * If the card is legal in the Historic play format.
     *
     * @return If the card is legal in the Historic play format.
     */
    public Legality getHistoric() {
        return historic;
    }

    /**
     * If the card is legal in the Historic Brawl play format.
     *
     * @return If the card is legal in the Historic Brawl play format.
     */
    public Legality getHistoricbrawl() {
        return historicbrawl;
    }

    /**
     * If the card is legal in the Legacy play format.
     *
     * @return If the card is legal in the Legacy play format.
     */
    public Legality getLegacy() {
        return legacy;
    }

    /**
     * Set Legacy legality.
     *
     * @param legality Legacy legality.
     * @return This.
     */
    LegalitiesJson setLegacy(final Legality legality) {
        this.legacy = legality;
        return this;
    }

    /**
     * If the card is legal in the Modern play format.
     *
     * @return If the card is legal in the Modern play format.
     */
    public Legality getModern() {
        return modern;
    }

    /**
     * If the card is legal in the Old School play format.
     *
     * @return If the card is legal in the Old School play format.
     */
    public Legality getOldschool() {
        return oldschool;
    }

    /**
     * Set Old School legality.
     *
     * @param legality Old School legality.
     * @return This.
     */
    LegalitiesJson setOldschool(final Legality legality) {
        this.oldschool = legality;
        return this;
    }

    /**
     * If the card is legal in the Pauper play format.
     *
     * @return If the card is legal in the Pauper play format.
     */
    public Legality getPauper() {
        return pauper;
    }

    /**
     * If the card is legal in the Pauper Commander play format.
     *
     * @return If the card is legal in the Pauper Commander play format.
     */
    public Legality getPaupercommander() {
        return paupercommander;
    }

    /**
     * If the card is legal in the Penny Dreadful play format.
     *
     * @return If the card is legal in the Penny Dreadful play format.
     */
    public Legality getPenny() {
        return penny;
    }

    /**
     * Set Penny Dreadful legality.
     *
     * @param legality Penny Dreadful legality.
     * @return This.
     */
    LegalitiesJson setPenny(final Legality legality) {
        this.penny = legality;
        return this;
    }

    /**
     * If the card is legal in the Pioneer play format.
     *
     * @return If the card is legal in the Pioneer play format.
     */
    public Legality getPioneer() {
        return pioneer;
    }

    /**
     * If the card is legal in the Premodern play format.
     *
     * @return If the card is legal in the Premodern play format.
     */
    public Legality getPremodern() {
        return premodern;
    }

    /**
     * Set Premodern legality.
     *
     * @param legality Premodern legality.
     * @return This.
     */
    LegalitiesJson setPremodern(final Legality legality) {
        this.premodern = legality;
        return this;
    }

    /**
     * If the card is legal in the Standard play format.
     *
     * @return If the card is legal in the Standard play format.
     */
    public Legality getStandard() {
        return standard;
    }

    /**
     * If the card is legal in the Vintage play format.
     *
     * @return If the card is legal in the Vintage play format.
     */
    public Legality getVintage() {
        return vintage;
    }

    /**
     * Set vintage legality.
     *
     * @param legality Vintage legality.
     * @return This.
     */
    LegalitiesJson setVintage(final Legality legality) {
        this.vintage = legality;
        return this;
    }

    /**
     * Compare two instances of LegalitiesJson.
     *
     * @param o Object to compare.
     * @return True if both objects have the same legalities.
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LegalitiesJson that = (LegalitiesJson) o;

        return alchemy == that.alchemy && brawl == that.brawl
                && commander == that.commander && duel == that.duel
                && future == that.future && gladiator == that.gladiator
                && historic == that.historic
                && historicbrawl == that.historicbrawl && legacy == that.legacy
                && modern == that.modern && oldschool == that.oldschool
                && pauper == that.pauper
                && paupercommander == that.paupercommander
                && penny == that.penny && pioneer == that.pioneer
                && premodern == that.premodern && standard == that.standard
                && vintage == that.vintage;
    }

    /**
     * Hash of legalities.
     *
     * @return Hash of legalities.
     */
    @Override
    public int hashCode() {
        return Objects.hash(alchemy, brawl, commander, duel, future, gladiator,
                historic, historicbrawl, legacy, modern, oldschool, pauper,
                paupercommander, penny, pioneer, premodern, standard, vintage);
    }

    /**
     * Legalities as a readable string.
     *
     * @return Legalities as a readable string.
     */
    @Override
    public String toString() {
        return "Legalities{" + "alchemy=" + alchemy + ", brawl=" + brawl
                + ", commander=" + commander + ", duel=" + duel + ", future="
                + future + ", gladiator=" + gladiator + ", historic=" + historic
                + ", historicbrawl=" + historicbrawl + ", legacy=" + legacy
                + ", modern=" + modern + ", oldschool=" + oldschool
                + ", pauper=" + pauper + ", paupercommander=" + paupercommander
                + ", penny=" + penny + ", pioneer=" + pioneer + ", premodern="
                + premodern + ", standard=" + standard + ", vintage=" + vintage
                + '}';
    }
}
