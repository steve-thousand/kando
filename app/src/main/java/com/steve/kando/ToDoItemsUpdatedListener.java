package com.steve.kando;

public interface ToDoItemsUpdatedListener {
    void onToDoItemAdded(ToDoItem toDoItem);
    void onToDoItemRemoved(int position);
}
