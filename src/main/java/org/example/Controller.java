package org.example;

import org.example.instagramUserInfo.InstagramUserInfo;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Controller extends TelegramLongPollingBot {
    private final String TOKEN="7167826147:AAFuUgOHus80rjGQMAmah1tXNlEtf18v7fk";
    private final String USERNAME="yeietest0_bot";
    private final InstagramUserInfo instagramUserInfo=new InstagramUserInfo();
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()){
            Message message = update.getMessage();
            if (message.hasText()){
                String text = message.getText();
                if (text.equals("/start")){
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setChatId(message.getChatId());
                    sendMessage.setText("ma`lumotlarini olmoqchi bo`lgan instagram foydalanuvchisining username ini kiriting");
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                else {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setChatId(message.getChatId());
                    sendMessage.setText("Instagram bilan connection vaqti cho`zilib ketishi mumkin biroz kuting...");
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }

                    sendMessage.setChatId(message.getChatId());
                    sendMessage.setText(instagramUserInfo.getInstagramUserInfo(text
                    ));
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    @Override
    public String getBotToken() {
        return TOKEN;
    }

    @Override
    public String getBotUsername() {
        return USERNAME;
    }
}
