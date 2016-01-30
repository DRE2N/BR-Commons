package io.github.dre2n.commons.util.messageutil;

import net.minecraft.server.v1_8_R2.IChatBaseComponent;
import net.minecraft.server.v1_8_R2.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R2.PlayerConnection;
import net.minecraft.server.v1_8_R2.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R2.PacketPlayOutTitle.EnumTitleAction;

import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

class v1_8_R2 {
	
	static void sendScreenMessage(Player player, String title, String subtitle, int fadeIn, int show, int fadeOut) {
		subtitle = ChatColor.translateAlternateColorCodes('&', subtitle);
		title = ChatColor.translateAlternateColorCodes('&', title);
		
		IChatBaseComponent subtitleComponent = ChatSerializer.a("{\"text\": \"" + subtitle + "\"}");
		IChatBaseComponent titleComponent = ChatSerializer.a("{\"text\": \"" + title + "\"}");
		
		PacketPlayOutTitle clearPacket = new PacketPlayOutTitle(EnumTitleAction.CLEAR, titleComponent);
		PacketPlayOutTitle resetPacket = new PacketPlayOutTitle(EnumTitleAction.RESET, titleComponent);
		PacketPlayOutTitle subtitlePacket = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, subtitleComponent);
		PacketPlayOutTitle titlePacket = new PacketPlayOutTitle(EnumTitleAction.TITLE, titleComponent);
		PacketPlayOutTitle timesPacket = new PacketPlayOutTitle(fadeIn, show, fadeOut);
		
		PlayerConnection connection = ((CraftPlayer) player).getHandle().playerConnection;
		connection.sendPacket(clearPacket);
		connection.sendPacket(resetPacket);
		connection.sendPacket(subtitlePacket);
		connection.sendPacket(titlePacket);
		connection.sendPacket(timesPacket);
	}
	
}
