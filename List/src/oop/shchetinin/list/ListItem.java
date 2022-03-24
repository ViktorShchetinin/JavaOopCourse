package oop.shchetinin.list;

public class ListItem<T> {
    protected T data;
    protected ListItem<T> next;

    public ListItem() {
    }

    public ListItem(T data) {
        if (data == null) {
            throw new NullPointerException("Data must be not null, data = " + data);
        }

        this.data = data;
    }

    public ListItem(T data, ListItem<T> next) {
        if (data == null) {
            throw new NullPointerException("Data must be not null, data = " + data);
        }

        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public ListItem<T> getNext() {
        return next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(ListItem<T> next) {
        this.next = next;
    }

    public ListItem(ListItem<T> listItem) {
        this.data = listItem.getData();
        this.next = listItem.getNext();
    }

    @Override
    public String toString() {
        return "" + data + "";
    }
}