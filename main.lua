card = {}
card.isGood = false

creature = {}
setmetatable(creature, card)

print(creature.isGood)
