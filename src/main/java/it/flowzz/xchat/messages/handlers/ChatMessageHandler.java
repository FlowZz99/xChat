package it.flowzz.xchat.messages.handlers;

import com.glyart.ermes.messages.IMessageHandler;
import it.flowzz.xchat.messages.ChatMessage;
import it.flowzz.xsync.api.SyncAPI;
import net.kyori.adventure.audience.MessageType;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import org.bukkit.Bukkit;

public class ChatMessageHandler implements IMessageHandler<ChatMessage> {

    @Override
    public void handle(ChatMessage message) {
        //Check if the message target is this server
        if (!message.canReceive(SyncAPI.getInstance().getCurrentServerId())) {
            return;
        }
        //Replicate the message
        Component component = Component.translatable("chat.type.text",
                GsonComponentSerializer.gson().deserialize(message.getSenderName()),
                GsonComponentSerializer.gson().deserialize(message.getMessage()));
        Bukkit.getOnlinePlayers().forEach(player -> player.sendMessage(component, MessageType.CHAT));
    }
}
