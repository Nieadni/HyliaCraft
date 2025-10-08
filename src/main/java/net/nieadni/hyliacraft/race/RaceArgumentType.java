package net.nieadni.hyliacraft.race;

import com.mojang.brigadier.LiteralMessage;
import com.mojang.brigadier.Message;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandExceptionType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.CompletableFuture;

public class RaceArgumentType implements ArgumentType<HyliaCraftRace> {

    private static final Message EXCEPTION_MESSAGE = new LiteralMessage("Expected enum entry from HyliaCraftRace");
    private static final CommandExceptionType EXCEPTION_TYPE = new SimpleCommandExceptionType(EXCEPTION_MESSAGE);

    @Override
    public HyliaCraftRace parse(StringReader reader) throws CommandSyntaxException {
        int start = reader.getCursor();
        String raceString = reader.readString();
        try {
            return HyliaCraftRace.valueOf(raceString);
        } catch (IllegalArgumentException e) {
            reader.setCursor(start);
            throw new CommandSyntaxException(EXCEPTION_TYPE, EXCEPTION_MESSAGE);
        }
    }

    @Override
    public <S> CompletableFuture<Suggestions> listSuggestions(CommandContext<S> context, SuggestionsBuilder builder) {
        for (HyliaCraftRace race : HyliaCraftRace.values()) {
            String id = race.toString();
            if (id.toLowerCase().startsWith(builder.getRemainingLowerCase())) {
                builder.suggest(id);
            }
        }
        return builder.buildFuture();
    }

    @Override
    public Collection<String> getExamples() {
        return Arrays.stream(HyliaCraftRace.values())
                .map(HyliaCraftRace::toString)
                .toList();
    }
}
