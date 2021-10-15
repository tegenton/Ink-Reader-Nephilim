# Grammar for Alpha

## Permanents
permanentCard -> ability? ('\n' ability)*

ability -> keywords
        -> staticAbility
        -> activatedAbility
        -> triggeredAbility

keywords -> keyword ([;,]' ' keyword)*

keyword -> enchantAbility
        -> 'Banding'
        -> 'First strike'
        -> 'Flying'
        -> 'Vigilance'
        -> 'Defender'
        -> 'Protection from ' color

staticAbility -> 'Enchanted Wall can attack as though it didn't have defender.'
              -> 'Untapped creatures you control get ' statMod '.'
              -> 'Enchanted land has indestructible and can’t be enchanted by other Auras.'
              -> 'All mountains are plains.'
              -> 'White creatures get ' statMod '.'
              -> 'Enchanted land has “At the beginning of your upkeep, you may pay ' cost '. If you do, you gain 1 life.”'
              -> 'Enchanted creature gets ' statMod '.'
              -> 'Enchanted creature has ' keyword '.' ('This effect doesn't remove ~.')?
              -> 'If you would draw a card during your draw step, instead you may skip that draw. If you do, until your next turn, you can’t be attacked except by creatures with flying and/or islandwalk.'
              -> 'As long as ~ is untapped, all damage that would be dealt to you by unblocked creatures is dealt to ~ instead.'
              
activatedAbility -> costs ': ' effect

costs -> cost (', ' cost)*

cost -> '{W}'+
     -> '{1}'
     -> '{0}'
     -> '{T}'

effect -> 'Enchanted creature gets ' statMod ' until end of turn.'
                 -> 'The next time a ' color ' source of your choice would deal damage to you this turn, prevent that damage.'
                 -> 'Destroy target black permanent.'
                 -> 'The next 1 damage that would be dealt to ~ this turn is dealt to its owner instead. Only ~’s owner may activate this ability.'
                 -> 'Prevent the next 1 damage that would be dealt to any target this turn.'

triggeredAbility -> 'At the beginning of your upkeep, sacrifice Conversion unless you pay ' cost '.'
                 -> 'At the beginning of each player’s upkeep, Karma deals damage to that player equal to the number of Swamps they control.'
                 -> 'When ~ dies, its owner loses half their life, rounded up.'

enchantAbility -> 'Enchant' object

statMod -> '+1/+1'
        -> '+0/+2'
        -> '+0/+1'
        -> '+1/+2'

## Spells

spellCard -> spellAbility (\n spellAbility)*

spellAbility -> 'Destroy all lands'
             -> 'Each player chooses a number of lands they control equal to the number of lands controlled by the player who controls the fewest, then sacrifices the rest. Players discard cards and sacrifice creatures the same way.'
             -> restriction
             -> 'Target creature defending player controls can block any number of creatures this turn. It blocks each attacking creature this turn if able.'
             -> 'Regenerate target creature'
             -> 'Destroy target artifact or enchantment'
             -> 'Prevent the next X damage that would be dealt to any target this turn. Until end of turn, you may pay {1} any time you could cast an instant. If you do, prevent the next 1 damage that would be dealt to that permanent or player this turn.'
             -> 'Choose one —\n• Target player gains 3 life.\n• Prevent the next 3 damage that would be dealt to any target this turn.'
             -> 'Target spell or permanent becomes ' color '.'
             -> 'Return target creature card from your graveyard to the battlefield.'
             -> 'The next time a source of your choice would deal damage to you this turn, prevent that damage. You gain life equal to the damage prevented this way.'
             -> 'Target blocking creature gets +7/+7 until end of turn.'
             -> 'Exile target creature. Its controller gains life equal to its power.'
             -> 'Destroy all creatures. They can’t be regenerated.'

restriction -> 'Cast this spell only during combat before blockers are declared'

## Definitions
color -> white
      -> blue
      -> black
      -> green
      -> red

object -> 'Wall'
       -> 'creature'
       -> 'land'
