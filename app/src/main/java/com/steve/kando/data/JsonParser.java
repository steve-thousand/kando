package com.steve.kando.data;

import com.steve.kando.ToDoItem;

import org.joda.time.LocalDateTime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonParser {

    /*
    When JSON format is updated, parser version must be updated.
     */
    private static final String PARSER_VERSION = "0.1.0";
    private static final String PARSER_VERSION_KEY = "$PARSER_VERSION";

    private static final String LABEL_KEY = "label";
    private static final String CREATE_DATE_KEY = "createDate";

    public static String generateJson(List<ToDoItem> toDoItems) throws DataException{
        try {
            JSONArray jsonArray = new JSONArray();
            for (ToDoItem toDoitem: toDoItems) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put(PARSER_VERSION_KEY, PARSER_VERSION);
                jsonObject.put(LABEL_KEY, toDoitem.getLabel());
                if(toDoitem.getCreateDate() != null) {
                    jsonObject.put(CREATE_DATE_KEY, toDoitem.getCreateDate().toDateTime().getMillis());
                }
                jsonArray.put(jsonObject);
            }
            return jsonArray.toString();
        }catch(JSONException jsonException){
            throw new DataException();
        }
    }

    public static List<ToDoItem> generateToDoItems(String json) throws DataException{
        try {
            if(json.equals("")){
                return new ArrayList<>();
            }
            JSONArray jsonArray = new JSONArray(json);
            List<ToDoItem> toDoItems = new ArrayList<>(jsonArray.length());
            for(int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonObject = (JSONObject)jsonArray.get(i);
                ToDoItem toDoItem = new ToDoItem();
                toDoItem.setLabel(jsonObject.getString(LABEL_KEY));
                if(jsonObject.has(CREATE_DATE_KEY)) {
                    toDoItem.setCreateDate(new LocalDateTime(jsonObject.getLong(CREATE_DATE_KEY)));
                }
                toDoItems.add(toDoItem);
            }
            return toDoItems;
        }catch(JSONException jsonException){
            throw new DataException();
        }
    }

}
