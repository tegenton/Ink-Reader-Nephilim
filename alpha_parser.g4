// Grammar for Alpha

parser grammar alpha_parser;

options {
    tokenVocab = alpha_lexer;
}

card: permanentCard | spellCard;

// Permanents
permanentCard : ability (NEWLINE ability)*|;

ability : keywords
        | staticAbility
        | activatedAbility
        | triggeredAbility;

keywords : keyword ((SEMICOLON|COMMA) SPACE keyword)*;

activatedAbility : costs COLON SPACE effect PERIOD (SPACE restriction PERIOD)?;

staticAbility : staticAbility SPACE staticAbility
              | subordinateClause COMMA SPACE staticAbility
              | continuousEffect (PERIOD)?;

triggeredAbility : triggerCondition COMMA SPACE triggerEffect (PERIOD)?;

// Spells

spellCard : spellAbility (NEWLINE spellAbility)*;

modal : CHOOSE SPACE englishNumber SPACE DASH (NEWLINE BULLET SPACE effect PERIOD)+;

spellAbility : effect PERIOD
             | restriction PERIOD
             | modal;

// Effects
continuousEffect : continuousEffect SPACE duration
                 | duration COMMA SPACE continuousEffect
                 | player SPACE MAY SPACE costs PERIOD SPACE effect
                 | player SPACE MAY SPACE costs SPACE anyTime PERIOD SPACE effect
                 | player SPACE MAY SPACE PLAY SPACE object
                 | player SPACE CAN (NOT)? SPACE BE SPACE ATTACKED SPACE subordinateClause
                 | player SPACE CAN (NOT)? SPACE TAP SPACE object SPACE duration
                 | player SPACE DO (NOT)? SPACE LOSE SPACE THE SPACE GAME SPACE prepositionalPhrase
                 | player SPACE HAVE SPACE NO SPACE MAXIMUM SPACE HAND SPACE SIZE
                 | player SPACE CONTROL SPACE something
                 | player SPACE SKIPS SPACE phase
                 | abilityType SPACE prepositionalPhrase SPACE COST SPACE costs SPACE comparative SPACE TO SPACE ACTIVATE
                 | damage SPACE IS SPACE DEALT SPACE prepositionalPhrase SPACE INSTEAD
                 | THIS SPACE EFFECT SPACE DO (NOT)? SPACE REMOVE SPACE object
                 | INSTEAD SPACE OF SPACE DECLARING SPACE BLOCKERS COMMA SPACE player SPACE CHOOSE SPACE object SPACE conjunction SPACE DIVIDE SPACE THEM SPACE IN SPACE article SPACE NUMBER SPACE OF SPACE PILE SPACE EQUAL SPACE TO SPACE amount PERIOD SPACE object SPACE MAY SPACE LIKEWISE SPACE BE SPACE PUT SPACE IN SPACE ADDITIONAL SPACE PILE PERIOD SPACE ASSIGN SPACE EACH SPACE PILE SPACE TO SPACE A SPACE DIFFERENT SPACE ONE SPACE OF SPACE object SPACE prepositionalPhrase
                 | FOR SPACE EACH SPACE damage SPACE distinguisher COMMA SPACE triggerEffect
                 | replacementEffect
                 | continuousObjectPhrase;

continuousObjectPhrase: object SPACE continuousObjectVerbPhrase (SPACE AND SPACE continuousObjectVerbPhrase)*
                      | objectIs SPACE object
                      | objectIs SPACE type
                      | objectPossessive SPACE characteristics SPACE IS SPACE EACH SPACE EQUAL SPACE TO SPACE amount;

continuousObjectVerbPhrase: continuousObjectVerbPhrase SPACE conjunction SPACE continuousObjectVerbPhrase
                	      | CAN (NOT)? SPACE objectAuxiliary
             	          | (HAVE | GAIN) SPACE ability
             	          | GET SPACE statMod ((COMMA)? SPACE subordinateClause)?
                          | (HAVE | GAIN) SPACE quotedAbility
                          | LOSE SPACE (keyword | quotedAbility)
                          | COST SPACE costs SPACE comparative SPACE TO SPACE CAST
                          | DO (NOT)? SPACE TAP SPACE DURING SPACE phase
                          | DO SPACE SO
                          | BECOME (S)? SPACE object;

statMod: (PLUS | DASH) (INT|VARIABLE) SLASH (PLUS | DASH) (INT|VARIABLE);

objectAuxiliary: ATTACK (SPACE subordinateClause)?
               | BLOCK SPACE object
               | BE SPACE BLOCKED (SPACE subordinateClause)?
               | BE SPACE ENCHANTED SPACE BY SPACE object
               | BE SPACE REGENERATED;

replacementEffect : subordinateClause COMMA SPACE (INSTEAD SPACE effect | effect SPACE INSTEAD)
                  | subordinateClause COMMA SPACE playerPhrase SPACE INSTEAD PERIOD SPACE subordinateClause COMMA SPACE effect
                  | subordinateClause COMMA SPACE playerVerbPhrase COMMA SPACE BUT SPACE player SPACE MAY SPACE PUT SPACE object prepositionalPhrase SPACE INSTEAD SPACE OF SPACE prepositionalPhrase
                  | subordinateClause SPACE duration COMMA SPACE effect SPACE INSTEAD
                  | objectPhrase SPACE prepositionalPhrase
                  | player SPACE MAY SPACE HAVE SPACE object SPACE ENTER SPACE zone SPACE subordinateClause
                  | IF SPACE object SPACE HAVE SPACE NOT SPACE BEEN SPACE TURNED SPACE FACE SPACE UP SPACE AND SPACE WOULD SPACE ASSIGN SPACE OR SPACE DEAL SPACE DAMAGE COMMA SPACE BE SPACE DEALT SPACE DAMAGE COMMA SPACE OR SPACE BECOME SPACE TAPPED COMMA SPACE INSTEAD SPACE object IS SPACE TURNED SPACE FACE SPACE UP SPACE AND SPACE ASSIGN SPACE OR SPACE DEAL SPACE DAMAGE COMMA SPACE IS SPACE DEALT SPACE DAMAGE COMMA SPACE OR SPACE BECOME SPACE TAPPED
                  | subordinateClause COMMA SPACE INSTEAD SPACE playerPhrase PERIOD SPACE effect
                  | AS SPACE objectPhrase COMMA SPACE effect;

triggerEffect : effect (SPACE subordinateClause)?;

effect: effect punctuation (SPACE conjunction)? SPACE effect
      | (delayedTrigger SPACE)? oneShotEffect (SPACE delayedTrigger)?
      | subordinateClause COMMA SPACE effect
      | continuousEffect
      | THE SPACE NEXT SPACE TIME SPACE source SPACE WOULD SPACE DEAL SPACE DAMAGE SPACE prepositionalPhrase SPACE duration COMMA SPACE effect;

punctuation: COMMA | PERIOD;

oneShotEffect: source SPACE DEAL SPACE damage SPACE TO SPACE player SPACE INSTEAD
             | phrase
             | playerVerbPhrase
             | THIS SPACE ABILITY SPACE CAN SPACE CAUSE SPACE THE SPACE TOTAL SPACE NUMBER OF SPACE counterType prepositionalPhrase
             | THEN COMMA SPACE FOR SPACE EACH SPACE object COMMA SPACE CHOOSE SPACE PILE_LABEL SPACE OR SPACE PILE_LABEL SPACE object SPACE CAN NOT SPACE BE SPACE BLOCKED SPACE duration SPACE EXCEPT SPACE BY SPACE object;

damage : DAMAGE
       | (INT | VARIABLE) (SPACE OF SPACE THAT)? SPACE DAMAGE (COMMA SPACE subordinateClause)?
       | ALL SPACE COMBAT SPACE DAMAGE SPACE THAT SPACE WOULD SPACE BE SPACE DEALT SPACE duration
       | ALL SPACE DAMAGE SPACE THAT SPACE WOULD SPACE BE SPACE DEALT SPACE TO SPACE player SPACE BY SPACE object
       | ALL SPACE BUT SPACE INT SPACE OF SPACE damage
       | determiner SPACE damage
       | THE SPACE NEXT SPACE damage SPACE THAT SPACE WOULD SPACE BE SPACE DEALT SPACE TO SPACE something SPACE duration;

// Definitions
anyTime : ANY SPACE TIME SPACE player SPACE COULD SPACE play SPACE playable;

play: PLAY | CAST | ACTIVATE;

playable: object | abilityType;

abilityType: (determiner SPACE)? (ACTIVATED | MANA) SPACE ABILITY;

amount: amount COMMA SPACE amount COMMA SPACE conjunction SPACE amount
      | HALF SPACE amount COMMA SPACE ROUNDED SPACE (ROUND_DIRECTION)
      | (UP SPACE TO|comparative SPACE THAN) SPACE amount
      | (englishNumber | INT) (SPACE conjunction SPACE comparative)?
      | objectPossessive SPACE characteristics (SPACE subordinateClause)?
      | VARIABLE
      | article SPACE NUMBER SPACE OF SPACE object (SPACE MINUS SPACE INT)?
      | (THE | ANY | A) SPACE NUMBER SPACE OF
      | damage SPACE DEALT SPACE prepositionalPhrase SPACE duration
      | playerPossessive SPACE LIFE SPACE TOTAL (SPACE subordinateClause)?
      | THAT SPACE MANY
      | THE SPACE AMOUNT SPACE OF SPACE MANA SPACE THAT SPACE player SPACE PAID SPACE THIS SPACE WAY
      | damage SPACE PREVENTED SPACE THIS SPACE WAY
      | ANY SPACE AMOUNT
      | THE SPACE DAMAGE SPACE DEALT COMMA SPACE BUT SPACE NOT SPACE MORE_ SPACE LIFE SPACE THAN SPACE amount;

article: A | AN | THE;

characteristics: characteristic (SPACE conjunction SPACE characteristic)*;

characteristic: POWER | TOUGHNESS | MANA SPACE VALUE | LOYALTY;

comparative: LESS | MORE_ | GREATER;

condition : objectIs (NOT)? SPACE adjective
          | objectIs SPACE prepositionalPhrase
          | objectIs SPACE object
          | object SPACE HAVE SPACE A SPACE counterType SPACE prepositionalPhrase
          | object SPACE HAVE SPACE keyword
          | object SPACE HAD SPACE keyword
          | object SPACE DID SPACE HAVE SPACE keyword
          | object SPACE WAS NOT SPACE THE SPACE FIRST SPACE object SPACE YOU SPACE PLAYED SPACE duration
          | object SPACE ATTACKED SPACE OR SPACE BLOCKED SPACE duration
          | object SPACE ATTACKED SPACE duration
          | player SPACE CONTROL SPACE object;

conjunction: AND | OR | AND SLASH OR | THEN;

costs : (PAY (S)? SPACE)? cost (COMMA SPACE costs)?;

cost : manaSymbol
     | TAP_SYMBOL
     | life
     | playerVerbPhrase;

counterType: (COUNTER_TYPE | statMod) SPACE COUNTER;

manaSymbol: (LBRACKET (MANA_COLOR | INT | VARIABLE) RBRACKET)+;

determiner: article | demonstrative | negative | alternative | universal | distributive | existential;

existential: ANY;

distributive: EACH;

universal: ALL;

alternative: OTHER | ANOTHER;

negative: NO;

demonstrative: TARGET | THIS | THESE | THAT | THOSE;

distinguisher : THAT SPACE WOULD SPACE BE SPACE DEALT SPACE TO SPACE object;

duration : UNTIL SPACE END SPACE OF SPACE TURN
         | UNTIL SPACE END SPACE OF SPACE COMBAT
         | UNTIL SPACE object SPACE LEAVE SPACE zone
         | UNTIL SPACE YOUR SPACE NEXT SPACE TURN
         | UNTIL SPACE object SPACE FINISHES SPACE RESOLVING
         | determiner SPACE TURN
         | ON SPACE EACH SPACE OF SPACE YOUR SPACE TURN
         | determiner SPACE COMBAT
         | DURING SPACE phase
         | FOR SPACE subordinateConjunction SPACE object HAVE A counterType SPACE prepositionalPhrase
         | subordinateConjunction SPACE player SPACE CONTROL SPACE object
         | WHILE SPACE object SPACE IS SPACE RESOLVING
         | anyTime;

keyword: BANDING | DEFENDER | FEAR | FLYING | HASTE | INDESTRUCTIBLE | REACH | TRAMPLE | VIGILANCE
       | FIRST SPACE STRIKE
       | PROTECTION SPACE FROM SPACE color
       | ENCHANT SPACE object
       | type WALK;

color: (NOT)? (WHITE | BLUE | BLACK | RED | GREEN);

englishNumber: ONE | TWO | THREE | FOUR | FIVE | SIX | SEVEN;

object: object SPACE conjunction SPACE object
      | (premodifier (COMMA)? SPACE)* (objectNouns) (SPACE postmodifier)*;

objectNouns: (objectNoun COMMA SPACE)* objectNoun ((COMMA)? SPACE conjunction SPACE objectNoun)?;
objectNoun: (TILDE | type | COPY | CARD | SPELL | PERMANENT | TOKEN | IT | THEY);

objectPhrase : object SPACE objectVerbPhrase;

objectPossessive: ((determiner | adjective) SPACE)* (IT S | objectNoun saxon);

saxon: APOSTROPHE S;

objectVerbPhrase : IS SPACE DEALT SPACE damage
                 | IS SPACE TAPPED SPACE prepositionalPhrase
                 | IS SPACE PUT SPACE prepositionalPhrase
                 | IS SPACE color
                 | ATTACK (SPACE duration SPACE subordinateClause)?
             	 | BECOME (S)? SPACE TAPPED
             	 | BECOME SPACE BLOCKED
             	 | BECOME SPACE color
                 | BLOCK SPACE object (SPACE duration)? (SPACE subordinateClause)?
                 | BLOCK SPACE OR SPACE BECOME SPACE BLOCKED SPACE BY SPACE object
             	 | DEAL SPACE damage SPACE prepositionalPhrase
                 | DEAL SPACE damage SPACE prepositionalPhrase SPACE AND SPACE damage SPACE prepositionalPhrase
                 | DEAL SPACE damage SPACE prepositionalPhrase COMMA SPACE subordinateClause
                 | DEAL SPACE damage SPACE prepositionalPhrase SPACE EQUAL SPACE TO SPACE amount
                 | DEAL SPACE damage SPACE EQUAL SPACE TO SPACE amount SPACE prepositionalPhrase
                 | DEAL SPACE damage SPACE DIVIDED SPACE EVENLY COMMA SPACE ROUNDED SPACE ROUND_DIRECTION COMMA SPACE AMONG SPACE something
                 | DIE
                 | DO SPACE TAP SPACE duration
                 | ENTER SPACE zone (TAPPED)?
             	 | GAIN SPACE keyword SPACE AND SPACE GET SPACE statMod SPACE duration COMMA SPACE subordinateClause
                 | GAIN SPACE quotedAbility
                 | LEAVE SPACE zone
                 | LOSE SPACE keyword;

postmodifier : player SPACE CONTROL
             | player SPACE CONTROLLED SPACE AT SPACE THE SPACE BEGINNING SPACE OF SPACE duration
             | player SPACE HAVE SPACE CONTROLLED SPACE CONTINUOUSLY SPACE SINCE SPACE THE SPACE BEGINNING SPACE OF SPACE duration
             | player SPACE DID SPACE CONTROL SPACE CONTINUOUSLY SPACE SINCE SPACE THE SPACE BEGINNING SPACE OF duration
             | CONTROLLED SPACE BY SPACE player
             | (IN | OF) SPACE zone
             | OF SPACE playerPossessive SPACE CHOICE
             | NAMED SPACE LITERAL_NAME SPACE prepositionalPhrase
             | ABLE SPACE TO SPACE BLOCK SPACE object
             | THAT SPACE CAN SPACE BLOCK SPACE object
             | THAT SPACE IS SPACE STILL SPACE object
             | THAT SPACE DID SPACE ATTACK SPACE duration
             | THAT SPACE CAN SPACE BLOCK SPACE ADDITIONAL object
             | THAT SPACE HAD SPACE BECOME SPACE BLOCKED SPACE BY SPACE ONLY SPACE object SPACE duration
             | THAT SPACE PILE SPACE IS SPACE ASSIGNED SPACE TO
             | THAT SPACE DIED SPACE duration
             | OTHER SPACE THAN SPACE object
             | object SPACE WAS SPACE BLOCKING
             | object BECOME AS IT RESOLVE
             | PUT SPACE prepositionalPhrase SPACE THIS SPACE WAY
             | PUT SPACE prepositionalPhrase SPACE WITH SPACE TILDE
             | DEALT SPACE DAMAGE SPACE BY SPACE object SPACE duration
             | IN SPACE A SPACE PILE (prepositionalPhrase)?
             | BEYOND SPACE THE SPACE FIRST
             | THAT SPACE A SPACE counterType SPACE WAS SPACE PUT SPACE ON SPACE WITH SPACE object SPACE BUT SPACE THAT SPACE A SPACE counterType SPACE HAVE SPACE NOT BEEN REMOVED FROM WITH object
             | EQUAL SPACE TO SPACE amount
             | WHOSE SPACE MANA SPACE COST SPACE COULD SPACE BE SPACE PAID SPACE BY SPACE SOME SPACE AMOUNT SPACE OF COMMA SPACE OR SPACE ALL SPACE OF COMMA SPACE THE SPACE MANA SPACE YOU SPACE SPENT SPACE ON SPACE manaSymbol
             | WITH SPACE quality
             | FOR SPACE WHOM SPACE player SPACE IS SPACE player
             | object SPACE TOUCHES;

premodifier : adjective
            | amount
            | color
            | determiner
            | CHOSEN
            | type
            | INT SLASH INT;

adjective: (NOT)? (ADDITIONAL | ATTACKING | BLOCKED | BLOCKING | ENCHANTED | SACRIFICED | TAPPED | TOKEN | TOP);

prepositionalPhrase : prepositionalPhrase SPACE (conjunction SPACE)? prepositionalPhrase
                    | preposition SPACE zone
                    | preposition SPACE something
                    | WITH SPACE amount SPACE counterType
                    | WITH SPACE keyword SPACE conjunction SPACE keyword
                    | WITH SPACE abilityType
                    | WITH SPACE THE SPACE CHOSEN SPACE LABEL
                    | FOR SPACE MANA
                    | FOR SPACE HAVING SPACE life
                    | FROM SPACE A SPACE HEIGHT SPACE OF SPACE AT SPACE LEAST SPACE ONE SPACE FOOT
                    | UNDER SPACE playerPossessive SPACE CONTROL
                    | ON SPACE TOP SPACE OF SPACE zone
                    | AT SPACE RANDOM
                    | TO SPACE BE SPACE amount
                    | TO SPACE play SPACE playable
                    | TO SPACE play SPACE playable SPACE OF SPACE object
                    | OF SPACE playerPossessive SPACE CHOICE
                    | ONLY SPACE IF SPACE THEY APOSTROPHE RE SPACE FROM SPACE object
                    | ONLY SPACE IF SPACE MANA SPACE THEY SPACE PRODUCE SPACE IS SPACE SPENT SPACE prepositionalPhrase;

preposition: ABOVE | FOR | FROM | IN | OF | ON | TO | UNDER | WITH;

delayedTrigger : AT SPACE END SPACE OF SPACE COMBAT
               | AT SPACE THE SPACE BEGINNING SPACE OF SPACE phase;

phase: (article SPACE)? playerPossessive SPACE TURN (COMMA SPACE subordinateClause)?
     | playerPossessive SPACE rawPhase
     | determiner SPACE rawPhase (SPACE OF SPACE player)?
     | article SPACE NEXT SPACE rawPhase
     | COMBAT (SPACE subordinateClause)?
     | THE SPACE TURN
     | EACH SPACE OF SPACE playerPossessive SPACE rawPhase SPACE FOR SPACE THE SPACE REST SPACE OF SPACE THE SPACE GAME
     | THE SPACE NEXT SPACE END SPACE STEP;

phrase: playerPhrase
      | objectPhrase;

player : ((CONTROLLER | OWNER | PLAYER | OPPONENT) (S)? | YOU | THEY) (SPACE playerPostmodifier)?
       | determiner SPACE player
       | playerPremodifier SPACE player
       | objectPossessive SPACE player;

playerPremodifier: ACTIVE | CHOSEN | DEFENDING;

playerPostmodifier: WHO SPACE CONTROL SPACE THE SPACE FEWEST;

playerPhrase: player SPACE playerVerbPhrase
            | playerIs SPACE DEALT SPACE DAMAGE;

playerPossessive : YOUR
                 | THEIR
                 | player saxon;

playerVerbPhrase : playerVerbPhrase (COMMA SPACE playerVerbPhrase)* (COMMA)? SPACE conjunction SPACE playerVerbPhrase
                 | (ANTE | CAST | CHOOSE | CREATE | DESTROY | DRAW | EXILE | OWN | REGENERATE | SACRIFICE) (S)? SPACE object
                 | MAY SPACE playerVerbPhrase
                 | CAN SPACE playerVerbPhrase
                 | CHANGE SPACE article SPACE TEXT SPACE prepositionalPhrase SPACE BY SPACE REPLACING SPACE ALL SPACE INSTANCES SPACE OF SPACE ONE SPACE textAspect SPACE WITH SPACE ANOTHER
                 | CHOOSE SPACE article SPACE textAspect
                 | CHOOSE SPACE player
                 | IS SPACE DEALT SPACE damage
                 | ADD (S)? SPACE mana
                 | ACTIVATE (S)? SPACE (A SPACE)? abilityType SPACE prepositionalPhrase
                 | ATTACH SPACE object SPACE TO SPACE object
                 | COPY SPACE object COMMA SPACE subordinateClause
                 | COUNTER SPACE object (SPACE subordinateClause)?
                 | CHOOSE SPACE NEW SPACE TARGET (S)? SPACE prepositionalPhrase
                 | CHOOSE SPACE object SPACE prepositionalPhrase
                 | DESTROY SPACE object SPACE subordinateClause
                 | EXCHANGE SPACE object SPACE WITH SPACE object
                 | FLIP SPACE object SPACE prepositionalPhrase
                 | GAIN SPACE life
                 | LOOK SPACE AT SPACE object
                 | LOOK SPACE AT SPACE zone
                 | LOSE SPACE THE SPACE GAME
                 | LOSE SPACE life
                 | LOSE SPACE HALF SPACE playerPossessive SPACE LIFE COMMA SPACE ROUNDED SPACE ROUND_DIRECTION
                 | LOSE SPACE ALL SPACE SPENT SPACE MANA
                 | PLAY (S)? SPACE object (SPACE subordinateClause)?
                 | PREVENT SPACE damage
                 | PUT SPACE THEM SPACE BACK SPACE IN SPACE ANY SPACE ORDER
                 | PUT SPACE object SPACE prepositionalPhrase
                 | PUT SPACE (amount|A) SPACE counterType SPACE prepositionalPhrase
                 | REMOVE SPACE article SPACE counterType SPACE prepositionalPhrase
                 | RETURN SPACE object SPACE prepositionalPhrase
                 | SACRIFICE (S)? SPACE object ((PERIOD)? SPACE subordinateClause)?
                 | SEARCH SPACE zone SPACE prepositionalPhrase
                 | SKIPS SPACE THAT SPACE (TURN|DRAW)
                 | TAKE SPACE AN SPACE EXTRA SPACE TURN SPACE AFTER SPACE THIS SPACE ONE
                 | TAP (S)? (SPACE OR SPACE NOT TAP)? SPACE object (SPACE prepositionalPhrase)?
                 | HAVE SPACE object SPACE BECOME SPACE object COMMA SPACE subordinateClause
                 | HAVE SPACE player SHUFFLE
                 | HAVE SPACE object SPACE BLOCK SPACE object
                 | SPEND SPACE color SPACE MANA SPACE AS SPACE THOUGH SPACE IT SPACE WERE SPACE color SPACE MANA
                 | PLAY SPACE object SPACE ON SPACE EACH SPACE OF SPACE duration
                 | PAY SPACE amount SPACE OF SPACE MANA
                 | PAY SPACE mana
                 | SHUFFLE (SPACE zone SPACE prepositionalPhrase)?
                 | SACRIFICE SPACE THE SPACE REST
                 | DISCARD SPACE zone
                 | DISCARD SPACE object (SPACE prepositionalPhrase)?
                 | DISCARD SPACE object SPACE AND SPACE SACRIFICE SPACE object SPACE THE SPACE SAME SPACE WAY
                 | CAST SPACE object SPACE AS SPACE object SPACE WITH SPACE PAYING SPACE objectPossessive SPACE MANA SPACE COST
                 | DIVIDE SPACE object SPACE IN SPACE A SPACE PILE_LABEL SPACE PILE SPACE AND SPACE A SPACE PILE_LABEL SPACE PILE
                 | PREVENT VARIABLE SPACE OF SPACE damage COMMA SPACE subordinateClause
                 | REMOVE SPACE object SPACE FROM SPACE COMBAT;

mana: manaSymbol+
    | article SPACE AMOUNT SPACE OF SPACE manaSymbol SPACE EQUAL SPACE TO SPACE amount
    | amount SPACE MANA SPACE OF SPACE ANY SPACE (ONE SPACE)? COLOR
    | amount SPACE MANA SPACE OF SPACE ANY SPACE TYPE SPACE object SPACE PRODUCED
    | article SPACE ADDITIONAL SPACE manaSymbol
    | THE SPACE MANA SPACE LOST SPACE THIS SPACE WAY;

life: INT SPACE LIFE
    | amount SPACE LIFE
    | LIFE SPACE EQUAL SPACE TO SPACE amount
    | LIFE SPACE EQUAL SPACE TO SPACE THE DAMAGE DEALT COMMA SPACE subordinateClause;

quality : MANA SPACE VALUE SPACE (INT | VARIABLE)
        | POWER SPACE amount
        | TOUGHNESS SPACE amount
        | POWER SPACE AND SPACE TOUGHNESS SPACE EACH SPACE EQUAL SPACE TO SPACE amount
        | keyword;

quotedAbility: OPENQUOTE ability (PERIOD)? CLOSEQUOTE;

rawPhase : turnPart
         | (turnPart SPACE)? turnPart SPACE STEP (S)?;

restriction : CAST SPACE object SPACE ONLY SPACE DURING SPACE phase
            | CAST SPACE object SPACE ONLY SPACE BEFORE SPACE phase
            | SPEND SPACE ONLY SPACE color SPACE MANA SPACE ON SPACE VARIABLE
            | AS SPACE AN SPACE ADDITIONAL SPACE COST SPACE TO SPACE CAST SPACE object COMMA SPACE costs
            | object SPACE COST SPACE costs SPACE comparative SPACE TO SPACE CAST SPACE prepositionalPhrase
            | ACTIVATE SPACE ONLY SPACE AS SPACE A SPACE CARD_TYPE
            | ACTIVATE SPACE ONLY SPACE DURING SPACE phase (SPACE AND SPACE ONLY SPACE ONCE SPACE duration)?
            | ACTIVATE SPACE ONLY SPACE DURING SPACE phase
            | REMOVE SPACE object SPACE prepositionalPhrase SPACE BEFORE SPACE PLAYING SPACE IF SPACE playerIs SPACE NOT SPACE PLAYING SPACE FOR SPACE ANTE
            | ONLY SPACE player SPACE MAY SPACE ACTIVATE SPACE THIS SPACE ABILITY;

playerIs: (YOU | THEY) APOSTROPHE RE | player SPACE IS;

something : determiner SPACE something
          | object
          | player
          | something SPACE conjunction SPACE something
          | target;

target: premodifier SPACE TARGET (S)? (SPACE BEYOND SPACE THE SPACE FIRST)?;

source : premodifier SPACE source
       | source SPACE postmodifier
       | object
       | color SPACE SOURCE
       | SOURCE;

variableDefinition: VARIABLE SPACE IS SPACE amount (COMMA SPACE AND SPACE variableDefinition)?;

subordinateClause : subordinateConjunction SPACE condition
                  | subordinateConjunction SPACE phrase
                  | subordinateConjunction SPACE player SPACE WOULD SPACE GAIN SPACE LIFE
                  | subordinateConjunction SPACE player SPACE WOULD SPACE BEGIN SPACE YOUR SPACE TURN SPACE WHILE condition
                  | IF SPACE ABLE
                  | IF SPACE AN SPACE EFFECT SPACE CAUSE SPACE player SPACE TO SPACE DISCARD SPACE object
                  | IF SPACE object SPACE WOULD SPACE objectVerbPhrase
                  | IF SPACE THIS SPACE ABILITY SPACE HAVE SPACE BEEN SPACE ACTIVATED SPACE amount SPACE TIME SPACE duration
                  | EXCEPT SPACE objectIs SPACE article SPACE type SPACE IN SPACE ADDITION SPACE TO SPACE objectPossessive SPACE OTHER SPACE TYPE
                  | EXCEPT SPACE objectIs SPACE color
                  | EXCEPT SPACE object SPACE DO SPACE COPY SPACE objectPossessive SPACE COLOR
                  | EXCEPT SPACE object SPACE DO NOT SPACE COPY SPACE objectPossessive SPACE COLOR SPACE AND SPACE object SPACE HAVE SPACE (quotedAbility | THIS SPACE ABILITY)
                  | EXCEPT SPACE BY SPACE object
                  | WHERE SPACE variableDefinition
                  | WHILE SPACE DOING SPACE SO
                  | IF SPACE objectIs SPACE CAST SPACE AS SPACE object
                  | IF SPACE object SPACE DID SPACE ATTACK SPACE duration
                  | IF object SPACE TURN SPACE OVER SPACE COMPLETELY SPACE AT SPACE LEAST SPACE ONCE SPACE DURING SPACE THE SPACE FLIP
                  | IF SPACE player SPACE WOULD SPACE playerVerbPhrase SPACE duration
                  | UNLESS SPACE player SPACE costs
                  | UNLESS SPACE player SPACE CONTROL SPACE object
                  | IF SPACE player SPACE DO (NOT)?
                  | AS SPACE object COMMA SPACE subordinateClause
                  | BEFORE SPACE THE SPACE DAMAGE SPACE WAS SPACE DEALT
                  | BEFORE SPACE (ATTACKERS|BLOCKERS) SPACE IS SPACE DECLARED
                  | IF SPACE player SPACE CAN (NOT)? COMMA SPACE effect;

objectIs: object SPACE IS
        | IT APOSTROPHE S;

subordinateConjunction: AS (SPACE LONG SPACE AS | SPACE THOUGH)? | BUT | EXCEPT | IF | WHERE;

textAspect : COLOR SPACE WORD
           | object SPACE TYPE;

triggerCondition : triggerWord SPACE triggerEvent (COMMA SPACE subordinateClause)?;

triggerWord: WHEN | WHENEVER | AT;

triggerEvent : THE SPACE BEGINNING SPACE OF SPACE phase
             | END SPACE OF SPACE COMBAT
             | phrase
             | continuousEffect;

type: (NOT)? (SUPER_TYPE | CARD_TYPE | CREATURE_TYPE | ENCHANTMENT_TYPE | LAND_TYPE) (S)? (SPACE conjunction SPACE type)?
    | CHOSEN SPACE TYPE;

zone: playerPossessive SPACE playerZone
    | determiner SPACE (BATTLEFIELD | ANTE | playerZone);

playerZone: (HAND | LIBRARY | DECK | GRAVEYARD) (SPACE AND SPACE playerZone)?;

turnPart : TAP
         | UPKEEP
         | DRAW
         | DECLARE
         | ATTACKERS
         | BLOCKERS
         | COMBAT
         | DAMAGE
         | END;