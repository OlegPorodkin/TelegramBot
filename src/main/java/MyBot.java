import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.List;

public class MyBot extends AbilityBot {

    protected MyBot(String botToken, String botUsername, DefaultBotOptions options) {
        super(botToken, botUsername, options);
    }

    public int creatorId() {
        return 0;
    }

    public void onUpdatesReceived(List<Update> updates) {
        Message message = updates.get(0).getMessage();

        if (message != null && message.hasText()) {
            switch (message.getText()) {
                case "/help":
                    sendMsg(message, "Че надо!");
                    break;
                case "/setting":
                    sendMsg(message, "Что будем настраивать!");
                    break;
            }
        }
    }

    private void sendMsg(Message message, String s) {
        SendMessage sm = new SendMessage();
        sm.enableMarkdown(true);
        sm.setChatId(message.getChatId().toString());
        sm.setReplyToMessageId(message.getMessageId());
        sm.setText(s);
        try{
            sendMessage(sm);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}
