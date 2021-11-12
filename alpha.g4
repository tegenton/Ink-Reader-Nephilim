// Grammar for Alpha

grammar alpha;
// Permanents
permanentCard : ability (newline ability)* |; // or nothing

ability : keywords
        | staticAbility
        | activatedAbility
        | triggeredAbility;

keywords : keyword ((semicolon|comma) space keyword)*;

activatedAbility : costs colon space effect period (restriction period)?;

staticAbility : staticAbility space staticAbility
              | subordinateClause comma space staticAbility
              | replacementEffect period
              //| continuous (period)?
              | abilityType space prepositionOf space object space verbCost space costs space comparator space prepositionTo space verbActivate period
              | damage space verbIs space verbDealt space prepositionTo space object adverbInstead period
              | prepositionFor space rawDeterminer damage space distinguisher  comma space triggerEffect period;

triggeredAbility : triggerCondition comma space triggerEffect period;

// Spells

spellCard : spellAbility (newline spellAbility)*;

modal : verbChoose space amount dash (newline bullet space effect period)+;

spellAbility : effect period
             | restriction period
             | modal
             | delayedTrigger comma space effect period space verbIgnore space demonstrative space nounEffect space prepositionFor space object period
             | duration comma space adverbInstead space prepositionOf space verbDeclaring space nounBlockers comma space rawDeterminer space player space verbChooses space object space conjunction space verbDivides space pronounThem space preposition space article space nounNumber space prepositionOf space nounPiles space adjectiveEqual space prepositionTo space amount period space object space verbMay space verbLikewise space verbBe space verbPut preposition space adjectiveAdditional space nounPiles period space verbAssign space rawDeterminer space nounPile prepositionTo space article space adjectiveDifferent space number prepositionOf space object space prepositionAt space adjectiveRandom period space space objectPhrase period;

// Symbols
apostrophe : '’';
bullet : '•';
comma : ',';
colon : ':';
dash : '-' | '—';
lBracket : '{';
newline : '\n';
period : '.';
plus : '+';
rBracket : '}';
semicolon : ';';
slash : '/';
space : ' ';
tilde : '~';

// Effects

replacementEffect : subordinateClause comma space (space adverbInstead)? effect (space adverbInstead)?
                  | subordinateClause comma space playerPhrase space adverbInstead period space subordinateClause comma space effect
                  | subordinateClause comma space playerVerbPhrase comma space prepositionBut space player space verbMay space verbPut space object preposition space nounTop space prepositionOf space zone space adverbInstead space prepositionOf space preposition space zone
                  | objectPhrase space prepositionalPhrase;

triggerEffect : effect (space subordinateClause)?;

effect //: //effect (period)? space conjunction space effect
       //| effect period space effect
       //| effect space duration
       //| (effect comma space)? effect comma space conjunction space effect
       : duration comma space rawDeterminer space nounTime space player space verbCould space verbActivate space article space abilityType comma space player space verbMay space costs period space subordinateClause comma space effect
       | duration comma space player space verbMay space costs space rawDeterminer space nounTime space player space verbCould space verbCast space article space 'instant' period space subordinateClause comma space effect
       | 'The next time' space source space 'would deal' space damageType space 'to' space something space 'this turn' comma space effect
       | 'Prevent' space damage
       | 'that source deals' space damage space 'to' space player space adverbInstead
       | 'The next ' damage ' that would be dealt to ' object ' this turn is dealt to its owner' adverbInstead
       | player ' loses half their life, rounded up'
       | verbChoose space object
       | object ' attacks this turn if able'
       | 'If Chaos Orb is on the battlefield, flip Chaos Orb onto the battlefield from a height of at least one foot. If Chaos Orb turns over completely at least once during the flip, destroy all nontoken permanents it touches'
       | delayedTrigger comma space 'remove all ' counter ' counters from a land that a ' counter ' counter was put onto with ' object ' but that a ' counter ' counter has not been removed from with ' object
       | delayedTrigger comma space 'destroy that creature if it attacked this turn'
       | player space verbChooses space 'a number of lands they control equal to ' amount ', then sacrifices the rest. Players discard cards and sacrifice creatures the same way'
       | duration comma space player ' can’t be attacked except by ' object
       | player space 'may pay any amount of mana. ' object ' deals 2 damage to that player. Prevent X of that damage, where X is the amount of mana that player paid this way'
       | player space verbMay space verbChoose space 'a creature card in your hand whose mana cost could be paid by some amount of, or all of, the mana you spent on {X}. If you do, you may cast that card face down as a 2/2 creature spell without paying its mana cost. If the creature that spell becomes as it resolves has not been turned face up and would assign or deal damage, be dealt damage, or become tapped, instead it’s turned face up and assigns or deals damage, is dealt damage, or becomes tapped. Activate only as a sorcery.'
       | player ' divides all creatures without flying they control into a “left” pile and a “right” pile. Then, for each attacking creature you control, ' verbChoose ' “left” or “right.” That creature can’t be blocked this combat except by creatures with flying and creatures in a pile with the chosen label'
       | 'it loses “enchant creature card in a graveyard” and gains “enchant creature put onto the battlefield with ~.” Return enchanted creature card to the battlefield under your control and attach ~ to it. When ~ leaves the battlefield, that creature’s controller sacrifices it'
       | 'remove' space object space 'from combat'
       | player ' may have ' object ' block ' object ' of your choice'
       | player ' activates a mana ability of ' object
       | player ' loses all unspent mana and ' player ' add the mana lost this way'
       | 'Look at ' zone ' and ' verbChoose ' a card from it'
       | player ' control ' player ' until ' object ' finishes resolving'
       | 'The player plays that card if able. While doing so, the player can activate mana abilities only if they’re from lands that player controls and only if mana they produce is spent to activate other mana abilities of lands the player controls and/or to play that card. If the chosen card is cast as a spell, you control the player while that spell is resolving'
       | 'put' space amount space counter ' counter on ' object (' for each creature that died this turn')?
       | 'put' space amount space counter ' counter on ' object '. That land is a Swamp for as long as it has a ' counter ' counter on it'
       | 'put' space amount space counter ' counters on ' object '. This ability can’t cause the total number of ' counter ' counters on ' object ' to be greater than ' amount
       | objectPossesive space characteristics space verbIs ' each equal to ' amount
       | phrase
       | playerVerbPhrase (' and sacrifice ' object ' of an opponent’s choice')? (' and ' player ' loses all unspent mana')? (period space player ' may attach ' object ' to ' object ' of their choice')?
       | object 'can’t be regenerated';

damage : 'damage'
       | number space 'damage'
       | 'all combat damage that would be dealt' space duration
       | 'all damage that would be dealt to ' player ' by ' object
       | 'all but 1 of that damage'
       | 'that' space damage
       | article space 'next' space damage space 'that would be dealt to' space something space duration;

// Definitions

adjective : 'enchanted'
          | 'tapped'
          | 'unblocked'
          | 'blocking'
          | 'attacking'
          | 'sacrificed'
          | 'token'
          | 'additional';

amount : 'half ' amount comma ' rounded ' ('up'|'down')
       | 'up to ' amount
       | comparator ' than ' englishNumber
       | englishNumber (space conjunction space comparator)?
       //| object saxon space characteristics
       | 'X'
       | article space 'number of ' object (' minus ' number)?
       | article space 'damage dealt to ' player ' this turn'
       | playerPossessive ' life total'
       | 'that many'
       | 'any number of'
       | 'the number of attacking creatures for whom that player is the defending player';

characteristic : 'power'
               | 'toughness'
               | 'mana value';

characteristics : characteristic (conjunction characteristic)?;

condition : object (space)? verbIs space ('un')? 'tapped'
          | object (space)? verbIs space prepositionalPhrase (space prepositionalPhrase)?
          | object (space)? verbIs space object
          | object (space)? verbIs space 'attacking'
          | object ' has a ' counter ' counter on it'
          | object ' has ' keyword
          | object ' wasn’t the first land you played this turn'
          | object ' attacked or blocked this combat';

costs : ('pay' space)? cost (comma space costs)?;

cost :(mana)+
     | lBracket tap rBracket
     | number space 'life'
     | playerVerbPhrase;

counter : statMod
        | counterType;

determiner : rawDeterminer
           | article
           | demonstrative
           | amount;

distinguisher : 'that would be' space verbDealt space prepositionTo space object;

duration : 'until end of turn'
         | 'until ' object ' leaves ' zone
         | 'until end of combat'
         | 'until your next turn'
         | 'this turn'
         | 'each combat';

keyword : 'enchant' object
        | 'banding'
        | 'first' space 'strike'
        | 'flying'
        | 'vigilance'
        | 'defender'
        | 'protection from' space color
        | landType 'walk'
        | 'indestructible'
        | 'fear'
        | 'haste'
        | 'trample'
        | 'reach';

mana : (lBracket (manaLetter | number) rBracket)+;

object : premodifier space object
       //| object space postmodifier
       //| object plural
       //| (object comma space)* object space conjunction object
       | tilde
       | type
       | 'card'
       | 'spell'
       | 'permanent'
       | 'it'
       | 'top card of ' zone;

objectPossesive : object saxon;

objectPhrase : object space objectVerbPhrase;

objectVerbPhrase : verbIs space 'dealt damage'
                 | verbIs space 'tapped for mana'
                 | verbIs space 'put into ' zone ' from ' zone
                 | verbIs space object
                 | 'blocks or becomes blocked by ' object
                 | 'deals damage to ' player
                 | objectVerb space zone 'tapped'
                 | objectVerb space color
                 | objectVerb space zone
                 | objectVerb space object (' if able')?
                 | 'do' ('es')? 'n’t untap during ' phase
                 | 'do' ('es')? 'so'
                 | verbCost space costs space comparator space 'to cast'
             	 | 'gains' space keyword space duration
             	 | 'gains' keyword
             	 | 'gains trample and gets ' statMod space duration ', where X is ' amount
             	 | 'get' ('s')? ' ' statMod (' as long as you control a Swamp')?
             	 | 'gets ' statMod space duration '. If this ability has been activated four or ' comparator ' times this turn, sacrifice ' object ' at the beginning of the next end step'
             	 | 'get' ('s')? space statMod ' and ha' ('s'|'ve') space ability
             	 | 'ha' ('s'|'ve') space quotedAbility
             	 | 'ha' ('s '|'ve ') ability (' and can’t be enchanted by ' object)? (period space 'this effect doesn’t remove ' object)?
             	 | 'can attack as though ' object ' didn’t have defender'
             	 | 'can attack as though ' object ' had haste'
             	 | 'can’t attack' (' ' subordinateClause)?
             	 | 'can block ' object
             	 | 'can’t be blocked'
             	 | 'can’t be blocked ' ('except ')? 'by ' object
             	 | 'can’t block ' object
             	 | 'become unblocked'
             	 | 'deals ' damage ' to ' something
                 | 'deals ' damage ' to ' something ' and ' damage ' to ' something
                 | 'deals ' damage ' to ' something ' and ' object ' gains "Enchanted creature loses flying"'
                 | 'deals ' damage ' to ' something comma space 'where X is ' amount
                 | 'deals ' damage ' to ' something period space player ' gain life equal to the damage dealt, but not ' comparator ' life than the player’s life total before the damage was dealt, the planeswalker’s loyalty before the damage was dealt, or the creature’s toughness'
                 | 'deals ' damage ' to ' something '. If ' condition ', it can’t be regenerated this turn, and if it would die this turn, exile it' space adverbInstead
                 | 'deals ' damage ' divided evenly, rounded down, among any number of targets'
                 | 'deals damage to ' something ' equal to ' amount
                 | 'deals damage equal to ' amount ' to ' something;

objectVerb : rawObjectVerb (plural)?;

postmodifier : player ' control' (plural)?
             | player ' controlled at the beginning of this turn'
             | player ' has controlled continuously since the beginning of the turn'
             | player ' didn’t control continuously since the beginning of the turn'
             | 'controlled by ' player
             | prepositionalPhrase
             | 'named Plague Rats' space prepositionalPhrase
             | 'able to block ' object
             | 'that can block' object
             | 'that ' verbIs ' still ' object
             | 'other than ' object
             | 'that didn’t attack this turn'
             | 'that can block additional creatures'
             | object ' was blocking that had become blocked by ' object ' this combat'
             | 'put ' prepositionalPhrase ' this way'
             | 'dealt damage by ' object ' this turn'
             | 'of your choice'
             | 'with' space keyword space conjunction space keyword
             | 'in a pile'
             | 'that pile is assigned to';

premodifier : (negation (space|dash))? adjective
            | (negation (space|dash))? color
            | determiner
            | type
            | number slash number;

prepositionalPhrase : prepositionalPhrase space prepositionalPhrase
                    | preposition space zone
                    | preposition space object
                    | preposition space quality
                    | preposition space amount space counter ' counters on ' object;

phase : playerPossessive space 'turn'
      | playerPossessive space rawPhase (plural)?
      | article space rawPhase ' of ' object saxon ' controller'
      | article space rawPhase
      | article space 'opponent’s turn' comma ' before attackers are declared'
      | article space 'next' space rawPhase
      | 'combat'
      | 'combat before blockers are declared'
      | 'the turn'
      | 'each of your upkeeps for the rest of the game'
      | 'the next end step';

phrase : playerPhrase
       | objectPhrase;

player : determiner space player
       //| player plural
       | object saxon space 'controller'
       | object saxon space 'owner'
       | 'player'
       | 'you'
       | 'opponent'
       | 'active player'
       | 'defending player'
       | 'they'
       | 'the player who controls the fewest';

playerPhrase : player space playerVerbPhrase;

playerPossessive : 'your'
                 | 'their'
                 //| player saxon
                 | 'their controller' plural saxon
                 | 'its controller' saxon
                 | 'the chosen player' saxon;

playerVerbPhrase : verbMay playerVerbPhrase
                 | playerVerb
                 | playerVerb space mana
                 | playerVerb space object (space prepositionAt space adjectiveRandom)?
                 | playerVerb space player
                 | playerVerb space object space 'for mana'
                 | playerVerb space article space 'amount of ' mana ' equal to ' amount
                 | playerVerb space amount space 'mana of any ' ('one' space)? 'color'
                 | playerVerb space amount space 'mana of any type that land produced'
                 | playerVerb space article space 'additional ' mana
                 | playerVerb space article space 'text of ' object ' by replacing all instances of one ' textAspect ' with another'
                 | playerVerb space article space textAspect
                 | playerVerb space zone
                 | '’re dealt damage'
                 | 'copy' space object comma space 'except' period space player space 'may ' verbChoose ' new targets for the copy'
                 | 'counter' space object (' unless its controller pays {X}. If that player doesn’t, they tap all lands with mana abilities they control and lose all unspent mana')
                 | 'create a 1/1 colorless Insect artifact creature token with flying named Wasp'
                 | 'destroy ' object period space object ' deals damage to each creature and each player equal to ' amount
                 | 'destroy ' object space delayedTrigger
                 | 'destroy ' object space delayedTrigger space 'if it didn’t attack this turn'
                 | 'exchange ' object ' with ' object
                 | 'exile ' object period space player ' gains life equal to ' amount
                 | 'gain' (plural)? space number ' life'
                 | 'gain life equal to the damage prevented this way'
                 | 'gain life equal to ' amount period space object ' deals damage to ' something ' equal to ' amount '.'
                 | 'Look at the top ' amount ' cards of ' zone ', then put them back in any order. ' player ' may have ' player ' shuffle'
                 | 'Look' space 'at' space zone
                 | 'lose the game'
                 | 'lose life equal to ' amount
                 | 'put' space object space prepositionalPhrase
                 | 'remove' space article space counter ' counter from ' object
                 | 'return' space object (' from ' zone)? ' to ' zone period
                 | 'sacrifice ' object (subordinateClause)?
                 | 'sacrifice ' object period space subordinateClause comma space effect
                 | 'search ' zone space prepositionalPhrase
                 | 'shuffle'
                 | 'skip' space phase
                 | 'skip' space demonstrative space ('turn'|'draw')
                 | 'take an extra turn after this one'
                 | 'have ' object ' enter ' zone ' as a copy of any ' object ' on ' zone (space prepositionalPhrase)?
                 | 'spend ' color ' mana as though it were ' color ' mana'
                 | 'play any number of lands on each of your turns'
                 | 'don’t lose the game for having 0 or less life'
                 | 'can’t untap ' comparator ' than one ' object ' during ' phase
                 | 'have no maximum hand size'
                 | 'antes ' object
                 | 'may ' costs period space subordinateClause comma space effect
                 | 'may ' effect
                 | 'may tap or untap ' object
                 | 'shuffles their hand and graveyard into ' zone;

delayedTrigger : 'at end of combat'
               | 'at the beginning of ' phase;

playerVerb : rawPlayerVerb (plural)?;

quality : 'mana value' space number
        | 'power' space amount
        | 'toughness' space amount
        | 'power and toughness each equal to ' amount
        | keyword;

quotedAbility : openQuote ability closeQuote;

rawPhase : turnPart
         | (turnPart space)? turnPart space rawWordStep;

restriction : verbCast space object ' only during ' phase
            | verbCast object ' only before ' phase
            | 'Spend only ' color ' mana on X'
            | 'As an additional cost to ' verbCast ' this spell, ' costs
            | 'This spell costs ' costs space  comparator space 'to' space verbCast ' for each target beyond the first'
            | 'Activate only during ' phase ('and only once each turn')?
            | 'Activate only during an opponent’s turn, before attackers are declared'
            | 'Remove ' object ' from your deck before playing if you’re not playing for ante'
            | 'Only ' player ' may activate this ability';

something : determiner space something
          | object
          | player
          | something space conjunction space something;

source : premodifier space source
       | source space postmodifier
       | object
       | space color space 'source'
       | 'source';

statMod : plusMinus number slash plusMinus number (' where X is ' amount (', and Y is ' amount)?)?;

subordinateClause : subordinateConjunction space 'long' space subordinateClause
                  | subordinateConjunction space condition
                  | subordinateConjunction space phrase
                  | subordinateConjunction space player ' would draw ' object ' during ' phase
                  | subordinateConjunction space player ' would gain life'
                  | subordinateConjunction space player ' would begin your turn while ' object ' is tapped'
                  | subordinateConjunction space 'an effect causes you to discard a card'
                  | subordinateConjunction space 'it’s ' object ' in addition to its other types'
                  | subordinateConjunction space 'it doesn’t copy that creature’s color and it has “At the beginning of your upkeep, you may have this creature become a copy of target creature, except it doesn’t copy that creature’s color and it has this ability.”'
                  | subordinateConjunction space 'that the copy is ' color;

textAspect : 'color word'
           | 'basic land type';

triggerCondition : triggerWord space triggerEvent (comma space subordinateClause)?;

triggerEvent : 'the beginning of' space phase
             | 'end of combat'
             | phrase;

type : negation (dash)? type
     | cardType
     | landType
     | creatureType
     | enchantmentType
     | 'chosen type';

verbIs : rawVerbIs (negation)?;

zone : playerPossessive space rawZone
     | article space rawZone;

// Morphemes

article : 'the'
        | 'a'
        | 'an';

cardType : 'creature'
         | 'land'
         | 'artifact'
         | 'enchantment';

color : 'white'
      | 'blue'
      | 'black'
      | 'green'
      | 'red';

comparator : 'less'
           | 'greater'
           | 'more';

conjunction : 'and'
            | 'or'
            | 'and' slash 'or'
            | 'then';

counterType : 'corpse'
            | 'vitality'
            | 'mire';

creatureType : 'Goblin'
             | 'Golem'
             | 'Merfolk'
             | 'Wall'
             | 'Zombie';

demonstrative : 'this'
              | 'these'
              | 'those'
              | 'that';

englishNumber : 'one'
              | 'two'
              | 'three'
              | 'seven';

enchantmentType : 'aura';

landType : 'plains'
         | 'island'
         | 'swamp'
         | 'mountain'
         | 'forest';

preposition : 'with' ('out')?
            | 'in' ('to')?
            | 'on' ('to')?
            | 'above';

plusMinus : plus
          | dash;

rawDeterminer : 'all'
              | 'each'
              | 'any'
              | 'other'
              | 'target'
              | 'no'
              | 'only';

rawObjectVerb : 'attack'
              | 'become'
              | 'block'
              | 'die'
              | 'enter';

rawPlayerVerb : 'add'
              | 'ante'
              | 'can’t'
              | 'cast'
              | 'change'
              | 'control'
	          | 'destroy'
	          | 'discard'
	          | 'destroy'
	          | 'do'
	          | 'draw'
	          | 'own'
	          | 'play'
	          | 'regenerate'
	          | ('un')? 'tap';

rawZone : 'graveyard'
        | 'battlefield'
        | 'hand'
        | 'library'
        | 'ante';

subordinateConjunction : 'as'
                       | 'if'
                       | 'unless'
                       | 'except';

turnPart : 'untap'
         | 'upkeep'
         | 'draw'
         | 'declare'
         | 'attackers'
         | 'blockers'
         | 'combat'
         | 'damage'
         | 'end';

triggerWord : 'at'
            | 'when'
            | 'whenever';

// individual words

rawVerbIs : 'is'
          | 'are'
          | apostrophe letterS;

rawWordStep : 'step';



// Lexemes

letterS : 's';

manaLetter : 'W'
           | 'U'
           | 'B'
           | 'R'
           | 'G'
           | 'C';

negation : 'non'
         | 'un'
         | 'n’t';

number : '0'
       | '1'
       | '2'
       | '3'
       | '4'
       | '5'
       | '6'
       | '7'
       | 'X';

plural : letterS;

openQuote : '“';
closeQuote : '”';

saxon : (apostrophe (letterS)?|letterS);

tap : 't';


// To Sort

abilityType : 'activated abilities'
            | 'mana ability';
verbChoose : 'choose';
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
verbPut : 'put';
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
verbIgnore : 'ignore';
verbDeclaring : 'declaring';
nounEffect : 'effect';
nounTop : 'top';
prepositionBut : 'but';
nounTime : 'time';
verbCould : 'could';
damageType : 'combat damage'
           | 'damage';