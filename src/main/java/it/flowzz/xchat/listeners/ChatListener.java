package it.flowzz.xchat.listeners;

import io.papermc.paper.event.player.AsyncChatEvent;
import it.flowzz.xchat.messages.ChatMessage;
import it.flowzz.xsync.api.SyncAPI;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncChatEvent event) {
        String messageJson = GsonComponentSerializer.gson().serialize(event.message());
        String nameJson = GsonComponentSerializer.gson().serialize(event.getPlayer().displayName());
        SyncAPI.getInstance().sendMessage(new ChatMessage(SyncAPI.getInstance().getCurrentServerId(), "Broadcast", nameJson, messageJson));
    }
}
