package oop.shchetinin.list;

import java.util.NoSuchElementException;
import java.util.Objects;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList() {
    }

    public SinglyLinkedList(T head) {
        this.head = new ListItem<>(head);
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
        if (index > count || index < 0) {
            throw new IndexOutOfBoundsException("Index must be < " + getCount() + " and >= 0, index = " + index);
        }

        if (index == 0) {
            addFirst(data);
            return;
        }

        ListItem<T> currentItem = getItemByIndex(index - 1);

        currentItem.setNext(new ListItem<>(data, currentItem.getNext()));

        count++;
    }

    public T getByIndex(int index) {
        checkIndex(index);

        if (index == 0) {
            return head.getData();
        }

        ListItem<T> item = getItemByIndex(index);

        return item.getData();
    }

    public T setByIndex(int index, T data) {
        checkIndex(index);

        if (index == 0) {
            head.setData(data);

            return data;
        }

        ListItem<T> item = getItemByIndex(index);

        item.setData(data);

        return data;
    }

    public T deleteFirst() {
        if (count == 0) {
            throw new NoSuchElementException("List is empty! Count must be >= 1, count = " + count);
        }

        ListItem<T> firstItem = head;

        head = head.getNext();
        count--;

        return firstItem.getData();
    }

    public T deleteByIndex(int index) {
        checkIndex(index);

        if (index == 0) {
            deleteFirst();
            return head.getData();
        }

        ListItem<T> item = getItemByIndex(index - 1);

        ListItem<T> previousItem = item;

        item = item.getNext();

        previousItem.setNext(item.getNext());

        count--;

        return item.getData();
    }

    public boolean deleteByData(T data) {
        if (count == 0) {
            return false;
        }

        if (Objects.equals(head.getData(), data)) {
            deleteFirst();

            return true;
        }
        int i = 0;

        ListItem<T> currentItem = head;

        while (i < count) {
            if (Objects.equals(currentItem.getNext().getData(), data)) {
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

    private void checkIndex(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index must be < " + count + " and >= 0, index = " + index);
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