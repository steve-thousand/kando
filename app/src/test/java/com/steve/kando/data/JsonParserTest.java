package com.steve.kando.data;

import com.steve.kando.ToDoItem;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class JsonParserTest {

    @Test
    public void testJsonWriteAndRead() throws DataException {
        List<ToDoItem> toDoItems = new ArrayList<>();

        ToDoItem toDoItem;

        toDoItem = new ToDoItem();
        toDoItem.setLabel("an item");
        toDoItems.add(toDoItem);

        toDoItem = new ToDoItem();
        toDoItem.setLabel("an item2");
        toDoItems.add(toDoItem);

        String json = JsonParser.generateJson(toDoItems);
        List<ToDoItem> parsedItems = JsonParser.generateToDoItems(json);

        assertEquals(toDoItems, parsedItems);
    }
}
