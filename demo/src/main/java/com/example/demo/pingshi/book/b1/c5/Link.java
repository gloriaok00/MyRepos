package com.example.demo.pingshi.book.b1.c5;

class Link {

    public int data;
    public Link next;

    public Link(int data) {
        this.data = data;
    }

}

class SortedList {

    private Link first;

    public SortedList() {
        first = null;
    }

    public void insert(int key) {
        Link newLink = new Link(key);
        Link previous = null;
        Link current = first;

        while (current != null && key > current.data) {
            previous = current;
            current = current.next;
        }

        if (previous == null) {
            first = newLink;
        } else {
            previous.next = newLink;
        }
        newLink.next = current;
    }

    public void displayList() {
        Link current = first;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}

class SortedListApp {
    public static void main(String[] args) {
        SortedList theSortedList = new SortedList();

        theSortedList.insert(20);
        theSortedList.insert(140);
        theSortedList.insert(60);

        theSortedList.displayList();

    }
}
