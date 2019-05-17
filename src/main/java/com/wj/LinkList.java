package com.wj;

/**
 * @author jun.wang
 * @title: LinkList
 * @projectName ownerpro
 * @description: TODO
 * @date 2019/5/17 10:29
 */
public class LinkList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size = 0;

    static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;
        Node(E item, Node<E> next, Node<E> prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    public boolean add(E e) {
        Node<E> node;
        if (first == null) {
            node = new Node<E>(e, null, null);
            first = node;
            last = node;
        }
        else {
            node = new Node<E>(e, null, last);
            last.next = node;
            last = node;
        }
        size++;
        return true;
    }

    public E get(int index) {
        if (index >= size) {
            throw new RuntimeException("out of index");
        }
        if (index == 0) {
            return first.item;
        }
        Node<E> node = first;
        /*if ((size << 1) > index) {
            for (int i = 0; i < index; i++) {
                node = first.next;
            }
        }*/
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.item;
    }

    public boolean remove(int index) {
        if (index >= size) {
            throw new RuntimeException("out of index");
        }
        if (index == 0) {
            first = first.next;
        }
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        Node<E> prev = node.prev;
        Node<E> next = node.next;
        prev.next = next;
        next.prev = prev;
        size--;
        return true;
    }

    public int size() {
        return size;
    }

    public static void main(String args[]) {
        LinkList<String> linkList = new LinkList<>();
        linkList.add("1");
        linkList.add("2");
        linkList.add("3");
        linkList.add("4");
        linkList.remove(2);
        for (int i = 0; i < linkList.size(); i++) {
            System.out.println(linkList.get(i));
        }
        System.out.println(linkList.get(4));
    }
}
