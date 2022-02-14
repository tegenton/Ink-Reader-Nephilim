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

    public Legality getAlchemy() {
        return alchemy;
    }

    public Legality getBrawl() {
        return brawl;
    }

    public Legality getCommander() {
        return commander;
    }

    public LegalitiesJson setCommander(Legality legality) {
        commander = legality;
        return this;
    }

    public Legality getDuel() {
        return duel;
    }

    public LegalitiesJson setDuel(Legality duel) {
        this.duel = duel;
        return this;
    }

    public Legality getFuture() {
        return future;
    }

    public Legality getGladiator() {
        return gladiator;
    }

    public Legality getHistoric() {
        return historic;
    }

    public Legality getHistoricbrawl() {
        return historicbrawl;
    }

    public Legality getLegacy() {
        return legacy;
    }

    public LegalitiesJson setLegacy(Legality legacy) {
        this.legacy = legacy;
        return this;
    }

    public Legality getModern() {
        return modern;
    }

    public Legality getOldschool() {
        return oldschool;
    }

    public LegalitiesJson setOldschool(Legality oldschool) {
        this.oldschool = oldschool;
        return this;
    }

    public Legality getPauper() {
        return pauper;
    }

    public Legality getPaupercommander() {
        return paupercommander;
    }

    public Legality getPenny() {
        return penny;
    }

    public LegalitiesJson setPenny(Legality penny) {
        this.penny = penny;
        return this;
    }

    public Legality getPioneer() {
        return pioneer;
    }

    public Legality getPremodern() {
        return premodern;
    }

    public LegalitiesJson setPremodern(Legality premodern) {
        this.premodern = premodern;
        return this;
    }

    public Legality getStandard() {
        return standard;
    }

    public Legality getVintage() {
        return vintage;
    }

    public LegalitiesJson setVintage(Legality vintage) {
        this.vintage = vintage;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LegalitiesJson that = (LegalitiesJson) o;

        return alchemy == that.alchemy && brawl == that.brawl && commander == that.commander && duel == that.duel && future == that.future && gladiator == that.gladiator && historic == that.historic && historicbrawl == that.historicbrawl && legacy == that.legacy && modern == that.modern && oldschool == that.oldschool && pauper == that.pauper && paupercommander == that.paupercommander && penny == that.penny && pioneer == that.pioneer && premodern == that.premodern && standard == that.standard && vintage == that.vintage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(alchemy, brawl, commander, duel, future, gladiator,
                historic, historicbrawl, legacy, modern, oldschool, pauper,
                paupercommander, penny, pioneer, premodern, standard, vintage);
    }

    @Override
    public String toString() {
        return "LegalitiesJson{" + "alchemy=" + alchemy + ", brawl=" + brawl + ", commander=" + commander + ", duel=" + duel + ", future=" + future + ", gladiator=" + gladiator + ", historic=" + historic + ", historicbrawl=" + historicbrawl + ", legacy=" + legacy + ", modern=" + modern + ", oldschool=" + oldschool + ", pauper=" + pauper + ", paupercommander=" + paupercommander + ", penny=" + penny + ", pioneer=" + pioneer + ", premodern=" + premodern + ", standard=" + standard + ", vintage=" + vintage + '}';
    }
}
