package net.pl3x.bukkit.stub.nms.v1_16_R1;

import net.minecraft.server.v1_16_R1.BlockPosition;
import net.minecraft.server.v1_16_R1.Entity;
import net.minecraft.server.v1_16_R1.EntityTypes;
import net.minecraft.server.v1_16_R1.EnumMobSpawn;
import net.minecraft.server.v1_16_R1.WorldServer;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R1.entity.CraftPlayer;
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
