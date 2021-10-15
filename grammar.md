# Grammar for Alpha

## Permanents
ability -> keywords
        -> staticAbility
        -> activatedAbility
        -> triggeredAbility

keywords -> enchantAbility | 'Banding'

staticAbility -> 'Enchanted Wall can attack as though it didn't have defender.'
              -> 'Enchanted creature has protection from ' color '. This effect doesn't remove ~'
              -> 'Untapped creatures you control get +0/+2.'
              -> 'Enchanted land has indestructible and can’t be enchanted by other Auras.'
              -> 'All mountains are plains.'

activatedAbility -> '{W}: Enchanted creature gets +1/+1 until end of turn.'
                 -> '{1}: The next time a ' color ' source of your choice would deal damage to you this turn, prevent that damage.'

triggeredAbility -> 'At the beginning of your upkeep, sacrifice Conversion unless you pay {W}{W}'

enchantAbility -> 'Enchant' object

object -> 'Wall'
       -> 'creature'
       -> 'land'

## Spells
spellAbility -> 'Destroy all lands'
             -> 'Each player chooses a number of lands they control equal to the number of lands controlled by the player who controls the fewest, then sacrifices the rest. Players discard cards and sacrifice creatures the same way.'
             -> restriction
             -> 'Target creature defending player controls can block any number of creatures this turn. It blocks each attacking creature this turn if able.'

restriction -> 'Cast this spell only during combat before blockers are declared'

## Definitions
color -> white
      -> blue
      -> black
      -> green
      -> red
