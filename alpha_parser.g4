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

modal : CHOOSE SPACE ENGLISH_NUMBER DASH (NEWLINE BULLET SPACE effect PERIOD)+;

spellAbility : effect PERIOD
             | restriction PERIOD
             | modal
             | delayedTrigger COMMA SPACE effect PERIOD SPACE verbIgnore SPACE demonstrative SPACE nounEffect SPACE prepositionFor SPACE object PERIOD
             | duration COMMA SPACE adverbInstead SPACE prepositionOf SPACE verbDeclaring SPACE nounBlockers COMMA SPACE rawDeterminer SPACE player SPACE verbChooses SPACE object SPACE CONJUNCTION SPACE verbDivides SPACE pronounThem SPACE preposition SPACE article SPACE nounNumber SPACE prepositionOf SPACE nounPiles SPACE adjectiveEqual SPACE prepositionTo SPACE amount PERIOD SPACE object SPACE verbMay SPACE verbLikewise SPACE verbBe SPACE verbPut preposition SPACE adjectiveAdditional SPACE nounPiles PERIOD SPACE verbAssign SPACE rawDeterminer SPACE nounPile prepositionTo SPACE article SPACE adjectiveDifferent SPACE number prepositionOf SPACE object SPACE prepositionAt SPACE adjectiveRandom PERIOD SPACE SPACE objectPhrase PERIOD;

// Effects

anyTime : ANY SPACE TIME SPACE player SPACE verbCould SPACE ACTIVATE SPACE A SPACE abilityType
        | ANY SPACE TIME SPACE player SPACE verbCould SPACE CAST SPACE A SPACE cardType;

continuousEffect : anyTime COMMA SPACE player SPACE verbMay SPACE costs PERIOD SPACE subordinateClause COMMA SPACE effect
                 | player SPACE verbMay SPACE costs SPACE anyTime PERIOD SPACE subordinateClause COMMA SPACE effect
                 | player SPACE 'can’t be attacked except by ' object
                 | player SPACE 'don’t lose ' THE ' game for having ' amount ' life'
                 | player SPACE 'can’t untap ' amount object ' during ' phase
                 | player SPACE HAS SPACE NO ' maximum ' HAND ' size'
                 | continuousObjectPhrase;

continuousObjectPhrase: object SPACE continuousObjectVerbPhrase;

continuousObjectVerbPhrase: continuousObjectVerbPhrase SPACE CONJUNCTION SPACE continuousObjectVerbPhrase
                          | verbIs SPACE object
                      	  | 'can attack as though ' object ' didn’t have defender'
                          | 'can attack as though ' object ' had haste'
                	      | 'can’t attack' (SPACE subordinateClause)?
             	          | 'can block ' object
                      	  | 'can’t block ' object
                      	  | 'can’t be blocked'
                      	  | 'can’t be blocked ' ('except ')? 'by ' object
                      	  | 'can’t be enchanted by ' object
                          | 'gains' SPACE keyword
                          | 'gains' SPACE quotedAbility
                      	  | GETS SPACE statMod
                          | HAS SPACE quotedAbility
             	          | HAS SPACE ability (PERIOD SPACE 'this effect doesn’t remove ' object)?
                          | 'loses' SPACE quotedAbility;

replacementEffect : subordinateClause COMMA SPACE (SPACE adverbInstead)? effect (SPACE adverbInstead)?
                  | subordinateClause COMMA SPACE playerPhrase SPACE adverbInstead PERIOD SPACE subordinateClause COMMA SPACE effect
                  | subordinateClause COMMA SPACE playerVerbPhrase COMMA SPACE prepositionBut SPACE player SPACE verbMay SPACE verbPut SPACE object preposition SPACE nounTop SPACE prepositionOf SPACE zone SPACE adverbInstead SPACE prepositionOf SPACE preposition SPACE zone
                  | objectPhrase SPACE prepositionalPhrase;

triggerEffect : effect (SPACE subordinateClause)?;

effect : rawEffect
       | rawEffect (PERIOD)? SPACE CONJUNCTION SPACE effect
       | rawEffect PERIOD SPACE effect
       | continuousEffect SPACE duration
       | duration COMMA SPACE continuousEffect
       | (rawEffect COMMA SPACE)? rawEffect COMMA SPACE CONJUNCTION SPACE rawEffect;

rawEffect: PREVENT SPACE damage
       | source SPACE verbDeals SPACE damage SPACE prepositionTo SPACE player SPACE adverbInstead
       | 'The next time' SPACE source SPACE 'would deal' SPACE damageType SPACE 'to' SPACE something SPACE 'this turn' COMMA SPACE effect
       | 'The next ' damage ' that would be dealt to ' object ' this turn is dealt to its owner' adverbInstead
       | subordinateClause ', flip ' object ' onto the battlefield from a height of at least one foot. If ' object ' turns over completely at least once during the flip, destroy all nontoken permanents it touches'
       | delayedTrigger COMMA SPACE 'remove all ' counter ' counters from a land that a ' counter ' counter was put onto with ' object ' but that a ' counter ' counter has not been removed from with ' object
       | delayedTrigger COMMA SPACE 'destroy ' object ' if it attacked this turn'
       | player SPACE verbChooses SPACE 'a number of lands they control equal to ' amount ', then sacrifices the rest. Players discard cards and sacrifice creatures the same way'
       | player SPACE 'may pay any amount of mana'
       | 'Prevent X of that damage, where ' variableDefinition
       | player SPACE verbMay SPACE CHOOSE SPACE 'a creature card in your hand whose mana cost could be paid by some amount of, or all of, the mana you spent on {X}. If you do, you may cast that card face down as a 2/2 creature spell without paying its mana cost. If the creature that spell becomes as it resolves has not been turned face up and would assign or deal damage, be dealt damage, or become tapped, instead it’s turned face up and assigns or deals damage, is dealt damage, or becomes tapped. Activate only as a sorcery.'
       | player ' divides all creatures without flying they control into a “left” pile and a “right” pile. Then, for each attacking creature you control, ' verbChoose ' “left” or “right.” That creature can’t be blocked this combat except by creatures with flying and creatures in a pile with the chosen label'
       | 'Return ' object ' to the battlefield under your control'
       | 'attach ' object ' to it'
       | 'When ' object ' leaves the battlefield, that creature’s controller sacrifices it'
       | 'remove' SPACE object SPACE 'from combat'
       | player SPACE 'may have ' object ' block ' object ' of your choice'
       | player SPACE 'activates a mana ability of ' object
       | player SPACE 'loses all unspent mana'
       | player SPACE 'add the mana lost this way'
       | player ' control ' player ' until ' object ' finishes resolving'
       | 'If this ability has been activated four or ' comparator ' times this turn, sacrifice ' object ' at the beginning of the next end step'
       | 'The player plays that card if able. While doing so, the player can activate mana abilities only if they’re from lands that player controls and only if mana they produce is spent to activate other mana abilities of lands the player controls and/or to play that card. If the chosen card is cast as a spell, you control the player while that spell is resolving'
       | objectPossesive SPACE characteristics SPACE verbIs ' each equal to ' amount
       | phrase
       | playerVerbPhrase (' and sacrifice ' object ' of an opponent’s choice')? (' and ' player ' loses all unspent mana')? (PERIOD SPACE player ' may attach ' object ' to ' object ' of their choice')?
       | object 'can’t be regenerated'
       | player SPACE 'may ' verbChoose ' new targets for' object
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
       | COMPARATIVE ' than ' ENGLISH_NUMBER
       | ENGLISH_NUMBER (SPACE CONJUNCTION SPACE COMPARATIVE)?
       | rawObject saxon SPACE characteristics
       | VARIABLE
       | ARTICLE SPACE 'number of ' object (' minus ' number)?
       | ARTICLE SPACE 'damage dealt to ' player ' this turn'
       | playerPossessive ' life total'
       | THAT 'many'
       | ANY 'number of'
       | THE 'number of attacking creatures for whom that player is the defending player'
       | THE 'amount of mana that player paid this way';

characteristics : characteristic (conjunction characteristic)?;

condition : object (SPACE)? verbIs SPACE ('un')? 'tapped'
          | object (SPACE)? verbIs SPACE prepositionalPhrase (SPACE prepositionalPhrase)?
          | object (SPACE)? verbIs SPACE object
          | object (SPACE)? verbIs SPACE 'attacking'
          | object SPACE HAS SPACE A SPACE COUNTER SPACE 'counter' prepositionalPhrase
          | object SPACE HAS SPACE keyword
          | object SPACE 'wasn’t the first land you played' SPACE THIS SPACE TURN
          | object SPACE 'attacked or blocked this combat';

costs : (PAY SPACE)? cost (COMMA SPACE costs)?;

cost :(MANA_SYMBOL)+
     | TAP_SYMBOL
     | NUMBER SPACE LIFE
     | playerVerbPhrase;

determiner: DETERMINER
          | amount;

distinguisher : 'that would be' SPACE DEALT SPACE prepositionTo SPACE object;

duration : 'until end of turn'
         | 'until end of combat'
         | 'until ' object ' leaves ' zone
         | 'until your next turn'
         | THIS 'turn'
         | EACH 'combat'
         | 'for as long as ' object ' has a ' counter ' counter on it'
         | 'as long as you control a Swamp';

keyword : SIMPLE_KEYWORD
        | PROTECTION SPACE 'from' SPACE COLOR
        | ENCHANT SPACE object;

object : rawObject
       | (premodifier SPACE)+ object
       | rawObject (SPACE postmodifier)+
       | rawObject plural
       | (rawObject COMMA SPACE)* rawObject SPACE CONJUNCTION rawObject;

rawObject : TILDE
          | TYPE
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
                 | objectVerb SPACE zone 'tapped'
                 | objectVerb SPACE COLOR
                 | objectVerb SPACE zone
                 | objectVerb SPACE object (' if able')?
                 | 'attacks this turn if able'
                 | 'blocks or becomes blocked by ' object
                 | 'deals damage to ' player
                 | 'do' ('es')? 'n’t untap during ' phase
                 | 'do' ('es')? 'so'
                 | verbCost SPACE costs SPACE comparator SPACE 'to cast'
             	 | 'gains trample and gets ' statMod SPACE duration ', where X is ' amount
             	 | 'become unblocked'
             	 | 'deals ' damage ' to ' something
                 | 'deals ' damage ' to ' something ' and ' damage ' to ' something
                 | 'deals ' damage ' to ' something ' and ' object ' gains "Enchanted creature loses flying"'
                 | 'deals ' damage ' to ' something COMMA SPACE 'where X is ' amount
                 | 'deals ' damage ' to ' something PERIOD SPACE player ' gain' SPACE LIFE SPACE 'equal to the damage dealt, but not ' comparator ' life than the player’s life total before the damage was dealt, the planeswalker’s loyalty before the damage was dealt, or the creature’s toughness'
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
            | (negation (SPACE|DASH))? COLOR
            | determiner
            | TYPE
            | NUMBER SLASH NUMBER;

prepositionalPhrase : prepositionalPhrase SPACE prepositionalPhrase
                    | preposition SPACE zone
                    | preposition SPACE object
                    | preposition SPACE quality
                    | preposition SPACE amount SPACE COUNTER ' counters ' prepositionalPhrase;

phase : playerPossessive SPACE TURN
      | playerPossessive SPACE rawPhase (plural)?
      | ARTICLE SPACE rawPhase ' of ' object saxon ' controller'
      | ARTICLE SPACE rawPhase
      | ARTICLE SPACE 'opponent’s' TURN COMMA ' before attackers are declared'
      | ARTICLE SPACE 'next' SPACE rawPhase
      | 'combat'
      | 'combat before blockers are declared'
      | THE TURN
      | EACH 'of your upkeeps for the rest of the game'
      | THE 'next end step';

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
                 | 'exile ' object
                 | 'gains ' LIFE ' equal to ' amount
                 | 'gain' (plural)? SPACE NUMBER SPACE LIFE
                 | 'gain life equal to the damage prevented this way'
                 | 'gain life equal to ' amount
                 | 'Look at the top ' amount ' cards of ' zone ', then put them back in any order. ' player ' may have ' player ' shuffle'
                 | 'Look' SPACE 'at' SPACE zone
                 | 'lose the game'
                 | 'lose life equal to ' amount
                 | 'loses half their life, rounded up'
                 | 'put' SPACE object SPACE prepositionalPhrase
                 | 'put' SPACE amount SPACE counter ' counter on ' object (' for each creature that died this turn')?
                 | 'put' SPACE amount SPACE counter ' counter on ' object
                 | 'put' SPACE amount SPACE counter ' counters on ' object
                 | 'remove' SPACE article SPACE counter ' counter from ' object
                 | 'return' SPACE object (' from ' zone)? ' to ' zone PERIOD
                 | 'sacrifice ' object (subordinateClause)?
                 | 'sacrifice ' object PERIOD SPACE subordinateClause COMMA SPACE effect
                 | 'search ' zone SPACE prepositionalPhrase
                 | 'skip' SPACE phase
                 | 'skip' SPACE demonstrative SPACE ('turn'|'draw')
                 | 'take ' AN ' extra ' TURN ' after ' THIS SPACE ONE
                 | 'have ' object ' enter ' zone ' as a copy of any ' object ' on ' zone (SPACE prepositionalPhrase)?
                 | 'spend ' color ' mana as though it were ' color ' mana'
                 | 'play any number of lands on each of your turns'
                 | 'antes ' object
                 | 'may ' costs PERIOD SPACE subordinateClause COMMA SPACE effect
                 | 'may ' effect
                 | 'may tap ' OR ' untap ' object
                 | 'shuffles their hand ' AND ' graveyard into ' zone;

delayedTrigger : AT SPACE 'end of combat'
               | AT SPACE THE 'beginning of ' phase;

playerVerb : rawPlayerVerb (plural)?;

quality : MANA VALUE SPACE NUMBER
        | POWER SPACE amount
        | TOUGHNESS SPACE amount
        | POWER SPACE AND SPACE TOUGHNESS SPACE EACH ' equal to ' amount
        | SIMPLE_KEYWORD;

quotedAbility : OPENQUOTE ability CLOSEQUOTE;

rawPhase : turnPart
         | (turnPart SPACE)? turnPart SPACE rawWordStep;

restriction : verbCast SPACE object ' only during ' phase
            | verbCast object ' only before ' phase
            | 'Spend only ' COLOR ' mana on X'
            | 'As an additional cost to ' verbCast ' this spell, ' costs
            | 'This spell costs ' costs SPACE  comparator SPACE 'to' SPACE verbCast ' for each target beyond the first'
            | 'Activate only during ' phase ('and only once each turn')?
            | 'Activate only during an opponent’s turn, before attackers are declared'
            | 'Remove ' object ' from your deck before playing if you’re not playing for ante'
            | 'Only ' player ' may activate this ability';

something : determiner SPACE something
          | object
          | player
          | something SPACE CONJUNCTION SPACE something;

source : premodifier SPACE source
       | source SPACE postmodifier
       | object
       | COLOR SPACE SOURCE
       | SOURCE;

statMod : plusMinus NUMBER SLASH plusMinus NUMBER (SPACE 'where' SPACE variableDefinition (COMMA SPACE CONJUNCTION variableDefinition)?)?;

variableDefinition: VARIABLE SPACE IS SPACE AMOUNT;

subordinateClause : SUBORDINATE_CONJUNCTION SPACE 'long' SPACE subordinateClause
                  | SUBORDINATE_CONJUNCTION SPACE condition
                  | SUBORDINATE_CONJUNCTION SPACE phrase
                  | SUBORDINATE_CONJUNCTION SPACE player ' would draw ' object ' during ' phase
                  | SUBORDINATE_CONJUNCTION SPACE player ' would gain life'
                  | SUBORDINATE_CONJUNCTION SPACE player ' would begin your turn while ' object ' is tapped'
                  | SUBORDINATE_CONJUNCTION SPACE 'an effect causes you to discard a card'
                  | SUBORDINATE_CONJUNCTION SPACE 'it’s ' object ' in addition to its other types'
                  | SUBORDINATE_CONJUNCTION SPACE 'it doesn’t copy that creature’s color and it has “At the beginning of your upkeep, you may have this creature become a copy of target creature, except it doesn’t copy that creature’s color and it has this ability.”'
                  | SUBORDINATE_CONJUNCTION SPACE 'that the copy is ' COLOR;

textAspect : 'color word'
           | 'basic land type';

triggerCondition : TRIGGER_WORD SPACE triggerEvent (COMMA SPACE subordinateClause)?;

triggerEvent : 'the beginning of' SPACE phase
             | 'end of combat'
             | phrase;

type : negation (DASH)? type
     | TYPE
     | 'chosen type';

verbIs : rawVerbIs (negation)?;

zone : playerPossessive SPACE ZONE
     | ARTICLE SPACE ZONE;

// Morphemes

preposition : 'with' ('out')?
            | 'in' ('to')?
            | 'on' ('to')?
            | 'above';

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
	          | SHUFFLE
	          | ('un')? 'tap';

turnPart : 'untap'
         | 'upkeep'
         | 'draw'
         | 'declare'
         | 'attackers'
         | 'blockers'
         | 'combat'
         | 'damage'
         | 'end';

// individual words

rawVerbIs : 'is'
          | 'are'
          | APOSTROPHE letterS;

// Lexemes
negation : 'non'
         | 'un'
         | 'n’t';
