package example.container;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContainerTest
{

    /**
     * Проверяем метод add
     */
    @Test
    public void add()
    {
        final Container container = new Container();
        container.add(new Item(1));
        container.add(new Item(2));
        final Item item = new Item(2);
        assertTrue(container.contains(item));
    }

    /**
     * Проверяем метод remove
     */
    @Test
    public void remove()
    {
        final Container container = new Container();
        final Item item1 = new Item(1);
        container.add(item1);
        container.add(new Item(2));
        final Item item = new Item(1);
        container.remove(item);
        assertFalse(container.contains(item1));
    }
}