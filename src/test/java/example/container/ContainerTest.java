package example.container;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContainerTest
{
    private Container container;
    @Before
    public void beforeEachTest()
    {
        container = new Container();
    }
    /**
     * Проверяем метод add
     */
    @Test
    public void add()
    {
        final Item item1 = new Item(1);
        final Item item2 = new Item(2);
        container.add(item1);
        container.add(item2);
        assertTrue(container.contains(item1));
        assertTrue(container.contains(item2));
        assertEquals(2,container.size());
    }

    /**
     * Проверяем метод remove
     */
    @Test
    public void remove()
    {
        final Item item1 = new Item(3);
        final Item item2 = new Item(4);
        container.add(item1);
        container.add(item2);
        container.remove(item1);
        assertFalse(container.contains(item1));
        assertTrue(container.contains(item2));
        assertEquals(item2,container.get(0));
        assertEquals(1,container.size());
    }
}