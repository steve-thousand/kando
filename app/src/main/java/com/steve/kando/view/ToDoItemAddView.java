package com.steve.kando.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

import com.steve.kando.ListActivity;
import com.steve.kando.ToDoItem;
import com.steve.kando.ToDoItemsUpdatedListener;

import java.util.Date;

public class ToDoItemAddView extends AlertDialog implements DialogInterface.OnClickListener {

    private final ToDoItemsUpdatedListener toDoItemsUpdatedListener;
    private final EditText input;

    public ToDoItemAddView(ListActivity listActivity) {
        super(listActivity);
        this.toDoItemsUpdatedListener = listActivity;

        input = new EditText(listActivity);
        input.setSingleLine(true);
        input.setImeOptions(EditorInfo.IME_ACTION_DONE);

        this.setTitle("Enter label");
        this.setView(input);
        this.setCancelable(true);
        this.setButton(DialogInterface.BUTTON_POSITIVE, "add", this);

        this.create();

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);

        this.show();
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        String itemLabel = input.getText().toString();
        ToDoItem toDoItem = new ToDoItem();
        toDoItem.setLabel(itemLabel);
        toDoItem.setCreateDate(new Date());
        toDoItemsUpdatedListener.onToDoItemAdded(toDoItem);
    }
}
