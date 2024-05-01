package example.bot;

import example.FakeTestingBot;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BotLogicTest
{
    private FakeTestingBot fakeTestingBot;
    private BotLogic botLogic;
    private User user;

    @Before
    public void beforeEachTestMethod()
    {
        fakeTestingBot = new FakeTestingBot();
        botLogic = new BotLogic(fakeTestingBot);
        user = new User(1L);
    }

    /**
     * тестируем команду /test на правильность ответов
     */
    @Test
    public void testTestingCommandCorrectAnswers()
    {
        botLogic.processCommand(user, "/test");
        botLogic.processCommand(user, "100");
        assertEquals("Правильный ответ!", fakeTestingBot.getByIndex(1));
        botLogic.processCommand(user, "8");
        assertEquals("Вы ошиблись, верный ответ: 6", fakeTestingBot.getByIndex(3));
    }

    /**
     * тестируем команду /notify с отрицательным временем напоминания
     */
    @Test(expected = IllegalArgumentException.class)
    public void testNotifyCommandIllegalTime()
    {
        botLogic.processCommand(user, "/notify");
        botLogic.processCommand(user, "Завтра пара в 12:10");
        botLogic.processCommand(user, "-1");
    }

    /**
     * Проверяем, что /notify реально работает через какое-то время
     */
    @Test
    public void testNotifyCommandNotifyWorked() throws InterruptedException
    {
        botLogic.processCommand(user, "/notify");
        botLogic.processCommand(user, "Завтра пара в 12:10");
        botLogic.processCommand(user, "1");
        Thread.sleep(1100);
        assertEquals("Сработало напоминание: 'Завтра пара в 12:10'", fakeTestingBot.getByIndex(3));
    }

    /**
     * тестируем команду /repeat
     */
    @Test
    public void testRepeatCommand()
    {
        botLogic.processCommand(user, "/repeat");
        assertEquals("Нет вопросов для повторения", fakeTestingBot.getByIndex(0));
        botLogic.processCommand(user, "/test");
        botLogic.processCommand(user, "99");
        botLogic.processCommand(user, "/repeat");
        assertEquals("Вычислите степень: 10^2", fakeTestingBot.getByIndex(4));
        botLogic.processCommand(user, "100");
        assertEquals("Правильный ответ!", fakeTestingBot.getByIndex(5));
    }
}