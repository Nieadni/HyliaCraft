execute as @s[name=Link,nbt={variant:"hyliacraft:maraudo"}] run function hyliacraft:wolf_variant/maraudo_link
execute as @s[name=!Link,nbt={variant:"hyliacraft:maraudo_link"}] run function hyliacraft:wolf_variant/maraudo

tag @s add init.dog_name