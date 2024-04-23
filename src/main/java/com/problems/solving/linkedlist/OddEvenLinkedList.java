package com.problems.solving.linkedlist;

public class OddEvenLinkedList {

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode firstEven = head.next;
        ListNode currentOdd = head;
        ListNode currentEven = firstEven;
        while (currentEven != null) {
            if (currentOdd.next == null || currentOdd.next.next == null) {
                currentOdd.next = firstEven;
                break;
            }
            currentOdd.next = currentOdd.next.next;
            currentEven.next = currentEven.next != null ? currentEven.next.next : null;
            currentOdd = currentOdd.next;
            currentEven = currentEven.next;
        }
        if(currentOdd.next == null) {
            currentOdd.next = firstEven;
        }
        System.out.println();
        return head;
    }

    public static void main(String[] args) {
       oddEvenList(ListNode.builder().val(1).next(ListNode.builder().val(2).next(ListNode.builder().val(3).next(ListNode.builder().val(4).next(ListNode.builder().val(5).next(ListNode.builder().val(6).next(ListNode.builder().val(7).next(ListNode.builder().val(8).build()).build()).build()).build()).build()).build()).build()).build());
    }
}
