package com.sniklz.springtelegrambot.service;

import lombok.Data;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.nio.file.Path;

@Data
public class MessageToSticker {

    private String message;
    private String imageFilePath;
    private TelegramBot bot;

    public MessageToSticker(String message, String imageFilePath, TelegramBot bot) {
        this.message = message;
        this.imageFilePath = imageFilePath;
        this.bot = bot;
    }

    public void checkMessage(Message receivedMessage) {
        if(receivedMessage.getText().toLowerCase().equals(message.toLowerCase())) {
            String chatId = receivedMessage.getChatId().toString();
            bot.DeleteMessage(chatId, receivedMessage.getMessageId());

            bot.SendMessage(chatId, imageFilePath);
        }
    }

}
