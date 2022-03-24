package oop.shchetinin.list_main;

import oop.shchetinin.list.ListItem;
import oop.shchetinin.list.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        ListItem<Integer> head = new ListItem<>(4);
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>(head);

        list.add(10);
        list.insertFirst(1);
        list.insertFirst(8);
        list.insertFirst(5);
        list.insertFirst(3);
        list.add(10);

        System.out.println(list);
        System.out.println("List size: " + list.getSize());

        System.out.println("Element has been removed: " + list.deleteFirst());
        System.out.println();

        list.addByIndex(4, 99);

        System.out.println(list);
        System.out.println("Head: " + list.getHead());
        System.out.println();

        System.out.println("Element has been removed: " + list.deleteByIndex(5));

        System.out.println(list);
        System.out.println(list.getByIndex(5));
        System.out.println();

        System.out.println("Element has been changed: " + list.changeByIndex(5, 66));

        System.out.println(list);
        System.out.println();

        System.out.println(list.deleteByValue(44));
        System.out.println(list);
        System.out.println();

        SinglyLinkedList<Integer> listCopy = new SinglyLinkedList<>();
        listCopy.copyOf(list);
        System.out.println(listCopy);
        System.out.println();

        System.out.println(list);
        list.reverse();
        System.out.println(list);
    }
}