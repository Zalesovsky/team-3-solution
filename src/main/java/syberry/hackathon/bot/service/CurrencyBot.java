package syberry.hackathon.bot.service;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import syberry.hackathon.bank.service.impl.BankNamesServiceImpl;
import syberry.hackathon.bot.config.BotConfig;
import syberry.hackathon.bot.constant.Constant;

import java.util.ArrayList;
import java.util.List;

@Component
public class CurrencyBot extends TelegramLongPollingBot {

    private final BotConfig config;

    private final BankNamesServiceImpl bankNames;

    private String currentBank;

    private String currentCurrency;

    public CurrencyBot(BotConfig config, BankNamesServiceImpl bankNames) {
        this.config = config;
        this.bankNames = bankNames;
    }


    @Override
    public String getBotUsername() {
        return config.getBotName();
    }


    @Override
    public String getBotToken(){
        return config.getBotToken();
    }


    @Override
    public void onUpdateReceived(Update update) {

        Message message = update.getMessage();

        if (message.hasText()){

            if (message.getText().equals("/start") && currentBank==null){

                initGreetKeyboard(message);
            }

            if (bankNames.getAllBankNames().contains(message.getText())){
                currentBank = message.getText();

                initCurrencyKeyboard(message);
            }
        }
    }


    private void initGreetKeyboard(Message message){

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);

        List<KeyboardRow> rows = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();

        for (String str :
                bankNames.getAllBankNames()) {

            row1.add(new KeyboardButton(str));
        }

        rows.add(row1);

        replyKeyboardMarkup.setKeyboard(rows);

        try {
            execute(SendMessage.builder()
                    .text("Привет! Чтобы воспользоваться фукциями бота сперва выбери банк из меню снизу.")
                    .chatId(message.getChatId())
                    .replyMarkup(replyKeyboardMarkup)
                    .build());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void initCurrencyKeyboard(Message message){

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);

        List<KeyboardRow> rows = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();

        rows.add(row1);

        replyKeyboardMarkup.setKeyboard(rows);

        try {
            execute(SendMessage.builder()
                    .text("Ты выбрал " + currentBank + ". Теперь выбери нужную тебе валюту из списка ниже.")
                    .chatId(message.getChatId())
                    .replyMarkup(replyKeyboardMarkup)
                    .build());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }


    }

    private void initPeriodsKeyboard(Message message){

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);

        List<KeyboardRow> rows = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton(Constant.CURRENT_DAY_COURSE));
        row1.add(new KeyboardButton(Constant.SELECTED_DAY_COURSE));
        row1.add(new KeyboardButton(Constant.COLLECT_DATA));

        KeyboardRow row2 = new KeyboardRow();

        row2.add(new KeyboardButton(Constant.CHOOSE_DIFFERENT_BANK));
        row2.add(new KeyboardButton(Constant.CHOOSE_DIFFERENT_CURRENCY));

        rows.add(row1);
        rows.add(row2);

        replyKeyboardMarkup.setKeyboard(rows);

        try {
            execute(SendMessage.builder()
                    .text("Выбранная валюта " + currentCurrency + ".")
                    .chatId(message.getChatId())
                    .replyMarkup(replyKeyboardMarkup)
                    .build());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }
}
