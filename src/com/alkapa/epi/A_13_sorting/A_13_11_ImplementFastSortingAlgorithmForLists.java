package com.alkapa.epi.A_13_sorting;

import com.alkapa.epi.A_07_linked_lists.A_07_01_MergeTwoSortedLists;
import com.alkapa.epi.A_07_linked_lists.ListNode;

public class A_13_11_ImplementFastSortingAlgorithmForLists {
    public static ListNode<Integer> insertionNode (final ListNode<Integer> L) {
        ListNode<Integer> dummyHead = new ListNode<>(0, L);
        ListNode<Integer> iter = L;

        while(iter != null && iter.next != null) {
            if (iter.data > iter.next.data) {
                ListNode<Integer> prev = dummyHead, target = iter.next;
                while (prev.next.data < target.data) {
                    prev = prev.next;
                }
                ListNode<Integer> temp = prev.next;
                prev.next = target;
                iter.next = target.next;
                target.next = temp;
            } else {
                iter = iter.next;
            }
        }
        return dummyHead.next;
    }

    public static ListNode<Integer> stableSortList(ListNode<Integer> L) {
        if (L == null || L.next == null) {
            return L;
        }

        ListNode<Integer> preSlow = null, slow = L, fast = L;
        while (fast != null && fast.next != null) {
            preSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if(preSlow != null) {
            preSlow.next = null;
        }

        return A_07_01_MergeTwoSortedLists.mergeTwoSortedListsV2(stableSortList(L), stableSortList(slow));
    }

    public static void main (String[] args) {
        ListNode<Integer> L = ListNode.createTestList(5, true);

        ListNode<Integer> iter = L;
        while (iter != null) {
            System.out.println(iter.data);
            iter = iter.next;
        }

        System.out.println();

        ListNode<Integer> res = stableSortList(L);
        while (res != null) {
            System.out.println(res.data);
            res = res.next;
        }
    }
}
