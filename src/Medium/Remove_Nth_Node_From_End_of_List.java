package Medium;

import Utils.ListNode;

//Question 19;
//Given the head of a linked list, remove the nth node from the end of the list and return its head.
public class Remove_Nth_Node_From_End_of_List {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n == 1 && head.next == null) return null;
        ListNode ptr1 = head;
        ListNode ptr2 = head.next;
        int dis = 1;
        int lstSize = 2;
        int steps;
        while( ptr2.next != null){
            ptr2 = ptr2.next;
            ++lstSize;
            ++dis;
            if(lstSize % 2 == 0){
                ptr1 = ptr1.next;
                --dis;
            }
        }
        if(dis > n -1){
            steps = dis - (n -1) -1;
        }else {
            steps = lstSize - n -1;
            ptr1 = head;
            if(steps == -1) return head.next;
        }
        int counter = 0;
        while(counter != steps){
            ptr1 = ptr1.next;
            ++counter;
        }
        ptr1.next = ptr1.next.next;
        return head;
    }
    public void printList(ListNode lst){
        ListNode ptr = lst;
        System.out.print("[");
        while(ptr != null){
            System.out.print(ptr.val);
            if(ptr.next != null) System.out.print(",");
            ptr = ptr.next;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        ListNode lst = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,new ListNode(5)))));
        Remove_Nth_Node_From_End_of_List solution  = new Remove_Nth_Node_From_End_of_List();
        solution.printList(lst);
        lst = solution.removeNthFromEnd(lst, 1);
        solution.printList(lst);
    }
}
