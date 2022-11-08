package Easy;

import Utils.ListNode;

public class Middle_of_the_Linked_List {
    public ListNode middleNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        int counter = 1;
        while(p2.next != null){
            ++counter;
            p2 = p2.next;
            if(counter % 2 == 0)
                p1 = p1.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(3, new ListNode(5, new ListNode(7, new ListNode(10, new ListNode(20, new ListNode(1, new ListNode(2)))))));
        Middle_of_the_Linked_List solution = new Middle_of_the_Linked_List();
        System.out.println(solution.middleNode(new ListNode(1, new ListNode(3))).val);
    }
}
