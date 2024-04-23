package com.problems.solving.linkedlist;

public class DeleteMiddle {

    public ListNode middleNode(ListNode head) {
        if (head.next == null) {
            return null;
        }
        ListNode a_pointer = head;
        ListNode b_pointer = head;
        ListNode previous = head;
        boolean firstLoop = true;
        while (b_pointer != null && b_pointer.next != null) {
            if (firstLoop) {
                firstLoop = false;
            } else {
                previous = previous.next;
            }
            a_pointer = a_pointer.next;
            b_pointer = b_pointer.next.next;
        }
        previous.next = a_pointer.next;
        a_pointer.next = null;
        return head;
    }


    public ListNode middleNodeV2(ListNode head) {
        if (head.next == null) {
            return null;
        }
        int length = 1;
        ListNode iterator = head;
        ListNode middleNode = head;
        while (iterator.next != null) {
            length++;
            iterator = iterator.next;
        }
        int middle = length / 2;
        for (int i = 0; i < middle-1; i++) {
            middleNode = middleNode.next;
        }
        middleNode.next = middleNode.next.next;
        return head;
    }


}
