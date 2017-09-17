package com.steve.kando.data;

import android.content.Context;

import com.steve.kando.ToDoItem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class LocalToDoItemService implements ToDoItemService {

    private static final String LOCAL_STORAGE_FILE = "kando_data.txt";
    private final Context context;

    public LocalToDoItemService(Context context) throws DataException {
        this.context = context;
        try{
            File file = new File(context.getFilesDir(), LOCAL_STORAGE_FILE);
            file.createNewFile();
        }catch(IOException e){
            throw new DataException();
        }
    }

    @Override
    public List<ToDoItem> getToDoItems() throws DataException{
        try(FileInputStream fin = context.openFileInput(LOCAL_STORAGE_FILE)){
            int c;
            String dataJson = "";
            while ((c = fin.read()) != -1) {
                dataJson += Character.toString((char) c);
            }
            fin.close();
            return JsonParser.generateToDoItems(dataJson);
        } catch (IOException e) {
            throw new DataException();
        }
    }

    @Override
    public void saveToDoItems(List<ToDoItem> toDoItems) throws DataException {
        String dataJson = JsonParser.generateJson(toDoItems);
        try(FileOutputStream fOut = context.openFileOutput(LOCAL_STORAGE_FILE,MODE_PRIVATE)){
            fOut.write(dataJson.getBytes());
            fOut.close();
        } catch (IOException e) {
            throw new DataException();
        }
    }
}
