package it.flowzz.xchat.messages;

import com.glyart.ermes.utils.ErmesDataInput;
import com.glyart.ermes.utils.ErmesDataOutput;
import it.flowzz.xsync.messages.AbstractMessage;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Message used to sync chat messages for each server.
 */
@Getter
@NoArgsConstructor
public class ChatMessage extends AbstractMessage {

    private String senderName;
    private String message;

    public ChatMessage(String senderId, String receiverId, String senderName, String message) {
        super(senderId, receiverId);
        this.senderName = senderName;
        this.message = message;
    }

    @Override
    public void read(ErmesDataInput input) {
        this.senderName = input.readUTF();
        this.message = input.readUTF();
    }

    @Override
    public void write(ErmesDataOutput output) {
        output.writeUTF(senderName);
        output.writeUTF(message);
    }
}
