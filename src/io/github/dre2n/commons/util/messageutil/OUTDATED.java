package io.github.dre2n.commons.util.messageutil;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

class OUTDATED {
	
	static void sendScreenMessage(Player player, String title, String subtitle, long fadeIn, long show, long fadeOut) {
		subtitle = ChatColor.translateAlternateColorCodes('&', subtitle);
		title = ChatColor.translateAlternateColorCodes('&', title);
		MessageUtil.sendCenteredMessage(player, title);
		MessageUtil.sendCenteredMessage(player, subtitle);
	}
	
}
