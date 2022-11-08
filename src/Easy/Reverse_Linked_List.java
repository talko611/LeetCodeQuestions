package Easy;

//Given the head of a singly linked list, reverse the list, and return the reversed list.

import Utils.ListNode;

public class Reverse_Linked_List {

    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode start = head;
        ListNode currentNode;
        while(head.next != null){
            currentNode = head.next;
            head.next = currentNode.next;
            currentNode.next = start;
            start = currentNode;
        }
        return start;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(5));
        Reverse_Linked_List solution = new Reverse_Linked_List();
        ListNode result = solution.reverseList(head);
        while(result != null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
