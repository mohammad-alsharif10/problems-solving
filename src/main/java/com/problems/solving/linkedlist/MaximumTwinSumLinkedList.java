package com.problems.solving.linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumTwinSumLinkedList {

    public static int pairSum(ListNode head) {
//        ListNode current = head;
//        Deque<Integer> deque = new ArrayDeque<>();
//        while (current != null) {
//            deque.add(current.val);
//            current = current.next;
//        }
//        int max = 0;
//        while (!deque.isEmpty()) {
//            max = Math.max(deque.removeFirst() + deque.removeLast(), max);
//        }
//        return max;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            ListNode tmp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = tmp;
        }
        int ans = 0;
        while(slow != null){
            ans = Math.max(ans, slow.val + prev.val);
            slow = slow.next;
            prev = prev.next;
        }
        return ans;

    }

    public static void main(String[] args) {
        pairSum(ListNode.builder().val(1).next(ListNode.builder().val(2).next(ListNode.builder().val(3).next(ListNode.builder().val(4).next(ListNode.builder().val(5).next(ListNode.builder().val(6).next(ListNode.builder().val(7).next(ListNode.builder().val(8).build()).build()).build()).build()).build()).build()).build()).build());

    }
}
