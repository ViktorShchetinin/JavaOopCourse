package oop.shchetinin.list_main;

import oop.shchetinin.list.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>(5);

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

        System.out.println("Element has been removed: " + list.deleteByIndex(5));

        System.out.println(list);
        System.out.println(list.getByIndex(4));
        System.out.println();

        System.out.println("Element has been changed: " + list.changeByIndex(4, 66));

        System.out.println(list);
        System.out.println();

        System.out.println(list.deleteByValue(8));
        System.out.println(list);
        System.out.println();

        SinglyLinkedList<Integer> listCopy = new SinglyLinkedList<>();
        listCopy.copyOf(list);
        System.out.println("List copy: " + listCopy);
        System.out.println();

        System.out.println(list);
        list.reverse();
        System.out.println(list);
    }
}