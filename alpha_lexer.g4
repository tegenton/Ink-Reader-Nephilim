lexer grammar alpha_lexer;

// Player verbs
ADD : A 'dd';
ANTE : A 'nte';
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
GOBLIN : G 'oblin';
GOLEM : G 'olem';
MERFOLK : M 'erfolk';
WALL : W 'all';
ZOMBIE : Z 'ombie';

// Literal symbols
APOSTROPHE : '’';
BULLET : '•';
CLOSEQUOTE : '”';
COMMA : ',';
COLON : ':';
DASH : '-' | '—';
LBRACKET : '{';
NEWLINE : '\n';
OPENQUOTE : '“';
PERIOD : '.';
PLUS : '+';
RBRACKET : '}';
SEMICOLON : ';';
SLASH : '/';
SPACE : ' ';
TILDE : '~';

// Numbers
NUMBER : ('0'..'9')+
       | 'X';

MANA_COLOR : 'W'
           | 'U'
           | 'B'
           | 'R'
           | 'G'
           | 'C';

// Case insensitive alphabet
fragment A : [Aa];
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
