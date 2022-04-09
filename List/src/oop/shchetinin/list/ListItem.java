package oop.shchetinin.list;

class ListItem<T> {
    protected T data;
    protected ListItem<T> next;

    public ListItem(T data) {
        this.data = data;
    }

    public ListItem(T data, ListItem<T> next) {
        this.data = data;
        this.next = next;
    }

    /*public ListItem(ListItem<T> listItem) {
        if (listItem == null) {
            throw new NullPointerException("ListItem must be not null, listItem = " + listItem);
        }

        this.data = listItem.data;
        this.next = listItem.next;
    }*/

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
}