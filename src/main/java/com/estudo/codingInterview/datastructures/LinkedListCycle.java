package com.estudo.codingInterview.datastructures;

public class LinkedListCycle {

    /*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as:
    class Node {
        int data;
        Node next;
    }
*/

    class Node {
        int data;
        Node next;
    }

    boolean hasCycle(Node head) {

        if(head == null)
            return false;

        Node cycle = head;
        Node noTest = head;

        while(cycle != null && cycle.next != null){
            cycle = cycle.next;
            noTest = noTest.next.next;

            if(cycle == null || noTest == null)
                return false;

            if(cycle == noTest)
                return true;

        }

        return false;

    }

}
