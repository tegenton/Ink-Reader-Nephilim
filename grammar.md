# Grammar for Alpha

## Permanents
permanentCard -> ability? ('\n' ability)*

ability -> keywords
        -> staticAbility
        -> activatedAbility
        -> triggeredAbility

keywords -> keyword ([;,]' ' keyword)*

keyword -> 'Enchant' object
        -> 'Banding'
        -> 'First strike'
        -> 'Flying'
        -> 'Vigilance'
        -> 'Defender'
        -> 'Protection from ' color

staticAbility -> object ' can attack as though it didn't have defender.'
              -> object ' has indestructible and can’t be enchanted by other Auras.'
              -> 'All mountains are plains.'
              -> object ' get' ('s')? ' ' statMod '.'
              -> object ' has “At the beginning of your upkeep, you may pay ' cost '. If you do, you gain 1 life.”'
              -> object 'has ' keyword '.' ('This effect doesn't remove ~.')?
              -> 'If you would draw a card during your draw step, instead you may skip that draw. If you do, until your next turn, you can’t be attacked except by creatures with flying and/or islandwalk.'
              -> 'As long as ~ is untapped, all damage that would be dealt to you by unblocked creatures is dealt to ~ instead.'
              -> 'As long as enchanted artifact isn’t a creature, it’s an artifact creature with power and toughness each equal to its mana value.'
              -> 'You may have ~ enter the battlefield as a copy of any creature on the battlefield.'
              -> 'You control' object
              -> 'You may have ~ enter the battlefield as a copy of any artifact on the battlefield, except it’s an enchantment in addition to its other types.'
              -> object ' can’t be blocked except by ' object '.'
              -> 'Other Merfolk get +1/+1 and have islandwalk.'
              -> 'As ~ enters the battlefield, choose a basic land type.'
              -> object ' is the chosen type.'
              -> object ' can’t attack unless defending player controls an Island.'
              -> 'Players skip their untap steps.'
              -> 'You may have Vesuvan Doppelganger enter the battlefield as a copy of any creature on the battlefield, except it doesn’t copy that creature’s color and it has “At the beginning of your upkeep, you may have this creature become a copy of target creature, except it doesn’t copy that creature’s color and it has this ability.”'
              
activatedAbility -> costs ': ' effect

costs -> cost (', ' cost)*

cost -> '{W}'+
     -> '{U}'
     -> '{1}'
     -> '{0}'
     -> '{T}'

effect -> object 'gets ' statMod ' until end of turn.'
                 -> 'The next time a ' color ' source of your choice would deal damage to you this turn, prevent that damage.'
                 -> 'Destroy ' object '.'
                 -> 'The next 1 damage that would be dealt to ' object ' this turn is dealt to its owner instead. Only ' object '’s owner may activate this ability.'
                 -> 'Prevent the next 1 damage that would be dealt to any target this turn.'
                 -> object ' deals 1 damage to any target.'

triggeredAbility -> 'At the beginning of your upkeep, sacrifice ' object ' unless you pay ' cost '.'
                 -> 'At the beginning of each player’s upkeep, ' object ' deals damage to that player equal to the number of Swamps they control.'
                 -> 'When ~ dies, its owner loses half their life, rounded up.'
                 -> 'When ' object ' dies, ~ deals damage equal to that creature’s toughness to the creature’s controller.'
                 -> 'At the beginning of the upkeep of enchanted enchantment’s controller, ~ deals 1 damage to that player.'
                 -> 'Whenever a Forest an opponent controls becomes tapped, you gain 1 life.'
                 -> 'When you control no islands, sacrifice ' object '.'
                 -> 'At the beginning of the upkeep of enchanted enchantment’s controller, that player may pay any amount of mana. Power Leak deals 2 damage to that player. Prevent X of that damage, where X is the amount of mana that player paid this way.'
                 -> 'Whenever enchanted land becomes tapped, ~ deals 2 damage to that land’s controller.'


statMod -> '+1/+1'
        -> '+0/+2'
        -> '+0/+1'
        -> '+1/+2'
        -> '+1/+0'

## Spells

spellCard -> spellAbility (\n spellAbility)*

spellAbility -> 'Destroy ' object '.' (' They can’t be regenerated.')?
             -> 'Each player chooses a number of lands they control equal to the number of lands controlled by the player who controls the fewest, then sacrifices the rest. Players discard cards and sacrifice creatures the same way.'
             -> restriction
             -> object ' can block any number of creatures this turn. It blocks each attacking creature this turn if able.'
             -> 'Regenerate ' object
             -> 'Prevent the next X damage that would be dealt to any target this turn. Until end of turn, you may pay {1} any time you could cast an instant. If you do, prevent the next 1 damage that would be dealt to that permanent or player this turn.'
             -> 'Choose one —\n• Target player gains 3 life.\n• Prevent the next 3 damage that would be dealt to any target this turn.'
             -> object ' becomes ' color '.'
             -> 'Return target creature card from your graveyard to the battlefield.'
             -> 'The next time a source of your choice would deal damage to you this turn, prevent that damage. You gain life equal to the damage prevented this way.'
             -> object ' gets +7/+7 until end of turn.'
             -> 'Exile ' object '. Its controller gains life equal to its power.'
             -> 'Target player draws three cards.'
             -> 'Choose one —\n• Counter target red spell.\n• Destroy target red permanent.'
             -> 'Target player draws X cards.'
             -> 'Counter target spell'
             -> 'Target player activates a mana ability of each land they control. Then that player loses all unspent mana and you add the mana lost this way.'
             -> object ' gains ' keyword ' until end of turn.'
             -> 'Change the text of ' object ' by replacing all instances of one basic land type with another.'
             -> 'Change the text of ' object ' by replacing all instances of one color word with another.'
             -> 'Tap all lands target player controls and that player loses all unspent mana.'
             -> 'Counter target spell unless its controller pays {X}. If that player doesn’t, they tap all lands with mana abilities they control and lose all unspent mana.'
             -> '~ deals 4 damage to any target and 2 damage to you.'
             -> 'Creatures the active player controls attack this turn if able.'
             -> 'At the beginning of the next end step, destroy all non-Wall creatures that player controls that didn’t attack this turn. Ignore this effect for each creature the player didn’t control continuously since the beginning of the turn.'
             -> 'Take an extra turn after this one.'
             -> 'Each player shuffles their hand and graveyard into their library, then draws seven cards.'
             ->'You may tap or untap target artifact, creature, or land.'
            
restriction -> 'Cast this spell only during combat before blockers are declared'
            -> 'Cast this spell only during an opponent’s turn, before attackers are declared.'
            -> 'Counter target spell with mana value X.'
            -> 'Return ' object ' to its owner’s hand.'
            -> 'Destroy X target Mountains. Volcanic Eruption deals damage to each creature and each player equal to the number of Mountains put into a graveyard this way.'


## Definitions
color -> white
      -> blue
      -> black
      -> green
      -> red

object -> '~'
       -> 'creature'
       -> 'land'
       -> 'Wall'
       -> 'artifact'
       -> 'enchantment'
       -> object ' or ' object
       -> 'spell'
       -> 'permanent'
       -> objectQualifier ' ' object
       -> object 's'
       -> object ' ' objectRestriction

objectQualifier -> 'Enchanted'
                -> 'all'
                -> 'target'
                -> color
                -> 'Untapped'
                -> 'blocking'

objectRestriction -> 'you control'
                  -> 'defending player controls'
