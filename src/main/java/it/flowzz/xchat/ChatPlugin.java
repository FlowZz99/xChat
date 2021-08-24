package it.flowzz.xchat;

import it.flowzz.xchat.listeners.ChatListener;
import it.flowzz.xchat.messages.ChatMessage;
import it.flowzz.xchat.messages.handlers.ChatMessageHandler;
import it.flowzz.xsync.api.SyncAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ChatPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        registerMessage();
        registerListeners();
    }

    private void registerListeners() {
        Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
    }

    private void registerMessage() {
        //Register the message
        SyncAPI.getInstance().registerMessage(ChatMessage.class);
        //Register your message handler
        SyncAPI.getInstance().registerMessageHandler(ChatMessage.class, new ChatMessageHandler());
    }
}
