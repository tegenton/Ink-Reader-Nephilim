package tegenton.card.parse.token.lexicon;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class KeywordAbilityTest {
    public static KeywordAbility keywordAbility;

    @ParameterizedTest
    @ValueSource(strings = {"Absorb",
            "Affinity",
            "Afflict",
            "Afterlife",
            "Aftermath",
            "Amplify",
            "Annihilator",
            "Ascend",
            "Assist",
            "Aura Swap",
            "Awaken",
            "Banding",
            "Battle Cry",
            "Bestow",
            "Bloodthirst",
            "Boast",
            "Bushido",
            "Buyback",
            "Cascade",
            "Champion",
            "Changeling",
            "Cipher",
            "Companion",
            "Conspire",
            "Convoke",
            "Crew",
            "Cumulative Upkeep",
            "Cycling",
            "Dash",
            "Daybound",
            "Nightbound",
            "Delve",
            "Demonstrate",
            "Dethrone",
            "Devoid",
            "Devour",
            "Disturb",
            "Dredge",
            "Echo",
            "Embalm",
            "Emerge",
            "Encore",
            "Entwine",
            "Epic",
            "Escalate",
            "Escape",
            "Eternalize",
            "Evoke",
            "Evolve",
            "Exalted",
            "Exploit",
            "Extort",
            "Fabricate",
            "Fading",
            "Fear",
            "Flanking",
            "Flashback",
            "Forecast",
            "Foretell",
            "Fortify",
            "Frenzy",
            "Fuse",
            "Graft",
            "Gravestorm",
            "Haunt",
            "Hidden Agenda",
            "Double Agenda",
            "Hideaway",
            "Horsemanship",
            "Improvise",
            "Infect",
            "Ingest",
            "Intimidate",
            "Jump-Start",
            "Kicker",
            "Multikicker",
            "Landwalk",
            "Level Up",
            "Living Weapon",
            "Madness",
            "Melee",
            "Mentor",
            "Miracle",
            "Modular",
            "Morph",
            "Megamorph",
            "Mutate",
            "Myriad",
            "Ninjutsu",
            "Commander Ninjutsu",
            "Offering",
            "Outlast",
            "Overload",
            "Partner",
            "Persist",
            "Phasing",
            "Poisonous",
            "Provoke",
            "Prowess",
            "Prowl",
            "Rampage",
            "Rebound",
            "Recover",
            "Reinforce",
            "Renown",
            "Replicate",
            "Retrace",
            "Riot",
            "Ripple",
            "Scavenge",
            "Shadow",
            "Shroud",
            "Skulk",
            "Soulbond",
            "Soulshift",
            "Spectacle",
            "Splice",
            "Split Second",
            "Storm",
            "Sunburst",
            "Surge",
            "Suspend",
            "Totem Armor",
            "Transfigure",
            "Transmute",
            "Tribute",
            "Undaunted",
            "Undying",
            "Unearth",
            "Unleash",
            "Vanishing",
            "Wither"})
    void otherKeywords(String s) {
        keywordAbility = KeywordAbility.fromString(s);
        assertNotNull(keywordAbility);
        assertEquals(s, keywordAbility.getWord());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Deathtouch", "Defender", "Double Strike", "Enchant", "Equip", "First Strike", "Flash", "Flying", "Haste", "Hexproof", "Indestructible", "Lifelink", "Menace", "Protection", "Reach", "Trample", "Vigilance", "Ward"})
    void evergreen(String word) {
        keywordAbility = KeywordAbility.fromString(word);
        assertNotNull(keywordAbility);
        assertEquals(word, keywordAbility.getWord());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Populate", "Magecraft", "Landfall"})
    void invalid(String word) {
        keywordAbility = KeywordAbility.fromString(word);
        assertNull(keywordAbility);
    }
}
