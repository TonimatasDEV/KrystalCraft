package net.tonimatasdev.krystalcraft.plorix.networking;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public interface  PacketContext {
    void apply(Player player, Level level);
}
