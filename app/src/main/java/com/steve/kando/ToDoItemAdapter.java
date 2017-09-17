package com.steve.kando;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.daimajia.swipe.SwipeLayout;

import java.util.List;

public class ToDoItemAdapter extends BaseAdapter {

    private ListActivity listActivity;
    private List<ToDoItem> toDoItems;
    private static LayoutInflater inflater = null;

    public ToDoItemAdapter(ListActivity listActivity, List<ToDoItem> toDoItems){
        this.listActivity = listActivity;
        this.toDoItems = toDoItems;
        inflater = (LayoutInflater) listActivity
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return toDoItems.size();
    }

    @Override
    public Object getItem(int i) {
        return toDoItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        ToDoItem toDoItem = toDoItems.get(position);
        SwipeLayout swipeLayout;
        if (view == null) {
            swipeLayout = (SwipeLayout)inflater.inflate(R.layout.swipe_list_item, null);

            TextView labelView = swipeLayout.findViewById(R.id.label);
            labelView.setText(toDoItem.getLabel());

            Button button = swipeLayout.findViewById(R.id.delete);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listActivity.onToDoItemRemoved(position);
                }
            });
        }else{
            swipeLayout = (SwipeLayout)view;
        }
        return swipeLayout;
    }
}
