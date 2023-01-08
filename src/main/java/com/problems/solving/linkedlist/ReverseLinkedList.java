package com.problems.solving.linkedlist;

public class ReverseLinkedList {

    static public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        boolean isFirst = true;
        ListNode newHead = new ListNode();
        ListNode current = new ListNode();
        current.val = head.val;
        current.next = head.next;

        while (current != null) {
            if (current.next == null) {
                break;
            }
            if (isFirst) {
                head.next = null;
                isFirst = false;
                newHead = creatNewNode(current.next.val, head);
            } else {
                newHead = creatNewNode(current.next.val, newHead);
            }
            current = current.next;

        }

        return newHead;

    }

    static ListNode creatNewNode(int value, ListNode next) {
        ListNode result = new ListNode();
        result.val = value;
        result.next = next;
        return result;
    }

    public static void main(String[] args) {
        ListNode list = ListNode.builder()
                .val(1).next(ListNode.builder().val(2).next(ListNode.builder().val(3).build()).build()).build();
        ListNode listNode = reverseList(list);
        System.out.println("hello");
    }

}
