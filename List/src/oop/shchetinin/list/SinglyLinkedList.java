package oop.shchetinin.list;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList() {
    }

    public SinglyLinkedList(ListItem<T> head) {
        this.head = head;
        count++;
    }

    public void copyOf(SinglyLinkedList<T> list) {
        head = new ListItem<>(list.getHead());
        count = list.getSize();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("(");

        int i = 0;
        ListItem<T> current = head;

        while (i < count) {
            sb.append(current).append(", ");

            current = current.getNext();

            i++;
        }

        sb.delete(sb.length() - 2, sb.length()).append(")");

        return sb.toString();
    }

    public int getSize() {
        return count;
    }

    public ListItem<T> getHead() {
        return head;
    }

    public void insertFirst(T data) {
        head = new ListItem<>(data, head);
        count++;
    }

    public ListItem<T> deleteFirst() {
        ListItem<T> firstElement = head;

        head = head.getNext();
        count--;

        return firstElement;
    }

    public void add(T data) {
        ListItem<T> current = head;

        if (head == null) {
            head = new ListItem<>();

            head.setData(data);
            head.setNext(null);
        } else {
            while (current.next != null) {
                current = current.getNext();
            }

            ListItem<T> newElement = new ListItem<>(data);

            current.setNext(newElement);
        }

        count++;
    }

    public ListItem<T> getByIndex(int index) {
        if (index > count) {
            throw new IllegalArgumentException("Index must be <= list length, index = " + index);
        }

        if (index == 0) {
            return head;
        }

        ListItem<T> current = head;

        int currentIndex = 0;

        while (index > currentIndex) {
            current = current.getNext();
            currentIndex++;
        }

        return current;
    }

    public ListItem<T> changeByIndex(int index, T data) {
        if (index >= count || index < 0) {
            throw new IllegalArgumentException("Index must be < list length and >= 0, index = " + index);
        }

        if (index == 0) {
            ListItem<T> firstElement = new ListItem<>(head);

            head.setData(data);

            return firstElement;
        }

        ListItem<T> current = head;

        int currentIndex = 0;

        while (index > currentIndex) {
            current = current.getNext();
            currentIndex++;
        }

        ListItem<T> oldElement = new ListItem<>(current);

        current.setData(data);

        return oldElement;
    }

    public void addByIndex(int index, T data) {
        if (index >= count || index < 0) {
            throw new IllegalArgumentException("Index must be < list length and >= 0, index = " + index);
        }

        if (index == 0) {
            insertFirst(data);
        } else {
            ListItem<T> current = head;

            int currentIndex = 0;

            while (index > currentIndex + 1) {
                current = current.getNext();
                currentIndex++;
            }

            ListItem<T> newElement = new ListItem<>(data);

            ListItem<T> nextElement = current.getNext();

            current.setNext(newElement);
            newElement.setNext(nextElement);

            count++;
        }
    }

    public ListItem<T> deleteByIndex(int index) {
        if (index >= count || index < 0) {
            throw new IllegalArgumentException("Index must be < list length and >= 0, index = " + index);
        }

        ListItem<T> current = head;

        if (index == 0) {
            deleteFirst();
            return current;
        }

        int currentIndex = 0;

        while (index > currentIndex + 1) {
            current = current.getNext();
            currentIndex++;
        }

        ListItem<T> previousElement = current;

        current = current.getNext();

        previousElement.setNext(current.getNext());

        count--;

        return current;
    }

    public boolean deleteByValue(T data) {
        if (data == null) {
            throw new NullPointerException("Data must be not null, data = " + data);
        }

        int i = 0;

        ListItem<T> current = head;

        while (i < count) {
            if (current.getData() == data) {
                deleteByIndex(i);

                return true;
            }

            current = current.getNext();

            i++;
        }

        return false;
    }

    public void reverse() {
        ListItem<T> previous = null;
        ListItem<T> curent = head;

        while (curent != null) {
            ListItem<T> nextElement = curent.getNext();
            curent.setNext(previous);
            previous = curent;
            curent = nextElement;
        }

        head = previous;
    }
}