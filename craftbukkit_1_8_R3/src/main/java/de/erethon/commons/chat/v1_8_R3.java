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

import net.md_5.bungee.api.ChatMessageType;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

/**
 * @author Daniel Saukel
 */
class v1_8_R3 extends InternalsProvider {

    @Override
    Object buildPacketPlayOutChat(ChatMessageType type, String message) {
        return new PacketPlayOutChat(ChatSerializer.a(message), getNMSCMT(type));
    }

    @Override
    void sendTitleMessage(Player player, String title, String subtitle, int fadeIn, int show, int fadeOut) {
        IChatBaseComponent subtitleComponent = ChatSerializer.a("{\"text\": \"" + subtitle + "\"}");
        IChatBaseComponent titleComponent = ChatSerializer.a("{\"text\": \"" + title + "\"}");

        PacketPlayOutTitle subtitlePacket = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, subtitleComponent);
        PacketPlayOutTitle titlePacket = new PacketPlayOutTitle(EnumTitleAction.TITLE, titleComponent);
        PacketPlayOutTitle timesPacket = new PacketPlayOutTitle(fadeIn, show, fadeOut);

        PlayerConnection connection = ((CraftPlayer) player).getHandle().playerConnection;
        connection.sendPacket(subtitlePacket);
        connection.sendPacket(titlePacket);
        connection.sendPacket(timesPacket);
    }

}
