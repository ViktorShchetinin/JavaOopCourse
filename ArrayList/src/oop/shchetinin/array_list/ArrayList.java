package oop.shchetinin.array_list;

import java.util.*;

public class ArrayList<T> implements List<T> {
    private static final int SIZE_FACTOR = 5;
    private T[] items;
    private int length;

    public ArrayList() {
        //noinspection unchecked
        items = (T[]) new Object[SIZE_FACTOR];
        length = 0;
    }

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(T data) {
        if (length >= items.length) {
            increaseCapacity();
        }

        items[length] = data;

        length++;

        return true;
    }

    @Override
    public boolean remove(Object data) {
        if (length >= items.length) {
            increaseCapacity();
        }

        int i = 0;

        while (i <= length) {
            if (items[i] == data) {
                items[i] = null;

                break;
            }

            i++;
        }

        length--;

        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T data) {
        if (index > length) {
            throw new ArrayIndexOutOfBoundsException("Index must be <= length, length = " + index);
        }

        items[index] = data;

        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public T[] toArray(Object[] a) {
        //noinspection unchecked
        return (T[]) new Object[0];
    }

    public T getIndex(int index) {
        if (index > length) {
            throw new ArrayIndexOutOfBoundsException("Index must be <= length, length = " + index);
        }

        return items[index];
    }

    /*public void set(int index, T data) {
        if (index > length) {
            throw new ArrayIndexOutOfBoundsException("Index must be <= length, length = " + index);
        }

        items[index] = data;
    }*/

    public void increaseCapacity() {
        items = Arrays.copyOf(items, items.length * 2);
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }
}