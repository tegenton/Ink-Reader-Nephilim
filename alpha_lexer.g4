lexer grammar alpha_lexer;
// Determiner types
// Articles
A: LetterA;
AN: LetterA 'n';
THE: T 'he';
// Demonstrative
TARGET: T 'arget';
THIS: T 'his';
THESE: T 'hese';
THAT: T 'hat';
THOSE: T 'hose';
// Negative
NO: N 'o';
// Alternative
OTHER: O 'ther';
// Alternative-addative
ANOTHER: A 'nother';
// Universal
ALL: LetterA 'll';
// Distributive
EACH: E 'ach';
// Existential
ANY: LetterA 'ny';

ADDITIONAL: ADDITION 'al';
ATTACKING: ATTACK ING;
BLOCKING: BLOCK ING;
ENCHANTED: (NOT)? ENCHANT ED;
SACRIFICED: SACRIFICE D;
TAPPED: TAP P ED;
TOKEN: (NOT)? T 'oken';
TOP: T 'op';

// Conjunctions
AND: LetterA 'nd';
OR: O 'r';
THEN: T 'hen';

// Prepositions
ABOVE: A 'bove';
FOR: F 'or';
FROM: F 'rom';
IN: I 'n' (TO)?;
OF: O 'f';
ON: O 'n' (TO)?;
TO: T 'o';
UNDER: U 'nder';
WITH: W 'ith' ('out')?;

// Comparatives
GREATER:  G 'reater';
MORE_: M 'ore';
LESS: L 'ess';

// Subordinate Conjunctions
AS: A 's';
LONG: L 'ong';
BUT: B 'ut';
EXCEPT: E 'xcept';
IF: I 'f';
WHERE: W 'here';

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
TURN: T 'urn' (S)?;

ACTIVATED: ACTIVATE D;

AT: LetterA 't';
WHEN: W 'hen';
WHENEVER: W 'henever';

// Object attributes
POWER: P 'ower';
TOUGHNESS: T 'oughness';
MANA: M 'ana';
VALUE: V 'alue';

// Object nouns
CARD: C 'ard' (S)?;
COPY: C 'op' ('y'| 'ies');
PERMANENT: P 'ermanent' (S)?;
SPELL: S 'pell' (S)?;
IT: I 't';

// Object verbs
BECOME: B 'ecome' (S)?;
COST: C 'ost' (S)?;
DO: D ('o' ('es')? (SPACE? NOT)?|'i');
GAIN: G 'ain' (S)?;
GET: G 'et' (S)?;
HAVE: H 'a' ('s'|'v'('e')?)?;
IS: (I 's' | LetterA 're');

// Negation
NOT: U N | N O (T|N(DASH)?) | N APOSTROPHE T;

ATTACK: LetterA 'ttack' (S)?;
BLOCK: B 'lock' (S)?;
DIE: D 'ie' (S)?;
ENTER: E 'nter' (S)?;
LEAVE: L 'eave' (S)?;
TAP: T 'ap';

// Player nouns
CONTROLLER: CONTROL L ER;
OWNER: OWN ER;
PLAYER: PLAY ER (S)?;
OPPONENT: O 'pponent' (S)?;
YOU: Y 'ou';
THEY: T 'he' ('y'|'i');

// Possessive players
YOUR: YOU R;
THEIR: THEY R;

// Player verbs
ADD: LetterA 'dd';
ATTACH: A 'ttach';
CHANGE: C 'hange';
CHOOSE: C 'ho' ('o')? ('se' (S)?)?;
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
LOSE: L 'os' ('e' (S)?)?;
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
SPEND: S 'pen' ('d')?;

ACTIVATE: A 'ctivate';
CAST: C 'ast';
PLAY: P 'lay';

// Source verb
DEAL: D 'eal' (S)?;
DEALT: DEAL 't';
CAN: C 'an';

// Zones
ANTE: LetterA 'nte' (S)?;
BATTLEFIELD: B 'attlefield';
EXILE: E 'xile' (S)?;
GRAVEYARD: G 'raveyard';
HAND: H 'and';
LIBRARY: L 'ibrary';

ABILITY_TYPE: ACTIVATE D | MANA;

COUNTER_TYPE: C 'orpse'
            | V 'itality'
            | M 'ire';

STAT_MOD: (PLUS | DASH) INT SLASH (PLUS | DASH) INT;

// Keywords
ENCHANT: E 'nchant';
PROTECTION: P 'rotection';
BANDING: B 'anding';
DEFENDER: D 'efender';
FEAR: F 'ear';
FLYING: F 'lying';
HASTE: H 'aste';
INDESTRUCTIBLE: I 'ndestructible';
LANDWALK: LAND_TYPE 'walk';
REACH: R 'each';
TRAMPLE: T 'rample';
VIGILANCE: V 'igilance';

FIRST: F 'irst';
STRIKE: S 'trike';

CARD_TYPE: C 'reature' (S)?
         | L 'and' (S)?
         | LetterA 'rtifact'
         | E 'nchantment'
         | I 'nstant'
         | S 'orcery';

CREATURE_TYPE: G 'oblin'
             | G 'olem'
             | M 'erfolk'
             | W 'all'
             | Z 'ombie';

ENCHANTMENT_TYPE: LetterA 'ura';

LAND_TYPE: P 'lains'
         | I 'sland'
         | S 'wamp' (S)?
         | M 'ountain' (S)?
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
ENGLISH_NUMBER: ONE
              | T 'wo'
              | T 'hree'
              | S 'even';
ONE: O 'ne';

INT: [0-9]+;

VARIABLE: X | Y;

// Colors
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
S: [Ss];
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
ASSIGN: A 'ssign' (S)?;
LIKEWISE: L 'ikewise';
EQUAL: E 'qual';
THEM : T 'hem';
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
BEGIN: B 'egin';
BEGINNING: BEGIN N ING;
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
DID: DO D (NOT)?;
WAS: W 'as';
PLAYED: PLAY ED;
UNTIL: U 'ntil';
FINISHES: F 'inishes';
RESOLVING: RESOLVE ING;
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
TYPE: T 'ype' (S)?;
DOING: DO ING;
CHOSEN: CHOOSE N;
COLOR: C 'olor';
PILE_LABEL: OPENQUOTE ('left'|'right') (PERIOD)? CLOSEQUOTE;
TURNED: TURN ED;
FACE: F 'ace';
RESOLVE: R 'esolv' ('e' ('s')?)?;
WHO: W 'ho';
WHOSE: WHO 'se';
WHOM: WHO 'm';
SOME: S 'ome';
TOUCHES: T 'ouches';
LABEL: L 'abel';
HAVING: HAVE ING;
DEFENDING: D 'efending';
HEIGHT: H 'eight';
LEAST: L 'east';
FOOT: F 'oot';
CHOICE: CHOOSE 'ice';
BEFORE: B 'efore';
REST: R 'est';
ACTIVE: A 'ctive';
FEWEST: F 'ewest';
TEXT: T 'ext';
REPLACING: R 'eplacing';
INSTANCES: I 'nstances';
PRODUCE: P 'roduce';
PRODUCED: PRODUCE D;
NEW: N 'ew';
FLIP: F 'lip';
SPENT: (NOT)? SPEND T;
BACK: B 'ack';
ORDER: O 'rder';
EXTRA: E 'xtra';
AFTER: A 'fter';
THOUGH: T 'hough';
WERE: W 'ere';
SAME: S 'ame';
PAYING:PAY ING;
PLAYING:PLAY ING;
LOST: LOSE T;
ONCE: O 'nce';
LOYALTY: L 'oyalty';
OVER: O 'ver';
COMPLETELY: C 'ompletely';
UNLESS: U 'nless';
WORD: W 'ord';
INSTEAD: I 'nstead';
