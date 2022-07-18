package oop.shchetinin.list;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList() {
    }

    public SinglyLinkedList(T head) {
        this.head = new ListItem<>(head);
        count++;
    }

    public void copyOf(SinglyLinkedList<T> list) {
        head = new ListItem<>(list.head.getData(), list.head.getNext());
        count = list.count;
    }

    @Override
    public String toString() {
        if (count == 0) {
            return "List is empty!";
        }

        StringBuilder sb = new StringBuilder();

        sb.append("(");

        ListItem<T> currentItem = head;

        while (currentItem != null) {
            sb.append(currentItem.getData().toString()).append(", ");

            currentItem = currentItem.getNext();
        }

        sb.delete(sb.length() - 2, sb.length()).append(")");

        return sb.toString();
    }

    public int getCount() {
        return count;
    }

    public void addFirst(T data) {
        head = new ListItem<>(data, head);
        count++;
    }

    public T deleteFirst() {
        if (count <= 0) {
            throw new IndexOutOfBoundsException("List is empty! Count must be >= 1, count = " + count);
        }

        ListItem<T> firstItem = head;

        head = head.getNext();
        count--;

        return firstItem.getData();
    }

    public void add(T data) {
        if (head == null) {
            addFirst(data);
            return;
        }

        addByIndex(count, data);
    }

    public T getByIndex(int index) {
        checkIndex(index);

        if (index == 0) {
            return head.getData();
        }

        ListItem<T> currentItem = iterator(index - 1);

        return currentItem.getData();
    }

    public T setByIndex(int index, T data) {
        checkIndex(index);

        if (index == 0) {
            ListItem<T> firstItem = head;

            head.setData(data);

            return firstItem.getData();
        }

        ListItem<T> currentItem = iterator(index);

        currentItem.setData(data);

        return currentItem.getData();
    }

    public void addByIndex(int index, T data) {
        if (index > count || index < 0) {
            throw new IndexOutOfBoundsException("Index must be < " + getCount() + " and >= 0, index = " + index);
        }

        if (index == 0) {
            addFirst(data);
            return;
        }

        ListItem<T> currentItem = iterator(index);

        currentItem.setNext(new ListItem<>(data, currentItem.getNext()));

        count++;
    }

    public T deleteByIndex(int index) {
        checkIndex(index);

        ListItem<T> currentItem = iterator(index);

        if (index == 0) {
            deleteFirst();
            return currentItem.getData();
        }

        ListItem<T> previousItem = currentItem;

        currentItem = currentItem.getNext();

        previousItem.setNext(currentItem.getNext());

        count--;

        return currentItem.getData();
    }

    public boolean deleteByData(T data) {
        int i = 0;

        if (head.getData().equals(data)) {
            deleteFirst();

            return true;
        }

        ListItem<T> currentItem = head;

        while (i < count) {
            if (currentItem.getNext().getData().equals(data)) {
                ListItem<T> previousItem = currentItem;

                currentItem = currentItem.getNext();

                previousItem.setNext(currentItem.getNext());

                count--;

                return true;
            }

            currentItem = currentItem.getNext();

            i++;
        }

        return false;
    }

    public void reverse() {
        ListItem<T> previousItem = null;
        ListItem<T> currentItem = head;

        while (currentItem != null) {
            ListItem<T> nextItem = currentItem.getNext();
            currentItem.setNext(previousItem);
            previousItem = currentItem;
            currentItem = nextItem;
        }

        head = previousItem;
    }

    public void checkIndex(int index) {
        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException("Index must be < " + getCount() + " and >= 0, index = " + index);
        }
    }

    public ListItem<T> iterator(int index) {
        ListItem<T> currentItem = head;

        int currentIndex = 0;

        while (index > currentIndex + 1) {
            currentItem = currentItem.getNext();
            currentIndex++;
        }

        return currentItem;
    }
}