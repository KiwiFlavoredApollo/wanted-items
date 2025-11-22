# README

WantedItem is a Cobblemon side mod adding special items for server admins.

- Lucky Egg
- Lucky Box
- Randomizer
- Bottle Caps

This is not unique work of mine and is motivated work of Cobblemizer and Umimplemented Items. Most of the textures have been reworked based on Cobblemon Assets but few of them are from the two mods. I do not intend to provide crafting recipes or acquisition methods for items included in this mod.

## !!! IMPORTANT !!!

Myths and Legends Lucky Box item is removed due to complication of depending on closed source mod.

Few items will be removed or changed in the future. Be sure to provide migration recipes for the users. Following items will be removed in 1.1.8

### To be Removed

- Cobblemon Lucky Box
- Shiny Gold Lucky Box
- Shiny Silver Lucky Box
- Gold Candy Lucky Box
- Silver Candy Lucky Box
- Gold Poke Ball Lucky Box
- Silver Poke Ball Lucky Box
- Ancient Poke Ball Lucky Box

### To be Changed

- Gold Lucky Egg
- Silver Lucky Egg

## Lucky Egg

Lucky Egg items grant random Pokémon to the player. Following Lucky Egg items can be customized to give different kinds of random Pokémon. Customization can be done by installing data packs and resource packs. (see below)

- Red Lucky Egg
- Green Lucky Egg 
- Blue Lucky Egg

### Red Lucky Egg

Already implemented to give random naturally-spawning Pokémon, sourced from [Cobblemon Spawns](https://docs.google.com/spreadsheets/d/1yngaUnlZvuwktxr-TLoh1zgji-9kAlx5mWpWaD3Yb1Y/edit?gid=0#gid=0). It can be still overridden by installing data packs.

### Green Lucky Egg

Needs to be implemented

### Blue Lucky Egg

Needs to be implemented

<details>
<summary>To be Changed in 1.1.8</summary>

### Gold Lucky Egg

Gold Lucky Egg gives any implemented Pokémon.

### Silver Lucky Egg

Silver Lucky Egg gives any implemented Pokémon except,
- Legendary Pokémon
- Mythical Pokémon
- Paradox Pokémon
- Ultra Beast Pokémon
- Mega Evolved Pokémon (Ascension Megamons)

</details>

## Lucky Box

Lucky Box items grant players random items. Following Lucky Box items can be customized to give different kinds of random items. Customization can be done by installing data packs and resource packs. (see below)

- Red Lucky Box
- Green Lucky Box
- Blue Lucky Box

## Lucky Ball

Gives random Poke Ball item, including Master Ball and Origin Ball.

## Lucky Berry

Gives random Berry item.

## Lucky Candy

Gives random Exp. Candy item.

<details>
<summary>To be Removed in 1.1.8</summary>

### Cobblemon Lucky Box

Cobblemon Lucky Box gives random Cobblemon items except, 
- Cobblemon Model items

### Gold Candy Lucky Box

Gold Candy Lucky Box gives random Candy items except,
- Exp Candy XS
- Exp Candy S
- Exp Candy M

### Silver Candy Lucky Box

Silver Candy Lucky Box gives random Candy items.

### Gold Poke Ball Lucky Box

Gold Poke Ball Lucky Box gives random Poke Ball items.

### Silver Poke Ball Lucky Box

Silver Poke Ball Lucky Box gives random Poke Ball items except,
- Master Ball
- Cherish Ball
- Ancient Origin Ball

### Ancient Poke Ball Lucky Box

Ancient Poke Ball Lucky Box gives random Ancient Poke Ball items except,
- Ancient Origin Ball

</details>

## Randomizer

- EV Randomizer
- IV Randomizer
- Level Randomizer

## Bottle Cap

### Bottle Cap

Bottle Cap maximizes specified Pokémon IV. 

### Gold Bottle Cap

Gold Bottle Cap maximizes all IVs.

### Copper Bottle Cap

Copper Bottle Cap zeroes specified Pokémon IV.

## Swappers

### Gender Swapper

Swaps gender. Doesn't work for genderless Pokémon

### Shiny Swapper

Swaps shininess

### Caught Ball Swapper

Swaps with the Poke Ball that the Pokémon is holding.

## Misc

### Ditto Residue

In spite of its name, Ditto Residue does nothing. Server admins can use it as an ingredient for duplicating items.

### Move Activator

When used, it can select Pokémon moves to create special effects. Following moves are available.

- Rain Dance
- Sunny Day
- Thunder
- Toxic
- Smoke Screen
- Agility

## Customization

```
datapacks/
└── your_datapack_name/
    ├── pack.mcmeta
    └── data/
        └── wanteditems/
        │   └── lucky_box/
        │       ├── red_lucky_box.json
        │       ├── green_lucky_box.json
        │       └── blue_lucky_box.json
        │       
        └── wanteditems/
            └── lucky_egg/
                ├── red_lucky_egg.json
                ├── green_lucky_egg.json
                └── blue_lucky_egg.json
```

### Lucky Box

```
{
    "replace": false,
    "values": [
        "minecraft:diamond",
        "minecraft:emerald",
        ...
    ]
}
```

### Lucky Egg

```
{
    "replace": false,
    "values": [
        "cobblemon:bulbasaur",
        "cobblemon:ivysaur",
        "cobblemon:venusaur",
        ...
    ]
}
```

## LICENSE

### GPL 3.0
- Source Code

### CC BY-NC-SA 4.0
- Translations
- Item Textures

## Translation

- [Voldir](https://discordapp.com/users/291233979196243968) (French)

## Credit

- [Cobblemizer](https://modrinth.com/mod/cobblemizer) by Dragomordor
- [UnImplemented Items](https://modrinth.com/mod/cobblemon-unimplemented-items) by tmetcalfe89
- [Cobblemon Assets](https://gitlab.com/cable-mc/cobblemon-assets)
- [Weekly Dot - Christmas](https://polymart.org/product/7274/weekly-dot-christmas) by Hungry22