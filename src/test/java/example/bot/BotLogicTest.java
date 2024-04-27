package example.bot;

import example.FakeTestingBot;
import org.junit.Test;

import static org.junit.Assert.*;

public class BotLogicTest
{
    /**
     * /test
     */
    @Test
    public void testTestingCommand()
    {
        final FakeTestingBot fakeTestingBot = new FakeTestingBot();
        final BotLogic botLogic = new BotLogic(fakeTestingBot);
        final User user = new User(1L);
        botLogic.processCommand(user, "/test");
        assertEquals("Вычислите степень: 10^2", fakeTestingBot.getMessageToUser());
        botLogic.processCommand(user, "/test");
        assertEquals("Сколько будет 2 + 2 * 2", fakeTestingBot.getMessageToUser());
    }

    /**
     * /notify
     */
    @Test
    public void testNotifyCommand()
    {
        final FakeTestingBot fakeTestingBot = new FakeTestingBot();
        final BotLogic botLogic = new BotLogic(fakeTestingBot);
        final User user = new User(1L);
        botLogic.processCommand(user, "/notify");
        assertEquals("Введите текст напоминания", fakeTestingBot.getMessageToUser());
        botLogic.processCommand(user, "Завтра пара в 12:10");
        assertEquals("Через сколько секунд напомнить?", fakeTestingBot.getMessageToUser());
    }

    /**
     * /repeat
     */
    @Test
    public void testRepeatCommand()
    {
        final FakeTestingBot fakeTestingBot = new FakeTestingBot();
        final BotLogic botLogic = new BotLogic(fakeTestingBot);
        final User user = new User(1L);
        botLogic.processCommand(user, "/repeat");
        assertEquals("Нет вопросов для повторения", fakeTestingBot.getMessageToUser());
    }
}