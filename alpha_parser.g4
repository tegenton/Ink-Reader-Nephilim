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
              | abilityType SPACE OF SPACE object SPACE COST SPACE costs SPACE COMPARATIVE SPACE TO SPACE ACTIVATE PERIOD
              | damage SPACE IS SPACE DEALT SPACE TO SPACE object INSTEAD PERIOD
              | FOR SPACE EACH SPACE damage SPACE distinguisher COMMA SPACE triggerEffect PERIOD;

abilityType: (ACTIVATED | MANA) SPACE ABILITY;

counterType: COUNTER_TYPE SPACE COUNTER;

triggeredAbility : triggerCondition COMMA SPACE triggerEffect PERIOD;

// Spells

spellCard : spellAbility (NEWLINE spellAbility)*;

modal : CHOOSE SPACE ENGLISH_NUMBER DASH (NEWLINE BULLET SPACE effect PERIOD)+;

spellAbility : effect PERIOD
             | restriction PERIOD
             | modal
             | delayedTrigger COMMA SPACE effect PERIOD SPACE IGNORE SPACE THIS SPACE EFFECT SPACE prepositionalPhrase PERIOD
             | duration COMMA SPACE INSTEAD SPACE OF SPACE DECLARING SPACE BLOCKERS COMMA SPACE player SPACE CHOOSE SPACE object SPACE CONJUNCTION SPACE DIVIDE SPACE THEM SPACE IN SPACE ARTICLE SPACE NUMBER SPACE OF SPACE PILE SPACE EQUAL SPACE TO SPACE amount PERIOD SPACE object SPACE MAY SPACE LIKEWISE SPACE BE SPACE PUT SPACE IN SPACE ADDITIONAL SPACE PILE PERIOD SPACE ASSIGN SPACE EACH SPACE PILE TO SPACE A SPACE DIFFERENT SPACE ONE OF SPACE object SPACE prepositionalPhrase PERIOD SPACE SPACE objectPhrase PERIOD;

// Effects
anyTime : ANY SPACE TIME SPACE player SPACE COULD SPACE ANY_PLAY SPACE A SPACE playableType;

playableType: CARD_TYPE | abilityType;

continuousEffect : anyTime COMMA SPACE player SPACE MAY SPACE costs PERIOD SPACE effect
                 | player SPACE MAY SPACE costs SPACE anyTime PERIOD SPACE effect
                 | player SPACE CAN SPACE BE SPACE ATTACKED SPACE subordinateClause
                 | player SPACE CAN SPACE TAP SPACE object SPACE duration
                 | player SPACE DO SPACE LOSE SPACE THE SPACE GAME SPACE prepositionalPhrase
                 | player SPACE HAVE SPACE NO SPACE MAXIMUM SPACE HAND SPACE SIZE
                 | player SPACE CONTROL SPACE player
                 | continuousObjectPhrase;

continuousObjectPhrase: object SPACE continuousObjectVerbPhrase;

continuousObjectVerbPhrase: continuousObjectVerbPhrase SPACE CONJUNCTION SPACE continuousObjectVerbPhrase
                          | IS SPACE object
                	      | CAN SPACE ATTACK (SPACE subordinateClause)?
             	          | CAN SPACE BLOCK SPACE object
                      	  | CAN BE SPACE BLOCKED
                      	  | CAN BE SPACE BLOCKED SPACE (EXCEPT)? SPACE BY object
                      	  | CAN BE SPACE ENCHANTED SPACE BY SPACE object
                          | GAIN SPACE keyword
                          | GAIN SPACE quotedAbility
                      	  | GET SPACE STAT_MOD
                          | HAVE SPACE quotedAbility
             	          | HAVE SPACE ability
                          | LOSE SPACE quotedAbility;

replacementEffect : subordinateClause COMMA SPACE (SPACE INSTEAD)? effect (SPACE INSTEAD)?
                  | subordinateClause COMMA SPACE playerPhrase SPACE INSTEAD PERIOD SPACE subordinateClause COMMA SPACE effect
                  | subordinateClause COMMA SPACE playerVerbPhrase COMMA SPACE BUT SPACE player SPACE MAY SPACE PUT SPACE object prepositionalPhrase SPACE INSTEAD SPACE OF SPACE prepositionalPhrase
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
       | source SPACE DEAL SPACE damage SPACE TO SPACE player SPACE INSTEAD
       | THE SPACE NEXT TIME SPACE source SPACE WOULD SPACE DEAL SPACE COMBAT DAMAGE SPACE TO SPACE something SPACE duration COMMA SPACE effect
       | THE SPACE NEXT damage SPACE THAT SPACE WOULD SPACE BE SPACE DEALT SPACE TO SPACE object SPACE duration SPACE IS SPACE DEALT SPACE TO SPACE player SPACE INSTEAD
       | delayedTrigger COMMA SPACE REMOVE SPACE ALL SPACE counterType SPACE FROM SPACE object
       | delayedTrigger COMMA SPACE DESTROY SPACE object subordinateClause
       | WHEN SPACE object SPACE LEAVE SPACE ZONE COMMA SPACE player SACRIFICE object
       | SACRIFICE SPACE object delayedTrigger
       | 'The player plays that card if ' ABLE
       | 'While doing so, the player can activate mana abilities only if they’re from lands that player controls and only if mana they produce is spent ' TO ' activate other mana abilities of lands the player controls and/or ' TO ' play that card'
       | 'If the chosen card is cast as a spell, you control the player while that spell is resolving'
       | objectPossessive SPACE characteristics SPACE IS SPACE EACH SPACE EQUAL TO SPACE amount
       | phrase
       | playerVerbPhrase
       | object CAN SPACE BE SPACE REGENERATED
       | object CAN SPACE BE SPACE REGENERATED duration
       | THIS SPACE EFFECT SPACE DO REMOVE SPACE object
       | THIS SPACE ABILITY SPACE CAN SPACE CAUSE SPACE THE SPACE TOTAL SPACE NUMBER OF SPACE counterType prepositionalPhrase
       | EXILE object SPACE INSTEAD;

damage : DAMAGE
       | NUMBER SPACE DAMAGE
       | ALL SPACE COMBAT SPACE DAMAGE SPACE THAT SPACE WOULD SPACE BE SPACE DEALT SPACE duration
       | ALL SPACE DAMAGE SPACE THAT SPACE WOULD SPACE BE SPACE DEALT SPACE TO SPACE player SPACE BY SPACE object
       | ALL SPACE BUT SPACE NUMBER SPACE OF SPACE damage
       | THAT SPACE damage
       | THE SPACE NEXT SPACE damage SPACE THAT SPACE WOULD SPACE BE SPACE DEALT SPACE TO SPACE something SPACE duration;

// Definitions
amount : HALF SPACE amount COMMA SPACE ROUNDED SPACE (ROUND_DIRECTION)
       | UP SPACE TO SPACE amount
       | COMPARATIVE SPACE THAN SPACE ENGLISH_NUMBER
       | ENGLISH_NUMBER (SPACE CONJUNCTION SPACE COMPARATIVE)?
       | objectPossessive SPACE characteristics
       | VARIABLE
       | ARTICLE SPACE NUMBER SPACE OF SPACE object (SPACE MINUS SPACE NUMBER)?
       | ANY SPACE NUMBER SPACE OF
       | damage SPACE DEALT SPACE TO SPACE player SPACE duration
       | playerPossessive SPACE LIFE SPACE TOTAL
       | THAT SPACE MANY
       | THE SPACE AMOUNT SPACE OF SPACE MANA SPACE THAT SPACE PLAYER SPACE PAID SPACE THIS SPACE WAY
       | damage SPACE PREVENTED SPACE THIS SPACE WAY
       | ANY SPACE AMOUNT;

characteristics: CHARACTERISTIC (SPACE CONJUNCTION SPACE CHARACTERISTIC)*;

condition : object (SPACE)? IS SPACE TAPPED
          | object (SPACE)? IS SPACE ATTACKING
          | object (SPACE)? IS SPACE prepositionalPhrase
          | object (SPACE)? IS SPACE object
          | object SPACE HAVE SPACE A SPACE counterType SPACE prepositionalPhrase
          | object SPACE HAVE SPACE keyword
          | object SPACE HAD SPACE keyword
          | object SPACE DID SPACE HAVE keyword
          | object SPACE WAS SPACE THE SPACE FIRST SPACE object SPACE YOU SPACE PLAYED duration
          | object SPACE ATTACKED SPACE OR SPACE BLOCKED SPACE duration
          | object SPACE ATTACKED SPACE duration;

costs : (PAY SPACE)? cost (COMMA SPACE costs)?;

cost :(MANA_SYMBOL)+
     | TAP_SYMBOL
     | NUMBER SPACE LIFE
     | playerVerbPhrase;

determiner: DETERMINER
          | amount;

distinguisher : THAT SPACE WOULD SPACE BE SPACE DEALT SPACE TO SPACE object;

duration : UNTIL SPACE END SPACE OF SPACE TURN
         | UNTIL SPACE END SPACE OF SPACE COMBAT
         | UNTIL SPACE object SPACE LEAVE SPACE zone
         | UNTIL SPACE YOUR SPACE NEXT SPACE TURN
         | UNTIL SPACE object SPACE FINISHES SPACE RESOLVING
         | THIS SPACE TURN
         | DETERMINER SPACE COMBAT
         | DURING SPACE phase
         | FOR SPACE AS SPACE LONG SPACE AS SPACE object HAVE A counterType SPACE prepositionalPhrase
         | AS SPACE LONG SPACE AS SPACE player SPACE CONTROL SPACE object;

keyword : SIMPLE_KEYWORD
        | PROTECTION SPACE FROM SPACE COLOR
        | ENCHANT SPACE object;

object : OBJECT
       | (premodifier SPACE)+ object
       | OBJECT (SPACE postmodifier)+
       | OBJECT
       | (OBJECT COMMA SPACE)* OBJECT SPACE CONJUNCTION OBJECT
       | 'a land that a' SPACE counterType SPACE 'was put onto with ' object ' but that a' SPACE counterType SPACE 'has ' NOT 'been removed from with ' object;

objectPhrase : object SPACE objectVerbPhrase;

objectPossessive: object SAXON;

objectVerbPhrase : IS SPACE DEALT SPACE damage
                 | IS SPACE TAPPED SPACE prepositionalPhrase
                 | IS SPACE PUT SPACE prepositionalPhrase
                 | IS SPACE COLOR
                 | ATTACK SPACE duration SPACE IF SPACE ABLE
             	 | BECOME SPACE BLOCKED
                 | BLOCK SPACE object (SPACE IF SPACE ABLE)?
                 | BLOCK SPACE OR SPACE BECOME SPACE BLOCKED SPACE BY SPACE object
                 | COST SPACE costs SPACE COMPARATIVE SPACE TO SPACE CAST
             	 | DEAL SPACE damage SPACE TO SPACE something
                 | DEAL SPACE damage SPACE TO SPACE something SPACE AND SPACE damage SPACE TO SPACE something
                 | DEAL SPACE damage SPACE TO SPACE something COMMA SPACE subordinateClause
                 | DEAL SPACE damage SPACE TO SPACE something SPACE EQUAL SPACE TO SPACE amount
                 | DEAL SPACE damage SPACE EQUAL SPACE TO SPACE amount SPACE TO SPACE something
                 | DEAL SPACE damage SPACE 'divided evenly, rounded down, among any number of targets'
                 | DO SPACE TAP SPACE duration
                 | DO SPACE SO
                 | ENTER SPACE zone TAPPED
             	 | GAIN SPACE keyword SPACE AND SPACE GET SPACE STAT_MOD SPACE duration COMMA SPACE subordinateClause
                 | GAIN SPACE quotedAbility
                 | LEAVE SPACE zone
                 | LOSE SPACE keyword;

postmodifier : player SPACE CONTROL
             | player ' controlled at the beginning of this turn'
             | player ' has controlled continuously since the beginning of the turn'
             | player ' didn’t ' CONTROL ' continuously since the beginning of the turn'
             | 'controlled by ' player
             | prepositionalPhrase
             | 'named Plague Rats' SPACE prepositionalPhrase
             | ABLE SPACE TO SPACE BLOCK SPACE object
             | THAT SPACE CAN BLOCK object
             | THAT SPACE IS ' still ' object
             | OTHER SPACE 'than ' object
             | THAT SPACE 'didn’t ' ATTACK SPACE duration
             | THAT SPACE CAN SPACE BLOCK SPACE 'additional creatures'
             | object ' was blocking that had become blocked by ' object SPACE DURATION
             | PUT prepositionalPhrase ' this way'
             | 'dealt damage by ' object SPACE DURATION
             | 'with' SPACE keyword SPACE CONJUNCTION SPACE keyword
             | 'in a pile'
             | 'that pile is assigned ' TO
             | 'of your choice'
             | 'of an opponent’s choice'
             | 'of their choice'
             | 'that died' SPACE duration
             | 'beyond the first';

premodifier : ADJECTIVE
            | COLOR
            | determiner
            | TYPE
            | NUMBER SLASH NUMBER;

prepositionalPhrase : prepositionalPhrase SPACE prepositionalPhrase
                    | PREPOSITION SPACE zone
                    | PREPOSITION SPACE object
                    | WITH SPACE quality
                    | WITH SPACE amount SPACE counterType
                    | FOR SPACE MANA
                    | FOR SPACE 'having' SPACE amount SPACE LIFE
                    | FOR SPACE 'whom that player is the defending player'
                    | FROM SPACE A 'height of at least one foot'
                    | UNDER SPACE playerPossessive SPACE CONTROL
                    | ON SPACE TOP SPACE OF SPACE zone
                    | AT SPACE RANDOM
                    | TO SPACE BE SPACE amount;

delayedTrigger : AT SPACE 'end of' SPACE COMBAT
               | AT SPACE THE 'beginning of ' phase;

phase : playerPossessive SPACE TURN
      | playerPossessive SPACE rawPhase
      | ARTICLE SPACE rawPhase SPACE OF SPACE player
      | ARTICLE SPACE rawPhase
      | ARTICLE SPACE playerPossessive TURN COMMA ' before attackers are ' DECLARED
      | ARTICLE SPACE 'next' SPACE rawPhase
      | COMBAT
      | COMBAT SPACE 'before ' BLOCKERS ' are ' DECLARED
      | THE TURN
      | EACH SPACE OF SPACE playerPossessive ' upkeeps for the rest of the game'
      | THE SPACE 'next end' SPACE STEP;

phrase : playerPhrase
       | objectPhrase;

player : ANY_PLAYER
       | determiner SPACE player
       | playerPremodifier SPACE player
       | ANY_PLAYER playerPostmodifier
       | objectPossessive ANY_PLAYER
       | 'the chosen player';

playerPremodifier: 'active' | 'chosen' | 'defending';

playerPostmodifier: 'who controls the fewest';

playerPhrase : player SPACE playerVerbPhrase;

playerPossessive : YOUR
                 | THEIR
                 | player SAXON;

playerVerbPhrase : MAY SPACE playerVerbPhrase
                 | CHANGE SPACE ARTICLE SPACE 'text of ' object ' by replacing all instances of one ' textAspect ' with another'
                 | CHOOSE SPACE ARTICLE SPACE textAspect
                 | '’re dealt damage'
                 | ADD SPACE MANA_SYMBOL+
                 | ADD SPACE ARTICLE SPACE 'amount of ' MANA_SYMBOL ' equal ' TO SPACE amount
                 | ADD SPACE amount SPACE MANA SPACE 'of any ' ('one' SPACE)? 'color'
                 | ADD SPACE amount SPACE MANA SPACE 'of any type that land produced'
                 | ADD SPACE ARTICLE SPACE 'additional ' MANA_SYMBOL
                 | ATTACH SPACE object SPACE TO SPACE object
                 | COPY SPACE object COMMA SPACE subordinateClause
                 | COUNTER SPACE object (' unless its controller pays {X}. If that player doesn’t, they tap all lands with mana abilities they control and lose all unspent mana')
                 | CHOOSE SPACE object
                 | CHOOSE ' new targets ' prepositionalPhrase
                 | CHOOSE SPACE object SPACE prepositionalPhrase
                 | CREATE SPACE 'a 1/1 colorless Insect artifact creature token with flying named Wasp'
                 | DESTROY SPACE object
                 | DESTROY SPACE object SPACE delayedTrigger
                 | DESTROY SPACE object SPACE delayedTrigger SPACE 'if it didn’t attack this turn'
                 | EXCHANGE SPACE object SPACE WITH SPACE object
                 | EXILE SPACE object
                 | FLIP SPACE object SPACE prepositionalPhrase PERIOD SPACE IF object ' turns over completely at least once during the flip, destroy all nontoken permanents it touches'
                 | GAIN SPACE LIFE SPACE EQUAL SPACE TO SPACE amount
                 | GAIN SPACE NUMBER SPACE LIFE
                 | GAIN SPACE LIFE SPACE EQUAL SPACE TO ' the damage dealt, but' SPACE NOT SPACE COMPARATIVE ' life than the player’s life total before the damage was dealt, the planeswalker’s loyalty before the damage was dealt, or the creature’s toughness'
                 | GAIN SPACE LIFE SPACE EQUAL SPACE TO SPACE amount
                 | LOOK SPACE AT SPACE object ', then put them back in any order'
                 | LOOK SPACE AT SPACE zone
                 | LOSE SPACE THE SPACE 'game'
                 | LOSE SPACE LIFE SPACE EQUAL SPACE TO SPACE amount
                 | LOSE SPACE 'half their' SPACE LIFE ', rounded up'
                 | LOSE SPACE ALL SPACE 'unspent' SPACE MANA
                 | PUT SPACE object SPACE prepositionalPhrase
                 | PUT SPACE amount SPACE counterType ' on ' object (prepositionalPhrase)?
                 | REMOVE SPACE ARTICLE SPACE counterType SPACE prepositionalPhrase
                 | RETURN SPACE object SPACE prepositionalPhrase
                 | RETURN SPACE object SPACE prepositionalPhrase
                 | SACRIFICE SPACE object (subordinateClause)?
                 | SEARCH SPACE zone SPACE prepositionalPhrase
                 | SKIPS SPACE phase
                 | SKIPS SPACE THAT SPACE (TURN|DRAW)
                 | TAKE SPACE AN SPACE 'extra' SPACE TURN SPACE 'after' SPACE THIS SPACE ONE
                 | HAVE object SPACE ENTER SPACE zone SPACE 'as a copy of any' SPACE object SPACE 'on' SPACE zone (SPACE prepositionalPhrase)?
                 | HAVE player SHUFFLE
                 | SPEND SPACE COLOR SPACE MANA 'as though it were ' COLOR SPACE MANA
                 | PLAY SPACE object SPACE 'on each of your turns'
                 | ANTE SPACE object
                 | costs
                 | effect
                 | TAP SPACE OR SPACE TAP SPACE object
                 | SHUFFLE SPACE zone SPACE prepositionalPhrase
                 | CHOOSE SPACE 'a number of lands they control equal ' TO SPACE amount ', then sacrifices the rest. Players discard cards and sacrifice creatures the same way'
                 | DIVIDE SPACE 'all creatures without flying they control into a “left” pile and a “right” pile. Then, for each attacking creature you control, ' CHOOSE ' “left” or “right.” That creature can’t be blocked this ' COMBAT ' except by creatures with flying and creatures in a pile with the chosen label'
                 | MAY SPACE PAY SPACE amount SPACE OF SPACE MANA
                 | MAY SPACE CHOOSE SPACE 'a creature card in your hand whose mana cost ' COULD ' be paid by some amount of, or all of, the mana you spent on {X}. If you do, you ' MAY ' cast that card face down as a 2/2 creature spell without paying its mana cost. If the creature that spell becomes as it resolves has' SPACE NOT SPACE 'been turned face up and would assign or deal damage, be dealt damage, or become tapped, ' INSTEAD ' it’s turned face up and assigns or deals damage, is dealt damage, or becomes tapped. Activate only as a sorcery.'
                 | MAY SPACE HAVE SPACE object SPACE BLOCK SPACE object
                 | ACTIVATE SPACE A SPACE MANA SPACE ABILITY SPACE OF SPACE object
                 | ADD SPACE THE SPACE MANA SPACE LOST SPACE THIS SPACE WAY
                 | PREVENT VARIABLE SPACE OF SPACE damage COMMA SPACE subordinateClause
                 | REMOVE SPACE object SPACE FROM SPACE COMBAT;

quality : MANA VALUE SPACE NUMBER
        | POWER SPACE amount
        | TOUGHNESS SPACE amount
        | POWER SPACE AND SPACE TOUGHNESS SPACE EACH SPACE EQUAL SPACE TO SPACE amount
        | SIMPLE_KEYWORD;

quotedAbility : OPENQUOTE ability CLOSEQUOTE;

rawPhase : turnPart
         | (turnPart SPACE)? turnPart SPACE STEP;

restriction : CAST SPACE object SPACE ONLY SPACE 'during' SPACE phase
            | CAST object SPACE ONLY SPACE 'before' SPACE phase
            | SPEND SPACE ONLY SPACE COLOR SPACE MANA SPACE ON VARIABLE
            | AS SPACE AN SPACE ADDITIONAL SPACE COST SPACE TO SPACE CAST object COMMA SPACE costs
            | object SPACE COST costs SPACE COMPARATIVE SPACE TO SPACE CAST prepositionalPhrase
            | ACTIVATE SPACE ONLY SPACE 'during' SPACE phase (SPACE 'and only once each turn')?
            | ACTIVATE SPACE ONLY SPACE 'during' SPACE playerPossessive SPACE TURN COMMA SPACE 'before attackers are ' DECLARED
            | REMOVE SPACE object SPACE prepositionalPhrase SPACE 'before playing if you’re' SPACE NOT SPACE PLAYING SPACE FOR SPACE ANTE
            | ONLY SPACE player SPACE MAY SPACE ACTIVATE SPACE THIS SPACE ABILITY;

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
                  | SUBORDINATE_CONJUNCTION SPACE player SPACE WOULD SPACE DRAW SPACE object SPACE duration
                  | SUBORDINATE_CONJUNCTION SPACE player SPACE WOULD SPACE GAIN SPACE LIFE
                  | SUBORDINATE_CONJUNCTION SPACE player SPACE WOULD SPACE 'begin your turn while ' condition
                  | IF SPACE AN SPACE EFFECT SPACE CAUSE SPACE player SPACE TO SPACE DISCARD SPACE object
                  | IF SPACE object SPACE WOULD SPACE DIE SPACE duration
                  | 'If this ability has been activated four or ' COMPARATIVE ' times ' duration
                  | EXCEPT SPACE object IS SPACE ARTICLE SPACE CARD_TYPE SPACE IN SPACE ADDITION SPACE TO SPACE objectPossessive OTHER 'types'
                  | EXCEPT SPACE object SPACE DO SPACE 'copy that creature’s color and it has “At the beginning of your upkeep, you may have this creature become a copy of target creature, except it doesn’t copy that creature’s color and it has this ability.”'
                  | EXCEPT SPACE object SPACE IS SPACE COLOR
                  | EXCEPT SPACE BY SPACE object
                  | WHERE variableDefinition;

textAspect : 'color word'
           | 'basic land type';

triggerCondition : TRIGGER_WORD SPACE triggerEvent (COMMA SPACE subordinateClause)?;

triggerEvent : THE SPACE BEGINNING SPACE OF SPACE phase
             | END SPACE OF SPACE COMBAT
             | phrase;

type : TYPE
     | 'chosen type';

zone : playerPossessive SPACE ZONE
     | ARTICLE SPACE ZONE
     | THEIR SPACE HAND SPACE AND SPACE GRAVEYARD;

turnPart : TAP
         | UPKEEP
         | DRAW
         | DECLARE
         | ATTACKERS
         | BLOCKERS
         | COMBAT
         | DAMAGE
         | END;