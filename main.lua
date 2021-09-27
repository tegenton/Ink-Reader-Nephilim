card = {}
card.isGood = false

creature = {}
creature_meta = {}
creature_meta.__index = card
setmetatable(creature, creature_meta)

print(creature.isGood)
