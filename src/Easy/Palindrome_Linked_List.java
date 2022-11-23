package Easy;
//Question 234

import Utils.ListNode;

import java.util.ArrayList;
import java.util.List;

//Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
public class Palindrome_Linked_List {
        public boolean isPalindrome(ListNode head) {
            ListNode end = head;
            ListNode current = head.next;
            List<Integer> nums = new ArrayList<>();
            nums.add(head.val);
            while (current != null) {
                nums.add(current.val);
                head.next = current.next;
                current.next = end;
                end = current;
                current = head.next;
            }
            current = end;
            for (int i = 0; i < nums.size(); ++i) {
                if (nums.get(i) != current.val) return false;
                else current = current.next;
            }
            return true;
        }

        public boolean isPalindrome2(ListNode head) {
            int counter = 0;
            ListNode ptr1 = head;
            ListNode ptr2 = head;
            ListNode middle;
            ListNode ptr3;
            for (ptr1 = head; ptr1 != null; ptr1 = ptr1.next) ++counter;
            if (counter == 1) return true;
            for (int i = 0; i < counter / 2; ++i) ptr2 = ptr2.next;
            if (counter % 2 == 1) {
                ptr1 = ptr2;
                ptr2 = ptr2.next;
            }
            middle = ptr2;
            ptr3 = ptr2.next;
            while (ptr3 != null) {
                ptr2.next = ptr3.next;
                ptr3.next = middle;
                middle = ptr3;
                ptr3 = ptr2.next;
            }
            ptr1 = head;
            ptr2 = middle;
            while (ptr2 != null) {
                if (ptr1.val != ptr2.val) return false;
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
            return true;
        }

}


