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

SUBORDINATE_CONJUNCTION: A 's' (SPACE 'though')
                       | E 'xcept'
                       | I 'f'
                       | U 'nless';

// Concept Nouns
SOURCE: S 'ource';
LIFE: L 'ife';
PILE: P 'ile';
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

// Object verbs
CONTINUOUS_OBJECT_VERB: BECOMES
                      | HAS;
BECOMES: B 'ecome' ('s')?;
CAN: C 'an' (APOSTROPHE 't')?;
GAINS: G 'ains';
GETS: G 'et' ('s')?;
HAS: H 'as' | H 'ave';
IS: ((I 's' | A 're') ('n' APOSTROPHE 't')?) | APOSTROPHE S;
LOSES: L 'oses';
ONESHOT_OBJECT_VERB: ATTACK
                   | BLOCK
                   | DIE
                   | ENTER;
ATTACK: LetterA 'ttack';
BLOCK: B 'lock';
DIE: D 'ie';
ENTER: E 'nter';

// Player verbs
ADD: LetterA 'dd';
ACTIVATE: A 'ctivate';
CAST: C 'ast';
CHANGE: C 'hange';
CHOOSE: C 'hoose';
CONTROL: C 'ontrol';
DESTROY: D 'estroy';
DISCARD: D 'iscard';
DIVIDE: D 'ivide';
DRAW: D 'raw';
EXCHANGE: E 'xchange';
IGNORE: I 'gnore';
OWN: O 'wn';
PAY: P 'ay';
PUT: P 'ut';
PREVENT: P 'revent';
REGENERATE: R 'egenerate';
SHUFFLE: 'shuffle';

// Source verb
DEAL: D 'eal';
DEALT: DEAL 't';


// Zones
ZONE: ANTE
    | BATTLEFIELD
    | EXILE
    | GRAVEYARD
    | HAND
    | LIBRARY;

ANTE: LetterA 'nte';
BATTLEFIELD: B 'attlefield';
EXILE: E 'xile';
GRAVEYARD: G 'raveyard';
HAND: H 'and';
LIBRARY: L 'ibrary';

ABILITY_TYPE: ACTIVATE 'd' | MANA;

COUNTER: C 'orpse'
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
