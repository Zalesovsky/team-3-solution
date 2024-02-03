package syberry.hackathon.bot.service;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import syberry.hackathon.bot.config.BotConfig;

@Component
public class CurrencyBot extends TelegramLongPollingBot {

    private BotConfig config;


    @Override
    public void onUpdateReceived(Update update) {

        Message message = update.getMessage();
        

    }

    @Override
    public String getBotUsername() {
        return config.getBotName();
    }
}
