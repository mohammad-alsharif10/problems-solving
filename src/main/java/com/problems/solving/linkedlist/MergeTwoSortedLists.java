package com.problems.solving.linkedlist;

public class MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        boolean list1NextIsNull = list1 == null;
        boolean list2NextIsNull = list2 == null;
        if (list1NextIsNull && list2NextIsNull) {
            return null;
        } else if (list1NextIsNull) {
            return list2;
        } else if (list2NextIsNull) {
            return list1;
        } else {
            return mergeNonNullList(list1, list2);
        }
    }

    private static ListNode mergeNonNullList(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode firstListCurrentvalue = list1;
        ListNode secondListCurrentvalue = list2;
        if (firstListCurrentvalue.val <= secondListCurrentvalue.val) {
            result.val = firstListCurrentvalue.val;
            firstListCurrentvalue = firstListCurrentvalue.next;
        } else {
            result.val = secondListCurrentvalue.val;
            secondListCurrentvalue = secondListCurrentvalue.next;
        }
        while (firstListCurrentvalue != null || secondListCurrentvalue != null) {
            if (secondListCurrentvalue == null) {
                findLastNode(result).next = firstListCurrentvalue;
                return result;
            }
            if (firstListCurrentvalue == null) {
                findLastNode(result).next = secondListCurrentvalue;
                return result;
            }

            ListNode lastNodeINResult = findLastNode(result);
            ListNode listNode;
            if (firstListCurrentvalue.val <= secondListCurrentvalue.val) {
                listNode = firstListCurrentvalue;
                firstListCurrentvalue = firstListCurrentvalue.next;
            }
            else   {
                listNode = secondListCurrentvalue;
                secondListCurrentvalue = secondListCurrentvalue.next;
            }
            listNode.next = null;
            lastNodeINResult.next = listNode;

        }
        return result;

    }

    static ListNode findLastNode(ListNode listNode) {
        ListNode result = null;
        while (result == null) {
            if (listNode.next != null) {
                listNode = listNode.next;
            } else {
                result = listNode;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode11 = new ListNode(4);
        listNode.next = listNode1;
        listNode1.next = listNode11;

        ListNode listNode_ = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode22 = new ListNode(4);
        ListNode listNode222 = new ListNode(5);
        ListNode listNode2222 = new ListNode(6);
        listNode_.next = listNode2;
        listNode2.next = listNode22;
        listNode22.next = listNode222;
        listNode222.next = listNode2222;
        ListNode result = mergeTwoLists(listNode, listNode_);
        System.out.println("hello");
    }


}
