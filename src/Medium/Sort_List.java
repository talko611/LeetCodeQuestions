package Medium;
//Question 148
//Given the head of a linked list, return the list after sorting it in ascending order.

import Utils.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sort_List {
    public ListNode sortList(ListNode head) {
        int counter  = 0;
        for(ListNode temp = head; temp != null; temp = temp.next, ++counter);
        return sort(head, counter);
    }
    private ListNode sort(ListNode head, int size){
        if(head == null || head.next == null) return head;
        ListNode middle = head;
        ListNode left = head;
        ListNode right;
        for(int i = 0; i < size / 2 -1;++i, middle = middle.next);
        right = middle.next;
        middle.next = null;
        left = sort(left, size /2);
        right = sort(right, size - size/2);
        return merge(left, right);
    }
    private ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode();
        ListNode insertAfter = dummy;
        while(left != null && right != null){
            if(left.val < right.val){
                insertAfter.next = left;
                left = left.next;
            }else{
                insertAfter.next = right;
                right = right.next;
            }
            insertAfter = insertAfter.next;
        }
        if(left != null) insertAfter.next = left;
        if(right != null) insertAfter.next = right;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode nodes = new ListNode(2, new ListNode(1, new ListNode(-1, new ListNode(10, new ListNode(0)))));
        ListNode.printList(nodes);
        Sort_List solution  = new Sort_List();
        ListNode.printList(solution.sortList(nodes));
    }
}
