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
              | abilityType SPACE OF SPACE object SPACE COSTS SPACE costs SPACE COMPARATIVE SPACE TO SPACE ACTIVATE PERIOD
              | damage SPACE IS SPACE DEALT SPACE TO SPACE object adverbInstead PERIOD
              | FOR SPACE EACH SPACE damage SPACE distinguisher COMMA SPACE triggerEffect PERIOD;

triggeredAbility : triggerCondition COMMA SPACE triggerEffect PERIOD;

// Spells

spellCard : spellAbility (NEWLINE spellAbility)*;

modal : CHOOSE SPACE ENGLISH_NUMBER DASH (NEWLINE BULLET SPACE effect PERIOD)+;

spellAbility : effect PERIOD
             | restriction PERIOD
             | modal
             | delayedTrigger COMMA SPACE effect PERIOD SPACE verbIgnore SPACE THIS SPACE EFFECT SPACE prepositionalPhrase PERIOD
             | duration COMMA SPACE adverbInstead SPACE OF SPACE verbDeclaring SPACE nounBlockers COMMA SPACE player SPACE CHOOSE SPACE object SPACE CONJUNCTION SPACE DIVIDE SPACE pronounThem SPACE IN SPACE ARTICLE SPACE nounNumber SPACE OF SPACE PILE SPACE adjectiveEqual SPACE TO SPACE amount PERIOD SPACE object SPACE MAY SPACE verbLikewise SPACE verbBe SPACE PUT SPACE IN SPACE ADDITIONAL SPACE PILE PERIOD SPACE verbAssign SPACE EACH SPACE PILE TO SPACE A SPACE adjectiveDifferent SPACE ONE OF SPACE object SPACE AT SPACE adjectiveRandom PERIOD SPACE SPACE objectPhrase PERIOD;

// Effects
anyTime : ANY SPACE TIME SPACE player SPACE verbCould SPACE ANY_PLAY SPACE A SPACE abilityType
        | ANY SPACE TIME SPACE player SPACE verbCould SPACE ANY_PLAY SPACE A SPACE CARD_TYPE;

continuousEffect : anyTime COMMA SPACE player SPACE MAY SPACE costs PERIOD SPACE effect
                 | player SPACE MAY SPACE costs SPACE anyTime PERIOD SPACE effect
                 | player SPACE CAN SPACE 'be' SPACE ATTACKED SPACE subordinateClause
                 | player SPACE CAN SPACE TAP SPACE object SPACE duration
                 | player SPACE DOES SPACE LOSE SPACE THE SPACE GAME SPACE prepositionalPhrase
                 | player SPACE HAS SPACE NO SPACE 'maximum' SPACE HAND SPACE 'size'
                 | player SPACE CONTROL SPACE player
                 | continuousObjectPhrase;

continuousObjectPhrase: object SPACE continuousObjectVerbPhrase;

continuousObjectVerbPhrase: continuousObjectVerbPhrase SPACE CONJUNCTION SPACE continuousObjectVerbPhrase
                          | IS SPACE object
                	      | CAN SPACE ATTACK (SPACE subordinateClause)?
             	          | CAN SPACE BLOCK SPACE object
                      	  | CAN 'be' SPACE BLOCKED
                      	  | CAN 'be' SPACE BLOCKED SPACE (EXCEPT)? 'by ' object
                      	  | CAN 'be' SPACE ENCHANTED SPACE 'by ' object
                          | GAINS SPACE keyword
                          | GAINS SPACE quotedAbility
                      	  | GETS SPACE statMod
                          | HAS SPACE quotedAbility
             	          | HAS SPACE ability
                          | LOSES SPACE quotedAbility;

replacementEffect : subordinateClause COMMA SPACE (SPACE adverbInstead)? effect (SPACE adverbInstead)?
                  | subordinateClause COMMA SPACE playerPhrase SPACE adverbInstead PERIOD SPACE subordinateClause COMMA SPACE effect
                  | subordinateClause COMMA SPACE playerVerbPhrase COMMA SPACE prepositionBut SPACE player SPACE MAY SPACE PUT SPACE object prepositionalPhrase SPACE adverbInstead SPACE OF SPACE prepositionalPhrase
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
       | source SPACE DEAL SPACE damage SPACE TO SPACE player SPACE adverbInstead
       | THE SPACE 'next time' SPACE source SPACE 'would' SPACE DEAL SPACE damageType SPACE TO SPACE something SPACE DURATION COMMA SPACE effect
       | 'The next ' damage ' that would be dealt' SPACE TO SPACE object SPACE duration SPACE IS SPACE DEALT SPACE TO SPACE player SPACE adverbInstead
       | subordinateClause ', flip ' object SPACE prepositionalPhrase '. If ' object ' turns over completely at least once during the flip, destroy all nontoken permanents it touches'
       | delayedTrigger COMMA SPACE REMOVE SPACE ALL COUNTER_TYPE COUNTER 'from a land that a' SPACE COUNTER_TYPE SPACE COUNTER SPACE 'was put onto with ' object ' but that a' SPACE COUNTER_TYPE SPACE COUNTER SPACE 'has ' NOT 'been removed from with ' object
       | delayedTrigger COMMA SPACE DESTROY SPACE object subordinateClause
       | player SPACE CHOOSE SPACE 'a number of lands they control equal ' TO SPACE amount ', then sacrifices the rest. Players discard cards and sacrifice creatures the same way'
       | player ' divides all creatures without flying they control into a “left” pile and a “right” pile. Then, for each attacking creature you control, ' verbChoose ' “left” or “right.” That creature can’t be blocked this ' COMBAT ' except by creatures with flying and creatures in a pile with the chosen label'
       | WHEN SPACE object SPACE 'leaves the battlefield' COMMA SPACE 'that creature’s controller sacrifices it'
       | player SPACE MAY SPACE PAY SPACE 'any amount' SPACE OF SPACE MANA
       | PREVENT VARIABLE SPACE OF SPACE damage COMMA SPACE 'where' SPACE variableDefinition
       | player SPACE MAY SPACE CHOOSE SPACE 'a creature card in your hand whose mana cost could be paid by some amount of, or all of, the mana you spent on {X}. If you do, you ' MAY ' cast that card face down as a 2/2 creature spell without paying its mana cost. If the creature that spell becomes as it resolves has' SPACE NOT SPACE 'been turned face up and would assign or deal damage, be dealt damage, or become tapped, instead it’s turned face up and assigns or deals damage, is dealt damage, or becomes tapped. Activate only as a sorcery.'
       | REMOVE SPACE object SPACE FROM SPACE COMBAT
       | player SPACE MAY SPACE HAS SPACE object SPACE BLOCK SPACE object
       | player SPACE ACTIVATE SPACE A SPACE MANA SPACE ABILITY SPACE 'of' SPACE object
       | player SPACE ADD SPACE THE SPACE MANA SPACE 'lost' SPACE THIS SPACE 'way'
       | 'If this ability has been activated four or ' COMPARATIVE ' times this turn, sacrifice ' object ' at the beginning of the next end step'
       | 'The player plays that card if able. While doing so, the player can activate mana abilities only if they’re from lands that player controls and only if mana they produce is spent ' TO ' activate other mana abilities of lands the player controls and/or ' TO ' play that card. If the chosen card is cast as a spell, you control the player while that spell is resolving'
       | objectPossesive SPACE characteristics SPACE IS ' each equal ' TO SPACE amount
       | phrase
       | playerVerbPhrase
       | player ' loses all unspent mana'
       | player MAY ' attach ' object SPACE TO SPACE object
       | object CAN SPACE 'be regenerated'
       | object CAN SPACE 'be regenerated this turn'
       | player SPACE MAY SPACE CHOOSE ' new targets ' prepositionalPhrase
       | THIS SPACE EFFECT SPACE DOES 'remove' SPACE object
       | THIS SPACE ABILITY SPACE CAN SPACE 'cause the total number ' OF SPACE COUNTER_TYPE SPACE COUNTER ' on ' object SPACE TO ' be ' amount
       | player SPACE GAINS SPACE LIFE SPACE 'equal ' TO ' the damage dealt, but' SPACE NOT SPACE COMPARATIVE ' life than the player’s life total before the damage was dealt, the planeswalker’s loyalty before the damage was dealt, or the creature’s toughness'
       | 'if it would die ' DURATION ', exile it' SPACE adverbInstead;

damage : DAMAGE
       | NUMBER SPACE DAMAGE
       | ALL SPACE COMBAT SPACE DAMAGE SPACE THAT SPACE 'would be dealt' SPACE duration
       | ALL SPACE DAMAGE SPACE THAT SPACE 'would be dealt ' TO SPACE player ' by ' object
       | ALL SPACE 'but' SPACE NUMBER SPACE OF SPACE damage
       | THAT SPACE damage
       | THE SPACE 'next' SPACE damage SPACE THAT SPACE 'would be' SPACE DEALT SPACE TO SPACE something SPACE duration;

// Definitions
amount : 'half ' amount COMMA ' rounded ' ('up'|'down')
       | 'up ' TO SPACE amount
       | COMPARATIVE ' than ' ENGLISH_NUMBER
       | ENGLISH_NUMBER (SPACE CONJUNCTION SPACE COMPARATIVE)?
       | objectPossessive SPACE characteristics
       | VARIABLE
       | ARTICLE SPACE 'number' SPACE OF SPACE object (' minus ' NUMBER)?
       | ARTICLE SPACE 'damage dealt ' TO SPACE player SPACE duration
       | playerPossessive SPACE LIFE ' total'
       | THAT SPACE 'many'
       | ANY SPACE 'number' SPACE OF
       | THE SPACE 'amount of mana that player paid this way'
       | THE SPACE 'damage prevented this way';

characteristics : characteristic (conjunction characteristic)?;

condition : object (SPACE)? IS SPACE TAPPED
          | object (SPACE)? IS SPACE ATTACKING
          | object (SPACE)? IS SPACE prepositionalPhrase
          | object (SPACE)? IS SPACE object
          | object SPACE HAS SPACE A SPACE COUNTER_TYPE SPACE COUNTER prepositionalPhrase
          | object SPACE HAS SPACE keyword
          | object SPACE 'had haste'
          | object SPACE 'didn’t have defender'
          | object SPACE 'wasn’t the first land you played' SPACE duration
          | object SPACE ATTACKED SPACE OR SPACE BLOCKED SPACE duration
          | object SPACE ATTACKED SPACE duration;

costs : (PAY SPACE)? cost (COMMA SPACE costs)?;

cost :(MANA_SYMBOL)+
     | TAP_SYMBOL
     | NUMBER SPACE LIFE
     | playerVerbPhrase;

determiner: DETERMINER
          | amount;

distinguisher : THAT 'would be' SPACE DEALT SPACE TO SPACE object;

duration : 'until end of' SPACE TURN
         | 'until end of' SPACE COMBAT
         | 'until' SPACE object SPACE 'leaves' SPACE zone
         | 'until' SPACE YOUR SPACE 'next' SPACE TURN
         | 'until' SPACE object SPACE 'finishes resolving'
         | THIS SPACE TURN
         | DETERMINER SPACE COMBAT
         | 'during' SPACE phase
         | FOR SPACE 'as long as ' object HAS A COUNTER_TYPE SPACE COUNTER SPACE prepositionalPhrase
         | 'as long as ' player ' control' SPACE object;

keyword : SIMPLE_KEYWORD
        | PROTECTION SPACE FROM SPACE COLOR
        | ENCHANT SPACE object;

object : OBJECT
       | (premodifier SPACE)+ object
       | OBJECT (SPACE postmodifier)+
       | OBJECT
       | (OBJECT COMMA SPACE)* OBJECT SPACE CONJUNCTION OBJECT;

objectPossesive : object saxon;

objectPhrase : object SPACE objectVerbPhrase;

objectVerbPhrase : IS SPACE DEALT damage
                 | IS SPACE TAPPED prepositionalPhrase
                 | IS SPACE PUT SPACE prepositionalPhrase SPACE prepositionalPhrase
                 | IS SPACE COLOR
                 | ENTERS SPACE zone TAPPED
                 | LEAVES SPACE zone
                 | BLOCKS SPACE object (' if able')?
                 | ATTACKS SPACE duration ' if able'
                 | BLOCKS SPACE OR SPACE BECOMES SPACE 'blocked by ' object
                 | DEAL SPACE damage SPACE TO SPACE player
                 | DOES SPACE TAP SPACE duration
                 | DOES SPACE 'so'
                 | COST SPACE costs SPACE COMPARATIVE SPACE TO SPACE CAST
             	 | GAINS SPACE KEYWORD SPACE AND SPACE GETS SPACE STAT_MOD SPACE duration ', where X is ' amount
                 | GAINS '"Enchanted creature loses flying"'
             	 | BECOMES SPACE BLOCKED
             	 | DEAL SPACE damage SPACE TO SPACE something
                 | DEAL SPACE damage SPACE TO SPACE something SPACE AND SPACE damage SPACE TO SPACE something
                 | DEAL SPACE damage SPACE TO SPACE something COMMA SPACE 'where X is ' amount
                 | DEAL SPACE damage SPACE TO SPACE something SPACE 'equal' SPACE TO SPACE amount
                 | DEAL SPACE damage SPACE 'equal' SPACE TO SPACE amount SPACE TO SPACE something
                 | DEAL SPACE damage SPACE 'divided evenly, rounded down, among any number of targets';

postmodifier : player SPACE CONTROL
             | player ' controlled at the beginning of this turn'
             | player ' has controlled continuously since the beginning of the turn'
             | player ' didn’t ' CONTROL ' continuously since the beginning of the turn'
             | 'controlled by ' player
             | prepositionalPhrase
             | 'named Plague Rats' SPACE prepositionalPhrase
             | 'able ' TO ' block ' object
             | THAT SPACE CAN BLOCK object
             | THAT SPACE IS ' still ' object
             | OTHER SPACE 'than ' object
             | THAT SPACE 'didn’t ' ATTACK SPACE DURATION
             | THAT SPACE CAN SPACE BLOCK SPACE 'additional creatures'
             | object ' was blocking that had become blocked by ' object SPACE DURATION
             | PUT prepositionalPhrase ' this way'
             | 'dealt damage by ' object SPACE DURATION
             | 'with' SPACE keyword SPACE CONJUNCTION SPACE keyword
             | 'in a pile'
             | 'that pile is assigned ' TO
             | 'of your choice'
             | 'of an opponent’s choice'
             | ' of their choice'
             | 'of' SPACE zone;

premodifier : (negation (SPACE|DASH))? adjective
            | (negation (SPACE|DASH))? COLOR
            | determiner
            | TYPE
            | NUMBER SLASH NUMBER;

prepositionalPhrase : prepositionalPhrase SPACE prepositionalPhrase
                    | PREPOSITION SPACE zone
                    | PREPOSITION SPACE object
                    | WITH SPACE quality
                    | WITH SPACE amount SPACE COUNTER_TYPE COUNTERS
                    | FOR SPACE MANA
                    | FOR SPACE EACH SPACE 'creature that died' SPACE duration
                    | FOR SPACE EACH SPACE 'target beyond the first'
                    | FOR SPACE 'having' SPACE amount SPACE LIFE
                    | FOR SPACE 'whom that player is the defending player'
                    | FROM SPACE A 'height of at least one foot'
                    | UNDER SPACE playerPossessive SPACE CONTROL
                    | ON SPACE TOP SPACE OF SPACE zone;

phase : playerPossessive SPACE TURN
      | playerPossessive SPACE rawPhase
      | ARTICLE SPACE rawPhase ' of ' objectPossesive SPACE CONTROLLER
      | ARTICLE SPACE rawPhase
      | ARTICLE SPACE playerPossessive TURN COMMA ' before attackers are declared'
      | ARTICLE SPACE 'next' SPACE rawPhase
      | COMBAT
      | COMBAT SPACE 'before blockers are declared'
      | THE TURN
      | EACH 'of ' playerPossessive ' upkeeps for the rest of the game'
      | THE 'next end ' STEP;

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
                 | playerVerb SPACE object (SPACE prepositionAt SPACE adjectiveRandom)?
                 | playerVerb SPACE player
                 | playerVerb SPACE object SPACE prepositionalPhrase
                 | playerVerb SPACE ARTICLE SPACE 'amount of ' MANA_SYMBOL ' equal ' TO SPACE amount
                 | playerVerb SPACE amount SPACE MANA SPACE 'of any ' ('one' SPACE)? 'color'
                 | playerVerb SPACE amount SPACE MANA SPACE 'of any type that land produced'
                 | playerVerb SPACE ARTICLE SPACE 'additional ' MANA_SYMBOL
                 | playerVerb SPACE ARTICLE SPACE 'text of ' object ' by replacing all instances of one ' textAspect ' with another'
                 | playerVerb SPACE ARTICLE SPACE textAspect
                 | playerVerb SPACE zone
                 | '’re dealt damage'
                 | ADD SPACE MANA_SYMBOL+
                 | ATTACH SPACE object SPACE TO SPACE object
                 | COPY SPACE object COMMA SPACE subordinateClause
                 | COUNTER SPACE object (' unless its controller pays {X}. If that player doesn’t, they tap all lands with mana abilities they control and lose all unspent mana')
                 | CHOOSE SPACE object
                 | CHOOSE SPACE object SPACE prepositionalPhrase
                 | CREATE SPACE 'a 1/1 colorless Insect artifact creature token with flying named Wasp'
                 | DESTROY SPACE object
                 | DESTROY SPACE object SPACE delayedTrigger
                 | DESTROY SPACE object SPACE delayedTrigger SPACE 'if it didn’t attack this turn'
                 | EXCHANGE SPACE object SPACE 'with' SPACE object
                 | EXILE SPACE object
                 | GAINS SPACE LIFE ' equal ' TO SPACE amount
                 | GAINS SPACE NUMBER SPACE LIFE
                 | GAINS SPACE LIFE SPACE 'equal ' TO SPACE amount
                 | LOOK SPACE AT SPACE object ', then put them back in any order'
                 | LOOK SPACE AT SPACE zone
                 | LOSE SPACE THE SPACE 'game'
                 | LOSE SPACE LIFE SPACE 'equal ' TO SPACE amount
                 | LOSE SPACE 'half their' SPACE LIFE ', rounded up'
                 | LOSE SPACE ALL SPACE 'unspent' SPACE MANA
                 | PUT SPACE object SPACE prepositionalPhrase
                 | PUT SPACE amount SPACE COUNTER_TYPE COUNTER ' on ' object (prepositionalPhrase)?
                 | REMOVE SPACE ARTICLE SPACE COUNTER_TYPE SPACE COUNTER SPACE prepositionalPhrase
                 | RETURN SPACE object SPACE prepositionalPhrase
                 | RETURN SPACE object SPACE prepositionalPhrase
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
                 | SHUFFLE 'their hand' SPACE AND SPACE 'graveyard' SPACE prepositionalPhrase;

delayedTrigger : AT SPACE 'end of' SPACE COMBAT
               | AT SPACE THE 'beginning of ' phase;

quality : MANA VALUE SPACE NUMBER
        | POWER SPACE amount
        | TOUGHNESS SPACE amount
        | POWER SPACE AND SPACE TOUGHNESS SPACE EACH ' equal ' TO SPACE amount
        | SIMPLE_KEYWORD;

quotedAbility : OPENQUOTE ability CLOSEQUOTE;

rawPhase : turnPart
         | (turnPart SPACE)? turnPart SPACE STEP;

restriction : CAST SPACE object ' only during ' phase
            | CAST object ' only before ' phase
            | SPEND SPACE 'only ' COLOR SPACE MANA SPACE 'on' VARIABLE
            | 'As an additional cost ' TO SPACE CAST ' this spell, ' costs
            | object SPACE COSTS costs SPACE COMPARATIVE SPACE TO SPACE CAST prepositionalPhrase
            | ACTIVATE SPACE 'only during ' phase ('and only once each turn')?
            | ACTIVATE SPACE 'only during an opponent’s ' TURN ', before attackers are declared'
            | REMOVE SPACE object SPACE prepositionalPhrase SPACE 'before playing if you’re' SPACE NOT SPACE 'playing ' FOR ' ante'
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
                  | SUBORDINATE_CONJUNCTION SPACE player ' would begin your turn while ' condition
                  | IF SPACE AN SPACE 'effect causes ' player SPACE TO SPACE 'discard a card'
                  | EXCEPT SPACE object '’s' SPACE object ' in addition' SPACE TO SPACE 'its other types'
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
