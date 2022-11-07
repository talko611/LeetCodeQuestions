package Easy;

//You are given the heads of two sorted linked lists list1 and list2.
//Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
//Return the head of the merged linked list.

//        Example:
//        Input: list1 = [1,2,4], list2 = [1,3,4]
//        Output: [1,1,2,3,4,4]

public class Merge_Two_Sorted_Lists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        else if(list2 == null) return list1;
        ListNode start = new ListNode(0);
        ListNode insetAfter = start;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                insetAfter.next =  list1;
                list1 = list1.next;
            }else{
                insetAfter.next = list2;
                list2 = list2.next;
            }
            insetAfter = insetAfter.next;
        }
        //Add the remaining list to the end
        if(list1 == null)
            insetAfter.next = list2;
        else
            insetAfter.next = list1;
        return start.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1,new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        Merge_Two_Sorted_Lists solutionObj = new Merge_Two_Sorted_Lists();
        ListNode merged = solutionObj.mergeTwoLists(null, list2);
        while (merged != null){
            System.out.println(merged.val);
            merged = merged.next;
        }

    }
}
