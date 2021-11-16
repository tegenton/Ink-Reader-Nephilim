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
              | damage SPACE IS SPACE verbDealt SPACE prepositionTo SPACE object adverbInstead PERIOD
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

anyTime : ANY SPACE TIME SPACE player SPACE verbCould SPACE ANY_PLAY SPACE A SPACE abilityType
        | ANY SPACE TIME SPACE player SPACE verbCould SPACE ANY_PLAY SPACE A SPACE cardType;

continuousEffect : anyTime COMMA SPACE player SPACE verbMay SPACE costs PERIOD SPACE effect
                 | player SPACE verbMay SPACE costs SPACE anyTime PERIOD SPACE effect
                 | player SPACE CAN SPACE 'be attacked' SPACE subordinateClause
                 | player SPACE CAN SPACE 'untap' SPACE object ' during ' phase
                 | player SPACE 'don’t lose' SPACE THE ' game for having ' amount SPACE LIFE
                 | player SPACE HAS SPACE NO SPACE 'maximum' SPACE HAND SPACE 'size'
                 | player SPACE CONTROL SPACE player
                 | continuousObjectPhrase;

continuousObjectPhrase: object SPACE continuousObjectVerbPhrase;

continuousObjectVerbPhrase: continuousObjectVerbPhrase SPACE CONJUNCTION SPACE continuousObjectVerbPhrase
                          | IS SPACE object
                	      | CAN SPACE ATTACK (SPACE subordinateClause)?
             	          | CAN SPACE BLOCK SPACE object
                      	  | CAN 'be blocked'
                      	  | CAN 'be blocked ' (EXCEPT)? 'by ' object
                      	  | CAN 'be enchanted by ' object
                          | GAINS SPACE keyword
                          | GAINS SPACE quotedAbility
                      	  | GETS SPACE statMod
                          | HAS SPACE quotedAbility
             	          | HAS SPACE ability
                          | LOSES SPACE quotedAbility;

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
       | subordinateClause COMMA SPACE effect
       | (rawEffect COMMA SPACE)? rawEffect COMMA SPACE CONJUNCTION SPACE rawEffect;

rawEffect: PREVENT SPACE damage
       | source SPACE verbDeals SPACE damage SPACE prepositionTo SPACE player SPACE adverbInstead
       | THE SPACE 'next time' SPACE source SPACE 'would' SPACE DEAL SPACE damageType SPACE 'to' SPACE something SPACE DURATION COMMA SPACE effect
       | 'The next ' damage ' that would be dealt to ' object ' this turn is dealt to its owner' adverbInstead
       | subordinateClause ', flip ' object ' onto the battlefield from a height of at least one foot. If ' object ' turns over completely at least once during the flip, destroy all nontoken permanents it touches'
       | delayedTrigger COMMA SPACE 'remove all ' counter ' counters from a land that a ' counter ' counter was put onto with ' object ' but that a ' counter ' counter has not been removed from with ' object
       | delayedTrigger COMMA SPACE DESTROY SPACE object subordinateClause
       | player SPACE verbChooses SPACE 'a number of lands they control equal to ' amount ', then sacrifices the rest. Players discard cards and sacrifice creatures the same way'
       | player SPACE 'may pay any amount of mana'
       | PREVENT VARIABLE 'of that damage, where ' variableDefinition
       | player SPACE verbMay SPACE CHOOSE SPACE 'a creature card in your hand whose mana cost could be paid by some amount of, or all of, the mana you spent on {X}. If you do, you may cast that card face down as a 2/2 creature spell without paying its mana cost. If the creature that spell becomes as it resolves has not been turned face up and would assign or deal damage, be dealt damage, or become tapped, instead it’s turned face up and assigns or deals damage, is dealt damage, or becomes tapped. Activate only as a sorcery.'
       | player ' divides all creatures without flying they control into a “left” pile and a “right” pile. Then, for each attacking creature you control, ' verbChoose ' “left” or “right.” That creature can’t be blocked this combat except by creatures with flying and creatures in a pile with the chosen label'
       | 'Return ' object ' to the battlefield under your control'
       | 'attach ' object ' to it'
       | 'When ' object ' leaves the battlefield, that creature’s controller sacrifices it'
       | 'remove' SPACE object SPACE 'from combat'
       | player SPACE 'may have ' object SPACE BLOCK SPACE object
       | player SPACE 'activates a mana ability of ' object
       | player SPACE 'loses all unspent mana'
       | player SPACE ADD SPACE THE SPACE MANA SPACE 'lost' SPACE THIS SPACE 'way'
       | 'If this ability has been activated four or ' comparator ' times this turn, sacrifice ' object ' at the beginning of the next end step'
       | 'The player plays that card if able. While doing so, the player can activate mana abilities only if they’re from lands that player controls and only if mana they produce is spent to activate other mana abilities of lands the player controls and/or to play that card. If the chosen card is cast as a spell, you control the player while that spell is resolving'
       | objectPossesive SPACE characteristics SPACE IS ' each equal to ' amount
       | phrase
       | playerVerbPhrase (' and sacrifice ' object ' of an opponent’s choice')? (' and ' player ' loses all unspent mana')? (PERIOD SPACE player ' may attach ' object ' to ' object ' of their choice')?
       | object CAN 'be regenerated'
       | player SPACE 'may ' verbChoose ' new targets for' object
       | THIS SPACE 'effect doesn’t remove ' object
       | 'This ability' SPACE CAN SPACE 'cause the total number of ' counter ' counters on ' object ' to be greater than ' amount;

damage : 'damage'
       | NUMBER SPACE 'damage'
       | ALL SPACE 'combat damage that would be dealt' SPACE duration
       | ALL SPACE 'damage that would be dealt to ' player ' by ' object
       | ALL SPACE 'but ' NUMBER ' of that damage'
       | THAT SPACE damage
       | THE SPACE 'next' SPACE damage SPACE THAT SPACE 'would be dealt to' SPACE something SPACE duration;

// Definitions

adjective : 'enchanted'
          | 'tapped'
          | 'unblocked'
          | 'blocking'
          | 'attacking'
          | 'sacrificed'
          | 'token'
          | 'additional'
          | 'top';

amount : 'half ' amount COMMA ' rounded ' ('up'|'down')
       | 'up to ' amount
       | COMPARATIVE ' than ' ENGLISH_NUMBER
       | ENGLISH_NUMBER (SPACE CONJUNCTION SPACE COMPARATIVE)?
       | OBJECT saxon SPACE characteristics
       | VARIABLE
       | ARTICLE SPACE 'number of ' object (' minus ' number)?
       | ARTICLE SPACE 'damage dealt to ' player ' this turn'
       | playerPossessive ' life total'
       | THAT 'many'
       | ANY 'number of'
       | THE 'amount of mana that player paid this way';

characteristics : characteristic (conjunction characteristic)?;

condition : object (SPACE)? IS SPACE ('un')? 'tapped'
          | object (SPACE)? IS SPACE prepositionalPhrase (SPACE prepositionalPhrase)?
          | object (SPACE)? IS SPACE object
          | object (SPACE)? IS SPACE 'attacking'
          | object SPACE HAS SPACE A SPACE COUNTER SPACE 'counter' prepositionalPhrase
          | object SPACE HAS SPACE keyword
          | object SPACE 'had haste'
          | object SPACE 'didn’t have defender'
          | object SPACE 'wasn’t the first land you played' SPACE duration
          | object SPACE 'attacked' SPACE OR SPACE 'blocked' SPACE duration
          | object SPACE 'attacked' SPACE duration;

costs : (PAY SPACE)? cost (COMMA SPACE costs)?;

cost :(MANA_SYMBOL)+
     | TAP_SYMBOL
     | NUMBER SPACE LIFE
     | playerVerbPhrase;

determiner: DETERMINER
          | amount;

distinguisher : 'that would be' SPACE DEALT SPACE prepositionTo SPACE object;

duration : 'until end of' SPACE TURN
         | 'until end of combat'
         | 'until ' object ' leaves ' zone
         | 'until your next' SPACE TURN
         | 'until ' object ' finishes resolving'
         | THIS SPACE TURN
         | DETERMINER SPACE 'combat'
         | 'for as long as ' object ' has a ' counter ' counter on it'
         | 'as long as ' player ' control' SPACE object;

keyword : SIMPLE_KEYWORD
        | PROTECTION SPACE 'from' SPACE COLOR
        | ENCHANT SPACE object;

object : OBJECT
       | (premodifier SPACE)+ object
       | OBJECT (SPACE postmodifier)+
       | OBJECT plural
       | (OBJECT COMMA SPACE)* OBJECT SPACE CONJUNCTION OBJECT;

objectPossesive : object saxon;

objectPhrase : object SPACE objectVerbPhrase;

objectVerbPhrase : IS SPACE 'dealt damage'
                 | IS SPACE 'tapped for mana'
                 | IS SPACE 'put into ' zone ' from ' zone
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

postmodifier : player SPACE CONTROL
             | player ' controlled at the beginning of this turn'
             | player ' has controlled continuously since the beginning of the turn'
             | player ' didn’t ' CONTROL ' continuously since the beginning of the turn'
             | 'controlled by ' player
             | prepositionalPhrase
             | 'named Plague Rats' SPACE prepositionalPhrase
             | 'able to block ' object
             | THAT SPACE CAN BLOCK object
             | THAT SPACE IS ' still ' object
             | OTHER SPACE 'than ' object
             | THAT SPACE 'didn’t ' ATTACK SPACE DURATION
             | THAT SPACE CAN SPACE BLOCK SPACE 'additional creatures'
             | object ' was blocking that had become blocked by ' object SPACE DURATION
             | PUT prepositionalPhrase ' this way'
             | 'dealt damage by ' object SPACE DURATION
             | 'with' SPACE keyword SPACE CONJUNCTION SPACE keyword
             | 'for whom that player is the defending player'
             | 'in a pile'
             | 'that pile is assigned to'
             | 'of your choice'
             | 'of' SPACE zone;

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

player : ANY_PLAYER
       | determiner SPACE player
       | playerPremodifier SPACE player
       | ANY_PLAYER playerPostmodifier
       | objectPossesive ANY_PLAYER;

playerPremodifier: 'active' | 'chosen' | 'defending';

playerPostmodifier: 'who controls the fewest';

playerPhrase : player SPACE playerVerbPhrase;

playerPossessive : 'your'
                 | 'their'
                 | ANY_PLAYER saxon
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
                 | verbChoose SPACE object SPACE 'from it'
                 | 'create a 1/1 colorless Insect artifact creature token with flying named Wasp'
                 | DESTROY SPACE object PERIOD SPACE object SPACE 'deals damage to each creature and each player equal to' SPACE amount
                 | DESTROY SPACE object SPACE delayedTrigger
                 | DESTROY SPACE object SPACE delayedTrigger SPACE 'if it didn’t attack this turn'
                 | EXCHANGE SPACE object SPACE 'with' SPACE object
                 | 'exile ' object
                 | GAINS SPACE LIFE ' equal to ' amount
                 | GAINS SPACE NUMBER SPACE LIFE
                 | GAINS SPACE LIFE SPACE 'equal to the damage prevented this way'
                 | GAINS SPACE LIFE SPACE 'equal to ' amount
                 | 'Look at the top ' amount ' cards of ' zone ', then put them back in any order. ' player ' may have ' player ' shuffle'
                 | 'Look' SPACE 'at' SPACE zone
                 | 'lose the game'
                 | 'lose life equal to ' amount
                 | 'loses half their life, rounded up'
                 | PUT SPACE object SPACE prepositionalPhrase
                 | PUT SPACE amount SPACE counter ' counter on ' object (' for each creature that died this turn')?
                 | PUT SPACE amount SPACE counter ' counters on ' object
                 | 'remove' SPACE article SPACE counter ' counter from ' object
                 | 'return' SPACE object (' from ' zone)? ' to ' zone PERIOD
                 | 'sacrifice ' object (subordinateClause)?
                 | 'sacrifice ' object
                 | 'search ' zone SPACE prepositionalPhrase
                 | 'skip' SPACE phase
                 | 'skip' SPACE demonstrative SPACE ('turn'|'draw')
                 | 'take ' AN ' extra ' TURN ' after ' THIS SPACE ONE
                 | 'have ' object ' enter ' zone ' as a copy of any ' object ' on ' zone (SPACE prepositionalPhrase)?
                 | 'spend ' color ' mana as though it were ' color ' mana'
                 | 'play any number of lands on each of your turns'
                 | 'antes ' object
                 | 'may ' costs
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

restriction : CAST SPACE object ' only during ' phase
            | CAST object ' only before ' phase
            | 'Spend only ' COLOR ' mana on X'
            | 'As an additional cost to ' verbCast ' this spell, ' costs
            | object SPACE 'costs ' costs SPACE  comparator SPACE 'to' SPACE CAST ' for each target beyond the first'
            | ACTIVATE SPACE 'only during ' phase ('and only once each turn')?
            | ACTIVATE SPACE 'only during an opponent’s ' TURN ', before attackers are declared'
            | 'Remove ' object ' from your deck before playing if you’re not playing for ante'
            | 'Only' SPACE player SPACE 'may' SPACE ACTIVATE SPACE THIS SPACE 'ability';

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

subordinateClause : SUBORDINATE_CONJUNCTION SPACE condition
                  | SUBORDINATE_CONJUNCTION SPACE phrase
                  | SUBORDINATE_CONJUNCTION SPACE player ' would draw ' object ' during ' phase
                  | SUBORDINATE_CONJUNCTION SPACE player ' would gain life'
                  | SUBORDINATE_CONJUNCTION SPACE player ' would begin your turn while ' object ' is tapped'
                  | IF SPACE 'an effect causes ' player ' to discard a card'
                  | EXCEPT SPACE 'it’s ' object ' in addition to its other types'
                  | EXCEPT SPACE object SPACE 'doesn’t copy that creature’s color and it has “At the beginning of your upkeep, you may have this creature become a copy of target creature, except it doesn’t copy that creature’s color and it has this ability.”'
                  | EXCEPT SPACE THAT SPACE OBJECT SPACE IS SPACE COLOR
                  | EXCEPT SPACE 'by' SPACE object;

textAspect : 'color word'
           | 'basic land type';

triggerCondition : TRIGGER_WORD SPACE triggerEvent (COMMA SPACE subordinateClause)?;

triggerEvent : 'the beginning of' SPACE phase
             | 'end of combat'
             | phrase;

type : negation (DASH)? type
     | TYPE
     | 'chosen type';

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

// Lexemes
negation : 'non'
         | 'un'
         | 'n’t';
