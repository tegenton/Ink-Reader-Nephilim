lexer grammar alpha_lexer;
// Determiner types
DETERMINER: ARTICLE | DEMONSTRATIVE | NEGATIVE | ALTERNATIVE | UNIVERSAL | DISTRIBUTIVE | EXISTENTIAL;
// Articles
ARTICLE: A | AN | THE;
A: LetterA;
AN: A 'n';
THE: T 'he';
// Demonstrative
DEMONSTRATIVE: TARGET | THIS | THESE | THAT | THOSE;
TARGET: T 'arget';
THIS: T 'his';
THESE: T 'hese';
THAT: T 'hat';
THOSE: T 'hose';
// Negative
NEGATIVE: NO;
NO: N 'o';
// Alternative
ALTERNATIVE: OTHER | ANOTHER;
OTHER: O 'ther';
// Alternative-addative
ANOTHER: A 'nother';
// Universal
UNIVERSAL: ALL;
ALL: LetterA 'll';
// Distributive
DISTRIBUTIVE: EACH;
EACH: E 'ach';
// Existential
EXISTENTIAL: ANY;
ANY: LetterA 'ny';

// Conjunctions
CONJUNCTION: O 'r'
           | LetterA 'nd' SLASH 'or'
           | T 'hen';
AND: LetterA 'nd';

COMPARATIVE: LESS | GREATER | MORE;
LESS: L 'ess';
GREATER:  G 'reater';
MORE: M 'ore';

SUBORDINATE_CONJUNCTION: A 's' (SPACE 'though' | SPACE 'long' SPACE 'as')
                       | EXCEPT
                       | IF
                       | U 'nless';
EXCEPT: E 'xcept';
IF: I 'f';

// Concept Nouns
ABILITY: A 'bility';
COMBAT: C 'ombat';
DAMAGE: D 'amage';
EFFECT: E 'ffect';
GAME: G 'ame';
LIFE: L 'ife';
PILE: P 'ile' (S)?;
SOURCE: S 'ource';
STEP: S 'tep';
TURN: T 'urn';

TRIGGER_WORD: AT | WHEN | WHENEVER;
AT: A 't';
WHEN: W 'hen';
WHENEVER: W 'henever';

// Object attributes
CHARACTERISTIC: POWER
              | TOUGHNESS
              | MANA SPACE VALUE;
POWER: P 'ower';
TOUGHNESS: T 'oughness';
MANA: M 'ana';
VALUE: V 'alue';

// Object nouns
OBJECT: TILDE | TYPE | COPY | CARD | SPELL | PERMANENT | IT;
CARD: C 'ard' (S)?;
COPY: C 'op' ('y'| 'ies');
PERMANENT: P 'ermanent' (S)?;
SPELL: S 'pell' (S)?;
IT: I 't';

// Object verbs
BECOMES: B 'ecome' (S)?;
COSTS: C 'ost' (S)?;
DOES: D 'o' ('es')? (SPACE? NOT)?;
GAINS: G 'ain' (S)?;
GETS: G 'et' (S)?;
HAS: H 'as' | H 'ave';
IS: ((I 's' | A 're') (SPACE? NOT)?) | APOSTROPHE S;

NOT: N 'ot' | N APOSTROPHE T;
LOSES: L 'oses';

ATTACKS: LetterA 'ttack' (S)?;
BLOCKS: B 'lock' (S)?;
DIES: D 'ie' (S)?;
ENTERS: E 'nter' (S)?;
LEAVES: L 'eave' (S)?;

// Player nouns
ANY_PLAYER: CONTROLLER | OWNER | PLAYER | OPPONENT | YOU | THEY;
CONTROLLER: CONTROL 'l' ER;
OWNER: OWN ER;
PLAYER: PLAY ER (S)?;
OPPONENT: O 'pponent' (S)?;
YOU: 'you';
THEY: 'they';

// Possessive players
YOUR: YOU R;
THEIR: T 'heir';

// Player verbs
ADD: LetterA 'dd';
CHANGE: C 'hange';
CHOOSE: C 'hoose' (S)?;
CONTROL: C 'ontrol' (S)?;
COUNTER: C 'ounter' (S)?;
CREATE: C 'reate';
DESTROY: D 'estroy';
DISCARD: D 'iscard';
DIVIDE: D 'ivide' (S)?;
DRAW: D 'raw';
EXCHANGE: E 'xchange';
IGNORE: I 'gnore';
LOOK: L 'ook';
LOSE: L 'ose' (S)?;
MAY: M 'ay';
OWN: O 'wn';
PAY: P 'ay';
PUT: P 'ut';
PREVENT: P 'revent';
REGENERATE: R 'egenerate';
REMOVE: R 'emove';
RETURN: R 'eturn';
SACRIFICE: S 'acrifice';
SEARCH: S 'earch';
SHUFFLE: S 'huffle' (S)?;
SKIP: S 'kip';
TAKE: T 'ake';
SPEND: S 'pend';

ANY_PLAY: ACTIVATE | CAST | PLAY;
ACTIVATE: A 'ctivate';
CAST: C 'ast';
PLAY: P 'lay';

// Source verb
DEAL: D 'eal' (S)?;
DEALT: DEAL 't';
CAN: C 'an' (APOSTROPHE 't')?;

// Zones
ZONE: ANTE
    | BATTLEFIELD
    | EXILE
    | GRAVEYARD
    | HAND
    | LIBRARY;

ANTE: LetterA 'nte' (S)?;
BATTLEFIELD: B 'attlefield';
EXILE: E 'xile' (S)?;
GRAVEYARD: G 'raveyard';
HAND: H 'and';
LIBRARY: L 'ibrary';

ABILITY_TYPE: ACTIVATE 'd' | MANA;

COUNTER_TYPE: C 'orpse'
            | V 'itality'
            | M 'ire'
            | STAT_MOD;

STAT_MOD: PLUSMINUS NUMBER SLASH PLUSMINUS NUMBER;

PLUSMINUS: PLUS | DASH;

// Keywords
ENCHANT: E 'nchant';
PROTECTION: P 'rotection';
// Keywords that need no context
SIMPLE_KEYWORD: BANDING | DEFENDER | FEAR | FIRST_STRIKE | FLYING | HASTE | INDESTRUCTIBLE | LANDWALK | REACH | TRAMPLE | VIGILANCE;
BANDING: B 'anding';
DEFENDER: D 'efender';
FEAR: F 'ear';
FIRST_STRIKE: FIRST SPACE STRIKE;
FLYING: F 'lying';
HASTE: H 'aste';
INDESTRUCTIBLE: I 'ndesctructible';
LANDWALK: LAND_TYPE 'walk';
REACH: R 'each';
TRAMPLE: T 'rample';
VIGILANCE: V 'igilance';

FIRST: F 'irst';
STRIKE: S 'trike';

TYPE: CARD_TYPE
    | CREATURE_TYPE
    | ENCHANTMENT_TYPE
    | LAND_TYPE;

CARD_TYPE: C 'reature'
         | L 'and'
         | LetterA 'rtifact'
         | E 'nchantment'
         | I 'nstant';

CREATURE_TYPE: G 'oblin'
             | G 'olem'
             | M 'erfolk'
             | W 'all'
             | Z 'ombie';

ENCHANTMENT_TYPE: LetterA 'ura';

LAND_TYPE: P 'lains'
         | I 'sland'
         | S 'wamp'
         | M 'ountain'
         | F 'orest';

// Literal symbols
fragment APOSTROPHE: '’';
fragment BULLET: '•';
fragment CLOSEQUOTE: '”';
fragment COMMA: ',';
fragment COLON: ':';
fragment DASH: '-' | '—';
fragment LBRACKET: '{';
fragment NEWLINE: '\n';
fragment OPENQUOTE: '“';
fragment PERIOD: '.';
fragment PLUS: '+';
fragment RBRACKET: '}';
fragment SEMICOLON: ';';
fragment SLASH: '/';
fragment SPACE: ' ';
fragment TILDE: '~';

// Numbers
ENGLISH_NUMBER : ONE
              | T 'wo'
              | T 'hree'
              | S 'even';
ONE: O 'ne';

NUMBER: [0-9]+
      | VARIABLE;

VARIABLE: X | Y;

// Colors
COLOR: W 'hite'
     | B 'lue'
     | B 'lack'
     | G 'reen'
     | R 'ed';

MANA_COLOR: W
          | U
          | B
          | R
          | G
          | C;

MANA_SYMBOL: LBRACKET (MANA_COLOR | NUMBER) RBRACKET;
TAP_TYMBOL: LBRACKET T RBRACKET;

// Case insensitive alphabet
fragment LetterA: [Aa];
fragment B: [Bb];
fragment C: [Cc];
fragment D: [Dd];
fragment E: [Ee];
fragment F: [Ff];
fragment G: [Gg];
fragment H: [Hh];
fragment I: [Ii];
fragment J: [Jj];
fragment K: [Kk];
fragment L: [Ll];
fragment M: [Mm];
fragment N: [Nn];
fragment O: [Oo];
fragment P: [Pp];
fragment Q: [Qq];
fragment R: [Rr];
fragment S: [Ss];
fragment T: [Tt];
fragment U: [Uu];
fragment V: [Vv];
fragment W: [Ww];
fragment X: [Xx];
fragment Y: [Yy];
fragment Z: [Zz];

// Conjugation fragments
fragment ER: 'er';

// To Sort
abilityType : 'activated abilities'
            | 'mana ability';
verbCost : 'cost';
adverbInstead : 'instead';
prepositionTo : 'to';
prepositionFor : 'for';
verbDealt : 'dealt';
adjectiveRandom : 'random';
adjectiveDifferent : 'different';
verbAssign : 'assign';
verbBe : 'be';
verbLikewise : 'likewise';
verbMay : 'may';
adjectiveEqual : 'equal';
prepositionOf : 'of';
nounNumber : 'number';
pronounThem : 'them';
nounBlockers : 'blockers';
verbChooses : 'chooses';
verbDivides : 'divides';
verbDeclaring : 'declaring';
nounEffect : 'effect';
nounTop : 'top';
prepositionBut : 'but';
nounTime : 'time';
verbCould : 'could';
damageType : 'combat damage'
           | 'damage';
