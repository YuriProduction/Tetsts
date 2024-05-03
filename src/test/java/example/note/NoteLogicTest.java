package example.note;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NoteLogicTest
{
    /**
     * Тестируем команду /add
     */
    @Test
    public void testAddCommand()
    {
        NoteLogic noteLogic = new NoteLogic();
        final String userMessage = "/add Сделать матанализ к среде";
        final String answer = noteLogic.handleMessage(userMessage);
        assertEquals(answer, "Note added!");
        final String notes = noteLogic.handleMessage("/notes");
        assertEquals(notes, "Your notes:\nСделать матанализ к среде");
    }

    /**
     * Тестируем команду /notes
     */
    @Test
    public void testNotesCommand()
    {
        NoteLogic noteLogic = new NoteLogic();
        noteLogic.handleMessage("/add NewNote");
        assertEquals(noteLogic.handleMessage("/notes"), "Your notes:\nNewNote");
    }

    /**
     * Тестируем команду /edit
     */
    @Test
    public void testEditCommand()
    {
        NoteLogic noteLogic = new NoteLogic();
        noteLogic.handleMessage("/add Note");
        noteLogic.handleMessage("/edit Note Note1");
        assertEquals(noteLogic.handleMessage("/notes"),
                "Your notes:\n" +
                        "Note1");
    }

    /**
     * Тестируем команду /del
     */
    @Test
    public void testDelCommand()
    {
        NoteLogic noteLogic = new NoteLogic();
        noteLogic.handleMessage("/add MyNote1");
        noteLogic.handleMessage("/add MyNote2");
        noteLogic.handleMessage("/del MyNote2");
        assertEquals(noteLogic.handleMessage("/notes"),
                "Your notes:\n" +
                        "MyNote1");
    }
}