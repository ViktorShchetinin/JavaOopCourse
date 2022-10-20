package oop.shchetinin.list_main;

import oop.shchetinin.list.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>(5);

        list.add(10);
        list.addFirst(1);
        list.addFirst(8);
        list.addFirst(5);
        list.addFirst(3);
        list.add(10);

        System.out.println(list);
        System.out.println("List size: " + list.getCount());

        System.out.println("Element has been removed: " + list.deleteFirst());
        System.out.println();

        list.addByIndex(5, 99);
        System.out.println(list);

        System.out.println("Element has been removed: " + list.deleteByIndex(5));

        System.out.println(list);
        System.out.println(list.getByIndex(5));
        System.out.println();

        System.out.println("Element has been changed: " + list.setByIndex(4, 66));

        System.out.println(list);
        System.out.println();

        System.out.println(list.deleteByData(5));
        System.out.println("Delete by data: " + list);
        System.out.println();

        SinglyLinkedList<Integer> listCopy = list.copy();
        list.add(77);
        System.out.println("List copy: " + listCopy);
        System.out.println();

        System.out.println(list);
        list.reverse();
        System.out.println(list);

        System.out.println("Empty list: " + new SinglyLinkedList<>());
    }
}