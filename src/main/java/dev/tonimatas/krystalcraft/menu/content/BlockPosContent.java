package dev.tonimatas.krystalcraft.menu.content;
/*
import com.teamresourceful.resourcefullib.common.menu.MenuContent;
import com.teamresourceful.resourcefullib.common.menu.MenuContentSerializer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public record BlockPosContent(BlockPos pos) implements MenuContent<BlockPosContent> {
    public static final MenuContentSerializer<BlockPosContent> SERIALIZER = new Serializer();


    public static BlockEntity getOrNull(Optional<BlockPosContent> content, Level level) {
        return content.map(blockPosContent -> level.getBlockEntity(blockPosContent.pos())).orElse(null);
    }
    
    @Override
    public MenuContentSerializer<BlockPosContent> serializer() {
        return SERIALIZER;
    }

    private static class Serializer implements MenuContentSerializer<BlockPosContent> {
        @Override
        public void to(FriendlyByteBuf buffer, BlockPosContent content) {
            buffer.writeBlockPos(content.pos);
        }

        @Override
        public @Nullable BlockPosContent from(FriendlyByteBuf buffer) {
            return new BlockPosContent(buffer.readBlockPos());
        }
    }
}*/
