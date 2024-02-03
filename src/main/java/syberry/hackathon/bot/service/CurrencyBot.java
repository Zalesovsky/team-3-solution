package syberry.hackathon.bot.service;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.Update;
import syberry.hackathon.bot.config.BotConfig;

import java.util.Objects;

@Component
public class CurrencyBot extends TelegramLongPollingBot {
    private final BotConfig config;

    public CurrencyBot(BotConfig config) {
        this.config = config;
    }

    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (!Objects.equals(update.getMessage(), null) && !Objects.equals(update.getMessage().getText(), null)) {
            String message = update.getMessage().getText();
            Chat chat = update.getMessage().getChat();
            long chatId = chat.getId();

        }
    }


}
