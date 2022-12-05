package Utils;

import Easy.Reverse_Linked_List;

public class ListNode implements Comparable<ListNode> {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public static void printList(ListNode head){
        System.out.print("[");
        for(ListNode temp = head; head != null; head = head.next){
            if(head.next == null)
                System.out.print(head.val);
            else
                System.out.print(head.val + ",");
        }
        System.out.println("]");
    }

    @Override
    public int compareTo(ListNode o) {
        return this.val - o.val;
    }
}
