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
                 | player SPACE CONTROL SPACE something
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
         | DETERMINER SPACE TURN
         | DETERMINER SPACE COMBAT
         | DURING SPACE phase
         | FOR SPACE AS SPACE LONG SPACE AS SPACE object HAVE A counterType SPACE prepositionalPhrase
         | AS SPACE LONG SPACE AS SPACE player SPACE CONTROL SPACE object
         | WHILE SPACE object SPACE IS SPACE RESOLVING;

keyword : SIMPLE_KEYWORD
        | PROTECTION SPACE FROM SPACE COLOR
        | ENCHANT SPACE object;

object : OBJECT
       | (premodifier SPACE)+ object
       | OBJECT (SPACE postmodifier)+
       | OBJECT
       | (OBJECT COMMA SPACE)* OBJECT SPACE CONJUNCTION OBJECT;

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
                 | DEAL SPACE damage SPACE DIVIDED SPACE EVENLY COMMA SPACE ROUNDED SPACE ROUND_DIRECTION COMMA SPACE AMONG SPACE object
                 | DO SPACE TAP SPACE duration
                 | DO SPACE SO
                 | ENTER SPACE zone TAPPED
             	 | GAIN SPACE keyword SPACE AND SPACE GET SPACE STAT_MOD SPACE duration COMMA SPACE subordinateClause
                 | GAIN SPACE quotedAbility
                 | LEAVE SPACE zone
                 | LOSE SPACE keyword;

postmodifier : player SPACE CONTROL
             | player SPACE CONTROLLED SPACE AT SPACE THE SPACE BEGINNING SPACE OF SPACE duration
             | player SPACE HAVE SPACE CONTROLLED SPACE CONTINUOUSLY SPACE SINCE SPACE THE SPACE BEGINNING SPACE OF duration
             | player SPACE DID SPACE CONTROL SPACE CONTINUOUSLY SPACE SINCE SPACE THE SPACE BEGINNING SPACE OF duration
             | CONTROLLED SPACE BY SPACE player
             | prepositionalPhrase
             | NAMED SPACE LITERAL_NAME SPACE prepositionalPhrase
             | ABLE SPACE TO SPACE BLOCK SPACE object
             | THAT SPACE CAN BLOCK object
             | THAT SPACE IS SPACE STILL SPACE object
             | THAT SPACE DID SPACE ATTACK SPACE duration
             | THAT SPACE CAN SPACE BLOCK SPACE ADDITIONAL object
             | THAT SPACE HAD SPACE BECOME SPACE BLOCKED SPACE BY SPACE object SPACE duration
             | THAT SPACE PILE SPACE IS SPACE ASSIGNED SPACE TO
             | THAT SPACE DIED SPACE duration
             | OTHER SPACE THAN SPACE object
             | object SPACE WAS SPACE BLOCKING
             | PUT prepositionalPhrase SPACE THIS SPACE WAY
             | DEALT SPACE DAMAGE SPACE BY SPACE object SPACE duration
             | IN SPACE A SPACE PILE
             | BEYOND SPACE THE SPACE FIRST
             | THAT SPACE A SPACE counterType SPACE WAS SPACE PUT SPACE ON SPACE WITH SPACE object SPACE BUT SPACE THAT SPACE A SPACE counterType SPACE HAVE SPACE NOT BEEN REMOVED FROM WITH object;

premodifier : ADJECTIVE
            | COLOR
            | determiner
            | CHOSEN
            | type
            | NUMBER SLASH NUMBER;

prepositionalPhrase : prepositionalPhrase SPACE prepositionalPhrase
                    | PREPOSITION SPACE zone
                    | PREPOSITION SPACE object
                    | WITH SPACE quality
                    | WITH SPACE amount SPACE counterType
                    | WITH SPACE keyword SPACE CONJUNCTION SPACE keyword
                    | FOR SPACE MANA
                    | FOR SPACE HAVING SPACE amount SPACE LIFE
                    | FOR SPACE WHOM SPACE THAT SPACE PLAYER SPACE IS SPACE THE SPACE DEFENDING SPACE PLAYER
                    | FROM SPACE A SPACE HEIGHT SPACE OF SPACE AT SPACE LEAST SPACE ONE SPACE FOOT
                    | UNDER SPACE playerPossessive SPACE CONTROL
                    | ON SPACE TOP SPACE OF SPACE zone
                    | AT SPACE RANDOM
                    | TO SPACE BE SPACE amount
                    | OF SPACE playerPossessive SPACE CHOICE;

delayedTrigger : AT SPACE END SPACE OF SPACE COMBAT
               | AT SPACE THE SPACE BEGINNING SPACE OF SPACE phase;

phase : playerPossessive SPACE TURN
      | playerPossessive SPACE rawPhase
      | ARTICLE SPACE rawPhase SPACE OF SPACE player
      | ARTICLE SPACE rawPhase
      | ARTICLE SPACE playerPossessive TURN COMMA SPACE BEFORE SPACE ATTACKERS SPACE IS SPACE DECLARED
      | ARTICLE SPACE NEXT SPACE rawPhase
      | COMBAT
      | COMBAT SPACE BEFORE SPACE BLOCKERS SPACE IS SPACE DECLARED
      | THE TURN
      | EACH SPACE OF SPACE playerPossessive SPACE UPKEEP SPACE FOR SPACE THE SPACE REST SPACE OF SPACE THE SPACE GAME
      | THE SPACE NEXT SPACE END SPACE STEP;

phrase : playerPhrase
       | objectPhrase;

player : ANY_PLAYER
       | determiner SPACE player
       | playerPremodifier SPACE player
       | ANY_PLAYER playerPostmodifier
       | objectPossessive ANY_PLAYER;

playerPremodifier: ACTIVE | CHOSEN | DEFENDING;

playerPostmodifier: WHO SPACE CONTROL SPACE THE SPACE FEWEST;

playerPhrase : player SPACE playerVerbPhrase;

playerPossessive : YOUR
                 | THEIR
                 | player SAXON;

playerVerbPhrase : MAY SPACE playerVerbPhrase
                 | CHANGE SPACE ARTICLE SPACE TEXT SPACE OF SPACE object SPACE BY SPACE REPLACING SPACE ALL SPACE INSTANCES SPACE OF SPACE ONE SPACE textAspect SPACE WITH SPACE ANOTHER
                 | CHOOSE SPACE ARTICLE SPACE textAspect
                 | IS SPACE DEALT SPACE damage
                 | ADD SPACE MANA_SYMBOL+
                 | ADD SPACE ARTICLE SPACE AMOUNT SPACE OF SPACE MANA_SYMBOL SPACE EQUAL SPACE TO SPACE amount
                 | ADD SPACE amount SPACE MANA SPACE OF SPACE ANY SPACE (ONE SPACE)? COLOR
                 | ADD SPACE amount SPACE MANA SPACE OF SPACE ANY SPACE type SPACE THAT SPACE object SPACE PRODUCED
                 | ADD SPACE ARTICLE SPACE ADDITIONAL SPACE MANA_SYMBOL
                 | ATTACH SPACE object SPACE TO SPACE object
                 | 'can activate mana abilities only if they’re from lands that player controls and only if mana they produce is spent ' TO ' activate other mana abilities of lands the player controls and/or ' TO ' play that card'
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
                 | LOSE SPACE THE SPACE GAME
                 | LOSE SPACE LIFE SPACE EQUAL SPACE TO SPACE amount
                 | LOSE SPACE HALF SPACE playerPossessive SPACE LIFE ', rounded up'
                 | LOSE SPACE ALL SPACE UNSPENT SPACE MANA
                 | PLAY SPACE OBJECT SPACE IF SPACE ABLE
                 | PUT SPACE object SPACE prepositionalPhrase
                 | PUT SPACE amount SPACE counterType SPACE prepositionalPhrase
                 | REMOVE SPACE ARTICLE SPACE counterType SPACE prepositionalPhrase
                 | RETURN SPACE object SPACE prepositionalPhrase
                 | SACRIFICE SPACE object (subordinateClause)?
                 | SEARCH SPACE zone SPACE prepositionalPhrase
                 | SKIPS SPACE phase
                 | SKIPS SPACE THAT SPACE (TURN|DRAW)
                 | TAKE SPACE AN SPACE EXTRA SPACE TURN SPACE AFTER SPACE THIS SPACE ONE
                 | HAVE SPACE object SPACE ENTER SPACE zone SPACE 'as a copy of any' SPACE object SPACE 'on' SPACE zone (SPACE prepositionalPhrase)?
                 | HAVE SPACE player SHUFFLE
                 | HAVE SPACE object SPACE BLOCK SPACE object
                 | SPEND SPACE COLOR SPACE MANA 'as though it were ' COLOR SPACE MANA
                 | PLAY SPACE object SPACE 'on each of your turns'
                 | PAY SPACE amount SPACE OF SPACE MANA
                 | costs
                 | ANTE SPACE object
                 | TAP SPACE OR SPACE TAP SPACE object
                 | SHUFFLE SPACE zone SPACE prepositionalPhrase
                 | CHOOSE SPACE 'a number of lands they control equal ' TO SPACE amount ', then sacrifices the rest. Players discard cards and sacrifice creatures the same way'
                 | CHOOSE SPACE 'a creature card in your hand whose mana cost ' COULD ' be paid by some amount of, or all of, the mana you spent on {X}. If you do, you ' MAY ' cast that card face down as a 2/2 creature spell without paying its mana cost. If the creature that spell becomes as it resolves has' SPACE NOT SPACE 'been turned face up and would assign or deal damage, be dealt damage, or become tapped, ' INSTEAD ' it’s turned face up and assigns or deals damage, is dealt damage, or becomes tapped. Activate only as a sorcery.'
                 | DIVIDE SPACE 'all creatures without flying they control into a “left” pile and a “right” pile. Then, for each attacking creature you control, ' CHOOSE ' “left” or “right.” That creature can’t be blocked this ' COMBAT ' except by creatures with flying and creatures in a pile with the chosen label'
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

restriction : CAST SPACE object SPACE ONLY SPACE DURING SPACE phase
            | CAST object SPACE ONLY SPACE BEFORE SPACE phase
            | SPEND SPACE ONLY SPACE COLOR SPACE MANA SPACE ON VARIABLE
            | AS SPACE AN SPACE ADDITIONAL SPACE COST SPACE TO SPACE CAST object COMMA SPACE costs
            | object SPACE COST costs SPACE COMPARATIVE SPACE TO SPACE CAST prepositionalPhrase
            | ACTIVATE SPACE ONLY SPACE DURING SPACE phase (SPACE 'and only once each turn')?
            | ACTIVATE SPACE ONLY SPACE DURING SPACE playerPossessive SPACE TURN COMMA SPACE 'before attackers are ' DECLARED
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
                  | 'If this ability has been activated' SPACE amount SPACE TIME SPACE duration
                  | EXCEPT SPACE object IS SPACE ARTICLE SPACE CARD_TYPE SPACE IN SPACE ADDITION SPACE TO SPACE objectPossessive OTHER 'types'
                  | EXCEPT SPACE object SPACE DO SPACE 'copy that creature’s color and it has “At the beginning of your upkeep, you may have this creature become a copy of target creature, except it doesn’t copy that creature’s color and it has this ability.”'
                  | EXCEPT SPACE object SPACE IS SPACE COLOR
                  | EXCEPT SPACE BY SPACE object
                  | WHERE variableDefinition
                  | WHILE SPACE DOING SPACE SO
                  | IF SPACE object IS CAST AS object;

textAspect : 'color word'
           | object TYPE;

triggerCondition : TRIGGER_WORD SPACE triggerEvent (COMMA SPACE subordinateClause)?;

triggerEvent : THE SPACE BEGINNING SPACE OF SPACE phase
             | END SPACE OF SPACE COMBAT
             | phrase;

type : OBJECT_TYPE
     | CHOSEN TYPE;

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