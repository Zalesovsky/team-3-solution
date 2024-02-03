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
import syberry.hackathon.bank.service.impl.AlfaBankServiceImpl;
import syberry.hackathon.bank.service.impl.BankNamesServiceImpl;
import syberry.hackathon.bank.service.impl.BelarusBankServiceImpl;
import syberry.hackathon.bank.service.impl.NationalBankServiceImpl;
import syberry.hackathon.bot.config.BotConfig;
import syberry.hackathon.bot.constant.Constant;
import syberry.hackathon.bot.model.StepCombination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CurrencyBot extends TelegramLongPollingBot {


    private Map<Long, StepCombination> usersSteps = new HashMap<>();

    StepCombination stepCombination = new StepCombination();
    private final BotConfig config;
    private final BankNamesServiceImpl bankNames;
    private final AlfaBankServiceImpl alfaBankService;
    private final NationalBankServiceImpl nationalBankService;
    private final BelarusBankServiceImpl belarusBankService;

    public CurrencyBot(BotConfig config, BankNamesServiceImpl bankNames, AlfaBankServiceImpl alfaBankService, NationalBankServiceImpl nationalBankService, BelarusBankServiceImpl belarusBankService) {
        this.config = config;
        this.bankNames = bankNames;
        this.alfaBankService = alfaBankService;
        this.nationalBankService = nationalBankService;
        this.belarusBankService = belarusBankService;
    }


    @Override
    public String getBotUsername() {
        return config.getBotName();
    }


    @Override
    public String getBotToken() {
        return config.getBotToken();
    }


    @Override
    public void onUpdateReceived(Update update) {

        Message message = update.getMessage();

        long chatId = message.getChatId();

        if (message.hasText()) {

            if (message.getText().equals("/start")) {

                initGreetKeyboard(message);
            }

            if (bankNames.getAllBankNames().contains(message.getText())) {

                stepCombination.setBankName(message.getText());
                usersSteps.put(chatId, stepCombination);
            }

            if (message.getText().equals("Альфа-Банк")) {

                initCurrencyKeyboardAlphaBank(message, alfaBankService);

            } else if (message.getText().equals("Беларусбанк")) {

                initCurrencyKeyboardBelarusbank(message, belarusBankService);
            } else if (message.getText().equals("Нацбанк Республики Беларусь")) {

                initCurrencyKeyboardNatsBank(message, nationalBankService);
            }

            stepCombination.setCurrency(message.getText());

            usersSteps.put(chatId, stepCombination);

            getABCurrencies(message);
//            initPeriodsKeyboard(message);
        }
    }


    private void initGreetKeyboard(Message message) {

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
                    .text("Привет! Чтобы воспользоваться функциями бота сперва выбери банк из меню снизу.")
                    .chatId(message.getChatId())
                    .replyMarkup(replyKeyboardMarkup)
                    .build());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void initCurrencyKeyboardAlphaBank(Message message, AlfaBankServiceImpl bankService) {

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);

        List<KeyboardRow> rows = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();

        for (String currency : bankService.getAllCurrencies()) {

            row1.add(new KeyboardButton(currency));
        }

        rows.add(row1);

        replyKeyboardMarkup.setKeyboard(rows);

        try {
            execute(SendMessage.builder()
                    .text("Ты выбрал " + usersSteps.get(message.getChatId()).getBankName() + ". Теперь выбери нужную тебе валюту из списка ниже.")
                    .chatId(message.getChatId())
                    .replyMarkup(replyKeyboardMarkup)
                    .build());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void initCurrencyKeyboardBelarusbank(Message message, BelarusBankServiceImpl bankService) {

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);

        List<KeyboardRow> rows = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();

        for (String currency : bankService.getAllCurrencies()) {

            row1.add(new KeyboardButton(currency));
        }

        rows.add(row1);

        replyKeyboardMarkup.setKeyboard(rows);

        try {
            execute(SendMessage.builder()
                    .text("Ты выбрал " + usersSteps.get(message.getChatId()).getBankName() + ". Теперь выбери нужную тебе валюту из списка ниже.")
                    .chatId(message.getChatId())
                    .replyMarkup(replyKeyboardMarkup)
                    .build());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void initCurrencyKeyboardNatsBank(Message message, NationalBankServiceImpl bankService) {

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setResizeKeyboard(true);

        List<KeyboardRow> rows = new ArrayList<>();

        KeyboardRow row1 = new KeyboardRow();

        for (String currency : bankService.getAllCurrencies()) {

            row1.add(new KeyboardButton(currency));
        }

        rows.add(row1);

        replyKeyboardMarkup.setKeyboard(rows);

        try {
            execute(SendMessage.builder()
                    .text("Ты выбрал " + usersSteps.get(message.getChatId()).getBankName() + ". Теперь выбери нужную тебе валюту из списка ниже.")
                    .chatId(message.getChatId())
                    .replyMarkup(replyKeyboardMarkup)
                    .build());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void getABCurrencies(Message message) {
        String answer = "";
        switch (stepCombination.getBankName()) {
            case ("Альфа-Банк"):
                switch(stepCombination.getCurrency()){
                    case("доллар"):
                        answer = alfaBankService.getRateForDateUSD("");
                        break;
                    case("евро"):
                        answer = alfaBankService.getRateForDateEUR("");
                        break;
                    case("российский рубль"):
                        answer = alfaBankService.getRateForDateRUB("");
                        break;
                }
                break;
            case ("Беларусбанк"):
                switch(stepCombination.getCurrency()){
                    case("доллар"):
                        answer = belarusBankService.getRateForDateUSD("");
                        break;
                    case("евро"):
                        answer = belarusBankService.getRateForDateEUR("");
                        break;
                    case("российский рубль"):
                        answer =  belarusBankService.getRateForDateRUB("");
                        break;
                }
                break;
            case ("Нацбанк Республики Беларусь"):
                switch(stepCombination.getCurrency()) {
                    case ("доллар"):
                        answer = nationalBankService.getRateForDateUSD("2024-02-03");
                        break;
                    case ("евро"):
                        answer = nationalBankService.getRateForDateEUR("2024-02-03");
                        break;
                    case ("российский рубль"):
                        answer = nationalBankService.getRateForDateRUB("2024-02-03");
                        break;
                }
                break;
        }
        try {
            execute(SendMessage.builder()
                    .chatId(message.getChatId())
                    .text(answer)
                    .build());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private void initPeriodsKeyboard(Message message) {

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
                    .text("Выбранная валюта " + usersSteps.get(message.getChatId()).getCurrency() + ".")
                    .chatId(message.getChatId())
                    .replyMarkup(replyKeyboardMarkup)
                    .build());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
