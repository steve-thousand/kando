package com.steve.kando;

import org.joda.time.LocalDateTime;

public class ToDoItem {


    private String label;
    private LocalDateTime createDate;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ToDoItem toDoItem = (ToDoItem) o;

        if (label != null ? !label.equals(toDoItem.label) : toDoItem.label != null) return false;
        return createDate != null ? createDate.equals(toDoItem.createDate) : toDoItem.createDate == null;

    }

    @Override
    public int hashCode() {
        int result = label != null ? label.hashCode() : 0;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        return result;
    }
}
