package example;

import example.bot.Bot;

/**
 * Фэйк-бот для тестирования
 */
public class FakeTestingBot implements Bot
{
    private String messageToUser;

    @Override
    public void sendMessage(Long chatId, String message)
    {
        messageToUser = message;
    }

    public String getMessageToUser()
    {
        return messageToUser;
    }
}
