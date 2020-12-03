package net.pl3x.bukkit.stub.nms.v1_16_R2;

import net.minecraft.server.v1_16_R2.BlockPosition;
import net.minecraft.server.v1_16_R2.Entity;
import net.minecraft.server.v1_16_R2.EntityTypes;
import net.minecraft.server.v1_16_R2.EnumMobSpawn;
import net.minecraft.server.v1_16_R2.WorldServer;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class NMSHandler implements net.pl3x.bukkit.stub.api.NMSHandler {
    @Override
    public org.bukkit.entity.Entity spawnCow(Location location, Player player) {
        BlockPosition pos = new BlockPosition(location.getBlockX(), location.getBlockY(), location.getBlockZ());
        WorldServer nmsWorld = ((CraftWorld) location.getWorld()).getHandle();
        Entity cow = EntityTypes.COW.spawnCreature(nmsWorld, null, ((CraftPlayer) player).getHandle(), pos, EnumMobSpawn.COMMAND, false, false);
        return cow == null ? null : cow.getBukkitEntity();
    }
}
