package oop.shchetinin.list;

import java.util.NoSuchElementException;
import java.util.Objects;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList() {
    }

    public SinglyLinkedList(T data) {
        this.head = new ListItem<>(data);
        count++;
    }

    public SinglyLinkedList<T> copy() {
        if (count == 0) {
            return new SinglyLinkedList<>();
        }

        SinglyLinkedList<T> newList = new SinglyLinkedList<>();

        ListItem<T> currentItem = new ListItem<>(head.getData());
        newList.head = currentItem;

        for (ListItem<T> p = head.getNext(); p != null; p = p.getNext()) {
            currentItem.setNext(new ListItem<>(p.getData()));
            currentItem = currentItem.getNext();
        }

        newList.count = count;

        return newList;
    }

    @Override
    public String toString() {
        if (count == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();

        sb.append("[");

        ListItem<T> currentItem = head;

        while (currentItem != null) {
            sb.append(currentItem.getData()).append(", ");

            currentItem = currentItem.getNext();
        }

        sb.delete(sb.length() - 2, sb.length()).append("]");

        return sb.toString();
    }

    public int getCount() {
        return count;
    }

    public void add(T data) {
        addByIndex(count, data);
    }

    public void addFirst(T data) {
        head = new ListItem<>(data, head);
        count++;
    }

    public void addByIndex(int index, T data) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("Index must be >= 0 and <= " + count + " , index = " + index);
        }

        if (index == 0) {
            addFirst(data);
            return;
        }

        ListItem<T> previousItem = getItemByIndex(index - 1);

        previousItem.setNext(new ListItem<>(data, previousItem.getNext()));

        count++;
    }

    public T getByIndex(int index) {
        checkIndex(index);

        ListItem<T> item = getItemByIndex(index);

        return item.getData();
    }

    public T setByIndex(int index, T data) {
        checkIndex(index);

        ListItem<T> item = getItemByIndex(index);

        T oldData = item.getData();

        item.setData(data);

        return oldData;
    }

    public T deleteFirst() {
        if (count == 0) {
            throw new NoSuchElementException("List is empty! Count must be >= 1, count = " + count);
        }

        ListItem<T> deletedItem = head;

        head = head.getNext();
        count--;

        return deletedItem.getData();
    }

    public T deleteByIndex(int index) {
        checkIndex(index);

        if (index == 0) {
            T deletedData = head.getData();

            deleteFirst();

            return deletedData;
        }

        ListItem<T> previousItem = getItemByIndex(index - 1);

        ListItem<T> deletedItem = new ListItem<>(previousItem.getNext().getData());

        previousItem.setNext(previousItem.getNext().getNext());

        count--;

        return deletedItem.getData();
    }

    public boolean deleteByData(T data) {
        if (count == 0) {
            return false;
        }

        if (Objects.equals(head.getData(), data)) {
            deleteFirst();

            return true;
        }

        ListItem<T> currentItem = head;

        for (int i = 0; i < count; i++) {
            if (Objects.equals(currentItem.getNext().getData(), data)) {
                currentItem.setNext(currentItem.getNext().getNext());

                count--;

                return true;
            }

            currentItem = currentItem.getNext();
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

    private void checkIndex(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index must be >= 0 and < " + count + " , index = " + index);
        }
    }

    private ListItem<T> getItemByIndex(int index) {
        ListItem<T> currentItem = head;

        for (int i = 0; i < index; i++) {
            currentItem = currentItem.getNext();
        }

        return currentItem;
    }
}