/*
 * Written from 2015-2018 by Daniel Saukel
 *
 * To the extent possible under law, the author(s) have dedicated all
 * copyright and related and neighboring rights to this software
 * to the public domain worldwide.
 *
 * This software is distributed without any warranty.
 *
 * You should have received a copy of the CC0 Public Domain Dedication
 * along with this software. If not, see <http://creativecommons.org/publicdomain/zero/1.0/>.
 */
package de.erethon.commons.chat;

import net.minecraft.server.v1_11_R1.IChatBaseComponent;
import net.minecraft.server.v1_11_R1.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_11_R1.PacketPlayOutChat;
import net.minecraft.server.v1_11_R1.PlayerConnection;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

/**
 * @author Daniel Saukel
 */
class v1_11_R1 extends InternalsProvider {

    @Override
    void sendActionBarMessage(Player player, String message) {
        message = ChatColor.translateAlternateColorCodes('&', message);
        IChatBaseComponent messageComponent = ChatSerializer.a("{\"text\": \"" + message + "\"}");
        PacketPlayOutChat barPacket = new PacketPlayOutChat(messageComponent, (byte) 2);
        PlayerConnection connection = ((CraftPlayer) player).getHandle().playerConnection;
        connection.sendPacket(barPacket);
    }

}
