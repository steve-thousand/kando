package com.steve.kando;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.steve.kando.data.DataException;
import com.steve.kando.data.LocalToDoItemService;
import com.steve.kando.data.ToDoItemService;
import com.steve.kando.view.ToDoItemAddView;

import java.util.List;

public class ListActivity extends AppCompatActivity implements ToDoItemsUpdatedListener {

    private ToDoItemService toDoItemService;
    private ToDoItemAdapter toDoItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        try {
            toDoItemService = new LocalToDoItemService(this);
            List<ToDoItem> toDoItems = toDoItemService.getToDoItems();
            toDoItemAdapter = new ToDoItemAdapter(this, toDoItems);
            ListView listView = findViewById(R.id.todo_list_view);
            listView.setAdapter(toDoItemAdapter);
        } catch (DataException e) {
            //todo anything
        }

        FloatingActionButton addButton = findViewById(R.id.add_item_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ToDoItemAddView(ListActivity.this);
            }
        });
    }

    @Override
    public void onToDoItemAdded(ToDoItem toDoItem) {
        try {
            List<ToDoItem> toDoItems = toDoItemService.getToDoItems();
            toDoItems.add(toDoItem);
            toDoItemService.saveToDoItems(toDoItems);
            toDoItemAdapter.add(toDoItem);
        } catch (DataException e) {
            //todo anything
        }
    }

    @Override
    public void onToDoItemRemoved(int position) {
        try {
            List<ToDoItem> toDoItems = toDoItemService.getToDoItems();
            toDoItems.remove(position);
            toDoItemService.saveToDoItems(toDoItems);
            toDoItemAdapter.remove(toDoItemAdapter.getItem(position));
        } catch (DataException e) {
            //todo anything
        }
    }
}
