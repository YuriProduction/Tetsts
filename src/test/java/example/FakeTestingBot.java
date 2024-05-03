package example;

import example.bot.Bot;

import java.util.ArrayList;
import java.util.List;

/**
 * Фэйк-бот для тестирования
 */
public class FakeTestingBot implements Bot
{
    /**
     * Хранит сообщения для пользователей от бота
     */
    private final List<String> messagesToUser = new ArrayList<>();

    @Override
    public void sendMessage(Long chatId, String message)
    {
        messagesToUser.add(message);
    }

    /**
     * Получаем сообщение по индексу
     */
    public String getByIndex(int i)
    {
        return messagesToUser.get(i);
    }

    /**
     * Получить сколько сообщений хранится
     */
    public int getMessagesToUserSize()
    {
        return messagesToUser.size();
    }
}
