lexer grammar alpha_lexer;

// Player verbs
ADD : A 'dd';
ANTE : A 'nte';
CAST : C 'ast';
CHANGE : C 'hange';
CONTROL : C 'ontrol';
DESTROY : D 'estroy';
DISCARD : D 'iscard';
DRAW : D 'raw';
EXCHANGE : E 'xchange';
OWN : O 'wn';
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
COMMA : ',';
COLON : ':';
DASH : '-' | '—';
LBRACKET : '{';
NEWLINE : '\n';
OPENQUOTE : '“';
CLOSEQUOTE : '”';
PERIOD : '.';
PLUS : '+';
RBRACKET : '}';
SEMICOLON : ';';
SLASH : '/';
SPACE : ' ';
TILDE : '~';

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

