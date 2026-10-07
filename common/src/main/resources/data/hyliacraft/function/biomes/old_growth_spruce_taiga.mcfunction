scoreboard objectives add temp dummy
execute store result score @s temp run random value 1..100

execute if score @s temp matches 1..100 run function hyliacraft:wolf_variant/chestnut

scoreboard objectives remove temp