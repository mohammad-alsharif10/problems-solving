package com.problems.solving.linkedlist;

public class DeleteNode {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (n==1){
            head=head.next;
            return head;
        }
        int index = 1;
        ListNode current = head;
        ListNode previous = head;
        boolean firstRound = true;
        while (index < n) {
            if (firstRound) {
                firstRound = false;
            } else {
                previous = previous.next;
            }
            current = current.next;
            ++index;
        }
        previous.next = current.next;
        current.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode list = ListNode.builder()
                .val(1).next(ListNode.builder().val(2).next(ListNode.builder().val(3).build()).build()).build();
        ListNode listNode= ListNode.builder().val(1).build();
        System.out.println(removeNthFromEnd(list,2));
    }

}
