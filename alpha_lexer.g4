lexer grammar alpha_lexer;
// Determiner types
// Articles
A: LetterA;
AN: A 'n';
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

CONJUNCTION : LetterA 'nd'
            | O 'r'
            | LetterA 'nd' SLASH 'or'
            | T 'hen';

// Object verbs
ATTACK : LetterA 'ttack';
BECOME : B 'ecome';
BLOCK : B 'lock';
DIE : D 'ie';
ENTER : E 'nter';

// Player verbs
ADD : LetterA 'dd';
ANTE : LetterA 'nte';
CAST : C 'ast';
CHANGE : C 'hange';
CHOOSE : C 'hoose';
CONTROL : C 'ontrol';
DESTROY : D 'estroy';
DISCARD : D 'iscard';
DIVIDE : D 'ivide';
DRAW : D 'raw';
EXCHANGE : E 'xchange';
IGNORE : I 'gnore';
OWN : O 'wn';
PUT : P 'ut';
PREVENT : P 'revent';
REGENERATE : R 'egenerate';

// Keywords
ENCHANT : E 'nchant';
BANDING : B 'anding';
FLYING : F 'lying';
VIGILANCE : V 'igilance';
DEFENDER : D 'efender';
INDESTRUCTIBLE : I 'ndesctructible';
FEAR : F 'ear';
HASTE : H 'aste';
TRAMPLE : T 'rample';
REACH : R 'each';

// Creature types
CREATURE_TYPE : G 'oblin'
              | G 'olem'
              | M 'erfolk'
              | W 'all'
              | Z 'ombie';

ENCHANTMENT_TYPE : LetterA 'ura';

// Land types
LAND_TYPE : P 'lains'
          | I 'sland'
          | S 'wamp'
          | M 'ountain'
          | F 'orest';

// Literal symbols
fragment APOSTROPHE : '’';
fragment BULLET : '•';
fragment CLOSEQUOTE : '”';
fragment COMMA : ',';
fragment COLON : ':';
fragment DASH : '-' | '—';
fragment LBRACKET : '{';
fragment NEWLINE : '\n';
fragment OPENQUOTE : '“';
fragment PERIOD : '.';
fragment PLUS : '+';
fragment RBRACKET : '}';
fragment SEMICOLON : ';';
fragment SLASH : '/';
fragment SPACE : ' ';
fragment TILDE : '~';

// Numbers
NUMBER : [0-9]+
       | X;

// Colors
COLOR : W 'hite'
      | B 'lue'
      | B 'lack'
      | G 'reen'
      | R 'ed';

MANA_COLOR : W
           | U
           | B
           | R
           | G
           | C;

// Case insensitive alphabet
fragment LetterA : [Aa];
fragment B : [Bb];
fragment C : [Cc];
fragment D : [Dd];
fragment E : [Ee];
fragment F : [Ff];
fragment G : [Gg];
fragment H : [Hh];
fragment I : [Ii];
fragment J : [Jj];
fragment K : [Kk];
fragment L : [Ll];
fragment M : [Mm];
fragment N : [Nn];
fragment O : [Oo];
fragment P : [Pp];
fragment Q : [Qq];
fragment R : [Rr];
fragment S : [Ss];
fragment T : [Tt];
fragment U : [Uu];
fragment V : [Vv];
fragment W : [Ww];
fragment X : [Xx];
fragment Y : [Yy];
fragment Z : [Zz];

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
adjectiveAdditional : 'additional';
verbBe : 'be';
verbLikewise : 'likewise';
verbMay : 'may';
adjectiveEqual : 'equal';
nounPile : 'pile';
nounPiles : 'piles';
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
