package Medium;

//Question 328

//Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
//The first node is considered odd, and the second node is even, and so on.
//Note that the relative order inside both the even and odd groups should remain as it was in the input.
//You must solve the problem in O(1) extra space complexity and O(n) time complexity.
//Example 1:
//Input: head = [1,2,3,4,5]
//Output: [1,3,5,2,4]


import Utils.ListNode;

import java.util.List;

public class Odd_Even_Linked_List {
    public ListNode oddEvenList(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode temp;
        ListNode lastPlacedOdd = head.next;
        ListNode lastPlacedEven = head;
        while(lastPlacedOdd != null && lastPlacedOdd.next != null){
            temp = lastPlacedOdd.next;
            lastPlacedOdd.next = temp.next;
            temp.next = lastPlacedEven.next;
            lastPlacedEven.next = temp;
            lastPlacedOdd = lastPlacedOdd.next;
            lastPlacedEven = lastPlacedEven.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode lst = new ListNode(1,new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, new ListNode(7, new ListNode(8))))))) );
        ListNode.printList(lst);
        Odd_Even_Linked_List solution  = new Odd_Even_Linked_List();
        lst = solution.oddEvenList(lst);
        ListNode.printList(lst);
    }
}
