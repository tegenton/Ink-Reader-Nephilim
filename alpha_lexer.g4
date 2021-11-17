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

ADJECTIVE: ADDITIONAL | ATTACKING | BLOCKING | ENCHANTED | SACRIFICED | TAPPED | TOKEN | TOP;
ADDITIONAL: ADDITION 'al';
ATTACKING: ATTACK ING;
BLOCKING: BLOCK ING;
ENCHANTED: (NOT)? ENCHANT ED;
SACRIFICED: SACRIFICE D;
TAPPED: TAP P ED;
TOKEN: T 'oken';
TOP: T 'op';

// Conjunctions
CONJUNCTION: OR
           | AND SLASH OR
           | T 'hen';
AND: LetterA 'nd';
OR: O 'r';

// Prepositions
PREPOSITION: ABOVE | FOR | FROM | IN | OF | ON | TO | UNDER | WITH;
ABOVE: A 'bove';
FOR: F 'or';
FROM: F 'rom';
IN: I 'n' (TO)?;
OF: O 'f';
ON: O 'n' (TO)?;
TO: T 'o';
UNDER: U 'nder';
WITH: W 'ith';

COMPARATIVE: LOW | HIGH;
HIGH: GREATER | M 'ore';
GREATER:  G 'reater';
LOW: LESS;
LESS: L 'ess';

SUBORDINATE_CONJUNCTION: AS (SPACE 'though' | SPACE LONG SPACE AS)
                       | EXCEPT
                       | IF
                       | U 'nless';
AS: A 's';
LONG: L 'ong';
EXCEPT: E 'xcept';
IF: I 'f';
WHERE: W 'here';

INSTEAD: I 'nstead';

// Concept Nouns
ABILITY: A 'bilit' ('y'|'ies');
COMBAT: C 'ombat';
DAMAGE: D 'amage';
EFFECT: E 'ffect';
GAME: G 'ame';
LIFE: L 'ife';
PILE: P 'ile' (S)?;
SOURCE: S 'ource';
STEP: S 'tep';
TURN: T 'urn';

ACTIVATED: ACTIVATE D;


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
BECOME: B 'ecome' (S)?;
COST: C 'ost' (S)?;
DO: D 'o' ('es')? (SPACE? NOT)?;
GAIN: G 'ain' (S)?;
GET: G 'et' (S)?;
HAVE: H 'as' | H 'ave';
IS: ((I 's' | LetterA 're') (SPACE? NOT)?) | APOSTROPHE ('s'|'re');

NOT: U N | N O (T|N(DASH)?) | N APOSTROPHE T;

ATTACK: LetterA 'ttack' (S)?;
BLOCK: B 'lock' (S)?;
DIE: D 'ie' (S)?;
ENTER: E 'nter' (S)?;
LEAVE: L 'eave' (S)?;
TAP: (NOT)? T 'ap';

// Player nouns
ANY_PLAYER: CONTROLLER | OWNER | PLAYER | OPPONENT | YOU | THEY;
CONTROLLER: CONTROL L ER;
OWNER: OWN ER;
PLAYER: PLAY ER (S)?;
OPPONENT: O 'pponent' (S)?;
YOU: 'you';
THEY: 'they';

SAXON: (APOSTROPHE)? S;
// Possessive players
YOUR: YOU R;
THEIR: T 'heir';

// Player verbs
ADD: LetterA 'dd';
ATTACH: A 'ttach';
CHANGE: C 'hange';
CHOOSE: C 'ho' ('o')? 'se' (S)?;
CONTROL: C 'ontrol' (S)?;
COULD: C 'ould';
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
PAY: P 'a' ('i'|'y');
PUT: P 'ut';
PREVENT: P 'revent';
REGENERATE: R 'egenerate';
REMOVE: R 'emove';
RETURN: R 'eturn';
SACRIFICE: S 'acrifice';
SEARCH: S 'earch';
SHUFFLE: S 'huffle' (S)?;
SKIPS: S 'kip' (S)?;
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

STAT_MOD: PLUSMINUS INT SLASH PLUSMINUS INT;

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

OBJECT_TYPE:(NOT)? (CARD_TYPE | CREATURE_TYPE | ENCHANTMENT_TYPE | LAND_TYPE);

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
APOSTROPHE: '’';
BULLET: '•';
CLOSEQUOTE: '”';
COMMA: ',';
COLON: ':';
DASH: '-' | '—';
LBRACKET: '{';
NEWLINE: '\n';
OPENQUOTE: '“';
PERIOD: '.';
PLUS: '+';
RBRACKET: '}';
SEMICOLON: ';';
SLASH: '/';
SPACE: ' ';
TILDE: '~';

// Numbers
ENGLISH_NUMBER : ONE
              | T 'wo'
              | T 'hree'
              | S 'even';
ONE: O 'ne';

INT: [0-9]+
   | VARIABLE;

VARIABLE: X | Y;

// Colors
COLOR:(NOT)? (WHITE | BLUE | BLACK | RED | GREEN);
WHITE: W 'hite';
BLUE: B 'lue';
BLACK: B 'lack';
RED: R 'ed';
GREEN: G 'reen';

MANA_COLOR: W
          | U
          | B
          | R
          | G
          | C;

MANA_SYMBOL: LBRACKET (MANA_COLOR | NUMBER) RBRACKET;
TAP_SYMBOL: LBRACKET T RBRACKET;

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
fragment ED: 'ed';
fragment ER: 'er';
fragment ING: 'ing';

LITERAL_NAME: 'Plague' SPACE 'Rats';

// To Sort
ATTACKED: ATTACK ED;
ATTACKERS: ATTACK ER (S)?;
BLOCKED: (NOT)? BLOCK ED;
BLOCKERS: BLOCK ER (S)?;
ADDITION: A 'ddition';
DECLARE: D 'eclar' (E)?;
DECLARING: DECLARE ING;
DECLARED: DECLARE D;

BE: B 'e';
RANDOM: R 'andom';
NUMBER: N 'umber';
DIFFERENT: D 'ifferent';
ASSIGN: A 'ssign';
LIKEWISE: L 'ikewise';
EQUAL: E 'qual';
THEM : T 'hem';
BUT: B 'ut';
TIME: T 'ime' (S)?;
MAXIMUM: M 'aximum';
SIZE: S 'ize';
BY: B 'y';
NEXT: N 'ext';
WOULD: W 'ould';
REGENERATED: REGENERATE D;
ROUND_DIRECTION: UP | DOWN;
UP: U 'p';
DOWN: D 'own';
UPKEEP: U 'pkeep';
BEGINNING: B 'eginning';
END: E 'nd';
ONLY: O 'nly';
CAUSE: C 'ause';
TOTAL: T 'otal';
HALF: H 'alf';
ROUNDED: R 'ounded';
THAN: T 'han';
MINUS: M 'inus';
MANY: M 'any';
AMOUNT: A 'mount';
PAID: PAY D;
PREVENTED: PREVENT ED;
HAD: HAVE D;
DID: DO D;
WAS: W 'as';
PLAYED: PLAY ED;
UNTIL: U 'ntil';
FINISHES: F 'inishes';
RESOLVING: R 'esolving';
DURING: D 'uring';
WHILE: W 'hile';
ABLE: A 'ble';
DIVIDED: DIVIDE D;
EVENLY: E 'venly';
AMONG: A 'mong';
SO: S 'o';
WAY: W 'ay';
CONTROLLED: CONTROL L ED;
CONTINUOUSLY: C 'ontinuously';
SINCE: S 'ince';
NAMED: N 'ame' D;
STILL: S 'till';
ASSIGNED: ASSIGN ED;
DIED: DIE D;
BEYOND: B 'eyond';
REMOVED: REMOVE D;
BEEN: BE 'en';
TYPE: T 'ype';
DOING: DO ING;
CHOSEN: CHOOSE N;