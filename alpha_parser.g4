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
              | abilityType SPACE OF SPACE object SPACE COSTS SPACE costs SPACE COMPARATIVE SPACE prepositionTo SPACE ACTIVATE PERIOD
              | damage SPACE IS SPACE verbDealt SPACE prepositionTo SPACE object adverbInstead PERIOD
              | prepositionFor SPACE EACH SPACE damage SPACE distinguisher COMMA SPACE triggerEffect PERIOD;

triggeredAbility : triggerCondition COMMA SPACE triggerEffect PERIOD;

// Spells

spellCard : spellAbility (NEWLINE spellAbility)*;

modal : CHOOSE SPACE ENGLISH_NUMBER DASH (NEWLINE BULLET SPACE effect PERIOD)+;

spellAbility : effect PERIOD
             | restriction PERIOD
             | modal
             | delayedTrigger COMMA SPACE effect PERIOD SPACE verbIgnore SPACE THIS SPACE EFFECT SPACE prepositionFor SPACE object PERIOD
             | duration COMMA SPACE adverbInstead SPACE prepositionOf SPACE verbDeclaring SPACE nounBlockers COMMA SPACE player SPACE CHOOSE SPACE object SPACE CONJUNCTION SPACE DIVIDE SPACE pronounThem SPACE preposition SPACE ARTICLE SPACE nounNumber SPACE prepositionOf SPACE PILE SPACE adjectiveEqual SPACE prepositionTo SPACE amount PERIOD SPACE object SPACE MAY SPACE verbLikewise SPACE verbBe SPACE PUT SPACE preposition SPACE adjectiveAdditional SPACE PILE PERIOD SPACE verbAssign SPACE determiner SPACE PILE prepositionTo SPACE ARTICLE SPACE adjectiveDifferent SPACE number prepositionOf SPACE object SPACE prepositionAt SPACE adjectiveRandom PERIOD SPACE SPACE objectPhrase PERIOD;

// Effects

anyTime : ANY SPACE TIME SPACE player SPACE verbCould SPACE ANY_PLAY SPACE A SPACE abilityType
        | ANY SPACE TIME SPACE player SPACE verbCould SPACE ANY_PLAY SPACE A SPACE cardType;

continuousEffect : anyTime COMMA SPACE player SPACE MAY SPACE costs PERIOD SPACE effect
                 | player SPACE MAY SPACE costs SPACE anyTime PERIOD SPACE effect
                 | player SPACE CAN SPACE 'be attacked' SPACE subordinateClause
                 | player SPACE CAN SPACE 'untap' SPACE object SPACE duration
                 | player SPACE DOES SPACE LOSE SPACE THE SPACE GAME SPACE 'for having' SPACE amount SPACE LIFE
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
                  | subordinateClause COMMA SPACE playerVerbPhrase COMMA SPACE prepositionBut SPACE player SPACE MAY SPACE verbPut SPACE object preposition SPACE nounTop SPACE prepositionOf SPACE zone SPACE adverbInstead SPACE prepositionOf SPACE preposition SPACE zone
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
       | delayedTrigger COMMA SPACE 'remove all ' counter ' counters from a land that a ' counter ' counter was put onto with ' object ' but that a ' counter ' counter has ' NOT 'been removed from with ' object
       | delayedTrigger COMMA SPACE DESTROY SPACE object subordinateClause
       | player SPACE CHOOSE SPACE 'a number of lands they control equal to ' amount ', then sacrifices the rest. Players discard cards and sacrifice creatures the same way'
       | player SPACE MAY SPACE PAY SPACE 'any amount of' SPACE MANA
       | PREVENT VARIABLE 'of that damage, where ' variableDefinition
       | player SPACE MAY SPACE CHOOSE SPACE 'a creature card in your hand whose mana cost could be paid by some amount of, or all of, the mana you spent on {X}. If you do, you ' MAY ' cast that card face down as a 2/2 creature spell without paying its mana cost. If the creature that spell becomes as it resolves has' SPACE NOT SPACE 'been turned face up and would assign or deal damage, be dealt damage, or become tapped, instead it’s turned face up and assigns or deals damage, is dealt damage, or becomes tapped. Activate only as a sorcery.'
       | player ' divides all creatures without flying they control into a “left” pile and a “right” pile. Then, for each attacking creature you control, ' verbChoose ' “left” or “right.” That creature can’t be blocked this ' COMBAT ' except by creatures with flying and creatures in a pile with the chosen label'
       | 'attach' SPACE object SPACE 'to' object
       | 'When' SPACE object ' leaves the battlefield, that creature’s controller sacrifices it'
       | REMOVE SPACE object SPACE 'from' SPACE COMBAT
       | player SPACE MAY SPACE HAS SPACE object SPACE BLOCK SPACE object
       | player SPACE ACTIVATE SPACE A SPACE MANA SPACE ABILITY SPACE 'of' SPACE object
       | player SPACE ADD SPACE THE SPACE MANA SPACE 'lost' SPACE THIS SPACE 'way'
       | 'If this ability has been activated four or ' COMPARATIVE ' times this turn, sacrifice ' object ' at the beginning of the next end step'
       | 'The player plays that card if able. While doing so, the player can activate mana abilities only if they’re from lands that player controls and only if mana they produce is spent to activate other mana abilities of lands the player controls and/or to play that card. If the chosen card is cast as a spell, you control the player while that spell is resolving'
       | objectPossesive SPACE characteristics SPACE IS ' each equal to ' amount
       | phrase
       | playerVerbPhrase (AND SPACE 'sacrifice ' object ' of an opponent’s choice')? (' and ' player ' loses all unspent mana')? (PERIOD SPACE player MAY ' attach ' object ' to ' object ' of their choice')?
       | object CAN SPACE 'be regenerated'
       | object CAN SPACE 'be regenerated this turn'
       | player SPACE MAY SPACE CHOOSE ' new targets for ' object
       | THIS SPACE EFFECT SPACE DOES 'remove' SPACE object
       | THIS SPACE ABILITY SPACE CAN SPACE 'cause the total number of ' COUNTER_TYPE SPACE COUNTER ' on ' object ' to be greater than ' amount
       | player SPACE GAINS SPACE LIFE SPACE 'equal to the damage dealt, but' SPACE NOT SPACE COMPARATIVE ' life than the player’s life total before the damage was dealt, the planeswalker’s loyalty before the damage was dealt, or the creature’s toughness'
       | 'if it would die this turn, exile it' SPACE adverbInstead;

damage : DAMAGE
       | NUMBER SPACE DAMAGE
       | ALL SPACE COMBAT SPACE DAMAGE SPACE THAT SPACE 'would be dealt' SPACE duration
       | ALL SPACE DAMAGE SPACE THAT SPACE 'would be dealt to ' player ' by ' object
       | ALL SPACE 'but ' NUMBER SPACE 'of' SPACE damage
       | THAT SPACE damage
       | THE SPACE 'next' SPACE damage SPACE THAT SPACE 'would be' SPACE DEALT SPACE 'to' SPACE something SPACE duration;

// Definitions

amount : 'half ' amount COMMA ' rounded ' ('up'|'down')
       | 'up to ' amount
       | COMPARATIVE ' than ' ENGLISH_NUMBER
       | ENGLISH_NUMBER (SPACE CONJUNCTION SPACE COMPARATIVE)?
       | objectPossessive SPACE characteristics
       | VARIABLE
       | ARTICLE SPACE 'number of ' object (' minus ' number)?
       | ARTICLE SPACE 'damage dealt to ' player SPACE duration
       | playerPossessive SPACE LIFE ' total'
       | THAT 'many'
       | ANY 'number of'
       | THE SPACE 'amount of mana that player paid this way'
       | THE SPACE 'damage prevented this way';

characteristics : characteristic (conjunction characteristic)?;

condition : object (SPACE)? IS SPACE ('un')? 'tapped'
          | object (SPACE)? IS SPACE prepositionalPhrase (SPACE prepositionalPhrase)?
          | object (SPACE)? IS SPACE object
          | object (SPACE)? IS SPACE 'attacking'
          | object SPACE HAS SPACE A SPACE COUNTER_TYPE SPACE COUNTER prepositionalPhrase
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

distinguisher : THAT 'would be' SPACE DEALT SPACE prepositionTo SPACE object;

duration : 'until end of' SPACE TURN
         | 'until end of' SPACE COMBAT
         | 'until' SPACE object SPACE 'leaves' SPACE zone
         | 'until' SPACE YOUR SPACE 'next' SPACE TURN
         | 'until' SPACE object SPACE 'finishes resolving'
         | THIS SPACE TURN
         | DETERMINER SPACE COMBAT
         | 'during' SPACE phase
         | 'for as long as ' object HAS A COUNTER_TYPE SPACE COUNTER SPACE 'on it'
         | 'as long as ' player ' control' SPACE object;

keyword : SIMPLE_KEYWORD
        | PROTECTION SPACE 'from' SPACE COLOR
        | ENCHANT SPACE object;

object : OBJECT
       | (premodifier SPACE)+ object
       | OBJECT (SPACE postmodifier)+
       | OBJECT
       | (OBJECT COMMA SPACE)* OBJECT SPACE CONJUNCTION OBJECT;

objectPossesive : object saxon;

objectPhrase : object SPACE objectVerbPhrase;

objectVerbPhrase : IS SPACE DEALT damage
                 | IS SPACE 'tapped for mana'
                 | IS SPACE PUT SPACE 'into ' zone ' from ' zone
                 | IS SPACE COLOR
                 | ENTERS SPACE zone 'tapped'
                 | LEAVES SPACE zone
                 | BLOCKS SPACE object (' if able')?
                 | ATTACKS SPACE duration ' if able'
                 | BLOCKS SPACE OR SPACE BECOMES SPACE 'blocked by ' object
                 | DEAL SPACE damage SPACE 'to' SPACE player
                 | DOES SPACE 'untap' SPACE duration
                 | DOES SPACE 'so'
                 | COST SPACE costs SPACE COMPARATIVE SPACE 'to cast'
             	 | GAINS SPACE KEYWORD SPACE AND SPACE GETS SPACE statMod SPACE duration ', where X is ' amount
                 | GAINS '"Enchanted creature loses flying"'
             	 | BECOMES SPACE 'unblocked'
             	 | DEAL SPACE damage ' to ' something
                 | DEAL SPACE damage ' to ' something ' and ' damage ' to ' something
                 | DEAL SPACE damage ' to ' something COMMA SPACE 'where X is ' amount
                 | DEAL SPACE damage ' divided evenly, rounded down, among any number of targets'
                 | DEAL SPACE damage ' to ' something ' equal to ' amount
                 | DEAL SPACE damage ' equal to ' amount ' to ' something;

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
                    | preposition SPACE amount SPACE COUNTER_TYPE COUNTERS prepositionalPhrase;

phase : playerPossessive SPACE TURN
      | playerPossessive SPACE rawPhase (plural)?
      | ARTICLE SPACE rawPhase ' of ' object saxon ' controller'
      | ARTICLE SPACE rawPhase
      | ARTICLE SPACE 'opponent’s' TURN COMMA ' before attackers are declared'
      | ARTICLE SPACE 'next' SPACE rawPhase
      | COMBAT
      | COMBAT SPACE 'before blockers are declared'
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

playerPossessive : YOUR
                 | THEIR
                 | ANY_PLAYER saxon
                 | 'their controller' plural saxon
                 | 'its controller' saxon
                 | 'the chosen player' saxon;

playerVerbPhrase : MAY SPACE playerVerbPhrase
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
                 | COPY SPACE object COMMA SPACE subordinateClause
                 | COUNTER SPACE object (' unless its controller pays {X}. If that player doesn’t, they tap all lands with mana abilities they control and lose all unspent mana')
                 | CHOOSE SPACE object
                 | CHOOSE SPACE object SPACE 'from it'
                 | CREATE SPACE 'a 1/1 colorless Insect artifact creature token with flying named Wasp'
                 | DESTROY SPACE object PERIOD SPACE object SPACE 'deals damage to each creature and each player equal to' SPACE amount
                 | DESTROY SPACE object SPACE delayedTrigger
                 | DESTROY SPACE object SPACE delayedTrigger SPACE 'if it didn’t attack this turn'
                 | EXCHANGE SPACE object SPACE 'with' SPACE object
                 | EXILE SPACE object
                 | GAINS SPACE LIFE ' equal to ' amount
                 | GAINS SPACE NUMBER SPACE LIFE
                 | GAINS SPACE LIFE SPACE 'equal to ' amount
                 | LOOK SPACE AT SPACE object ', then put them back in any order'
                 | LOOK SPACE AT SPACE zone
                 | LOSE SPACE THE SPACE 'game'
                 | LOSE SPACE LIFE SPACE 'equal to ' amount
                 | LOSE SPACE 'half their' SPACE LIFE ', rounded up'
                 | LOSE SPACE ALL SPACE 'unspent' SPACE MANA
                 | PUT SPACE object SPACE prepositionalPhrase
                 | PUT SPACE amount SPACE COUNTER_TYPE COUNTER ' on ' object (' for each creature that died this turn')?
                 | REMOVE SPACE ARTICLE SPACE COUNTER_TYPE SPACE COUNTER SPACE 'from' SPACE object
                 | RETURN SPACE object (SPACE 'from' SPACE zone)? SPACE 'to' SPACE zone
                 | RETURN SPACE object SPACE 'to the battlefield under your control'
                 | SACRIFICE SPACE object (subordinateClause)?
                 | SEARCH SPACE zone SPACE prepositionalPhrase
                 | SKIP SPACE phase
                 | SKIP SPACE THAT SPACE (TURN|DRAW)
                 | TAKE SPACE AN SPACE 'extra' SPACE TURN SPACE 'after' SPACE THIS SPACE ONE
                 | MAY SPACE HAS object SPACE ENTER SPACE zone SPACE 'as a copy of any' SPACE object SPACE 'on' SPACE zone (SPACE prepositionalPhrase)?
                 | MAY SPACE HAS player SHUFFLE
                 | MAY SPACE SPEND SPACE COLOR SPACE MANA 'as though it were ' COLOR SPACE MANA
                 | MAY PLAY SPACE object SPACE 'on each of your turns'
                 | ANTE SPACE object
                 | MAY SPACE costs
                 | MAY SPACE effect
                 | MAY SPACE 'tap' SPACE OR SPACE 'untap' SPACE object
                 | SHUFFLE 'their hand' SPACE AND SPACE 'graveyard into' SPACE zone;

delayedTrigger : AT SPACE 'end of' SPACE COMBAT
               | AT SPACE THE 'beginning of ' phase;

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
            | 'As an additional cost to ' CAST ' this spell, ' costs
            | object SPACE COSTS costs SPACE COMPARATIVE SPACE 'to' SPACE CAST ' for each target beyond the first'
            | ACTIVATE SPACE 'only during ' phase ('and only once each turn')?
            | ACTIVATE SPACE 'only during an opponent’s ' TURN ', before attackers are declared'
            | 'Remove ' object ' from your deck before playing if you’re' SPACE NOT SPACE 'playing for ante'
            | 'Only' SPACE player SPACE MAY SPACE ACTIVATE SPACE THIS SPACE ABILITY;

something : determiner SPACE something
          | object
          | player
          | something SPACE CONJUNCTION SPACE something;

source : premodifier SPACE source
       | source SPACE postmodifier
       | object
       | COLOR SPACE SOURCE
       | SOURCE;

variableDefinition: VARIABLE SPACE IS SPACE AMOUNT;

subordinateClause : SUBORDINATE_CONJUNCTION SPACE condition
                  | SUBORDINATE_CONJUNCTION SPACE phrase
                  | SUBORDINATE_CONJUNCTION SPACE player ' would' SPACE DRAW SPACE object SPACE duration
                  | SUBORDINATE_CONJUNCTION SPACE player ' would' SPACE GAIN SPACE LIFE
                  | SUBORDINATE_CONJUNCTION SPACE player ' would begin your turn while ' object ' is tapped'
                  | IF SPACE AN SPACE 'effect causes ' player ' to discard a card'
                  | EXCEPT SPACE object '’s' SPACE object ' in addition to its other types'
                  | EXCEPT SPACE object SPACE 'doesn’t copy that creature’s color and it has “At the beginning of your upkeep, you may have this creature become a copy of target creature, except it doesn’t copy that creature’s color and it has this ability.”'
                  | EXCEPT SPACE object SPACE IS SPACE COLOR
                  | EXCEPT SPACE 'by' SPACE object;

textAspect : 'color word'
           | 'basic land type';

triggerCondition : TRIGGER_WORD SPACE triggerEvent (COMMA SPACE subordinateClause)?;

triggerEvent : THE SPACE 'beginning of' SPACE phase
             | 'end of' SPACE COMBAT
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
              | CAN
              | CAST
              | CHANGE
              | CONTROL
              | DESTROY
	          | DISCARD
	          | 'do'
	          | DRAW
	          | OWN
	          | PLAY
	          | REGENERATE
	          | SHUFFLE
	          | ('un')? 'tap';

turnPart : 'untap'
         | 'upkeep'
         | 'draw'
         | 'declare'
         | 'attackers'
         | 'blockers'
         | COMBAT
         | 'damage'
         | 'end';
