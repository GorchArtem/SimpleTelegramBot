package com.simple.tgbot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "SimpleGeraltBot";
    }

    @Override
    public String getBotToken() {
        return "5768159507:AAEXsvyxBDdce5YZdRHdC6-jBqh2rK1J0lM";
    }

    @Override
    public void onUpdateReceived(Update update) {
        try {
            if (update.hasMessage() && update.getMessage().hasText()) {
                Message inMessage = update.getMessage();

                SendMessage outMessage = new SendMessage();

                outMessage.setChatId(inMessage.getChatId());

                outMessage.setText(inMessage.getText());

                execute(outMessage);
            }
        }catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}
