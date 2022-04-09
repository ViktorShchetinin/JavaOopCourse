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

        ListItem<T> current = head;

        while (current != null) {
            sb.append(current.getData().toString()).append(", ");

            current = current.getNext();
        }

        sb.delete(sb.length() - 2, sb.length()).append(")");

        return sb.toString();
    }

    public int getSize() {
        return count;
    }

    private ListItem<T> getHead() {
        return head;
    }

    public void insertFirst(T data) {
        head = new ListItem<>(data, head);
        count++;
    }

    public T deleteFirst() {
        ListItem<T> firstElement = head;

        head = head.getNext();
        count--;

        return firstElement.getData();
    }

    public void add(T data) {
        ListItem<T> current = head;

        if (head == null) {
            head = new ListItem<>(data);

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

    public T getByIndex(int index) {
        if (index >= count || index < 0) {
            throw new IllegalArgumentException("Index must be <= list length and >= 0, index = " + index);
        }

        if (index == 0) {
            return head.getData();
        }

        ListItem<T> current = head;

        int currentIndex = 0;

        while (index > currentIndex) {
            current = current.getNext();
            currentIndex++;
        }

        return current.getData();
    }

    public T changeByIndex(int index, T data) {
        if (index >= count || index < 0) {
            throw new IllegalArgumentException("Index must be < list length and >= 0, index = " + index);
        }

        if (index == 0) {
            ListItem<T> firstElement = head;

            head.setData(data);

            return firstElement.getData();
        }

        ListItem<T> current = head;

        int currentIndex = 0;

        while (index > currentIndex) {
            current = current.getNext();
            currentIndex++;
        }

        ListItem<T> oldElement = current;

        current.setData(data);

        return oldElement.getData();
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

    public T deleteByIndex(int index) {
        if (index >= count || index < 0) {
            throw new IllegalArgumentException("Index must be < list length and >= 0, index = " + index);
        }

        ListItem<T> current = head;

        if (index == 0) {
            deleteFirst();
            return current.getData();
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

        return current.getData();
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
        ListItem<T> current = head;

        while (current != null) {
            ListItem<T> nextElement = current.getNext();
            current.setNext(previous);
            previous = current;
            current = nextElement;
        }

        head = previous;
    }
}