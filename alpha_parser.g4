// Grammar for Alpha

parser grammar alpha_parser;

options {
    tokenVocab = alpha_lexer;
}

card : permanentCard | spellCard;

// Permanents
permanentCard : ability (NEWLINE ability)* |; // or nothing

ability : keywords
        | staticAbility
        | activatedAbility
        | triggeredAbility;

keywords : keyword ((SEMICOLON|COMMA) SPACE keyword)*;

activatedAbility : costs COLON SPACE effect PERIOD (restriction PERIOD)?;

staticAbility : staticAbility SPACE staticAbility
              | subordinateClause COMMA SPACE staticAbility
              | continuousEffect (PERIOD)?
              | replacementEffect PERIOD
              | abilityType SPACE prepositionOf SPACE object SPACE verbCost SPACE costs SPACE comparator SPACE prepositionTo SPACE verbActivate PERIOD
              | damage SPACE verbIs SPACE verbDealt SPACE prepositionTo SPACE object adverbInstead PERIOD
              | prepositionFor SPACE rawDeterminer damage SPACE distinguisher  COMMA SPACE triggerEffect PERIOD;

triggeredAbility : triggerCondition COMMA SPACE triggerEffect PERIOD;

// Spells

spellCard : spellAbility (NEWLINE spellAbility)*;

modal : verbChoose SPACE amount DASH (NEWLINE BULLET SPACE effect PERIOD)+;

spellAbility : effect PERIOD
             | restriction PERIOD
             | modal
             | delayedTrigger COMMA SPACE effect PERIOD SPACE verbIgnore SPACE demonstrative SPACE nounEffect SPACE prepositionFor SPACE object PERIOD
             | duration COMMA SPACE adverbInstead SPACE prepositionOf SPACE verbDeclaring SPACE nounBlockers COMMA SPACE rawDeterminer SPACE player SPACE verbChooses SPACE object SPACE conjunction SPACE verbDivides SPACE pronounThem SPACE preposition SPACE article SPACE nounNumber SPACE prepositionOf SPACE nounPiles SPACE adjectiveEqual SPACE prepositionTo SPACE amount PERIOD SPACE object SPACE verbMay SPACE verbLikewise SPACE verbBe SPACE verbPut preposition SPACE adjectiveAdditional SPACE nounPiles PERIOD SPACE verbAssign SPACE rawDeterminer SPACE nounPile prepositionTo SPACE article SPACE adjectiveDifferent SPACE number prepositionOf SPACE object SPACE prepositionAt SPACE adjectiveRandom PERIOD SPACE SPACE objectPhrase PERIOD;

// Effects

anyTime : rawDeterminer SPACE nounTime SPACE player SPACE verbCould SPACE verbActivate SPACE article SPACE abilityType
        | rawDeterminer SPACE nounTime SPACE player SPACE verbCould SPACE verbCast SPACE article SPACE cardType;

continuousEffect : anyTime COMMA SPACE player SPACE verbMay SPACE costs PERIOD SPACE subordinateClause COMMA SPACE effect
                 | player SPACE verbMay SPACE costs SPACE anyTime PERIOD SPACE subordinateClause COMMA SPACE effect;

replacementEffect : subordinateClause COMMA SPACE (SPACE adverbInstead)? effect (SPACE adverbInstead)?
                  | subordinateClause COMMA SPACE playerPhrase SPACE adverbInstead PERIOD SPACE subordinateClause COMMA SPACE effect
                  | subordinateClause COMMA SPACE playerVerbPhrase COMMA SPACE prepositionBut SPACE player SPACE verbMay SPACE verbPut SPACE object preposition SPACE nounTop SPACE prepositionOf SPACE zone SPACE adverbInstead SPACE prepositionOf SPACE preposition SPACE zone
                  | objectPhrase SPACE prepositionalPhrase;

triggerEffect : effect (SPACE subordinateClause)?;

effect : rawEffect
       | rawEffect (PERIOD)? SPACE conjunction SPACE effect
       | rawEffect PERIOD SPACE effect
       | continuousEffect SPACE duration
       | duration COMMA SPACE continuousEffect
       | (rawEffect COMMA SPACE)? rawEffect COMMA SPACE conjunction SPACE rawEffect;

rawEffect :
       | PREVENT SPACE damage
       | source SPACE 'deals' SPACE damage SPACE 'to' SPACE player SPACE adverbInstead
       | 'The next time' SPACE source SPACE 'would deal' SPACE damageType SPACE 'to' SPACE something SPACE 'this turn' COMMA SPACE effect
       | 'The next ' damage ' that would be dealt to ' object ' this turn is dealt to its owner' adverbInstead
       | player ' loses half their life, rounded up'
       | object ' attacks this turn if able'
       | 'If Chaos Orb is on the battlefield, flip Chaos Orb onto the battlefield from a height of at least one foot. If Chaos Orb turns over completely at least once during the flip, destroy all nontoken permanents it touches'
       | delayedTrigger COMMA SPACE 'remove all ' counter ' counters from a land that a ' counter ' counter was put onto with ' object ' but that a ' counter ' counter has not been removed from with ' object
       | delayedTrigger COMMA SPACE 'destroy that creature if it attacked this turn'
       | player SPACE verbChooses SPACE 'a number of lands they control equal to ' amount ', then sacrifices the rest. Players discard cards and sacrifice creatures the same way'
       | duration COMMA SPACE player ' can’t be attacked except by ' object
       | player SPACE 'may pay any amount of mana. ' object ' deals 2 damage to that player. Prevent X of that damage, where ' variableDefinition
       | player SPACE verbMay SPACE verbChoose SPACE 'a creature card in your hand whose mana cost could be paid by some amount of, or all of, the mana you spent on {X}. If you do, you may cast that card face down as a 2/2 creature spell without paying its mana cost. If the creature that spell becomes as it resolves has not been turned face up and would assign or deal damage, be dealt damage, or become tapped, instead it’s turned face up and assigns or deals damage, is dealt damage, or becomes tapped. Activate only as a sorcery.'
       | player ' divides all creatures without flying they control into a “left” pile and a “right” pile. Then, for each attacking creature you control, ' verbChoose ' “left” or “right.” That creature can’t be blocked this combat except by creatures with flying and creatures in a pile with the chosen label'
       | 'it loses “enchant creature card in a graveyard” and gains “enchant creature put onto the battlefield with ~.” Return enchanted creature card to the battlefield under your control and attach ~ to it. When ~ leaves the battlefield, that creature’s controller sacrifices it'
       | 'remove' SPACE object SPACE 'from combat'
       | player ' may have ' object ' block ' object ' of your choice'
       | player ' activates a mana ability of ' object
       | player ' loses all unspent mana and ' player ' add the mana lost this way'
       | 'Look at ' zone
       | player ' control ' player ' until ' object ' finishes resolving'
       | 'The player plays that card if able. While doing so, the player can activate mana abilities only if they’re from lands that player controls and only if mana they produce is spent to activate other mana abilities of lands the player controls and/or to play that card. If the chosen card is cast as a spell, you control the player while that spell is resolving'
       | objectPossesive SPACE characteristics SPACE verbIs ' each equal to ' amount
       | phrase
       | playerVerbPhrase (' and sacrifice ' object ' of an opponent’s choice')? (' and ' player ' loses all unspent mana')? (PERIOD SPACE player ' may attach ' object ' to ' object ' of their choice')?
       | object 'can’t be regenerated'
       | player SPACE 'may ' verbChoose ' new targets for' object
       | 'That land is a Swamp for as long as it has a ' counter ' counter on it'
       | 'This ability can’t cause the total number of ' counter ' counters on ' object ' to be greater than ' amount;

damage : 'damage'
       | number SPACE 'damage'
       | 'all combat damage that would be dealt' SPACE duration
       | 'all damage that would be dealt to ' player ' by ' object
       | 'all but 1 of that damage'
       | 'that' SPACE damage
       | article SPACE 'next' SPACE damage SPACE 'that would be dealt to' SPACE something SPACE duration;

// Definitions

adjective : 'enchanted'
          | 'tapped'
          | 'unblocked'
          | 'blocking'
          | 'attacking'
          | 'sacrificed'
          | 'token'
          | 'additional';

amount : 'half ' amount COMMA ' rounded ' ('up'|'down')
       | 'up to ' amount
       | comparator ' than ' englishNumber
       | englishNumber (SPACE conjunction SPACE comparator)?
       | rawObject saxon SPACE characteristics
       | VARIABLE
       | article SPACE 'number of ' object (' minus ' number)?
       | article SPACE 'damage dealt to ' player ' this turn'
       | playerPossessive ' life total'
       | 'that many'
       | 'any number of'
       | 'the number of attacking creatures for whom that player is the defending player'
       | 'the amount of mana that player paid this way';

characteristic : 'power'
               | 'toughness'
               | 'mana value';

characteristics : characteristic (conjunction characteristic)?;

condition : object (SPACE)? verbIs SPACE ('un')? 'tapped'
          | object (SPACE)? verbIs SPACE prepositionalPhrase (SPACE prepositionalPhrase)?
          | object (SPACE)? verbIs SPACE object
          | object (SPACE)? verbIs SPACE 'attacking'
          | object ' has a ' counter ' counter on it'
          | object ' has ' keyword
          | object ' wasn’t the first land you played this turn'
          | object ' attacked or blocked this combat';

costs : ('pay' SPACE)? cost (COMMA SPACE costs)?;

cost :(mana)+
     | LBRACKET tap RBRACKET
     | NUMBER SPACE 'life'
     | playerVerbPhrase;

counter : statMod
        | counterType;

determiner : rawDeterminer
           | article
           | demonstrative
           | amount;

distinguisher : 'that would be' SPACE verbDealt SPACE prepositionTo SPACE object;

duration : 'until end of turn'
         | 'until ' object ' leaves ' zone
         | 'until end of combat'
         | 'until your next turn'
         | 'this turn'
         | 'each combat';

keyword : ENCHANT SPACE object
        | BANDING
        | 'first' SPACE 'strike'
        | FLYING
        | VIGILANCE
        | DEFENDER
        | 'protection from' SPACE color
        | landType 'walk'
        | INDESTRUCTIBLE
        | FEAR
        | HASTE
        | TRAMPLE
        | REACH;

mana : (LBRACKET (manaLetter | number) RBRACKET)+;

object : rawObject
       | (premodifier SPACE)+ object
       | rawObject (SPACE postmodifier)+
       | rawObject plural
       | (rawObject COMMA SPACE)* rawObject SPACE conjunction rawObject;

rawObject : TILDE
          | type
          | 'copy'
          | 'card'
          | 'spell'
          | 'permanent'
          | 'it'
          | 'top card of ' zone;

objectPossesive : object saxon;

objectPhrase : object SPACE objectVerbPhrase;

objectVerbPhrase : verbIs SPACE 'dealt damage'
                 | verbIs SPACE 'tapped for mana'
                 | verbIs SPACE 'put into ' zone ' from ' zone
                 | verbIs SPACE object
                 | 'blocks or becomes blocked by ' object
                 | 'deals damage to ' player
                 | objectVerb SPACE zone 'tapped'
                 | objectVerb SPACE color
                 | objectVerb SPACE zone
                 | objectVerb SPACE object (' if able')?
                 | 'do' ('es')? 'n’t untap during ' phase
                 | 'do' ('es')? 'so'
                 | verbCost SPACE costs SPACE comparator SPACE 'to cast'
             	 | 'gains' SPACE keyword SPACE duration
             	 | 'gains' keyword
             	 | 'gains trample and gets ' statMod SPACE duration ', where X is ' amount
             	 | 'get' ('s')? ' ' statMod (' as long as you control a Swamp')?
             	 | 'gets ' statMod SPACE duration '. If this ability has been activated four or ' comparator ' times this turn, sacrifice ' object ' at the beginning of the next end step'
             	 | 'get' ('s')? SPACE statMod ' and ha' ('s'|'ve') SPACE ability
             	 | 'ha' ('s'|'ve') SPACE quotedAbility
             	 | 'ha' ('s '|'ve ') ability (' and can’t be enchanted by ' object)? (PERIOD SPACE 'this effect doesn’t remove ' object)?
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
                 | 'deals ' damage ' to ' something COMMA SPACE 'where X is ' amount
                 | 'deals ' damage ' to ' something PERIOD SPACE player ' gain life equal to the damage dealt, but not ' comparator ' life than the player’s life total before the damage was dealt, the planeswalker’s loyalty before the damage was dealt, or the creature’s toughness'
                 | 'deals ' damage ' to ' something '. If ' condition ', it can’t be regenerated this turn, and if it would die this turn, exile it' SPACE adverbInstead
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
             | 'named Plague Rats' SPACE prepositionalPhrase
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
             | 'with' SPACE keyword SPACE conjunction SPACE keyword
             | 'in a pile'
             | 'that pile is assigned to';

premodifier : (negation (SPACE|DASH))? adjective
            | (negation (SPACE|DASH))? color
            | determiner
            | type
            | number SLASH number;

prepositionalPhrase : prepositionalPhrase SPACE prepositionalPhrase
                    | preposition SPACE zone
                    | preposition SPACE object
                    | preposition SPACE quality
                    | preposition SPACE amount SPACE counter ' counters on ' object;

phase : playerPossessive SPACE 'turn'
      | playerPossessive SPACE rawPhase (plural)?
      | article SPACE rawPhase ' of ' object saxon ' controller'
      | article SPACE rawPhase
      | article SPACE 'opponent’s turn' COMMA ' before attackers are declared'
      | article SPACE 'next' SPACE rawPhase
      | 'combat'
      | 'combat before blockers are declared'
      | 'the turn'
      | 'each of your upkeeps for the rest of the game'
      | 'the next end step';

phrase : playerPhrase
       | objectPhrase;

player : rawPlayer
       | determiner SPACE player
       | rawPlayer plural
       | objectPossesive rawPlayer;

rawPlayer: 'controller'
         | 'owner'
         | 'player'
         | 'you'
         | 'opponent'
         | 'active player'
         | 'defending player'
         | 'they'
         | 'the player who controls the fewest';

playerPhrase : player SPACE playerVerbPhrase;

playerPossessive : 'your'
                 | 'their'
                 | rawPlayer saxon
                 | 'their controller' plural saxon
                 | 'its controller' saxon
                 | 'the chosen player' saxon;

playerVerbPhrase : verbMay playerVerbPhrase
                 | playerVerb
                 | playerVerb SPACE mana
                 | playerVerb SPACE object (SPACE prepositionAt SPACE adjectiveRandom)?
                 | playerVerb SPACE player
                 | playerVerb SPACE object SPACE 'for mana'
                 | playerVerb SPACE article SPACE 'amount of ' mana ' equal to ' amount
                 | playerVerb SPACE amount SPACE 'mana of any ' ('one' SPACE)? 'color'
                 | playerVerb SPACE amount SPACE 'mana of any type that land produced'
                 | playerVerb SPACE article SPACE 'additional ' mana
                 | playerVerb SPACE article SPACE 'text of ' object ' by replacing all instances of one ' textAspect ' with another'
                 | playerVerb SPACE article SPACE textAspect
                 | playerVerb SPACE zone
                 | '’re dealt damage'
                 | 'copy' SPACE object COMMA SPACE 'except the copy is red'
                 | 'counter' SPACE object (' unless its controller pays {X}. If that player doesn’t, they tap all lands with mana abilities they control and lose all unspent mana')
                 | verbChoose SPACE object
                 | verbChoose SPACE 'a card from it'
                 | 'create a 1/1 colorless Insect artifact creature token with flying named Wasp'
                 | DESTROY SPACE object PERIOD SPACE object SPACE 'deals damage to each creature and each player equal to' SPACE amount
                 | DESTROY SPACE object SPACE delayedTrigger
                 | DESTROY SPACE object SPACE delayedTrigger SPACE 'if it didn’t attack this turn'
                 | EXCHANGE SPACE object SPACE 'with' SPACE object
                 | 'exile ' object PERIOD SPACE player ' gains life equal to ' amount
                 | 'gain' (plural)? SPACE number ' life'
                 | 'gain life equal to the damage prevented this way'
                 | 'gain life equal to ' amount PERIOD SPACE object ' deals damage to ' something ' equal to ' amount '.'
                 | 'Look at the top ' amount ' cards of ' zone ', then put them back in any order. ' player ' may have ' player ' shuffle'
                 | 'Look' SPACE 'at' SPACE zone
                 | 'lose the game'
                 | 'lose life equal to ' amount
                 | 'put' SPACE object SPACE prepositionalPhrase
                 | 'put' SPACE amount SPACE counter ' counter on ' object (' for each creature that died this turn')?
                 | 'put' SPACE amount SPACE counter ' counter on ' object
                 | 'put' SPACE amount SPACE counter ' counters on ' object
                 | 'remove' SPACE article SPACE counter ' counter from ' object
                 | 'return' SPACE object (' from ' zone)? ' to ' zone PERIOD
                 | 'sacrifice ' object (subordinateClause)?
                 | 'sacrifice ' object PERIOD SPACE subordinateClause COMMA SPACE effect
                 | 'search ' zone SPACE prepositionalPhrase
                 | 'shuffle'
                 | 'skip' SPACE phase
                 | 'skip' SPACE demonstrative SPACE ('turn'|'draw')
                 | 'take an extra turn after this one'
                 | 'have ' object ' enter ' zone ' as a copy of any ' object ' on ' zone (SPACE prepositionalPhrase)?
                 | 'spend ' color ' mana as though it were ' color ' mana'
                 | 'play any number of lands on each of your turns'
                 | 'don’t lose the game for having 0 or less life'
                 | 'can’t untap ' comparator ' than one ' object ' during ' phase
                 | 'have no maximum hand size'
                 | 'antes ' object
                 | 'may ' costs PERIOD SPACE subordinateClause COMMA SPACE effect
                 | 'may ' effect
                 | 'may tap or untap ' object
                 | 'shuffles their hand and graveyard into ' zone;

delayedTrigger : 'at end of combat'
               | 'at the beginning of ' phase;

playerVerb : rawPlayerVerb (plural)?;

quality : 'mana value' SPACE number
        | 'power' SPACE amount
        | 'toughness' SPACE amount
        | 'power and toughness each equal to ' amount
        | keyword;

quotedAbility : OPENQUOTE ability CLOSEQUOTE;

rawPhase : turnPart
         | (turnPart SPACE)? turnPart SPACE rawWordStep;

restriction : verbCast SPACE object ' only during ' phase
            | verbCast object ' only before ' phase
            | 'Spend only ' color ' mana on X'
            | 'As an additional cost to ' verbCast ' this spell, ' costs
            | 'This spell costs ' costs SPACE  comparator SPACE 'to' SPACE verbCast ' for each target beyond the first'
            | 'Activate only during ' phase ('and only once each turn')?
            | 'Activate only during an opponent’s turn, before attackers are declared'
            | 'Remove ' object ' from your deck before playing if you’re not playing for ante'
            | 'Only ' player ' may activate this ability';

something : determiner SPACE something
          | object
          | player
          | something SPACE conjunction SPACE something;

source : premodifier SPACE source
       | source SPACE postmodifier
       | object
       | COLOR SPACE SOURCE
       | SOURCE;

statMod : plusMinus NUMBER SLASH plusMinus NUMBER (SPACE 'where' SPACE variableDefinition (COMMA SPACE CONJUNCTION variableDefinition)?)?;

variableDefinition: VARIABLE SPACE IS SPACE AMOUNT;

subordinateClause : subordinateConjunction SPACE 'long' SPACE subordinateClause
                  | subordinateConjunction SPACE condition
                  | subordinateConjunction SPACE phrase
                  | subordinateConjunction SPACE player ' would draw ' object ' during ' phase
                  | subordinateConjunction SPACE player ' would gain life'
                  | subordinateConjunction SPACE player ' would begin your turn while ' object ' is tapped'
                  | subordinateConjunction SPACE 'an effect causes you to discard a card'
                  | subordinateConjunction SPACE 'it’s ' object ' in addition to its other types'
                  | subordinateConjunction SPACE 'it doesn’t copy that creature’s color and it has “At the beginning of your upkeep, you may have this creature become a copy of target creature, except it doesn’t copy that creature’s color and it has this ability.”'
                  | subordinateConjunction SPACE 'that the copy is ' color;

textAspect : 'color word'
           | 'basic land type';

triggerCondition : triggerWord SPACE triggerEvent (COMMA SPACE subordinateClause)?;

triggerEvent : 'the beginning of' SPACE phase
             | 'end of combat'
             | phrase;

type : negation (DASH)? type
     | CARD_TYPE
     | LAND_TYPE
     | CREATURE_TYPE
     | ENCHANTMENT_TYPE
     | 'chosen type';

verbIs : rawVerbIs (negation)?;

zone : playerPossessive SPACE rawZone
     | article SPACE rawZone;

// Morphemes

comparator : 'less'
           | 'greater'
           | 'more';

counterType : 'corpse'
            | 'vitality'
            | 'mire';

englishNumber : 'one'
              | 'two'
              | 'three'
              | 'seven';

preposition : 'with' ('out')?
            | 'in' ('to')?
            | 'on' ('to')?
            | 'above';

plusMinus : PLUS
          | DASH;

rawDeterminer : ALL
              | EACH
              | ANY
              | OTHER
              | TARGET
              | NO;

rawObjectVerb : ATTACK
              | BECOME
              | BLOCK
              | DIE
              | ENTER;

rawPlayerVerb : ADD
              | ANTE
              | 'can’t'
              | CAST
              | CHANGE
              | CONTROL
              | DESTROY
	          | DISCARD
	          | 'do'
	          | DRAW
	          | OWN
	          | 'play'
	          | REGENERATE
	          | ('un')? 'tap';

rawZone : GRAVEYARD
        | BATTLEFIELD
        | HAND
        | LIBRARY
        | ANTE;

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
          | APOSTROPHE letterS;

rawWordStep : 'step';



// Lexemes

letterS : 's';

negation : 'non'
         | 'un'
         | 'n’t';

plural : letterS;

saxon : (APOSTROPHE (letterS)?|letterS);

tap : 't';
