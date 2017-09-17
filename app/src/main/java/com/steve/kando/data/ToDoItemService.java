package com.steve.kando.data;

import com.steve.kando.ToDoItem;

import java.util.List;

public interface ToDoItemService {

    List<ToDoItem> getToDoItems() throws DataException;

    void saveToDoItems(List<ToDoItem> toDoItems) throws DataException;

}
