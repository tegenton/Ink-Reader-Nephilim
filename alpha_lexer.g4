lexer grammar alpha_lexer;
// Determiner types
DETERMINER: ARTICLE | DEMONSTRATIVE | NEGATIVE | ALTERNATIVE | UNIVERSAL | DISTRIBUTIVE | EXISTENTIAL;
// Articles
ARTICLE: A | AN | THE;
fragment A: LetterA;
fragment AN: A 'n';
fragment THE: T 'he';
// Demonstrative
DEMONSTRATIVE: TARGET | THIS | THESE | THAT | THOSE;
TARGET: T 'arget';
fragment THIS: T 'his';
fragment THESE: T 'hese';
fragment THAT: T 'hat';
fragment THOSE: T 'hose';
// Negative
NEGATIVE: NO;
fragment NO: N 'o';
// Alternative
ALTERNATIVE: OTHER | ANOTHER;
fragment OTHER: O 'ther';
// Alternative-addative
fragment ANOTHER: A 'nother';
// Universal
UNIVERSAL: ALL;
fragment ALL: LetterA 'll';
// Distributive
DISTRIBUTIVE: EACH;
fragment EACH: E 'ach';
// Existential
EXISTENTIAL: ANY;
fragment ANY: LetterA 'ny';

CONJUNCTION: LetterA 'nd'
           | O 'r'
           | LetterA 'nd' SLASH 'or'
           | T 'hen';

// Assorted Nouns
SOURCE: S 'ource';
PILE: P 'ile';

// Object verbs
ATTACK: LetterA 'ttack';
BECOME: B 'ecome';
BLOCK: B 'lock';
DIE: D 'ie';
ENTER: E 'nter';

// Player verbs
ADD: LetterA 'dd';
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
PUT: P 'ut';
PREVENT: P 'revent';
REGENERATE: R 'egenerate';

// Zones
ANTE: LetterA 'nte';
EXILE: E 'xile';
BATTLEFIELD: B 'attlefield';
GRAVEYARD: G 'raveyard';
HAND: H 'and';
LIBRARY: L 'ibrary';

// Keywords
ENCHANT: E 'nchant';
BANDING: B 'anding';
FLYING: F 'lying';
VIGILANCE: V 'igilance';
DEFENDER: D 'efender';
INDESTRUCTIBLE: I 'ndesctructible';
FEAR: F 'ear';
HASTE: H 'aste';
TRAMPLE: T 'rample';
REACH: R 'each';

CARD_TYPE: C 'reature'
         | L 'and'
         | LetterA 'rtifact'
         | E 'nchantment'
         | I 'nstant';

// Creature types
CREATURE_TYPE: G 'oblin'
             | G 'olem'
             | M 'erfolk'
             | W 'all'
             | Z 'ombie';

ENCHANTMENT_TYPE: LetterA 'ura';

// Land types
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
verbCast : 'cast';
adverbInstead : 'instead';
prepositionTo : 'to';
prepositionFor : 'for';
verbActivate : 'activate';
verbDealt : 'dealt';
adjectiveRandom : 'random';
prepositionAt : 'at';
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
